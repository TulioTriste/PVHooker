package me.tulio.pvhooker.profile;

import lombok.Getter;
import me.tulio.pvhooker.profile.entry.Entry;

import java.util.Map;
import java.util.UUID;

@Getter
public class Profile {

    @Getter public static Map<UUID, Profile> profiles;

    private final UUID uuid;
    private Entry entry;

    public Profile(UUID uuid) {
        this.uuid = uuid;
    }

    public static Profile get(UUID uuid) {
        return profiles.get(uuid);
    }
}
