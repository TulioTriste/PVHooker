package me.tulio.pvhooker.profile;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import me.tulio.pvhooker.profile.entry.Entry;

import java.util.Map;
import java.util.UUID;

@Getter @Setter
@RequiredArgsConstructor
public class Profile {

    @Getter public static Map<UUID, Profile> profiles;

    private final UUID uuid;
    private Entry entry;
    private int task;

    public static Profile get(UUID uuid) {
        return profiles.get(uuid);
    }
}
