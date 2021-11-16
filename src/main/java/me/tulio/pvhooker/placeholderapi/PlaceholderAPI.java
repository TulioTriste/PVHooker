package me.tulio.pvhooker.placeholderapi;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.tulio.pvhooker.PVHooker;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlaceholderAPI extends PlaceholderExpansion {
    @Override
    public @NotNull String getIdentifier() {
        return PVHooker.get().getDescription().getName();
    }

    @Override
    public @NotNull String getAuthor() {
        return "TulioTriste";
    }

    @Override
    public @NotNull String getVersion() {
        return PVHooker.get().getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String params) {
        if (player == null) return "";
        return null;
    }
}
