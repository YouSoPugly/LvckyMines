package me.pugly.xyz.lvckymines.listeners;

import me.pugly.xyz.lvckymines.Pickaxe;
import me.pugly.xyz.lvckymines.utils.LuckyBlockUtils;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class blockBreak implements Listener {

    @EventHandler
    public static void onBlockBreak(BlockBreakEvent e) {

        if (e.getPlayer().getGameMode() == GameMode.CREATIVE)
            return;

        Player p = e.getPlayer();

        if (!p.getInventory().getItemInMainHand().hasItemMeta() || p.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData())
            return;

        e.setCancelled(true);

        Material start = e.getBlock().getType();

        switch (e.getBlock().getType()) {
            case GLOWSTONE:
                LuckyBlockUtils.basicLuckyBlock(e);
                break;
            case SEA_LANTERN:
                LuckyBlockUtils.rareLuckyBlock(e);
                break;
            case BEACON:
                LuckyBlockUtils.legendaryLuckyBlock(e);
                break;
            default:
                if (e.getBlock().getDrops(new ItemStack(Material.DIAMOND_PICKAXE)).toArray().length != 0)
                    p.getInventory().addItem((ItemStack) e.getBlock().getDrops(new ItemStack(Material.DIAMOND_PICKAXE)).toArray()[0]); // TODO GET FORTUNE MULT

                p.giveExp((int) (10 * Pickaxe.getExpMultiplier(p)));
        }

        if (e.getBlock().getType() == start)
            e.getBlock().setType(Material.AIR);
    }


}
