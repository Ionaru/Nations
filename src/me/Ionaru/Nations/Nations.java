package me.Ionaru.Nations;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.scoreboard.Team;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Nations extends JavaPlugin {
	public static Nations plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	
	 // Colors for the console output
	// example colored line: getLogger().info(ANSI_YELLOW + "TEXT" + ANSI_RESET);
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_BOLD = "\u001B[1m";
		
	
	@EventHandler
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " disabled");
	}
	@EventHandler
	public void onEnable() {
		this.logger.info(ANSI_CYAN + "Initializing Nations plugin." + ANSI_RESET);
		getConfig().options().copyDefaults(true);
		saveConfig();
		if(getConfig().getString("plugin_enabled") == "false"){
			this.logger.info(ANSI_RED + "Plugin_enabled is set to false in Nations config. Disabling plugin!" + ANSI_RESET);
			this.getServer().getPluginManager().disablePlugin(this);
		}
		else
		{
			this.logger.info(ANSI_GREEN + "Nations plugin enabled!" + ANSI_RESET);
		}
	}
	
	String NationNum[] = {"England","Netherlands","Spain","France"};
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;
		if(commandLabel.equalsIgnoreCase("nation") || commandLabel.equalsIgnoreCase("n") || commandLabel.equalsIgnoreCase("nations")){
			if(args.length == 0){
				if(player.isOp()){
					player.sendMessage("----" + ChatColor.GREEN + " Nations Help (" + ChatColor.RED + "Admin" +  ChatColor.GREEN + ") " + ChatColor.WHITE + "----");
					player.sendMessage(ChatColor.GREEN + "Accepted command aliases: " + ChatColor.AQUA + "/n" + ChatColor.GREEN + "," + ChatColor.AQUA + " /nation" + ChatColor.GREEN + " and" + ChatColor.AQUA + " /nations");
					player.sendMessage(ChatColor.AQUA + "/Nation" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Shows info on the Nations plugin commands.");
					player.sendMessage(ChatColor.AQUA + "/Nation list" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays active nations.");
					player.sendMessage(ChatColor.AQUA + "/Nation info <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays additional info on a nation.");
					player.sendMessage(ChatColor.AQUA + "/Nation join <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Join a nation.");
				}
				else{
					player.sendMessage("----" + ChatColor.GREEN + "Nations Help" + ChatColor.WHITE + "----");
					player.sendMessage(ChatColor.GREEN + "Accepted command aliases: " + ChatColor.AQUA + "/n" + ChatColor.GREEN + "," + ChatColor.AQUA + " /nation" + ChatColor.GREEN + " and" + ChatColor.AQUA + " /nations");
					player.sendMessage(ChatColor.AQUA + "/Nation" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Shows info on the Nations plugin commands.");
					player.sendMessage(ChatColor.AQUA + "/Nation list" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays active nations.");
					player.sendMessage(ChatColor.AQUA + "/Nation info <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays additional info on a nation.");
					player.sendMessage(ChatColor.AQUA + "/Nation join <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Join a nation.");
				}
			}
			else if(args.length == 1){
				if(args[0].equals("?") || args[0].equalsIgnoreCase("help")){
					if(player.isOp()){
						player.sendMessage("----" + ChatColor.GREEN + " Nations Help (" + ChatColor.RED + "Admin" +  ChatColor.GREEN + ") " + ChatColor.WHITE + "----");
						player.sendMessage(ChatColor.GREEN + "Accepted command aliases: " + ChatColor.AQUA + "/n" + ChatColor.GREEN + "," + ChatColor.AQUA + " /nation" + ChatColor.GREEN + " and" + ChatColor.AQUA + " /nations");
						player.sendMessage(ChatColor.AQUA + "/Nation" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Shows info on the Nations plugin commands.");
						player.sendMessage(ChatColor.AQUA + "/Nation list" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays active nations.");
						player.sendMessage(ChatColor.AQUA + "/Nation info <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays additional info on a nation.");
						player.sendMessage(ChatColor.AQUA + "/Nation join <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Join a nation.");
					}
					else{
						player.sendMessage("----" + ChatColor.GREEN + " Nations Help " + ChatColor.WHITE + "----");
						player.sendMessage(ChatColor.GREEN + "Accepted command aliases: " + ChatColor.AQUA + "/n" + ChatColor.GREEN + "," + ChatColor.AQUA + " /nation" + ChatColor.GREEN + " and" + ChatColor.AQUA + " /nations");
						player.sendMessage(ChatColor.AQUA + "/Nation" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Shows info on the Nations plugin commands.");
						player.sendMessage(ChatColor.AQUA + "/Nation list" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays active nations.");
						player.sendMessage(ChatColor.AQUA + "/Nation info <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Displays additional info on a nation.");
						player.sendMessage(ChatColor.AQUA + "/Nation join <Nation name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Join a nation.");
					}
				}
				else if(args[0].equalsIgnoreCase("list")){
					player.sendMessage("----" + ChatColor.GREEN + " Active nations " + ChatColor.WHITE + "----");
					for(int counter = 0; counter <= 3; counter++){
					player.sendMessage(ChatColor.AQUA + NationNum[counter] + ChatColor.WHITE + " | " + ChatColor.GREEN + "Use " + ChatColor.GOLD + "/nation info " + NationNum[counter] + ChatColor.GREEN + " for more information.");
					}
				}
				else if(args[0].equalsIgnoreCase("info") || args[0].equalsIgnoreCase("join")){
					player.sendMessage(ChatColor.RED + "Invalid arguments, please choose a nation.");
				}
				else if(args[0].equalsIgnoreCase("leave")){
					Nation.removeFromNation(NationType.England, player);
					//Removes player from whatever nation they are in
				}
			}
			else if(args.length == 2){
				//                     '/nation info' commands
				if(args[0].equalsIgnoreCase("info")){
					if(args[1].equalsIgnoreCase(NationNum[0])){
						player.sendMessage("----" + ChatColor.GREEN + " Nation info (" + ChatColor.AQUA + "England" + ChatColor.GREEN + ") " + ChatColor.WHITE + "----");
						player.sendMessage(ChatColor.AQUA + "General info" + ChatColor.WHITE + " | " + ChatColor.GREEN + "<General info on England here...>");
						player.sendMessage(ChatColor.AQUA + "Traits" + ChatColor.WHITE + " | " + ChatColor.GREEN + "<Info on English traits here...>");
					}
					else if(args[1].equalsIgnoreCase(NationNum[1])){
						player.sendMessage("----" + ChatColor.GREEN + " Nation info (" + ChatColor.AQUA + "The Netherlands" + ChatColor.GREEN + ") " + ChatColor.WHITE + "----");
						player.sendMessage(ChatColor.AQUA + "General info" + ChatColor.WHITE + " | " + ChatColor.GREEN + "<General info on The Netherlands here...>");
						player.sendMessage(ChatColor.AQUA + "Traits" + ChatColor.WHITE + " | " + ChatColor.GREEN + "<Info on Dutch traits here...>");
					}
					else if(args[1].equalsIgnoreCase(NationNum[2])){
						player.sendMessage("----" + ChatColor.GREEN + " Nation info (" + ChatColor.AQUA + "Spain" + ChatColor.GREEN + ") " + ChatColor.WHITE + "----");
						player.sendMessage(ChatColor.AQUA + "General info" + ChatColor.WHITE + " | " + ChatColor.GREEN + "<General info on Spain here...>");
						player.sendMessage(ChatColor.AQUA + "Traits" + ChatColor.WHITE + " | " + ChatColor.GREEN + "<Info on Spanish traits here...>");
					}
					else if(args[1].equalsIgnoreCase(NationNum[3])){
						player.sendMessage("----" + ChatColor.GREEN + " Nation info (" + ChatColor.AQUA + "France" + ChatColor.GREEN + ") " + ChatColor.WHITE + "----");
						player.sendMessage(ChatColor.AQUA + "General info" + ChatColor.WHITE + " | " + ChatColor.GREEN + "<General info on France here...>");
						player.sendMessage(ChatColor.AQUA + "Traits" + ChatColor.WHITE + " | " + ChatColor.GREEN + "<Info on French traits here...>");
					}
					else{
						player.sendMessage(ChatColor.RED + "Invalid arguments, please choose a nation.");
					}
				}
				//					'/nation join' commands
				else if(args[0].equalsIgnoreCase("join")){
					if(args[1].equalsIgnoreCase(NationNum[0])){
						Nation.addToNation(NationType.England, player);	
						//The player joins England
					}
					else if(args[1].equalsIgnoreCase(NationNum[1])){
						Nation.addToNation(NationType.Netherlands, player);
						//The player joins The Netherlands
					}
					else if(args[1].equalsIgnoreCase(NationNum[2])){
						player.sendMessage(ChatColor.GREEN + "You successfully joined " + ChatColor.AQUA + "Spain" + ChatColor.GREEN + "!");
						Nation.addToNation(NationType.Spain, player);
						//The player joins Spain
					}
					else if(args[1].equalsIgnoreCase(NationNum[3])){
						player.sendMessage(ChatColor.GREEN + "You successfully joined " + ChatColor.AQUA + "France" + ChatColor.GREEN + "!");
						Nation.addToNation(NationType.France, player);
						//The player joins France
					}
					else{
						player.sendMessage(ChatColor.RED + "Invalid arguments, please choose a nation.");
					}
				}
			}
		}
		return false;
	}
}
