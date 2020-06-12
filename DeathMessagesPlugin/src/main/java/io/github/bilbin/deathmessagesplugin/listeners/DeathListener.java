package io.github.bilbin.deathmessagesplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    @EventHandler
    private void onPlayerDeath(PlayerDeathEvent e) {
        if(e.getEntity().getKiller() == null) e.setDeathMessage(null);
    }
}
