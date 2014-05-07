package me.Ionaru.Nations;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Nation {
	
	private static List<String> NationEngland = new ArrayList<String>();
	private static List<String> NationNetherlands = new ArrayList<String>();
	
	public static void addToNation(NationType type, Player player){
		if(isInNation(player)){
			player.sendMessage(ChatColor.RED + "You cannot join this nation because you already are a part of a nation.");
			return;
		}
		switch (type){
		case England:
			NationEngland.add(player.getName());
			player.sendMessage(ChatColor.GREEN + "You successfully joined " + ChatColor.AQUA + "England" + ChatColor.GREEN + "!");		
			break;
		case Netherlands:
			NationNetherlands.add(player.getName());
			player.sendMessage(ChatColor.GREEN + "You successfully joined " + ChatColor.AQUA + "The Netherlands" + ChatColor.GREEN + "!");
			break;
		}
		
	}
	
	public static boolean isInNation(Player player){
		return NationEngland.contains(player.getName()) || NationNetherlands.contains(player.getName());
	}
	
	public static void removeFromNation(NationType type, Player player){
		if(!isInNation(player)){
			player.sendMessage(ChatColor.RED + "You cannot leave a nation because you are not in a nation.");
			return;
		}
		switch (type){
		case England:
			NationEngland.remove(player.getName());
			NationNetherlands.remove(player.getName());
			player.sendMessage(ChatColor.GREEN + "You left your nation.");
			break;
			//Will remove the player from every nation when the command '/nation leave' is issued
		default:
			break;
		}
	}
	
	public static void clearNations(){
		NationEngland.clear();
		NationNetherlands.clear();
	}
	
	public static List<String> getNationEngland(){
		return NationEngland;
	}
	
	public static List<String> getNationNetherlands(){
		return NationNetherlands;
	}
	
	public static List<String> getAllPlayersInNations(){
		List<String> combinedNations = new ArrayList<String>();
		combinedNations.addAll(NationEngland);
		combinedNations.addAll(NationNetherlands);
		return combinedNations;
	}
	
	public static NationType getNationType(Player player){
		if (!isInNation(player)){
			return null;
		}
		return (NationEngland.contains(player.getName()) ? NationType.England:NationType.Netherlands);
	}
}
