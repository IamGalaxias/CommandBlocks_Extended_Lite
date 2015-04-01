package nl.galaxias.commandblocksextendedlite;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        String displayname = player.getDisplayName();

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();
            if ((block.getType() == Material.COMMAND) && (!player.hasPermission("commandblocks.use"))) {
                player.closeInventory();
                event.setCancelled(true);
                if (event.isCancelled()) {
                    Bukkit.getLogger().info("[CommandBlocksExtended] " + displayname + " tried to use a Command Block but does not have permission to do that!");
                    player.sendMessage(ChatColor.RED + "You are not allowed to use this!");
                }
                else if ((block.getType() == Material.COMMAND) && (player.hasPermission("commandblocks.use"))) {
                    event.setCancelled(false);
                }
            }
        }
    }
}
