package main.java.me.ionaru.nations;

import java.io.File;
import java.util.HashMap;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Nations extends JavaPlugin {

    public static HashMap<String, NationType> nations = new HashMap<String, NationType>();
    //public static final String NationNum[] = {"England","Netherlands","Spain","France"};

    @EventHandler
    public void onDisable() {

    }
    @EventHandler
    public void onEnable() {
        PluginManager pm = Bukkit.getPluginManager();
        getCommand("nations").setExecutor(new CmdNations(this));
        createFolders();
        loadConfiguration();
        log("&av" + this.getDescription().getVersion() + " enabled");
    }

    public void loadConfiguration() {
        if (!getConfig().contains("color-logs")) getConfig().addDefault("color-logs", true);
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public void createFolders(){
        File folder = new File(this.getDataFolder() + File.separator + "data");
        if(!folder.exists()){
            folder.mkdir();
        }
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