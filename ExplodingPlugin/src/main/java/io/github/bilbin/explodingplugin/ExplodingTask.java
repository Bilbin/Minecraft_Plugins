package io.github.bilbin.explodingplugin;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Random;

public class ExplodingTask extends BukkitRunnable {

    private JavaPlugin plugin;

    protected ExplodingTask (JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        World world = Bukkit.getServer().getWorld("world");
        assert world != null;
        List<Entity> entities = world.getEntities();

        for (Entity entity: entities) {
            Random r = new Random();
            int check = r.nextInt();
            if ((check + 1) % 50 == 0 && entity instanceof Mob) {
                world.createExplosion(entity.getLocation(), 2F);
            }
        }
    }
}
