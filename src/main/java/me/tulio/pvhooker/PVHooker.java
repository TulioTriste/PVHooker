package me.tulio.pvhooker;

import dev.panda.file.FileConfig;
import lombok.Getter;
import me.tulio.pvhooker.listener.HookerListener;
import me.tulio.pvhooker.profile.Profile;
import me.tulio.pvhooker.redis.Redis;
import me.tulio.pvhooker.redis.impl.Payload;
import me.tulio.pvhooker.redis.util.RedisMessage;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class PVHooker extends JavaPlugin {

    private FileConfig fileConfig;
    private Redis redis;

    @Override
    public void onEnable() {
        fileConfig = new FileConfig(this, "config.yml");
        connectRedis();
        registerListener();

        if (fileConfig.getString("MODE").equals("PANDAHUB")) {
            getServer().getScheduler().runTaskTimerAsynchronously(this, () -> {
                for (Player onlinePlayer : getServer().getOnlinePlayers()) {
                    redis.write(new RedisMessage(Payload.VAPOR)
                            .setParam("UUID", onlinePlayer.getUniqueId().toString())
                            .toJSON());
                }
            }, 0L, 20L);
        }

        getServer().getScheduler().runTaskTimer(this, () -> {
            for (Player onlinePlayer : getServer().getOnlinePlayers()) {
                onlinePlayer.sendMessage("&aLives: &f" + Profile.get(onlinePlayer.getUniqueId()).getEntry().getLives());
                onlinePlayer.sendMessage("&aDeathban: &f" + Profile.get(onlinePlayer.getUniqueId()).getEntry().isDeathban());
            }
        }, 0L, 40L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void connectRedis() {
        redis = new Redis();
        redis.connect();
        System.out.println("[PVHooker] Redis connected!");
    }

    private void registerListener() {
        getServer().getPluginManager().registerEvents(new HookerListener(), this);
    }

    public static PVHooker get() {
        return getPlugin(PVHooker.class);
    }
}
