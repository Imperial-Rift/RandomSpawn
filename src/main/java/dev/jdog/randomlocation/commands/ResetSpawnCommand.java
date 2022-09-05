package dev.jdog.randomlocation.commands;

import dev.jdog.randomlocation.RandomLocation;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;

public class ResetSpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.isOp()) {
            Player p = Bukkit.getPlayer(args[0]);

            if (p != null) {
                PersistentDataContainer data = p.getPersistentDataContainer();
                data.remove(new NamespacedKey(RandomLocation.getPlugin(), "spawn"));
            }


        }
        return true;
    }
}
