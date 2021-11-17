package me.tulio.pvhooker.redis;

import lombok.Getter;
import me.tulio.pvhooker.PVHooker;
import me.tulio.pvhooker.redis.listener.RedisListener;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Getter
public class Redis {

    JedisPool jedisPool;

    RedisListener redisListener;

    private final String ip = PVHooker.get().getFileConfig().getString("REDIS.HOST");

    private final int port = PVHooker.get().getFileConfig().getInt("REDIS.PORT");

    private final String password = PVHooker.get().getFileConfig().getString("REDIS.AUTHENTICATION.PASSWORD");

    private final boolean auth = PVHooker.get().getFileConfig().getBoolean("REDIS.AUTHENTICATION.ENABLED");

    @Getter private boolean active = false;

    public void connect() {
        try {
            PVHooker.get().getLogger().info("Connecting to redis");
            this.jedisPool = new JedisPool(ip, port);
            Jedis jedis = this.jedisPool.getResource();
            if (auth)
                if (password != null || !password.equals(""))
                    jedis.auth(this.password);
            this.redisListener = new RedisListener();
            (new Thread(() -> jedis.subscribe(this.redisListener, "panda-core"))).start();
            jedis.connect();
            active = true;
            PVHooker.get().getLogger().info("Successfully redis connection.");
        } catch (Exception e) {
            PVHooker.get().getLogger().info("Error in redis connection.");
            active = false;
        }
    }

    public void disconnect() {
        this.redisListener.unsubscribe();
        jedisPool.destroy();
    }

    public void write(String json){
        try (Jedis jedis = this.jedisPool.getResource()) {
            if (auth) {
                if (password != null || !password.equals(""))
                    jedis.auth(this.password);
            }
            PVHooker.get().getServer().getScheduler().runTaskAsynchronously(PVHooker.get(), () -> jedis.publish("pvhooker", json));
        }
    }
}
