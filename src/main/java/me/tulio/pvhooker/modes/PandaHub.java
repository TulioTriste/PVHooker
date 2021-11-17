package me.tulio.pvhooker.modes;

import me.tulio.pvhooker.PVHooker;
import me.tulio.pvhooker.redis.impl.Payload;
import me.tulio.pvhooker.redis.util.RedisMessage;

import java.util.UUID;

public class PandaHub {

    public void hook(UUID uuid) {
        String json = new RedisMessage(Payload.VAPOR)
                .setParam("UUID", uuid.toString())
                .toJSON();

        PVHooker.get().getRedis().write(json);
    }
}
