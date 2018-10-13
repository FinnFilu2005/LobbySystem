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
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class SlowchatCMD implements CommandExecutor, Listener {

    private int taskID;
    public static boolean slowedchat = false;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("slowchat")) {
            if (sender instanceof ConsoleCommandSender) {

                if (args.length == 0) {
                    if (slowedchat == false) {

                        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

                            private int countdown = 30;

                            @Override
                            public void run() {

                                switch (countdown) {

                                    case 30:
                                    case 15:
                                    case 10:
                                    case 5:
                                    case 3:
                                    case 2:
                                        Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§7Der Chat wird in §e" + countdown + " Sekunden §7deaktiviert.");
                                        countdown--;
                                        break;
                                    case 1:
                                        Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§7Der Chat wird in §eeiner Sekunde §7deaktiviert.");
                                        countdown--;
                                        break;
                                    case 0:
                                        Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§7Der Chat wurde deaktiviert.");
                                        slowedchat = true;
                                        Bukkit.getScheduler().cancelTask(taskID);
                                        break;
                                    default:
                                        countdown--;
                                        break;

                                }

                            }
                        }, 20, 20);
                    } else if (slowedchat == true) {

                        slowedchat = false;
                        Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§7Der Chat wurde aktiviert.");

                    }
                } else
                    Bukkit.getConsoleSender().sendMessage(Main.getInstance().getPrefix() + "§cBitte benutze: §e/slowchat");

            } else if (sender instanceof Player) {
                final Player p = (Player) sender;

                if (p.hasPermission("LobbySystem.slowchat")) {
                    if (args.length == 0) {
                        if (slowedchat == false) {

                            taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

                                private int countdown = 30;

                                @Override
                                public void run() {

                                    switch (countdown) {
                                        case 30:
                                        case 15:
                                        case 10:
                                        case 5:
                                        case 3:
                                        case 2:
                                            Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§7Der Chat wird in §e" + countdown + " Sekunden §7deaktiviert.");
                                            countdown--;
                                            break;
                                        case 1:
                                            Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§7Der Chat wird in §eeiner Sekunde §7deaktivert.");
                                            countdown--;
                                            break;
                                        case 0:
                                            Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§7Der Chat wurde deaktiviert.");
                                            slowedchat = true;
                                            Bukkit.getScheduler().cancelTask(taskID);
                                            break;
                                        default:
                                            countdown--;
                                            break;
                                    }
                                }
                            }, 20, 20);
                        } else if (slowedchat == true) {

                            slowedchat = false;
                            Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§7Der Chat wurde aktiviert.");

                        }
                    } else
                        p.sendMessage(Main.getInstance().getPrefix() + "§cBitte benutze: §e/slowchat");
                } else
                    p.sendMessage(Main.getInstance().getNoperms());

            }
        }
        return false;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();

        if (slowedchat == true) {
            if (!p.hasPermission("LobbySystem.ignoreslowedchat")) {

                e.setCancelled(true);
                p.sendMessage(Main.getInstance().getPrefix() + "§cDer Chat ist zurzeit deaktiviert!");

            } else if (p.hasPermission("LobbySystem.ignoreslowedchat")) {
                e.setCancelled(false);
            }
        } else if (slowedchat == false) {
            e.setCancelled(false);
        }
    }

}
