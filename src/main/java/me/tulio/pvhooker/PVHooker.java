package me.tulio.pvhooker;

import dev.panda.file.FileConfig;
import org.bukkit.plugin.java.JavaPlugin;

public final class PVHooker extends JavaPlugin {

    private FileConfig config;

    @Override
    public void onEnable() {
        config = new FileConfig(this, "config.yml");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public PVHooker get() {
        return getPlugin(PVHooker.class);
    }
}
