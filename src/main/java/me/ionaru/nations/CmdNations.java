package main.java.me.ionaru.nations;

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
                }else if(args[0].equalsIgnoreCase("list") || args[0].equalsIgnoreCase("info")){
                    return nationList(cs);
                }else if(args[0].equalsIgnoreCase("join")){
                    return invalidParameters(cs);
                }else if(args[0].equalsIgnoreCase("leave")){
                    return nationLeave(cs);
                }else{
                	return nationErrorCommand(cs);
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
        cs.sendMessage("----" + ChatColor.AQUA + " Nations Help (" + ChatColor.RED + "Admin" +  ChatColor.GREEN + ") " + ChatColor.WHITE + "----");
        cs.sendMessage(ChatColor.GREEN + "Accepted command aliases: " + ChatColor.GOLD + "/n" + ChatColor.GREEN + "," + ChatColor.GOLD + " /nation" + ChatColor.GREEN + " and" + ChatColor.GOLD + " /nations");
        cs.sendMessage(ChatColor.GOLD + "/Nation" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Shows info on the Nations plugin commands.");
        cs.sendMessage(ChatColor.GOLD + "/Nation list" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays active nations.");
        cs.sendMessage(ChatColor.GOLD + "/Nation info <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays additional info on a nation.");
        cs.sendMessage(ChatColor.GOLD + "/Nation join <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Join a nation.");
        return true;
    }

    private boolean userHelp(CommandSender cs){
        cs.sendMessage("----" + ChatColor.AQUA + " Nations Help " + ChatColor.WHITE + "----");
        cs.sendMessage(ChatColor.GREEN + "Accepted command aliases: " + ChatColor.GOLD + "/n" + ChatColor.GREEN + "," + ChatColor.GOLD + " /nation" + ChatColor.GREEN + " and" + ChatColor.GOLD + " /nations");
        cs.sendMessage(ChatColor.GOLD + "/Nation" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Shows info on the Nations plugin commands.");
        cs.sendMessage(ChatColor.GOLD + "/Nation list" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays active nations.");
        cs.sendMessage(ChatColor.GOLD + "/Nation info <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays additional info on a nation.");
        cs.sendMessage(ChatColor.GOLD + "/Nation join <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Join a nation.");
        return true;
    }

    private boolean invalidParameters(CommandSender cs){
        cs.sendMessage(ChatColor.RED + "Invalid arguments, please choose a nation.");
        return true;
    }

    private boolean nationList(CommandSender cs){
        cs.sendMessage(plugin.colorize("&f---- &bActive nations &f----"));
        for(NationType n: NationType.values()){
            cs.sendMessage(plugin.colorize("&b" + n.getTitle() + "&f | &aUse &6/nation info " + n.getTitle() + "&a for more information."));
        }
        return true;
    }

    private boolean nationLeave(CommandSender cs){
        if(isConsole(cs)){
            return true;
        }
        Nation.removeFromNation((Player)cs);
        return true;
    }

    private boolean nationInfo(CommandSender cs, String[] args){
        String nation = args[1].toUpperCase();
        if(!NationType.contains(nation)){
        	cs.sendMessage(plugin.colorize("&cThat nation does not exist, use &6/nation list &cto see the active nations!"));
            return true;
        }
        NationType type = NationType.valueOf(nation);
        cs.sendMessage(plugin.colorize("&f---- &6Nation info: &b" + type.getTitle() + " &f----"));
        cs.sendMessage(plugin.colorize("&6Lore: &a" + type.getLore()));
        cs.sendMessage(plugin.colorize("----"));
        cs.sendMessage(plugin.colorize("&6Traits: &a" + type.getTraits()));
        cs.sendMessage(plugin.colorize("----"));
        return true;
    }

    private boolean nationJoin(CommandSender cs, String[] args){
        String nation = args[1].toUpperCase();
        if(isConsole(cs)){
            return true;
        }
        if(!NationType.contains(nation)){
        	cs.sendMessage(plugin.colorize("&cThat nation does not exist, use &6/nation list &cto see the active nations!"));
            return true;
        }
        Nation.addToNation(NationType.valueOf(nation), (Player) cs);
        return true;
    }

    private boolean isConsole(CommandSender cs){
        if (!(cs instanceof Player)) {
            cs.sendMessage(Nations.colorize("&4This command is only available to players!"));
            return true;
        }
        return false;
    }
    
    private boolean nationErrorCommand(CommandSender cs){
    	cs.sendMessage(Nations.colorize("&cThis is not a valid Nations command!"));
		return true;
    }
}
