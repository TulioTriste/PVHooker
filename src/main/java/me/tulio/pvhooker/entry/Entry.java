package me.tulio.pvhooker.entry;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class Entry {

    private final UUID identifier;
    private final String name;
    private final String url;
}
