package me.ionaru.nations.listeners;

import me.ionaru.nations.Nations;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class PVPListener implements Listener {

    private Nations parent;

    public PVPListener(Nations nations) {
        parent = nations;
    }

    @EventHandler
    public void onDamageEvent(EntityDamageByEntityEvent event){
        Entity entity = event.getEntity();
        Entity attacker = event.getDamager();

        if(entity instanceof Player && attacker instanceof Player){
            Player player = (Player) entity;
            Player player2 = (Player) attacker;

            if(parent.isInNation(player.getName()) && parent.isInNation(player2.getName())) {
                if (parent.getNationType(player).equals(parent.getNationType(player2))) {
                    player.sendMessage(Nations.colorize("&cYou can't attack someone from your own nation"));
                    event.setCancelled(true);
                }
            }
        }
    }
}
