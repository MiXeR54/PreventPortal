package ru.mixer54.pp;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class PreventPortal extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents((Listener) this, (Plugin) this);
    }


    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onIgnite(BlockIgniteEvent event) {
        //Player player = (Player) event.getPlayer();
        if (event.getBlock().getType() == Material.OBSIDIAN
                || event.getBlock().getRelative(BlockFace.DOWN).getType() == Material.OBSIDIAN
                || event.getBlock().getRelative(BlockFace.UP).getType() == Material.OBSIDIAN
                || event.getBlock().getRelative(BlockFace.EAST).getType() == Material.OBSIDIAN
                || event.getBlock().getRelative(BlockFace.WEST).getType() == Material.OBSIDIAN
                || event.getBlock().getRelative(BlockFace.NORTH).getType() == Material.OBSIDIAN
                || event.getBlock().getRelative(BlockFace.SOUTH).getType() == Material.OBSIDIAN) {

            if (!event.getPlayer().isOp()) {
                String nick = event.getPlayer().getName();
                getLogger().info(nick + " tried to open nether portal");
                //player.sendMessage("ignition obsidian prohibited");
                event.setCancelled(true);
            }
        }
    }
}

