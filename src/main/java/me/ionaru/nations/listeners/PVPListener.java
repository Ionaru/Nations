package ionaru.nations.listeners;

import main.java.me.ionaru.nations.Nations;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class PVPListener implements Listener {

    Nations plugin;

    public PVPListener(Nations nations) {
        plugin = nations;
    }

    @EventHandler
    public void onDamageEvent(EntityDamageByEntityEvent event){
        Entity entity = event.getEntity();
        Entity attacker = event.getDamager();

        if(entity instanceof Player && attacker instanceof Player){
            Player player = (Player) entity;
            Player player2 = (Player) attacker;

            if(Nations.nations.containsKey(player.getName()) && Nations.nations.containsKey(player2.getName())) {
                if (Nations.nations.get(player.getName()).equals(Nations.nations.get(player2.getName()))) {
                    player2.sendMessage(Nations.colorize("&cYou can't attack someone from your own nation."));
                    event.setCancelled(true);
                }
            }
        }
    }
}
