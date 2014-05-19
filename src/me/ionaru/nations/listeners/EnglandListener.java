package me.ionaru.nations.listeners;

import me.ionaru.nations.NationType;
import me.ionaru.nations.Nations;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EnglandListener implements Listener {

	private Nations parent;
	
	public EnglandListener(Nations nations) {
		parent = nations;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBowHit(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Arrow)
        {
            Arrow arrow = (Arrow) e.getDamager();
            if (arrow.getShooter() instanceof Player)
            {
            	if(parent.isInNation((Player)arrow.getShooter())) {
            		if(parent.getNationType((Player)arrow.getShooter()).equals(NationType.ENGLAND)) {
            			// extra 2 hearts damage
            			e.setDamage(e.getDamage() +100);
            		}
            	}
            }
        }
	}

}
