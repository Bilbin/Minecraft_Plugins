package io.github.bilbin.deathmessagesplugin;

import io.github.bilbin.deathmessagesplugin.listeners.DeathListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathMessagesPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new DeathListener(), this);
    }
}
