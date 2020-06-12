package io.github.bilbin.slimebootsplugin;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FallingTask extends BukkitRunnable {

    private JavaPlugin plugin;
    private Map<String, Double> fallHeightMap = new HashMap<String, Double>();

    FallingTask (JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        List<Player> players = plugin.getServer().getWorld("world").getPlayers();

        for (Player player: players) {
            //System.out.println(player.getInventory().getBoots().getItemMeta());
            //System.out.println(player.getInventory().getBoots().getItemMeta().getDisplayName());
            if (!player.getInventory().getBoots().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Slime Boots")) return;

            //Initialize player fall height if not in
            if (!player.isOnGround() && !fallHeightMap.containsKey(player.getName())) {
                fallHeightMap.put(player.getName(), player.getLocation().getY());
            }

            //Put fall height at apex of jump
            if (!player.isOnGround() && fallHeightMap.containsKey(player.getName()) && player.getLocation().getY() > fallHeightMap.get(player.getName())) {
                fallHeightMap.replace(player.getName(), player.getLocation().getY());
            }

            //Bounce if back on ground after falling
            if (player.isOnGround() && fallHeightMap.containsKey(player.getName())) {
                double bounceBack = (fallHeightMap.get(player.getName()) - player.getLocation().getY());
                fallHeightMap.remove(player.getName());

                if (bounceBack >= 2) {
                    Vector vector = player.getVelocity();
                    double blocksToMove = bounceBack / (double)2;
                    if (blocksToMove < 20) {
                        vector.setY((blocksToMove / (double)10) + 0.3);
                    } else {
                        vector.setY(1.1 + (Math.pow(blocksToMove, 2)) / (double)441);
                    }
                    System.out.println(vector.getY());

                    player.setVelocity(vector);
                }
            }
        }

    }
}
