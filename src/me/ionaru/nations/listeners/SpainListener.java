package me.ionaru.nations.listeners;

import java.util.Random;
import java.util.logging.Level;

import me.ionaru.nations.NationType;
import me.ionaru.nations.Nations;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Dye;

public class SpainListener implements Listener {
	
	private Nations parent;
	
	public SpainListener(Nations nations) {
		parent = nations;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onBlockBreak(BlockBreakEvent e) {
		if(parent.isInNation(e.getPlayer())) {
			if(parent.getNationType(e.getPlayer()).equals(NationType.SPAIN)) {
				Random rand = new Random();
				if(rand.nextInt(100) < parent.getConfig().getInt("extradropchance")){
					boolean ore = false;
					ItemStack is = null;
					
					Material type = e.getBlock().getType();
					
					if(type.equals(Material.COAL_ORE)) {
						is = new ItemStack(Material.COAL,2);
						ore = true;
					}
					else if (type.equals(Material.DIAMOND_ORE)) {
						is = new ItemStack(Material.DIAMOND,2);
						ore = true;
					}
					else if (type.equals(Material.IRON_ORE)) {
						is = new ItemStack(Material.IRON_INGOT,2); // prevents exploitation by dropping ingots
						ore = true;
					}
					else if (type.equals(Material.GOLD_ORE)) {
						is = new ItemStack(Material.GOLD_INGOT,2);// prevents exploitation by dropping ingots
						ore = true;
					}
					/*else if (type.equals(Material.OBSIDIAN)) {
						is = new ItemStack(Material.OBSIDIAN,2); // could be exploited
						ore = true;
					}*/
					else if (type.equals(Material.REDSTONE_ORE)) {
						is = new ItemStack(Material.REDSTONE,8);  // doesn't work right now
						ore = true;
					}
					else if (type.equals(Material.LAPIS_ORE )) {
						Dye l = new Dye();
						l.setColor(DyeColor.BLUE);  			// lapis is a dye, so create dyes
						is = l.toItemStack();
						is.setAmount(8);
						ore = true;
					}
					
					if(ore) {
						e.getBlock().setType(Material.AIR); // only cancel the event if it found an ore, else leave it alone
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
						e.setCancelled(true);
					}
					
				}
				
				
			}
		}
	}
	
}
