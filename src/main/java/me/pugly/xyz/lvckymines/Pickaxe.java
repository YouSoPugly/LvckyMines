package me.pugly.xyz.lvckymines;

import me.pugly.xyz.lvckymines.utils.TextUtils;
import net.kyori.adventure.text.ComponentBuilder;
import net.kyori.adventure.text.ComponentBuilderApplicable;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.util.Buildable;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Pickaxe {

    public static int getFortune(ItemStack i) {
        return 0;
    }

    public static double getExpMultiplier(Player p) {

        ItemStack i = p.getInventory().getItemInMainHand();
        double out = 1;

        //i.getItemMeta().getPersistentDataContainer(). get xp multi enchant

        if (i.getType().equals(PickaxeTypes.RAINBOW.getMaterial()) && i.getItemMeta().getCustomModelData() == PickaxeTypes.RAINBOW.getModel())
            out *= 2;

        if (p.hasPermission("luckymines.multiplier.15"))
            return out * 1.5;

        if (p.hasPermission("luckymines.multiplier.12"))
            return out * 1.2;

        return out;
    }

    public static ItemStack createPickaxe(PickaxeTypes type) {
        ItemStack out = new ItemStack(type.getMaterial(), 1);
        ItemMeta meta = out.getItemMeta();
        meta.setUnbreakable(true);
        meta.setCustomModelData(type.getModel());
        meta.setDisplayName(TextUtils.colorize(type.getName()));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
        out.setItemMeta(meta);
        return out;
    }

}
