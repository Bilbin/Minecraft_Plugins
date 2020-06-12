package io.github.bilbin.slimebootsplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class VelocityCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length != 1) return false;

        int vel = Integer.parseInt(args[0]);
        Player player = (Player) sender;
        player.setVelocity(new Vector(0, vel, 0));

        return false;
    }
}
