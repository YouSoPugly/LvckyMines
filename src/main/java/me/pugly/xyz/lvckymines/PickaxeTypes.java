package me.pugly.xyz.lvckymines;

import org.bukkit.Material;

public enum PickaxeTypes {

    STARDUST(Material.NETHERITE_PICKAXE, 2, "&b&lStardust &fPickaxe"),
    RAINBOW(Material.NETHERITE_PICKAXE, 1, "&c&lR&6&la&e&li&a&ln&b&lb&9&lo&5&lw &fPickaxe"),
    SLEDGEHAMMER(Material.NETHERITE_PICKAXE, 3, "&8&lSledgehammer"),
    NETHERITE(Material.NETHERITE_PICKAXE, 0, "&fNetherite Pickaxe"),
    DIAMOND(Material.DIAMOND_PICKAXE, 0, "&fDiamond Pickaxe"),
    IRON(Material.IRON_PICKAXE, 0, "&fIron Pickaxe"),
    GOLD(Material.GOLDEN_PICKAXE, 0, "&fGolden Pickaxe"),
    STONE(Material.STONE_PICKAXE, 0, "&fStone Pickaxe");


    private final Material m;
    private final int model;
    private final String name;

    PickaxeTypes(Material m, int model, String name) {
        this.m = m;
        this.name = name;
        this.model = model;
    }

    public Material getMaterial() {
        return m;
    }

    public int getModel() {
        return model;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name.replaceAll("(?<=&)[0-9a-zA-Z]", "");
    }
}
