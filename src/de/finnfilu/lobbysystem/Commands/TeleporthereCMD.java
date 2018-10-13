package de.finnfilu.lobbysystem.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.lobbysystem.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class TeleporthereCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("teleporthere")) {

            if (sender instanceof ConsoleCommandSender) {

                Bukkit.getConsoleSender().sendMessage(Main.getInstance().getNotplayer());

            } else if (sender instanceof Player) {
                final Player p = (Player) sender;

                if (p.hasPermission("LobbySystem.teleporthere")) {
                    if (args.length == 1) {
                        if (Bukkit.getPlayer(args[0]) == null) {

                            p.sendMessage(Main.getInstance().getNotonline());

                        } else {

                            Bukkit.getPlayer(args[0]).teleport(p);
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                            p.sendMessage(Main.getInstance().getPrefix() + "§7Teleportiere §e" + Bukkit.getPlayer(args[0]).getName() + "§7 zu §e" + p.getName() + ".");
                            Bukkit.getPlayer(args[0]).sendMessage(Main.getInstance().getPrefix() + "§7Teleportiere §e" + Bukkit.getPlayer(args[0]).getName() + "§7 zu §e" + p.getName() + ".");

                        }
                    } else
                        p.sendMessage(Main.getInstance().getPrefix() + "§cBitte benutze: §e/tphere <Spieler>");
                } else
                    p.sendMessage(Main.getInstance().getNoperms());
            }
        }

        return false;
    }
}
