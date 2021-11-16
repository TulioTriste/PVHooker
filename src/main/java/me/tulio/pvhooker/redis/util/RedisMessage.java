package me.tulio.pvhooker.redis.util;

import com.google.gson.Gson;
import lombok.Getter;
import me.tulio.pvhooker.redis.impl.Payload;

import java.util.HashMap;
import java.util.Map;

public class RedisMessage {

    /*
    Credits to Brulin to for providing a RedisMessage method -> https://pastebin.com/kg614Sy3
     */

    @Getter
    private final Payload payload;
    private final Map<String, String> params;

    public RedisMessage(Payload payload) {
        this.payload = payload;
        params = new HashMap<>();
    }

    public RedisMessage setParam(String key, String value) {
        params.put(key, value);
        return this;
    }

    public String getParam(String key) {
        if (containsParam(key)) {
            return params.get(key);
        }
        return null;
    }

    public boolean containsParam(String key) {
        return params.containsKey(key);
    }

    public void removeParam(String key) {
        if (containsParam(key)) {
            params.remove(key);
        }
    }

    public String toJSON() {
        return new Gson().toJson(this);
    }
}
