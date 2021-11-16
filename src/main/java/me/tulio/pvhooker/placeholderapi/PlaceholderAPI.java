package me.tulio.pvhooker.placeholderapi;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.tulio.pvhooker.PVHooker;
import me.tulio.pvhooker.profile.Profile;
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

        if (params.contains("lives")) {
            return String.valueOf(Profile.get(player.getUniqueId()).getEntry().getLives());
        }
        else if (params.contains("deathban")) {
            return String.valueOf(Profile.get(player.getUniqueId()).getEntry().isDeathban());
        }
        return null;
    }
}
