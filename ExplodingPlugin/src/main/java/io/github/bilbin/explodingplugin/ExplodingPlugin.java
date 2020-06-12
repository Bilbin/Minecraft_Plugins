package io.github.bilbin.explodingplugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

public final class ExplodingPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        BukkitRunnable explodingTask = new ExplodingTask(this);
        explodingTask.runTaskTimer(this, 20L, 20L);
    }

}
