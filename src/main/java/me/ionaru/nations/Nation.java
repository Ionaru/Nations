package me.ionaru.nations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Nation {

    private static HashMap<String, NationType> nations = new HashMap<String, NationType>();

    public static void addToNation(NationType type, Player player){
        if(isInNation(player)){
            player.sendMessage(ChatColor.RED + "You cannot join this nation because you already are a part of a nation.");
            return;
        }
        player.sendMessage(Nations.colorize("&aYou have joined" + type.getTitle()));
        nations.put(player.getName(), type);
    }

    public static boolean isInNation(Player player){
        return nations.containsKey(player.getName());
    }

    public static void removeFromNation(Player player){
        if(!isInNation(player)){
            player.sendMessage(ChatColor.RED + "You cannot leave a nation because you are not in a nation.");
            return;
        }
        nations.remove(player.getName());
    }

    public static void clearNations(){
        nations.clear();
    }

    public static List<String> getAllPlayersInNations(){
        List<String> players = new ArrayList<String>();
        players.addAll(nations.keySet());
        return players;
    }

    public static NationType getNationType(Player player){
        if (!isInNation(player)){
            return null;
        }
        return nations.get(player.getName());
    }
}