package dev.jdog.randomlocation.commands;

import dev.jdog.randomlocation.Locations;
import dev.jdog.randomlocation.RandomLocation;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class SetSpawnCommand implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.isOp()) {
            if (args.length == 2) {
                Player p = Bukkit.getPlayer(args[0]);

                if (p != null) {
                    PersistentDataContainer data = p.getPersistentDataContainer();
                    data.set(new NamespacedKey(RandomLocation.getPlugin(), "spawn"), PersistentDataType.STRING, args[1]);
                }
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 2) {
            ArrayList<String> names = new Locations().getNames();
            return names;
        }
        return null;
    }
}
