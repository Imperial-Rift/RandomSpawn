package dev.jdog.randomlocation.listeners;

import dev.jdog.randomlocation.Coordinates;
import dev.jdog.randomlocation.Locations;
import dev.jdog.randomlocation.RandomLocation;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Random;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();


        PersistentDataContainer data = p.getPersistentDataContainer();

        if (!data.has(new NamespacedKey(RandomLocation.getPlugin(), "spawn"), PersistentDataType.STRING)){
            Locations locations = new Locations();
            String newLoc = locations.random();

            data.set(new NamespacedKey(RandomLocation.getPlugin(), "spawn"), PersistentDataType.STRING, newLoc);

            Coordinates cords = locations.getCords(newLoc);
            Block safeBlock = e.getPlayer().getWorld().getHighestBlockAt(cords.getLat(), cords.getLon());
            e.getPlayer().teleport(new Location(e.getPlayer().getWorld(), cords.getLat(), safeBlock.getY(), cords.getLon()));
            p.sendMessage(ChatColor.GOLD + "You spawned in " + ChatColor.WHITE + newLoc + ChatColor.GOLD + "!");
        }


    }
}
