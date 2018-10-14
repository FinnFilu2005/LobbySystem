package de.finnfilu.lobbysystem.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.lobbysystem.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.io.File;
import java.util.ArrayList;

public class BuildCMD implements CommandExecutor {

    public static ArrayList<String> builders = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("buildmode")) {

            if (sender instanceof ConsoleCommandSender) {

                if (args.length == 1) {

                    File file = new File("plugins//LobbySystem//warps.yml");
                    if (!file.exists()) {
                        Bukkit.getConsoleSender().sendMessage(Main.getInstance().getPrefix() + "§cSetze den Spawn zuerst!");
                    } else if (Bukkit.getPlayer(args[0]) != null) {

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
                        hmeta.setOwner(Bukkit.getPlayer(args[0]).getName());
                        hmeta.setDisplayName(Main.getInstance().getConfig().getString("Item.HeadName").replace("&", "§"));
                        head.setItemMeta(hmeta);

                        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

                        if (!builders.contains(Bukkit.getPlayer(args[0]).getName())) {

                            builders.add(Bukkit.getPlayer(args[0]).getName());
                            Bukkit.getPlayer(args[0]).sendMessage(Main.getInstance().getPrefix() + "§7Baumodus wurde §aaktiviert.");
                            Main.getInstance().playSound(Bukkit.getPlayer(args[0]));
                            Bukkit.getPlayer(args[0]).getInventory().clear();
                            Bukkit.getPlayer(args[0]).setGameMode(GameMode.CREATIVE);
                            Bukkit.getConsoleSender().sendMessage(Main.getInstance().getPrefix() + "§e" + Bukkit.getPlayer(args[0]).getName() + "'s §7Baumodus wurde §aaktiviert.");

                        } else if (builders.contains(Bukkit.getPlayer(args[0]).getName())) {

                            builders.remove(Bukkit.getPlayer(args[0]).getName());
                            Bukkit.getPlayer(args[0]).sendMessage(Main.getInstance().getPrefix() + "§7Baumodus wurde §cdeaktiviert");
                            Main.getInstance().playSound(Bukkit.getPlayer(args[0]));
                            Bukkit.getPlayer(args[0]).setGameMode(GameMode.SURVIVAL);
                            Bukkit.getConsoleSender().sendMessage(Main.getInstance().getPrefix() + "§e" + Bukkit.getPlayer(args[0]).getName() + "'s §7Baumodus wurde §cdeaktiviert.");

                            String world = cfg.getString("Spawn.World");
                            int x = cfg.getInt("Spawn.X");
                            int y = cfg.getInt("Spawn.Y");
                            int z = cfg.getInt("Spawn.Z");
                            double yaw = cfg.getDouble("Spawn.Yaw");
                            double pitch = cfg.getDouble("Spawn.Pitch");

                            Location loc = Bukkit.getPlayer(args[0]).getLocation();
                            loc.setX(x);
                            loc.setY(y);
                            loc.setZ(z);
                            loc.setYaw((float) yaw);
                            loc.setPitch((float) pitch);

                            Bukkit.getPlayer(args[0]).teleport(loc);

                            Bukkit.getPlayer(args[0]).getInventory().clear();
                            Bukkit.getPlayer(args[0]).getInventory().setItem(0, compass);
                            Bukkit.getPlayer(args[0]).getInventory().setItem(1, br);
                            Bukkit.getPlayer(args[0]).getInventory().setItem(8, head);

                        }
                    } else
                        Bukkit.getConsoleSender().sendMessage(Main.getInstance().getNotonline());
                } else
                    Bukkit.getConsoleSender().sendMessage(Main.getInstance().getPrefix() + "§cBitte benutze: §e/build <Spieler>");

            } else if (sender instanceof Player) {
                final Player p = (Player) sender;

                if (args.length == 0) {
                    if (p.hasPermission("LobbySystem.buildmode")) {

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

                        File file = new File("plugins//LobbySystem//warps.yml");
                        if (!file.exists()) {
                            p.sendMessage(Main.getInstance().getPrefix() + "§cSetze den Spawn zuerst!");
                        } else {

                            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);


                            if (!builders.contains(p.getName())) {

                                builders.add(p.getName());
                                p.sendMessage(Main.getInstance().getPrefix() + "§7Baumodus wurde §aaktiviert.");
                                Main.getInstance().playSound(p);
                                p.setGameMode(GameMode.CREATIVE);
                                p.getInventory().clear();

                            } else if (builders.contains(p.getName())) {

                                builders.remove(p.getName());
                                p.sendMessage(Main.getInstance().getPrefix() + "§7Baumodus wurde §cdeaktiviert");
                                Main.getInstance().playSound(p);
                                p.setGameMode(GameMode.SURVIVAL);

                                String world = cfg.getString("Spawn.World");
                                int x = cfg.getInt("Spawn.X");
                                int y = cfg.getInt("Spawn.Y");
                                int z = cfg.getInt("Spawn.Z");
                                double yaw = cfg.getDouble("Spawn.Yaw");
                                double pitch = cfg.getDouble("Spawn.Pitch");

                                Location loc = p.getLocation();
                                loc.setX(x);
                                loc.setY(y);
                                loc.setZ(z);
                                loc.setYaw((float) yaw);
                                loc.setPitch((float) pitch);

                                p.teleport(loc);

                                p.getInventory().clear();
                                p.getInventory().setItem(0, compass);
                                p.getInventory().setItem(1, br);
                                p.getInventory().setItem(8, head);

                            }
                        }
                    } else
                        p.sendMessage(Main.getInstance().getNoperms());
                } else if (args.length == 1) {
                    if (p.hasPermission("LobbySystem.buildmode.other")) {

                        File file = new File("plugins//LobbySystem//warps.yml");
                        if (!file.exists()) {
                            p.sendMessage(Main.getInstance().getPrefix() + "§cSetze den Spawn zuerst!");
                        } else if (Bukkit.getPlayer(args[0]) != null) {

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
                            hmeta.setOwner(Bukkit.getPlayer(args[0]).getName());
                            hmeta.setDisplayName(Main.getInstance().getConfig().getString("Item.HeadName").replace("&", "§"));
                            head.setItemMeta(hmeta);

                            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

                            if (!builders.contains(Bukkit.getPlayer(args[0]).getName())) {

                                builders.add(Bukkit.getPlayer(args[0]).getName());
                                Bukkit.getPlayer(args[0]).sendMessage(Main.getInstance().getPrefix() + "§7Baumodus wurde §aaktiviert.");
                                Main.getInstance().playSound(Bukkit.getPlayer(args[0]));
                                Bukkit.getPlayer(args[0]).setGameMode(GameMode.CREATIVE);
                                p.sendMessage(Main.getInstance().getPrefix() + "§e" + Bukkit.getPlayer(args[0]).getName() + "'s §7Baumodus wurde §aaktiviert.");
                                Bukkit.getPlayer(args[0]).getInventory().clear();

                            } else if (builders.contains(Bukkit.getPlayer(args[0]).getName())) {

                                builders.remove(Bukkit.getPlayer(args[0]).getName());
                                Bukkit.getPlayer(args[0]).sendMessage(Main.getInstance().getPrefix() + "§7Baumodus wurde §cdeaktiviert");
                                Main.getInstance().playSound(Bukkit.getPlayer(args[0]));
                                Bukkit.getPlayer(args[0]).setGameMode(GameMode.SURVIVAL);
                                p.sendMessage(Main.getInstance().getPrefix() + "§e" + Bukkit.getPlayer(args[0]).getName() + "'s §7Baumodus wurde §cdeaktiviert.");

                                String world = cfg.getString("Spawn.World");
                                int x = cfg.getInt("Spawn.X");
                                int y = cfg.getInt("Spawn.Y");
                                int z = cfg.getInt("Spawn.Z");
                                double yaw = cfg.getDouble("Spawn.Yaw");
                                double pitch = cfg.getDouble("Spawn.Pitch");

                                Location loc = p.getLocation();
                                loc.setX(x);
                                loc.setY(y);
                                loc.setZ(z);
                                loc.setYaw((float) yaw);
                                loc.setPitch((float) pitch);

                                Bukkit.getPlayer(args[0]).teleport(loc);

                                Bukkit.getPlayer(args[0]).getInventory().clear();
                                Bukkit.getPlayer(args[0]).getInventory().setItem(0, compass);
                                Bukkit.getPlayer(args[0]).getInventory().setItem(1, br);
                                Bukkit.getPlayer(args[0]).getInventory().setItem(8, head);

                            }
                        } else
                            p.sendMessage(Main.getInstance().getNotonline());
                    } else
                        p.sendMessage(Main.getInstance().getNoperms());
                } else
                    p.sendMessage(Main.getInstance().getPrefix() + "§cBitte benutze: §e/build <Spieler>");
            }
        }

        return false;
    }
}
