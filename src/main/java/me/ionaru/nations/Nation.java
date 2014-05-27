package me.ionaru.nations;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Nation{

    public static void addToNation(NationType type, Player player){
        if(isInNation(player)){
            player.sendMessage(ChatColor.RED + "You cannot join this nation because you are already in a nation.");
            return;
        }
        player.sendMessage(Nations.colorize("&aYou have joined " + type.getTitle()));
        Nations.nations.put(player.getName(), type);
    }

    public static boolean isInNation(Player player){
        return Nations.nations.containsKey(player.getName());
    }

    public static void removeFromNation(Player player){
        if(!isInNation(player)){
            player.sendMessage(ChatColor.RED + "You cannot leave a nation because you are not in a nation.");
            return;
        }
        Nations.nations.remove(player.getName());
        player.sendMessage(ChatColor.GREEN + "You left your nation.");
    }

    public static void clearNations(){
        Nations.nations.clear();
    }

    public static List<String> getAllPlayersInNations(){
        List<String> players = new ArrayList<String>();
        players.addAll(Nations.nations.keySet());
        return players;
    }

    public static NationType getNationType(Player player){
        if (!isInNation(player)){
            return null;
        }
        return Nations.nations.get(player.getName());
    }
}
