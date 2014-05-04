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
					player.sendMessage("----" + ChatColor.GREEN + "Nations Help (Admin)" + ChatColor.WHITE + "---- " + Nation[1]);
					player.sendMessage(ChatColor.AQUA + "/n, /nation and /nations");
					player.sendMessage(ChatColor.AQUA + "/Nation" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Shows info on the Nations plugin commands.");
					player.sendMessage(ChatColor.AQUA + "/Nation list" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays active nations.");
					player.sendMessage(ChatColor.AQUA + "/Nation info <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays additional info on a nation.");
					player.sendMessage(ChatColor.AQUA + "/Nation join <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Join a nation.");
				}else{
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
						player.sendMessage("----" + ChatColor.GREEN + "Nations Help (Admin)" + ChatColor.WHITE + "----");
						player.sendMessage(ChatColor.AQUA + "/n, /nation and /nations");
						player.sendMessage(ChatColor.AQUA + "/Nation" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Shows info on the Nations plugin commands.");
						player.sendMessage(ChatColor.AQUA + "/Nation list" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays active nations.");
						player.sendMessage(ChatColor.AQUA + "/Nation info <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays additional info on a nation.");
						player.sendMessage(ChatColor.AQUA + "/Nation join <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Join a nation.");
					}else{
						player.sendMessage("----" + ChatColor.GREEN + "Nations Help" + ChatColor.WHITE + "----");
						player.sendMessage(ChatColor.AQUA + "/Nation" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Shows info on the Nations plugin commands.");
						player.sendMessage(ChatColor.AQUA + "/Nation list" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays active nations.");
						player.sendMessage(ChatColor.AQUA + "/Nation info <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays additional info on a nation.");
						player.sendMessage(ChatColor.AQUA + "/Nation join <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Join a nation.");
					}
				}
				else if(args[0].equalsIgnoreCase("info") || args[0].equalsIgnoreCase("join")){
					player.sendMessage(ChatColor.RED + "Invalid arguments, please choose a nation.");
				}
			}
			else if(args.length ==2){
				if(args[0].equalsIgnoreCase("info") && args[1].equalsIgnoreCase(Nation[1])){
					player.sendMessage(ChatColor.AQUA + "The Netherlands" + ChatColor.WHITE + " | " + ChatColor.GREEN + "<Info on The Netherlands here...>");
				}
			}
		}
		return false;
	}
}
