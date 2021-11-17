package me.tulio.pvhooker.modes;

import me.tulio.pvhooker.PVHooker;
import me.tulio.pvhooker.redis.impl.Payload;
import me.tulio.pvhooker.redis.util.RedisMessage;

import java.util.UUID;

public class Vapor {

    public static void hook(UUID uuid) {
        String json = new RedisMessage(Payload.PANDAHUB)
                .setParam("UUID", uuid.toString())
                .setParam("LIVES", String.valueOf(me.daaz.vapor.Vapor.get().getDeathbanManager().getLives(uuid)))
                .setParam("DEATHBAN", String.valueOf(
                        me.daaz.vapor.Vapor.get().getUserManager().getUser(uuid).getDeathban().isActive()))
                .toJSON();

        PVHooker.get().getServer().getScheduler().runTaskAsynchronously(PVHooker.get(), () ->
                PVHooker.get().getRedis().write(json));
    }
}
