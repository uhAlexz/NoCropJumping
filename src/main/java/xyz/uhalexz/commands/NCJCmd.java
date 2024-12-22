package xyz.uhalexz.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.uhalexz.NoCropJumping;

public class NCJCmd implements CommandExecutor {

    private final NoCropJumping plugin;

    public NCJCmd(NoCropJumping plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        boolean isEnabled = plugin.getConfig().getBoolean("cropjumping");
        plugin.getConfig().set("cropjumping", !isEnabled);
        plugin.saveConfig();

        sender.sendMessage(ChatColor.GOLD + "NCJ " + ChatColor.RESET + "| Crop protection is now " + (isEnabled ? "enabled" : "disabled") + "!");

        return true;
    }
}
