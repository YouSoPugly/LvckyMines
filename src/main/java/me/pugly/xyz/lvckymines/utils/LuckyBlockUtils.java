package me.pugly.xyz.lvckymines.utils;

import me.pugly.xyz.lvckymines.Pickaxe;
import me.pugly.xyz.lvckymines.PickaxeTypes;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.function.Consumer;

public class LuckyBlockUtils {

    public static void basicLuckyBlock(BlockBreakEvent e) {
        BasicReward[] items = {BasicReward.XP, BasicReward.HASTE1, BasicReward.COMMONCRATE, BasicReward.HASTE2, BasicReward.RARELB, BasicReward.MONEY, BasicReward.BLIND1, BasicReward.DIAMONDP, BasicReward.GOLDP, BasicReward.IRONP};
        double totalWeight = 0.0;
        for (BasicReward r : items) {
            totalWeight += r.getWeight();
        }

        int idx = 0;
        for (double r = Math.random() * totalWeight; idx < items.length - 1; ++idx) {
            r -= items[idx].getWeight();
            if (r <= 0.0) break;
        }

        items[idx].execute(e);
    }

    public static void rareLuckyBlock(BlockBreakEvent e) {
        RareReward[] items = {RareReward.DIAMONDP, RareReward.HASTE2, RareReward.RARECRATE, RareReward.BASICLB, RareReward.MONEY, RareReward.NETHERITEP, RareReward.XP, RareReward.XPMULT};
        double totalWeight = 0.0;
        for (RareReward r : items) {
            totalWeight += r.getWeight();
        }

        int idx = 0;
        for (double r = Math.random() * totalWeight; idx < items.length - 1; ++idx) {
            r -= items[idx].getWeight();
            if (r <= 0.0) break;
        }

        items[idx].execute(e);
    }

    public static void legendaryLuckyBlock(BlockBreakEvent e) {
        LegendaryReward[] items = {LegendaryReward.XP, LegendaryReward.MONEY, LegendaryReward.AUTOSELL, LegendaryReward.EFFMAX, LegendaryReward.FLIGHT, LegendaryReward.FORTUNEMAX, LegendaryReward.LUCKYTITLE, LegendaryReward.RAINBOWP, LegendaryReward.SLEDGEHAMMERP, LegendaryReward.STARDUSTP};
        double totalWeight = 0.0;
        for (LegendaryReward r : items) {
            totalWeight += r.getWeight();
        }

        int idx = 0;
        for (double r = Math.random() * totalWeight; idx < items.length - 1; ++idx) {
            r -= items[idx].getWeight();
            if (r <= 0.0) break;
        }

        items[idx].execute(e);
    }

    private enum BasicReward {

        XP((e -> e.getPlayer().giveExp((int) (Math.random()*100 + 100))), 100),
        MONEY((e -> Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "eco give " + e.getPlayer().getName() + " " + (int) (Math.random()*100 + 100))), 100),
        RARELB((e -> e.getBlock().setType(Material.SEA_LANTERN)), 10),
        COMMONCRATE((e -> Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "ac key give " + e.getPlayer().getName() + " Common")), 5),
        IRONP((e -> e.getPlayer().getInventory().addItem(Pickaxe.createPickaxe(PickaxeTypes.IRON))), 20),
        GOLDP((e -> e.getPlayer().getInventory().addItem(Pickaxe.createPickaxe(PickaxeTypes.GOLD))), 10),
        DIAMONDP((e -> e.getPlayer().getInventory().addItem(Pickaxe.createPickaxe(PickaxeTypes.DIAMOND))), 1),
        HASTE1((e -> e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 1))), 50),
        BLIND1((e -> e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 200, 1))), 50),
        HASTE2((e -> e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 200, 2))), 30);


        private Consumer<BlockBreakEvent> run;
        private int weight;

        BasicReward(Consumer<BlockBreakEvent> run, int weight) {
            this.run = run;
            this.weight = weight;
        }

        public void execute(BlockBreakEvent e) {
            run.accept(e);
        }

        public int getWeight() {
            return weight;
        }
    }

    private enum RareReward {

        XP((e -> e.getPlayer().giveExp((int) (Math.random()*1000 + 3000))), 100),
        MONEY((e -> Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "eco give " + e.getPlayer().getName() + " " + (int) (Math.random()*10000 + 15000))), 100),
        RARECRATE((e -> Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "ac key give " + e.getPlayer().getName() + " Rare")), 5),
        XPMULT((e -> e.getPlayer().getInventory().addItem(new ItemStack(Material.NETHER_STAR, 1))), 30),
        BASICLB((e -> e.getBlock().setType(Material.GLOWSTONE)), 10),
        DIAMONDP((e -> e.getPlayer().getInventory().addItem(Pickaxe.createPickaxe(PickaxeTypes.DIAMOND))), 10),
        NETHERITEP((e -> e.getPlayer().getInventory().addItem(Pickaxe.createPickaxe(PickaxeTypes.NETHERITE))), 5),
        HASTE2((e -> e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 600, 2))), 30);


        private Consumer<BlockBreakEvent> run;
        private int weight;

        RareReward(Consumer<BlockBreakEvent> run, int weight) {
            this.run = run;
            this.weight = weight;
        }

        public void execute(BlockBreakEvent e) {
            run.accept(e);
        }

        public int getWeight() {
            return weight;
        }
    }

    private enum LegendaryReward {

        XP((e -> e.getPlayer().giveExp((int) (Math.random()*20000 + 10000))), 1000),
        MONEY((e -> Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "eco give " + e.getPlayer().getName() + " " + (int) (Math.random()*100000 + 100000))), 1000),
        STARDUSTP((e -> e.getPlayer().getInventory().addItem(Pickaxe.createPickaxe(PickaxeTypes.STARDUST))), 1),
        RAINBOWP((e -> e.getPlayer().getInventory().addItem(Pickaxe.createPickaxe(PickaxeTypes.RAINBOW))), 1),
        SLEDGEHAMMERP((e -> e.getPlayer().getInventory().addItem(Pickaxe.createPickaxe(PickaxeTypes.SLEDGEHAMMER))), 1),
        LUCKYTITLE((e -> e.getPlayer().getInventory().addItem(new ItemStack(Material.NETHER_STAR, 1))), 10),
        EFFMAX((e -> e.getPlayer().getInventory().addItem(new ItemStack(Material.NETHER_STAR, 1))), 300),
        AUTOSELL((e -> e.getPlayer().getInventory().addItem(new ItemStack(Material.NETHER_STAR, 1))), 300),
        FORTUNEMAX((e -> e.getPlayer().getInventory().addItem(new ItemStack(Material.NETHER_STAR, 1))), 300),
        FLIGHT((e -> e.getPlayer().getInventory().addItem(new ItemStack(Material.NETHER_STAR, 1))), 300);


        private Consumer<BlockBreakEvent> run;
        private int weight;

        LegendaryReward(Consumer<BlockBreakEvent> run, int weight) {
            this.run = run;
            this.weight = weight;
        }

        public void execute(BlockBreakEvent e) {
            run.accept(e);
        }

        public int getWeight() {
            return weight;
        }
    }

}
