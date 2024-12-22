package xyz.uhalexz;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.uhalexz.commands.NCJCmd;
import xyz.uhalexz.listeners.CropListener;

public final class NoCropJumping extends JavaPlugin {

    @Override
    public void onEnable() {

        getDataFolder();
        saveDefaultConfig();

        getCommand("nocropjumping").setExecutor(new NCJCmd(this));

        getServer().getPluginManager().registerEvents(new CropListener(this), this);

        getLogger().info("Plugin has loaded!");

    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin has been disabled!");
        saveConfig();
    }
}
