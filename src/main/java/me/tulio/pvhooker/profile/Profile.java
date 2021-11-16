package me.tulio.pvhooker.profile;

import lombok.Getter;

import java.util.Map;
import java.util.UUID;

@Getter
public class Profile {

    @Getter public static Map<UUID, Profile> profiles;

    private final UUID uuid;
}
