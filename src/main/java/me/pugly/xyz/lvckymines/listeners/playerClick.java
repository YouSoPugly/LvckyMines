package me.pugly.xyz.lvckymines.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class playerClick implements Listener {

    @EventHandler
    public static void onPlayerClick(PlayerInteractEvent e) {

        Player p = e.getPlayer();

        if (e.getAction() != Action.RIGHT_CLICK_BLOCK && e.getAction() != Action.RIGHT_CLICK_AIR)
            return;

        ItemStack mainHand = p.getInventory().getItemInMainHand();


        if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.PAPER) {
            //TODO do stuff
        }
    }

}
