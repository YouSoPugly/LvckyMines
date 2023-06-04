package me.pugly.xyz.lvckymines;

import me.pugly.xyz.lvckymines.commands.giveCommand;
import me.pugly.xyz.lvckymines.commands.testCommand;
import me.pugly.xyz.lvckymines.listeners.blockBreak;
import me.pugly.xyz.lvckymines.listeners.playerJoin;
import me.pugly.xyz.lvckymines.utils.Commands.CommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LvckyMines extends JavaPlugin {

    private static JavaPlugin plugin;
    private static CommandHandler luckyMinesCommand;

    @Override
    public void onEnable() {
        // Plugin startup logic

        plugin = this;

        Bukkit.getPluginManager().registerEvents(new blockBreak(), this);
        Bukkit.getPluginManager().registerEvents(new playerJoin(), this);

        luckyMinesCommand = new CommandHandler("luckymines", this);
        luckyMinesCommand.registerCommand(new testCommand());
        luckyMinesCommand.registerCommand(new giveCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }

}
