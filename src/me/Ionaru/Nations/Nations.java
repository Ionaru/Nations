package me.Ionaru.Nations;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Nations extends JavaPlugin{
	public static Nations plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	
	@EventHandler
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " disabled");
	}
	@EventHandler
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " " + pdfFile.getVersion()
				+ " enabled");
	}
	
	String Nation[] = {"England","Netherlands","Spain","France"};
	
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		Player player = (Player) sender;
		if(commandLabel.equalsIgnoreCase("nation") || commandLabel.equalsIgnoreCase("n") || commandLabel.equalsIgnoreCase("nations")){
			if(args.length == 0){
				if(player.isOp()){
					player.sendMessage("----" + ChatColor.GREEN + " Nations Help (Admin) " + ChatColor.WHITE + "----");
					player.sendMessage(ChatColor.AQUA + "Accepted command aliases: /n, /nation and /nations");
					player.sendMessage(ChatColor.AQUA + "/Nation" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Shows info on the Nations plugin commands.");
					player.sendMessage(ChatColor.AQUA + "/Nation list" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays active nations.");
					player.sendMessage(ChatColor.AQUA + "/Nation info <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays additional info on a nation.");
					player.sendMessage(ChatColor.AQUA + "/Nation join <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Join a nation.");
				}
				else{
					player.sendMessage("----" + ChatColor.GREEN + "Nations Help" + ChatColor.WHITE + "----");
					player.sendMessage(ChatColor.AQUA + "/Nation" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Shows info on the Nations plugin commands.");
					player.sendMessage(ChatColor.AQUA + "/Nation list" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays active nations.");
					player.sendMessage(ChatColor.AQUA + "/Nation info <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays additional info on a nation.");
					player.sendMessage(ChatColor.AQUA + "/Nation join <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Join a nation.");
				}
			}
			else if(args.length == 1){
				if(args[0].equals("?") || args[0].equalsIgnoreCase("help")){
					if(player.isOp()){
						player.sendMessage("----" + ChatColor.GREEN + " Nations help (Admin) " + ChatColor.WHITE + "----");
						player.sendMessage(ChatColor.AQUA + "Accepted command aliases: /n, /nation and /nations");
						player.sendMessage(ChatColor.AQUA + "/Nation" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Shows info on the Nations plugin commands.");
						player.sendMessage(ChatColor.AQUA + "/Nation list" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays active nations.");
						player.sendMessage(ChatColor.AQUA + "/Nation info <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays additional info on a nation.");
						player.sendMessage(ChatColor.AQUA + "/Nation join <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Join a nation.");
					}
					else{
						player.sendMessage("----" + ChatColor.GREEN + " Nations Help " + ChatColor.WHITE + "----");
						player.sendMessage(ChatColor.AQUA + "/Nation" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Shows info on the Nations plugin commands.");
						player.sendMessage(ChatColor.AQUA + "/Nation list" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays active nations.");
						player.sendMessage(ChatColor.AQUA + "/Nation info <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays additional info on a nation.");
						player.sendMessage(ChatColor.AQUA + "/Nation join <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Join a nation.");
					}
				}
				else if(args[0].equalsIgnoreCase("list")){
					int counter = 0;
					player.sendMessage("----" + ChatColor.GREEN + " Active nations " + ChatColor.WHITE + "----");
					player.sendMessage(ChatColor.AQUA + Nation[counter] + ChatColor.WHITE + " | " + ChatColor.GREEN + "Use " + ChatColor.GOLD + "/nation info " + Nation[counter] + ChatColor.GREEN + " for more information.");
					counter++;
					player.sendMessage(ChatColor.AQUA + Nation[counter] + ChatColor.WHITE + " | " + ChatColor.GREEN + "Use " + ChatColor.GOLD + "/nation info " + Nation[counter] + ChatColor.GREEN + " for more information.");
					counter++;
					player.sendMessage(ChatColor.AQUA + Nation[counter] + ChatColor.WHITE + " | " + ChatColor.GREEN + "Use " + ChatColor.GOLD + "/nation info " + Nation[counter] + ChatColor.GREEN + " for more information.");
					counter++;
					player.sendMessage(ChatColor.AQUA + Nation[counter] + ChatColor.WHITE + " | " + ChatColor.GREEN + "Use " + ChatColor.GOLD + "/nation info " + Nation[counter] + ChatColor.GREEN + " for more information.");
				}
				else if(args[0].equalsIgnoreCase("info") || args[0].equalsIgnoreCase("join")){
					player.sendMessage(ChatColor.RED + "Invalid arguments, please choose a nation.");
				}
			}
			else if(args.length == 2){
				if(args[0].equalsIgnoreCase("info") && args[1].equalsIgnoreCase(Nation[0])){
					player.sendMessage("----" + ChatColor.GREEN + " Nation info " + ChatColor.AQUA + "(England) " + ChatColor.WHITE + "----");
					player.sendMessage(ChatColor.AQUA + "General info" + ChatColor.WHITE + " | " + ChatColor.GREEN + "<General info on England here...>");
					player.sendMessage(ChatColor.AQUA + "Traits" + ChatColor.WHITE + " | " + ChatColor.GREEN + "<Info on English traits here...>");
				}
				else if(args[0].equalsIgnoreCase("info") && args[1].equalsIgnoreCase(Nation[1])){
					player.sendMessage("----" + ChatColor.GREEN + " Nation info " + ChatColor.AQUA + "(The Netherlands) " + ChatColor.WHITE + "----");
					player.sendMessage(ChatColor.AQUA + "General info" + ChatColor.WHITE + " | " + ChatColor.GREEN + "<General info on The Netherlands here...>");
					player.sendMessage(ChatColor.AQUA + "Traits" + ChatColor.WHITE + " | " + ChatColor.GREEN + "<Info on Dutch traits here...>");
					}
				else if(args[0].equalsIgnoreCase("info") && args[1].equalsIgnoreCase(Nation[2])){
					player.sendMessage("----" + ChatColor.GREEN + " Nation info " + ChatColor.AQUA + "(Spain) " + ChatColor.WHITE + "----");
					player.sendMessage(ChatColor.AQUA + "General info" + ChatColor.WHITE + " | " + ChatColor.GREEN + "<General info on Spain here...>");
					player.sendMessage(ChatColor.AQUA + "Traits" + ChatColor.WHITE + " | " + ChatColor.GREEN + "<Info on Spanish traits here...>");
				}
				else if(args[0].equalsIgnoreCase("info") && args[1].equalsIgnoreCase(Nation[3])){
					player.sendMessage("----" + ChatColor.GREEN + " Nation info " + ChatColor.AQUA + "(France) " + ChatColor.WHITE + "----");
					player.sendMessage(ChatColor.AQUA + "General info" + ChatColor.WHITE + " | " + ChatColor.GREEN + "<General info on France here...>");
					player.sendMessage(ChatColor.AQUA + "Traits" + ChatColor.WHITE + " | " + ChatColor.GREEN + "<Info on French traits here...>");
				}
			}
		}
		return false;
	}
}
