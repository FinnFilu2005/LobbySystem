package de.finnfilu.lobbysystem.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.lobbysystem.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class FlyCMD implements CommandExecutor {

    private boolean isflying = false;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("fly")) {

            if (sender instanceof ConsoleCommandSender) {

                if (Bukkit.getPlayer(args[0]) == null) {
                    Bukkit.getConsoleSender().sendMessage(Main.getInstance().getNotonline());
                } else {

                    if (args.length == 1) {

                        if (isflying == false) {

                            Bukkit.getPlayer(args[0]).setAllowFlight(true);
                            Bukkit.getPlayer(args[0]).setHealth(20);
                            Bukkit.getPlayer(args[0]).setFoodLevel(20);
                            Bukkit.getPlayer(args[0]).sendMessage(Main.getInstance().getPrefix() + "§7Flugmodus wurde §aaktiviert.");
                            Bukkit.getConsoleSender().sendMessage(Main.getInstance().getPrefix() + "§e" + Bukkit.getPlayer(args[0]).getName() + "'s §7Flugmodus wurde §aaktiviert");
                            isflying = true;

                        } else if (isflying == true) {

                            Bukkit.getPlayer(args[0]).setAllowFlight(false);
                            Bukkit.getPlayer(args[0]).setHealth(20);
                            Bukkit.getPlayer(args[0]).setFoodLevel(20);
                            Bukkit.getPlayer(args[0]).sendMessage(Main.getInstance().getPrefix() + "§7Flugmodus wurde §cdeaktiviert.");
                            Bukkit.getConsoleSender().sendMessage(Main.getInstance().getPrefix() + "§e" + Bukkit.getPlayer(args[0]).getName() + "'s §7Flugmodus wurde §cdeaktiviert");
                            isflying = false;

                        }

                    } else
                        Bukkit.getConsoleSender().sendMessage(Main.getInstance().getPrefix() + "§cBitte benutze: §e/fly <Spieler>");
                }

            } else if (sender instanceof Player) {
                final Player p = (Player) sender;

                if (Bukkit.getPlayer(args[0]) == null) {
                    p.sendMessage(Main.getInstance().getNotonline());
                } else {

                    if (args.length == 0) {
                        if (p.hasPermission("LobbySystem.fly")) {

                            if (isflying == false) {

                                p.setAllowFlight(true);
                                p.setHealth(20);
                                p.setFoodLevel(20);
                                p.sendMessage(Main.getInstance().getPrefix() + "§7Flugmodus wurde §aaktiviert.");
                                isflying = true;

                            } else if (isflying == true) {

                                p.setAllowFlight(false);
                                p.setHealth(20);
                                p.setFoodLevel(20);
                                p.sendMessage(Main.getInstance().getPrefix() + "§7Flugmodus wurde §cdeaktiviert.");
                                isflying = false;

                            }
                        } else
                            p.sendMessage(Main.getInstance().getNoperms());
                    } else if (args.length == 1) {
                        if (p.hasPermission("LobbySystem.fly.other")) {
                            if (isflying == false) {

                                Bukkit.getPlayer(args[0]).setAllowFlight(true);
                                Bukkit.getPlayer(args[0]).setHealth(20);
                                Bukkit.getPlayer(args[0]).setFoodLevel(20);
                                Bukkit.getPlayer(args[0]).sendMessage(Main.getInstance().getPrefix() + "§7Flugmodus wurde §aaktiviert.");
                                p.sendMessage(Main.getInstance().getPrefix() + "§e" + Bukkit.getPlayer(args[0]).getName() + "'s §7Flugmodus wurde §aaktiviert");
                                isflying = true;

                            } else if (isflying == true) {

                                Bukkit.getPlayer(args[0]).setAllowFlight(false);
                                Bukkit.getPlayer(args[0]).setHealth(20);
                                Bukkit.getPlayer(args[0]).setFoodLevel(20);
                                Bukkit.getPlayer(args[0]).sendMessage(Main.getInstance().getPrefix() + "§7Flugmodus wurde §cdeaktiviert.");
                                p.sendMessage(Main.getInstance().getPrefix() + "§e" + Bukkit.getPlayer(args[0]).getName() + "'s §7Flugmodus wurde §cdeaktiviert");
                                isflying = false;

                            }
                        } else
                            p.sendMessage(Main.getInstance().getNoperms());
                    } else
                        p.sendMessage(Main.getInstance().getPrefix() + "§cBitte benutze: §e/fly <Spieler>");
                }
            }
        }

        return false;
    }
}
