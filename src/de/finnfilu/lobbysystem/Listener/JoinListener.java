package de.finnfilu.lobbysystem.Listener;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.lobbysystem.Main.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        final Player p = e.getPlayer();

        e.setJoinMessage(Main.getInstance().getConfig().getString("LobbySystem.JoinMessage").replace("&", "§").replace("name", p.getName()));

        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta cmeta = compass.getItemMeta();
        cmeta.setDisplayName(Main.getInstance().getConfig().getString("Item.CompassName").replace("&", "§"));
        compass.setItemMeta(cmeta);

        ItemStack br = new ItemStack(Material.BLAZE_ROD);
        ItemMeta bmeta = br.getItemMeta();
        bmeta.setDisplayName(Main.getInstance().getConfig().getString("Item.BlazeRodName").replace("&", "§"));
        br.setItemMeta(bmeta);

        ItemStack head = new ItemStack(Material.SKULL_ITEM);
        SkullMeta hmeta = (SkullMeta) head.getItemMeta();
        hmeta.setOwner(p.getName());
        hmeta.setDisplayName(Main.getInstance().getConfig().getString("Item.HeadName").replace("&", "§"));
        head.setItemMeta(hmeta);

        p.getInventory().setItem(0, compass);
        p.getInventory().setItem(1, br);
        p.getInventory().setItem(8, head);

    }
}
