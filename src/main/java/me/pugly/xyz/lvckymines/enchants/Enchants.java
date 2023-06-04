package me.pugly.xyz.lvckymines.enchants;

import org.bukkit.event.block.BlockBreakEvent;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public enum Enchants {

    FORTUNE((e, l) -> {
        e.getPlayer();
    }, "Fortune", ""),

    XPMULT((e, l) -> {}, "EXP Multiplier", ""),

    EFFICIENCY((e,l) -> {}, "Efficiency", "");


    private final BiConsumer<BlockBreakEvent, Integer> run;
    private final String name;
    private final String displayName;

    Enchants(BiConsumer<BlockBreakEvent, Integer> run, String name, String displayName) {
        this.run = run;
        this.name = name;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getName() {
        return name;
    }

    public void execute(BlockBreakEvent e, int level) {
        run.accept(e, level);
    }
}
