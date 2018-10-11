package de.finnfilu.lobbysystem.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.lobbysystem.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class GamemodeCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("gamemode")) {
            if (sender instanceof ConsoleCommandSender) {

                if (Bukkit.getPlayer(args[0]) == null) {
                    Bukkit.getConsoleSender().sendMessage(Main.getInstance().getNotonline());
                } else {

                    if (args.length == 2) {

                        if (args[0].equalsIgnoreCase("0")) {

                            Bukkit.getPlayer(args[1]).setGameMode(GameMode.SURVIVAL);
                            Bukkit.getPlayer(args[1]).setHealth(20);
                            Bukkit.getPlayer(args[1]).setFoodLevel(20);
                            Bukkit.getPlayer(args[1]).sendMessage(Main.getInstance().getPrefix() + "§7Setze Gamemode auf §eÜberleben.");
                            Bukkit.getConsoleSender().sendMessage(Main.getInstance().getPrefix() + "§7Setze §e" + Bukkit.getPlayer(args[1]).getName() + "'s §7Gamemode auf §eÜberleben.");

                        } else if (args[0].equalsIgnoreCase("1")) {

                            Bukkit.getPlayer(args[1]).setGameMode(GameMode.CREATIVE);
                            Bukkit.getPlayer(args[1]).setHealth(20);
                            Bukkit.getPlayer(args[1]).setFoodLevel(20);
                            Bukkit.getPlayer(args[1]).sendMessage(Main.getInstance().getPrefix() + "§7Setze Gamemode auf §eKreativ.");
                            Bukkit.getConsoleSender().sendMessage(Main.getInstance().getPrefix() + "§7Setze §e" + Bukkit.getPlayer(args[1]).getName() + "'s §7Gamemode auf §eKreativ.");

                        } else if (args[0].equalsIgnoreCase("2")) {

                            Bukkit.getPlayer(args[1]).setGameMode(GameMode.ADVENTURE);
                            Bukkit.getPlayer(args[1]).setHealth(20);
                            Bukkit.getPlayer(args[1]).setFoodLevel(20);
                            Bukkit.getPlayer(args[1]).sendMessage(Main.getInstance().getPrefix() + "§7Setze Gamemode auf §eAbenteuer.");
                            Bukkit.getConsoleSender().sendMessage(Main.getInstance().getPrefix() + "§7Setze §e" + Bukkit.getPlayer(args[1]).getName() + "'s §7Gamemode auf §eAbenteuer.");

                        } else if (args[0].equalsIgnoreCase("3")) {

                            Bukkit.getPlayer(args[1]).setGameMode(GameMode.SPECTATOR);
                            Bukkit.getPlayer(args[1]).setHealth(20);
                            Bukkit.getPlayer(args[1]).setFoodLevel(20);
                            Bukkit.getPlayer(args[1]).sendMessage(Main.getInstance().getPrefix() + "§7Setze Gamemode auf §eZuschauer.");
                            Bukkit.getConsoleSender().sendMessage(Main.getInstance().getPrefix() + "§7Setze §e" + Bukkit.getPlayer(args[1]).getName() + "'s §7Gamemode auf §eZuschauer.");

                        }


                    } else
                        Bukkit.getConsoleSender().sendMessage(Main.getInstance().getPrefix() + "§cBitte benutze: §e/gm <0, 1, 2, 3> <Spieler>");
                }

            } else if (sender instanceof Player) {
                final Player p = (Player) sender;

                if (Bukkit.getPlayer(args[0]) == null) {
                    p.sendMessage(Main.getInstance().getNotonline());
                } else {

                    if (args.length == 1) {
                        if (p.hasPermission("LobbySystem.gamemode")) {

                            if (args[0].equalsIgnoreCase("0")) {

                                p.setGameMode(GameMode.SURVIVAL);
                                p.setFoodLevel(20);
                                p.setHealth(20);
                                p.sendMessage(Main.getInstance().getPrefix() + "§7Setze Gamemode auf §eÜberleben.");

                            } else if (args[0].equalsIgnoreCase("1")) {

                                p.setGameMode(GameMode.CREATIVE);
                                p.setFoodLevel(20);
                                p.setHealth(20);
                                p.sendMessage(Main.getInstance().getPrefix() + "§7Setze Gamemode auf §eKreativ.");

                            } else if (args[0].equalsIgnoreCase("2")) {

                                p.setGameMode(GameMode.ADVENTURE);
                                p.setFoodLevel(20);
                                p.setHealth(20);
                                p.sendMessage(Main.getInstance().getPrefix() + "§7Setze Gamemode auf §eAbenteuer.");

                            } else if (args[0].equalsIgnoreCase("3")) {

                                p.setGameMode(GameMode.ADVENTURE);
                                p.setFoodLevel(20);
                                p.setHealth(20);
                                p.sendMessage(Main.getInstance().getPrefix() + "§7Setze Gamemode auf §eZuschauer.");

                            }
                        } else
                            p.sendMessage(Main.getInstance().getNoperms());
                    } else if (args.length == 2) {
                        if (p.hasPermission("LobbySystem.gamemode.other")) {

                            if (args[0].equalsIgnoreCase("0")) {

                                Bukkit.getPlayer(args[1]).setGameMode(GameMode.SURVIVAL);
                                Bukkit.getPlayer(args[1]).setHealth(20);
                                Bukkit.getPlayer(args[1]).setFoodLevel(20);
                                Bukkit.getPlayer(args[1]).sendMessage(Main.getInstance().getPrefix() + "§7Setze Gamemode auf §eÜberleben.");
                                p.sendMessage(Main.getInstance().getPrefix() + "§7Setze §e" + Bukkit.getPlayer(args[1]).getName() + "'s §7Gamemode auf §eÜberleben.");

                            } else if (args[0].equalsIgnoreCase("1")) {

                                Bukkit.getPlayer(args[1]).setGameMode(GameMode.CREATIVE);
                                Bukkit.getPlayer(args[1]).setHealth(20);
                                Bukkit.getPlayer(args[1]).setFoodLevel(20);
                                Bukkit.getPlayer(args[1]).sendMessage(Main.getInstance().getPrefix() + "§7Setze Gamemode auf §eKreativ.");
                                p.sendMessage(Main.getInstance().getPrefix() + "§7Setze §e" + Bukkit.getPlayer(args[1]).getName() + "'s §7Gamemode auf §eKreativ.");

                            } else if (args[0].equalsIgnoreCase("2")) {

                                Bukkit.getPlayer(args[1]).setGameMode(GameMode.ADVENTURE);
                                Bukkit.getPlayer(args[1]).setHealth(20);
                                Bukkit.getPlayer(args[1]).setFoodLevel(20);
                                Bukkit.getPlayer(args[1]).sendMessage(Main.getInstance().getPrefix() + "§7Setze Gamemode auf §eAbenteuer.");
                                p.sendMessage(Main.getInstance().getPrefix() + "§7Setze §e" + Bukkit.getPlayer(args[1]).getName() + "'s §7Gamemode auf §eAbenteuer.");

                            } else if (args[0].equalsIgnoreCase("3")) {

                                Bukkit.getPlayer(args[1]).setGameMode(GameMode.SPECTATOR);
                                Bukkit.getPlayer(args[1]).setHealth(20);
                                Bukkit.getPlayer(args[1]).setFoodLevel(20);
                                Bukkit.getPlayer(args[1]).sendMessage(Main.getInstance().getPrefix() + "§7Setze Gamemode auf §eZuschauer.");
                                p.sendMessage(Main.getInstance().getPrefix() + "§7Setze §e" + Bukkit.getPlayer(args[1]).getName() + "'s §7Gamemode auf §eZuschauer.");

                            }
                        } else
                            p.sendMessage(Main.getInstance().getNoperms());
                    } else
                        p.sendMessage(Main.getInstance().getPrefix() + "§cBitte benutze: §e/gm <0, 1, 2, 3> <Spieler>");
                }
            }
        }


        return false;
    }
}
