package xyz.uhalexz.listeners;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import xyz.uhalexz.NoCropJumping;

public class CropListener implements Listener {

    private final NoCropJumping plugin;

    public CropListener(NoCropJumping plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void noUpRoot(PlayerInteractEvent event) {

        if (!plugin.getConfig().getBoolean("cropjumping")) {
            if (event.getClickedBlock() != null
                    && event.getAction() == Action.PHYSICAL
                    && event.getClickedBlock().getType() == Material.FARMLAND
                    && !event.getPlayer().hasPermission("ncj.bypass")) {
                event.setCancelled(true);

                if (plugin.getConfig().getBoolean("messages.logging")) {

                    Player player = event.getPlayer();
                    String message = plugin.getConfig().getString("messages.message").replace("&", "§");

                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy(message));
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0f, 1.0f);
                }

            }
        }


    }

}
