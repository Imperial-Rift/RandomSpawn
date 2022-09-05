package dev.jdog.randomlocation;

import dev.jdog.randomlocation.commands.ResetSpawnCommand;
import dev.jdog.randomlocation.commands.SetSpawnCommand;
import dev.jdog.randomlocation.listeners.PlayerRespawnListener;
import dev.jdog.randomlocation.listeners.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.java.JavaPlugin;

public final class RandomLocation extends JavaPlugin implements CommandExecutor {
    public static RandomLocation plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawnListener(), this);

        getCommand("resetSpawn").setExecutor(new ResetSpawnCommand());
        getCommand("setNewSpawn").setExecutor(new SetSpawnCommand());
        getCommand("setNewSpawn").setTabCompleter(new SetSpawnCommand());
    }

    public static RandomLocation getPlugin() {
        return plugin;
    }


}
