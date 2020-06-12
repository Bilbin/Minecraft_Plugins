package io.github.bilbin.slimebootsplugin;

import io.github.bilbin.slimebootsplugin.listeners.DamageListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

public final class SlimeBootsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        registerSlimeBoots();
        BukkitRunnable fallingTask = new FallingTask(this);
        fallingTask.runTaskTimer(this, 0L, 1L);
        this.getCommand("vel").setExecutor(new VelocityCommand());
        Bukkit.getServer().getPluginManager().registerEvents(new DamageListener(), this);
    }

    private void registerSlimeBoots() {
        ItemStack item = new ItemStack(Material.IRON_BOOTS);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.GREEN + "Slime Boots");
        item.setItemMeta(meta);
        NamespacedKey key = new NamespacedKey(this, "slime_boots");

        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("   ", "S S", "S S");
        recipe.setIngredient('S', Material.SLIME_BLOCK);
        Bukkit.addRecipe(recipe);
    }
}
