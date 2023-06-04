package me.pugly.xyz.lvckymines.commands;

import me.pugly.xyz.lvckymines.Pickaxe;
import me.pugly.xyz.lvckymines.PickaxeTypes;
import me.pugly.xyz.lvckymines.utils.Commands.Command;
import me.pugly.xyz.lvckymines.utils.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class giveCommand extends Command {

    private final item[] items = { item.HASTEPOTION, item.HASTE2POTION, item.STONEPICK, item.GOLDPICK, item.IRONPICK, item.DIAMONDPICK, item.NETHERITEPICK, item.SLEDGEHAMMER, item.RAINBOWPICK, item.STARDUSTPICK};

    public giveCommand() {
        super(Arrays.asList("give", "g"), "Give command", "mines.give", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (args.length < 2)
            return;

        if (!(sender instanceof Player) && args.length < 3)
            return;

        if (Arrays.stream(items).map(item::toString).noneMatch(s -> s.equals(args[1])))
            return;

        if (args.length == 2) {
            Player p = (Player) sender;

            item.valueOf(args[1]).execute(p);
            return;
        }

        if (Bukkit.getPlayer(args[2]) != null)
            item.valueOf(args[1]).execute(Bukkit.getPlayer(args[2]));
    }

    @Override
    public List<String> TabComplete(CommandSender cs, org.bukkit.command.Command cmd, String s, String[] args) {

        if (cs instanceof Player && args.length == 2) {
            return Arrays.stream(items).map(item::toString).collect(Collectors.toList());
        }

        if (cs instanceof Player && args.length == 3) {
            return Bukkit.getOnlinePlayers().stream().map(p -> p.getPlayer().getName()).collect(Collectors.toList());
        }

        return null;
    }


    private enum item {

        HASTEPOTION((player -> {
            ItemStack pot = new ItemStack(Material.POTION, 1);
            PotionMeta meta = (PotionMeta) pot.getItemMeta();
            meta.setColor(Color.YELLOW);
            meta.addCustomEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 600, 0), true);
            meta.setDisplayName(TextUtils.colorize("&6&lHaste &7Potion"));
            pot.setItemMeta(meta);
            player.getInventory().addItem(pot);
        })),
        HASTE2POTION((player -> {
            ItemStack pot = new ItemStack(Material.POTION, 1);
            PotionMeta meta = (PotionMeta) pot.getItemMeta();
            meta.setColor(Color.YELLOW);
            meta.addCustomEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 600, 1), true);
            meta.setDisplayName(TextUtils.colorize("&6&lHaste II &7Potion"));
            pot.setItemMeta(meta);
            player.getInventory().addItem(pot);
        })),

        STONEPICK((player -> player.getInventory().addItem(Pickaxe.createPickaxe(PickaxeTypes.STONE)))),
        GOLDPICK((player -> player.getInventory().addItem(Pickaxe.createPickaxe(PickaxeTypes.GOLD)))),
        IRONPICK((player -> player.getInventory().addItem(Pickaxe.createPickaxe(PickaxeTypes.IRON)))),
        DIAMONDPICK((player -> player.getInventory().addItem(Pickaxe.createPickaxe(PickaxeTypes.DIAMOND)))),
        NETHERITEPICK((player -> player.getInventory().addItem(Pickaxe.createPickaxe(PickaxeTypes.NETHERITE)))),
        SLEDGEHAMMER((player -> player.getInventory().addItem(Pickaxe.createPickaxe(PickaxeTypes.SLEDGEHAMMER)))),
        RAINBOWPICK((player -> player.getInventory().addItem(Pickaxe.createPickaxe(PickaxeTypes.RAINBOW)))),
        STARDUSTPICK((player -> player.getInventory().addItem(Pickaxe.createPickaxe(PickaxeTypes.STARDUST))));

        private final Consumer<Player> give;

        item(Consumer<Player> give) {
            this.give = give;
        }

        public void execute(Player player) {
            give.accept(player);
        }
    }

}
