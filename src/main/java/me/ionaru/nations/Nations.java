package me.ionaru.nations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import me.ionaru.nations.listeners.PVPListener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Nations extends JavaPlugin {
	
	//HashMap<String, String> data;
	
	private HashMap<String, PlayerAttributes> players; 
    
    private ConfigAccessor playerConfig;

    public static HashMap<String, NationType> nations = new HashMap<String, NationType>();
    //public static final String NationNum[] = {"England","Netherlands","Spain","France"};

    @EventHandler
    public void onDisable() {
    	log("&cv" + this.getDescription().getVersion() + " disabled");
    	save(nations, new File(getDataFolder(), "data/data.dat"));

    }
    @EventHandler
    public void onEnable() {
        PluginManager pm = Bukkit.getPluginManager();
        getCommand("nations").setExecutor(new CmdNations(this));
        pm.registerEvents(new PVPListener(this), this);
        createFolders();
        loadConfiguration();
        log("&av" + this.getDescription().getVersion() + " enabled");
        
    }

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
    public void addToNation(NationType type, Player player){
        if(isInNation(player)){
            player.sendMessage(ChatColor.RED + "You cannot join this nation because you are already in a nation.");
            return;
        }
        player.sendMessage(Nations.colorize("&aYou have joined " + type.getTitle()));
        players.put(player.getName(), new PlayerAttributes(type,player.getName()));
    }

    public boolean isInNation(Player player){
        return players.containsKey(player.getName());
    }
    
    public boolean isInNation(String player){
        return players.containsKey(player);
    }

    public void removeFromNation(Player player){
        if(!isInNation(player)){
            player.sendMessage(ChatColor.RED + "You cannot leave a nation because you are not in a nation.");
            return;
        }
        players.remove(player.getName());
        player.sendMessage(ChatColor.GREEN + "You left your nation.");
    }
    
    public List<String> getPlayersInNation (NationType nation) {
    	List<String> temp = new LinkedList<String>();
    	
    	for(Entry <String,PlayerAttributes> e: players.entrySet()) {
    		if(e.getValue().getNation().equals(nation)) {
    			temp.add(e.getKey());
    		}
    	}
    	
    	return temp;    	
    }

    public void clearNations(){
        players.clear();
    }

    public List<String> getAllPlayersInNations(){
        List<String> temp = new ArrayList<String>();
        temp.addAll(players.keySet());
        return temp;
    }

    public NationType getNationType(Player player){
        if (!isInNation(player)){
            return null;
        }
        return players.get(player.getName()).getNation();
    }
    
    public PlayerAttributes getAttributes (Player ply) {
    	return players.get(ply.getName());
    }
    
    public static Integer getBukkitBuild() {
		String version = Bukkit.getVersion();
		Pattern pattern = Pattern.compile("(b)([0-9]+)(jnks)");
		Matcher matcher = pattern.matcher(version);

		if (matcher.find()) {
			return Integer.valueOf(matcher.group(2));
		}

		return null;
	}   
}