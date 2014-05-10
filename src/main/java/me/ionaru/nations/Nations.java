package me.ionaru.nations;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.scoreboard.Team;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Nations extends JavaPlugin {

    public static final String NationNum[] = {"England","Netherlands","Spain","France"};

    @EventHandler
    public void onDisable() {

    }
    @EventHandler
    public void onEnable() {
        PluginManager pm = Bukkit.getPluginManager();
        getCommand("nations").setExecutor(new CmdNations(this));
        loadConfiguration();
        log("&av" + this.getDescription().getVersion() + " by EnderCrest and Ionaru enabled");
    }

    public void loadConfiguration() {
        if (!getConfig().contains("color-logs")) getConfig().addDefault("color-logs", true);
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public static String colorize(String str){ return str.replaceAll("(?i)&([a-f0-9k-or])", "\u00a7$1");}

    public void log(Object obj){
        if(getConfig().getBoolean("color-logs", true)){
            getServer().getConsoleSender().sendMessage(colorize("&3[&d" + getName() + "&3] &r" + obj));
        }else{
            Bukkit.getLogger().log(Level.INFO, "[" + getName() + "] " + (colorize((String) obj)).replaceAll("(?)\u00a7([a-f0-9k-or])", ""));
        }
    }
}