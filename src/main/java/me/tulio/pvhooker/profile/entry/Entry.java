package me.tulio.pvhooker.profile.entry;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class Entry {

    private final UUID identifier;
    private final int lives;
    private final boolean deathban;
}
