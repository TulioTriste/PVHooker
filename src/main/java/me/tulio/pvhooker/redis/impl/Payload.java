package me.tulio.pvhooker.redis.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.tulio.pvhooker.PVHooker;

@Getter
@AllArgsConstructor
public enum Payload {

    LOAD_SERVER("LOAD_SERVER"),
    STAFF_JOIN("STAFF_JOIN"),
    STAFF_LEAVE("STAFF_LEAVE"),
    STAFF_CHAT("STAFF_CHAT"),
    ADMIN_CHAT("ADMIN_CHAT"),
    CLOSE_SERVER("CLOSE_SERVER"),
    ENABLE_WHITELIST("ENABLE_WHITELIST"),
    DISABLE_WHITELIST("DISABLE_WHITELIST");

    public String section;

    public static boolean getBoolean(Payload payload) {
        return PVHooker.get().getConfig().getBoolean(payload.getSection());
    }
}
