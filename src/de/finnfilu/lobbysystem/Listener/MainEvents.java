package de.finnfilu.lobbysystem.Listener;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.lobbysystem.Commands.BuildCMD;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;

public class MainEvents implements Listener {

    @EventHandler
    public void onDamage(PlayerJoinEvent e) {
        final Player p = e.getPlayer();

        e.setJoinMessage(null);
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);

    }

    @EventHandler
    public void onHunger(EntityDamageEvent e) {

        e.setCancelled(true);

    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {

        if (!BuildCMD.builders.contains(e.getPlayer().getName())) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void onFood(FoodLevelChangeEvent e) {
        Player p = (Player) e.getEntity();

        e.setCancelled(true);
        p.setFoodLevel(20);

    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {

        if (!BuildCMD.builders.contains(e.getPlayer().getName())) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void onMove(InventoryDragEvent e) {

        if (!BuildCMD.builders.contains(e.getWhoClicked().getName())) {
            e.setCancelled(true);
        } else if (BuildCMD.builders.contains(e.getWhoClicked().getName())) {
            e.setCancelled(false);
        }

    }

    @EventHandler
    public void onInventory(InventoryInteractEvent e) {

        if (!BuildCMD.builders.contains(e.getWhoClicked().getName())) {
            e.setCancelled(true);
        } else if (BuildCMD.builders.contains(e.getWhoClicked().getName())) {
            e.setCancelled(false);
        }

    }

    @EventHandler
    public void onInv(InventoryPickupItemEvent e) {

        e.setCancelled(true);

    }

    @EventHandler
    public void onI(InventoryMoveItemEvent e) {

        if (!BuildCMD.builders.contains(e.getSource().getName())) {
            e.setCancelled(true);
        } else if (BuildCMD.builders.contains(e.getSource().getName())) {
            e.setCancelled(false);
        }

    }

    @EventHandler
    public void onItem(InventoryClickEvent e) {

        if (!BuildCMD.builders.contains(e.getWhoClicked().getName())) {
            e.setCancelled(true);
        } else if (BuildCMD.builders.contains(e.getWhoClicked().getName())) {
            e.setCancelled(false);
        }

    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {

        if (!BuildCMD.builders.contains(e.getPlayer().getName())) {
            e.setCancelled(true);
        } else if (BuildCMD.builders.contains(e.getPlayer().getName())) {
            e.setCancelled(false);
        }

    }

    @EventHandler
    public void onPick(PlayerPickupItemEvent e) {

        if (!BuildCMD.builders.contains(e.getPlayer().getName())) {
            e.setCancelled(true);
        } else if (BuildCMD.builders.contains(e.getPlayer().getName())) {
            e.setCancelled(false);
        }

    }

}
