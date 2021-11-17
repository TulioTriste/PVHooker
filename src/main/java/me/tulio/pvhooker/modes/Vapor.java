package me.tulio.pvhooker.modes;

import me.tulio.pvhooker.redis.impl.Payload;
import me.tulio.pvhooker.redis.util.RedisMessage;

import java.util.UUID;

public class Vapor {

    public static void hook(UUID uuid) {
        String json = new RedisMessage(Payload.PANDAHUB)
                .setParam("UUID", uuid.toString())
                .setParam("LIVES", String.valueOf(me.daaz.vapor.Vapor.get().getDeathbanManager().getLives(uuid)))
                .setParam("DEATHBAN", String.valueOf(me.daaz.vapor.Vapor.get().getDeathbanManager().applyDeathBan()))
    }
}
