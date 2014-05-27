package me.ionaru.nations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.logging.Level;

import me.ionaru.nations.listeners.PVPListener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Nations extends JavaPlugin {
	
    public static HashMap<String, NationType> nations = new HashMap<String, NationType>();

    @EventHandler
    public void onDisable() {
    	log("&cv" + this.getDescription().getVersion() + " disabled");
    	save(nations, new File(getDataFolder(), "data/data.dat"));

    }
    @EventHandler
    public void onEnable() {
    	// Check if plugin needs to be running
    	if(getConfig().getString("plugin_enabled") == "false"){
			log("&c'Plugin_enabled' is set to false in Nations config. Disabling plugin!");
			// Will not load the plugin any further
			this.getServer().getPluginManager().disablePlugin(this);
		}
		else
		{
			// Load plugin normally
        PluginManager pm = Bukkit.getPluginManager();
        getCommand("nations").setExecutor(new CmdNations(this));
        pm.registerEvents(new PVPListener(this), this);
        createFolders();
        loadConfiguration();
        log("&av" + this.getDescription().getVersion() + " enabled");
		}
        
    }

    @SuppressWarnings("unchecked")
	public void loadConfiguration() {
        if (!getConfig().contains("color-logs")) getConfig().addDefault("color-logs", true);
        getConfig().options().copyDefaults(true);
        saveConfig();
        nations = (HashMap<String, NationType>) load(new File(getDataFolder(), "data/data.dat"));
        if (nations == null){
        	nations = new HashMap<String, NationType>();
        }
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
    
    public void save(Object o, File f){
    	try{
    		if(!f.exists())
    			f.createNewFile();
    			
    		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
    		oos.writeObject(o);
    		oos.flush();
    		oos.close();
    	}catch(Exception e){
    			e.printStackTrace();
    	}
    }
    
    public Object load(File f){
    	try{
    		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
    		Object result = ois.readObject();
    		ois.close();
    		return result;
    	}catch(Exception e){
			return null;
	}
    }
}