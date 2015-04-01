package nl.galaxias.commandblocksextendedlite;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandBlocksExtendedLite extends JavaPlugin implements Listener {
    private static Plugin plugin;

    public void onEnable()
    {
        plugin = this;

        registerEvents(this, new PlayerInteractListener());
    }

    public void onDisable() {
        plugin = null;
    }

    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}