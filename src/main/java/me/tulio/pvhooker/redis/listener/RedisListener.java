package me.tulio.pvhooker.redis.listener;

import com.google.gson.Gson;
import me.tulio.pvhooker.PVHooker;
import me.tulio.pvhooker.redis.util.RedisMessage;
import redis.clients.jedis.JedisPubSub;

import java.util.UUID;

public class RedisListener extends JedisPubSub {

    private final PVHooker plugin = PVHooker.get();

    @Override
    public void onMessage(String channel, String message) {
        RedisMessage redisMessage = new Gson().fromJson(message, RedisMessage.class);
        /*
        A switch is made to assign the action for each type of Payload, it can also be done by "if"
         */
        switch (redisMessage.getPayload()) {
            case PANDAHUB: {
                UUID uuid = UUID.fromString(redisMessage.getParam("UUID"));
                int lives = Integer.parseInt(redisMessage.getParam("LIVES"));
                boolean deathban = Boolean.parseBoolean(redisMessage.getParam("DEATHBAN"));
            }
            break;
            case VAPOR: {
                UUID uuid = UUID.fromString(redisMessage.getParam("UUID"));

            }
            break;
            default: {
                plugin.getLogger().info("[Redis] The message was received, but there was no response");
            }
            break;
        }
    }
}
