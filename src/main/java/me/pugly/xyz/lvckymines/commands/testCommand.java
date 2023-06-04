package me.pugly.xyz.lvckymines.commands;

import me.pugly.xyz.lvckymines.Pickaxe;
import me.pugly.xyz.lvckymines.PickaxeTypes;
import me.pugly.xyz.lvckymines.utils.Commands.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testCommand extends Command {
    public testCommand() {
        super(Arrays.asList("test"), "Test command", "mines.test", true);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;

        p.getInventory().addItem(Pickaxe.createPickaxe(PickaxeTypes.RAINBOW));
    }

    @Override
    public List<String> TabComplete(CommandSender cs, org.bukkit.command.Command cmd, String s, String[] args) {
        return null;
    }
}
