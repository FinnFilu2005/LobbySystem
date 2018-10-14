package de.finnfilu.lobbysystem.Listener;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.lobbysystem.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CompassListener implements Listener {

    Inventory inv = Bukkit.createInventory(null, 7 * 9);

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        final Player p = e.getPlayer();

        ItemStack b = new ItemStack(Material.BED);
        ItemMeta bm = b.getItemMeta();
        bm.setDisplayName(Main.getInstance().getConfig().getString("Compass.Item1Name").replace("&", "§"));
        b.setItemMeta(bm);

        ItemStack g = new ItemStack(Material.GRASS);
        ItemMeta gm = g.getItemMeta();
        gm.setDisplayName(Main.getInstance().getConfig().getString("Compass.Item2Name").replace("&", "§"));
        g.setItemMeta(gm);

        ItemStack s = new ItemStack(Material.SANDSTONE);
        ItemMeta sm = s.getItemMeta();
        sm.setDisplayName(Main.getInstance().getConfig().getString("Compass.Item3Name").replace("&", "§"));
        s.setItemMeta(sm);

        ItemStack i = new ItemStack(Material.IRON_SWORD);
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(Main.getInstance().getConfig().getString("Compass.Item4Name").replace("&", "§"));
        i.setItemMeta(im);

        ItemStack gl = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.BLACK.getData());
        ItemMeta glm = gl.getItemMeta();
        glm.setDisplayName(" ");
        gl.setItemMeta(glm);

        ItemStack n = new ItemStack(Material.NETHER_STAR);
        ItemMeta nm = n.getItemMeta();
        nm.setDisplayName(Main.getInstance().getConfig().getString("Compass.SpawnName").replace("&", "§"));
        n.setItemMeta(nm);

        inv.setItem(20, b);
        inv.setItem(24, g);
        inv.setItem(31, n);
        inv.setItem(38, s);
        inv.setItem(42, i);

        inv.setItem(0, gl);
        inv.setItem(1, gl);
        inv.setItem(2, gl);
        inv.setItem(3, gl);
        inv.setItem(4, gl);
        inv.setItem(5, gl);
        inv.setItem(6, gl);
        inv.setItem(7, gl);
        inv.setItem(8, gl);
        inv.setItem(9, gl);
        inv.setItem(17, gl);
        inv.setItem(18, gl);
        inv.setItem(26, gl);
        inv.setItem(27, gl);
        inv.setItem(35, gl);
        inv.setItem(36, gl);
        inv.setItem(44, gl);
        inv.setItem(45, gl);
        inv.setItem(53, gl);
        inv.setItem(54, gl);
        inv.setItem(55, gl);
        inv.setItem(56, gl);
        inv.setItem(57, gl);
        inv.setItem(58, gl);
        inv.setItem(59, gl);
        inv.setItem(60, gl);
        inv.setItem(61, gl);
        inv.setItem(62, gl);

        if (e.getMaterial() == Material.COMPASS) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {

                p.openInventory(inv);

            }
        }

    }

}
