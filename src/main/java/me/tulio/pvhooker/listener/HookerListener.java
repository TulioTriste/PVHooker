package me.tulio.pvhooker.listener;

import me.tulio.pvhooker.PVHooker;
import me.tulio.pvhooker.profile.Profile;
import me.tulio.pvhooker.redis.impl.Payload;
import me.tulio.pvhooker.redis.util.RedisMessage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class HookerListener implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public void onAsyncPreLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        Profile profile = new Profile(player.getUniqueId());
        if (event.getResult() == PlayerLoginEvent.Result.ALLOWED) {
            try {
                PVHooker.get().getRedis().write(new RedisMessage(Payload.PANDAHUB)
                        .setParam("UUID", player.getUniqueId().toString())
                        .toJSON());

                Profile.getProfiles().put(player.getUniqueId(), profile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
