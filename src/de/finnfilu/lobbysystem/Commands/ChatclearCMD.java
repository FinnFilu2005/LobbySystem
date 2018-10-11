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

public class ChatclearCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("chatclear")) {

            if (sender instanceof ConsoleCommandSender) {
                if (args.length == 0) {
                    for (int i = 0; i < 100; i++) {

                        Bukkit.broadcastMessage(" ");

                    }
                    Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§7Der Chat wurde geleert.");
                } else
                    Bukkit.getConsoleSender().sendMessage(Main.getInstance().getPrefix() + "§cBitte benutze: §e/cc");

            } else if (sender instanceof Player) {
                final Player p = (Player) sender;

                if (args.length == 0) {
                    if (p.hasPermission("LobbySystem.chatclear")) {

                        for (int i = 0; i < 100; i++) {

                            Bukkit.broadcastMessage(" ");

                        }

                        Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§7Der Chat wurde geleert.");

                    } else
                        p.sendMessage(Main.getInstance().getNoperms());
                } else
                    p.sendMessage(Main.getInstance().getPrefix() + "§cBitte benutze: §e/cc");
            }
        }

        return false;
    }
}
