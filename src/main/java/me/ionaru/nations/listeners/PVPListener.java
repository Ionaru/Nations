package me.ionaru.nations.listeners;

import me.ionaru.nations.Nations;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.potion.PotionEffect;

public class PVPListener implements Listener {

    public PVPListener(Nations nations) {
    	//Constructor
    }
       /* This method checks if two players are on the same team,
    and sends a warning to the attacker if they are. */
    private boolean sameTeam(Player victim, Player attacker) {
    	if(Nations.nations.containsKey(victim.getName()) && Nations.nations.containsKey(attacker.getName())) {
            if (Nations.nations.get(victim.getName()).equals(Nations.nations.get(attacker.getName()))) {
            	attacker.sendMessage(Nations.colorize("&cYou can't attack someone from your own nation."));
            	return true;
            }
        }
        return false;
    }
     
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) { // Triggered whenever an entity damages another entity
        if(!(e.getEntity() instanceof Player)) {
            // Victim is not a player
            return;
        }
     
        // Cast victim
        Player victim = (Player) e.getEntity();
     
        // Create an empty player object to store attacker
        Player attacker = null;
     
        if(e.getDamager() instanceof Player) {
            // Attacker is a player (melee damage)
            attacker = (Player) e.getDamager();
        } else if((e.getDamager() instanceof Arrow)){
            // Attacker is an arrow or snowball (projectile damage)
            Arrow arrow = (Arrow) e.getDamager();
            if(!(arrow.getShooter() instanceof Player)){
                // Projectile was not fired by a player
                return;
            }
            // Cast attacker
            attacker = (Player) arrow.getShooter();
        } else if(e.getDamager() instanceof Snowball){ 
        	Snowball snowball = (Snowball) e.getDamager();
        	if(!(snowball.getShooter() instanceof Player)){
        		return;
        	}
        	attacker = (Player) snowball.getShooter();
        } else if(e.getDamager() instanceof ThrownPotion) {
            /* Splash potion of harming triggers this event because it deals direct damage,
            but we will deal with that kind of stuff in PotionSplashEvent instead */
            return;
        }
     
        // It's possible to shoot yourself
        if(victim == attacker) {
            return;
        }
        // Just a quick null check for the attacker, in case I missed something
        if(attacker == null) {
            return;
        }
     
        // Check the teams
        if(sameTeam(victim, attacker)) {
            e.setCancelled(true);
        }
    }
     
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onPotionSplash(PotionSplashEvent e) {
        // Is this a dangerous potion? (Probably not the most efficient way to check this. Tips?)
        boolean cancel = true;
        for(PotionEffect effect : e.getEntity().getEffects()) {
            if(effect.getType().getName().equalsIgnoreCase("harm") || // Splash potion of harming
            effect.getType().getName().equalsIgnoreCase("poison") || // Splash potion of poison
            effect.getType().getName().equalsIgnoreCase("slow") || // Splash potion of slowness
            effect.getType().getName().equalsIgnoreCase("weak")){ //Spash potion of weakness
                cancel = false;
            }
        }
        if(cancel) return;
     
        // Figure out who threw it
        if(!(e.getPotion().getShooter() instanceof Player)) {
            // The potion was not thrown by a player. Probably just some crazy witch again.
            return;
        }
     
        // Cast attacker
        Player attacker = (Player) e.getPotion().getShooter();
     
        // Check each entity that was hit by this potion
        Player victim = null;
        for(LivingEntity entity : e.getAffectedEntities()) {
            if(entity instanceof Player) {
                // This victim is a player, cast him/her
                victim = (Player) entity;
     
                // You can easily hit yourself with a splash potion.
                if(victim == attacker) {
                    // Yeah, this is the same player. Let him burn! Next!
                    continue;
                }
     
                // Check teams
                if(sameTeam(victim, attacker)) {
                    // Reduce the effect of this potion to zero (victim only)
                    e.setIntensity(victim, 0);
                }
            }
        }
    }
}
