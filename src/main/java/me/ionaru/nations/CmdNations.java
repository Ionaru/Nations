package me.ionaru.nations;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdNations implements CommandExecutor {

    Nations plugin;

    public CmdNations(Nations plugin){
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args){
        if(cmd.getName().equalsIgnoreCase("nations")){
            if(args.length == 0){
                if(cs.hasPermission("nations.admin")){
                    return adminHelp(cs);
                }else{
                    return userHelp(cs);
                }
            }else if(args.length == 1){
                if(args[0].equalsIgnoreCase("help") || args[0].equals("?")){
                    if(cs.hasPermission("nations.admin")){
                        return adminHelp(cs);
                    }else{
                        return userHelp(cs);
                    }
                }else if(args[0].equalsIgnoreCase("list")){
                    return nationList(cs);
                }else if(args[0].equalsIgnoreCase("info") || args[0].equalsIgnoreCase("join")){
                    return invalidParameters(cs);
                }else if(args[0].equalsIgnoreCase("leave")){
                    return nationLeave(cs);
                }
            }else if(args.length == 2) {
                if (args[0].equalsIgnoreCase("info")) {
                    return nationInfo(cs, args);
                }else if(args[0].equalsIgnoreCase("join")){
                    return nationJoin(cs, args);
                }
            }
        }
        return false;
    }

    private boolean adminHelp(CommandSender cs){
        cs.sendMessage("----" + ChatColor.GREEN + " Nations Help (" + ChatColor.RED + "Admin" +  ChatColor.GREEN + ") " + ChatColor.WHITE + "----");
        cs.sendMessage(ChatColor.GREEN + "Accepted command aliases: " + ChatColor.AQUA + "/n" + ChatColor.GREEN + "," + ChatColor.AQUA + " /nation" + ChatColor.GREEN + " and" + ChatColor.AQUA + " /nations");
        cs.sendMessage(ChatColor.AQUA + "/Nation" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Shows info on the Nations plugin commands.");
        cs.sendMessage(ChatColor.AQUA + "/Nation list" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays active nations.");
        cs.sendMessage(ChatColor.AQUA + "/Nation info <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays additional info on a nation.");
        cs.sendMessage(ChatColor.AQUA + "/Nation join <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Join a nation.");
        return true;
    }

    private boolean userHelp(CommandSender cs){
        cs.sendMessage("----" + ChatColor.GREEN + "Nations Help" + ChatColor.WHITE + "----");
        cs.sendMessage(ChatColor.GREEN + "Accepted command aliases: " + ChatColor.AQUA + "/n" + ChatColor.GREEN + "," + ChatColor.AQUA + " /nation" + ChatColor.GREEN + " and" + ChatColor.AQUA + " /nations");
        cs.sendMessage(ChatColor.AQUA + "/Nation" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Shows info on the Nations plugin commands.");
        cs.sendMessage(ChatColor.AQUA + "/Nation list" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays active nations.");
        cs.sendMessage(ChatColor.AQUA + "/Nation info <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays additional info on a nation.");
        cs.sendMessage(ChatColor.AQUA + "/Nation join <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Join a nation.");
        return true;
    }

    private boolean invalidParameters(CommandSender cs){
        cs.sendMessage(ChatColor.RED + "Invalid arguments, please choose a nation.");
        return true;
    }

    private boolean nationList(CommandSender cs){
        cs.sendMessage("----" + ChatColor.GREEN + " Active nations " + ChatColor.WHITE + "----");
        for(int counter = 0; counter <= 3; counter++){
            cs.sendMessage(ChatColor.AQUA + plugin.NationNum[counter] + ChatColor.WHITE + " | " + ChatColor.GREEN + "Use " + ChatColor.GOLD + "/nation info " + plugin.NationNum[counter] + ChatColor.GREEN + " for more information.");
        }
        return true;
    }

    private boolean nationLeave(CommandSender cs){
        if(isConsole(cs)){
            return true;
        }
        //TODO Redo the removal of the player
        Nation.removeFromNation(NationType.England, (Player)cs);
        return true;
    }

    private boolean nationInfo(CommandSender cs, String[] args){
        if(!NationType.contains(args[1])){
            return true;
        }
        cs.sendMessage("Coming Soon");
        return true;
    }

    private boolean nationJoin(CommandSender cs, String[] args){
        if(isConsole(cs)){
            return true;
        }
        if(!NationType.contains(args[1])){
            return true;
        }
        Nation.addToNation(NationType.valueOf(args[1]), (Player) cs);
        cs.sendMessage("You have been added to: " + args[1]);
        return true;
    }

    private boolean isConsole(CommandSender cs){
        if (!(cs instanceof Player)) {
            cs.sendMessage(Nations.colorize("&4This command is only available to players!"));
            return true;
        }
        return false;
    }
}