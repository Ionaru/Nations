package me.ionaru.nations;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Nation {

    private static List<String> NationEngland = new ArrayList<String>();
    private static List<String> NationNetherlands = new ArrayList<String>();
    private static List<String> NationSpain = new ArrayList<String>();
    private static List<String> NationFrance = new ArrayList<String>();

    public static void addToNation(NationType type, Player player){
        if(isInNation(player)){
            player.sendMessage(ChatColor.RED + "You cannot join this nation because you already are a part of a nation.");
            return;
        }
        //Adds players to the nation of their choice
        switch (type){
            case ENGLAND:
                NationEngland.add(player.getName());
                player.sendMessage(ChatColor.GREEN + "You successfully joined " + ChatColor.AQUA + "England" + ChatColor.GREEN + "!");
                break;
            case NETHERLANDS:
                NationNetherlands.add(player.getName());
                player.sendMessage(ChatColor.GREEN + "You successfully joined " + ChatColor.AQUA + "The Netherlands" + ChatColor.GREEN + "!");
                break;
            case SPAIN:
                NationSpain.add(player.getName());
                player.sendMessage(ChatColor.GREEN + "You successfully joined " + ChatColor.AQUA + "Spain" + ChatColor.GREEN + "!");
                break;
            case FRANCE:
                NationFrance.add(player.getName());
                player.sendMessage(ChatColor.GREEN + "You successfully joined " + ChatColor.AQUA + "France" + ChatColor.GREEN + "!");
                break;
        }

    }

    public static boolean isInNation(Player player){
        return NationEngland.contains(player.getName()) || NationNetherlands.contains(player.getName()) || NationSpain.contains(player.getName()) || NationFrance.contains(player.getName());
    }

    public static void removeFromNation(NationType type, Player player){
        if(!isInNation(player)){
            player.sendMessage(ChatColor.RED + "You cannot leave a nation because you are not in a nation.");
            return;
        }
        switch (type){
            case ENGLAND:
                NationEngland.remove(player.getName());
                NationNetherlands.remove(player.getName());
                NationSpain.remove(player.getName());
                NationFrance.remove(player.getName());
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
        NationSpain.clear();
        NationFrance.clear();
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
        return (NationEngland.contains(player.getName()) ? NationType.ENGLAND:NationType.NETHERLANDS);
    }
}