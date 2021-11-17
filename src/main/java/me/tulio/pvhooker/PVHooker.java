package me.tulio.pvhooker;

import dev.panda.file.FileConfig;
import lombok.Getter;
import me.tulio.pvhooker.redis.Redis;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class PVHooker extends JavaPlugin {

    private FileConfig config;
    private Redis redis;

    @Override
    public void onEnable() {
        config = new FileConfig(this, "config.yml");
        connectRedis();
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

    public static PVHooker get() {
        return getPlugin(PVHooker.class);
    }
}
