package me.ionaru.nations;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class FrenchRunnable extends BukkitRunnable {
	
	private final Nations parent;
	
	public FrenchRunnable (Nations _parent) {
		parent = _parent;
	}

	@Override
	public void run() {
		for(String s : parent.getPlayersInNation(NationType.FRANCE)) {
			Player p = parent.getServer().getPlayer(s);
			PlayerInventory i = p.getInventory();
			
			if(p!=null) {
				// wearing a complete set of diamond armor gives them Resistance 2
				if(i.getChestplate().getType().equals(Material.DIAMOND_CHESTPLATE)) {
					if(i.getBoots().getType().equals(Material.DIAMOND_BOOTS)) {
						if (i.getLeggings().getType().equals(Material.DIAMOND_LEGGINGS)) {
							if (i.getHelmet().getType().equals(Material.DIAMOND_HELMET)) {
								p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 1));
							}
						}
					}
				}
				else if(i.getChestplate().getType().equals(Material.IRON_CHESTPLATE)) {
					if(i.getBoots().getType().equals(Material.IRON_BOOTS)) {
						if (i.getLeggings().getType().equals(Material.IRON_LEGGINGS)) {
							if (i.getHelmet().getType().equals(Material.IRON_HELMET)) {
								p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 0));
							}
						}
					}
				}
				else if(i.getChestplate().getType().equals(Material.LEATHER_CHESTPLATE)) {
					if(i.getBoots().getType().equals(Material.LEATHER_BOOTS)) {
						if (i.getLeggings().getType().equals(Material.LEATHER_LEGGINGS)) {
							if (i.getHelmet().getType().equals(Material.LEATHER_HELMET)) {
								p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 0));
							}
						}
					}
				}
				// for what gold lacks in durablitliy, it protects better
				else if(i.getChestplate().getType().equals(Material.GOLD_CHESTPLATE)) {
					if(i.getBoots().getType().equals(Material.GOLD_BOOTS)) {
						if (i.getLeggings().getType().equals(Material.GOLD_LEGGINGS)) {
							if (i.getHelmet().getType().equals(Material.GOLD_HELMET)) {
								p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 2));
							}
						}
					}
				}
			}
			
		}

	}

}
