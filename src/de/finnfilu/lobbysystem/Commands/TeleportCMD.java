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

public class TeleportCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("teleport")) {
            if (sender instanceof ConsoleCommandSender) {

                Bukkit.getConsoleSender().sendMessage(Main.getInstance().getNotplayer());

            } else if (sender instanceof Player) {
                Player p = (Player) sender;

                if (p.hasPermission("LobbySystem.teleport")) {
                    if (args.length == 1) {
                        if (Bukkit.getPlayer(args[0]) == null) {

                            p.sendMessage(Main.getInstance().getNotonline());

                        } else {

                            p.teleport(Bukkit.getPlayer(args[0]));
                            p.sendMessage(Main.getInstance().getPrefix() + "§7Du wurdest zu §e" + Bukkit.getPlayer(args[0]).getName() + "§7 teleportiert.");
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);

                        }
                    } else
                        p.sendMessage(Main.getInstance().getPrefix() + "§cBitte benutze: §e/tp <Spieler>");
                } else
                    p.sendMessage(Main.getInstance().getNoperms());
            }
        }

        return false;
    }
}
