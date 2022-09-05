package dev.jdog.randomlocation.listeners;

import dev.jdog.randomlocation.Coordinates;
import dev.jdog.randomlocation.Locations;
import dev.jdog.randomlocation.RandomLocation;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PlayerRespawnListener implements Listener {
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();

        if (!p.getWorld().getName().endsWith("_the_end")) {
            PersistentDataContainer data = p.getPersistentDataContainer();

            if (!data.has(new NamespacedKey(RandomLocation.getPlugin(), "spawn"), PersistentDataType.STRING)){
                p.sendMessage(ChatColor.DARK_RED + "Failed to find your previous spawn!");
            } else {
                String spawn = data.get(new NamespacedKey(RandomLocation.getPlugin(), "spawn"), PersistentDataType.STRING);
                Coordinates coords = new Locations().getCords(spawn);
                Block safeBlock = e.getPlayer().getWorld().getHighestBlockAt(coords.getLat(), coords.getLon());
                e.setRespawnLocation(new Location(e.getPlayer().getWorld(), coords.getLat(), safeBlock.getY(), coords.getLon()));
                p.sendMessage(ChatColor.GOLD + "You spawned back in " + ChatColor.WHITE + spawn + ChatColor.GOLD + "!");
            }
        }
    }
}
