package me.pugly.xyz.lvckymines.listeners;

import me.pugly.xyz.lvckymines.Pickaxe;
import me.pugly.xyz.lvckymines.PickaxeTypes;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class playerJoin implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent e) {
        if (!e.getPlayer().hasPlayedBefore())
            e.getPlayer().getInventory().addItem(Pickaxe.createPickaxe(PickaxeTypes.STONE));
    }



}
