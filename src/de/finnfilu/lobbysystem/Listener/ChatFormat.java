package de.finnfilu.lobbysystem.Listener;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.lobbysystem.Main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFormat implements Listener {


    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        String msg = e.getMessage();

        if (p.hasPermission("LobbySystem.Owner")) {

            e.setFormat(Main.getInstance().getConfig().getString("Chatformat.Owner").replace("&", "§").replace("name", p.getName()) + msg);

        } else if (p.hasPermission("LobbySystem.Admin")) {

            e.setFormat(Main.getInstance().getConfig().getString("Chatformat.Admin").replace("&", "§").replace("name", p.getName()) + msg);

        } else if (p.hasPermission("LobbySystem.SrModerator")) {

            e.setFormat(Main.getInstance().getConfig().getString("Chatformat.SrModerator").replace("&", "§").replace("name", p.getName()) + msg);

        } else if (p.hasPermission("LobbySystem.SrDeveloper")) {

            e.setFormat(Main.getInstance().getConfig().getString("Chatformat.SrDeveloper").replace("&", "§").replace("name", p.getName()) + msg);

        } else if (p.hasPermission("LobbySystem.SrBuilder")) {

            e.setFormat(Main.getInstance().getConfig().getString("Chatformat.SrBuilder").replace("&", "§").replace("name", p.getName()) + msg);

        } else if (p.hasPermission("LobbySystem.Moderator")) {

            e.setFormat(Main.getInstance().getConfig().getString("Chatformat.Moderator").replace("&", "§").replace("name", p.getName()) + msg);

        } else if (p.hasPermission("LobbySystem.Supporter")) {

            e.setFormat(Main.getInstance().getConfig().getString("Chatformat.Supporter").replace("&", "§").replace("name", p.getName()) + msg);

        } else if (p.hasPermission("LobbySystem.Developer")) {

            e.setFormat(Main.getInstance().getConfig().getString("Chatformat.Developer").replace("&", "§").replace("name", p.getName()) + msg);

        } else if (p.hasPermission("LobbySystem.Builder")) {

            e.setFormat(Main.getInstance().getConfig().getString("Chatformat.Builder").replace("&", "§").replace("name", p.getName()) + msg);

        } else if (p.hasPermission("LobbySystem.Hero")) {

            e.setFormat(Main.getInstance().getConfig().getString("Chatformat.Hero").replace("&", "§").replace("name", p.getName()) + msg);

        } else if (p.hasPermission("LobbySystem.Master")) {

            e.setFormat(Main.getInstance().getConfig().getString("Chatformat.Master").replace("&", "§").replace("name", p.getName()) + msg);

        } else if (p.hasPermission("LobbySystem.Diamond")) {

            e.setFormat(Main.getInstance().getConfig().getString("Chatformat.Diamond").replace("&", "§").replace("name", p.getName()) + msg);

        } else if (p.hasPermission("LobbySystem.Emerald")) {

            e.setFormat(Main.getInstance().getConfig().getString("Chatformat.Emerald").replace("&", "§").replace("name", p.getName()) + msg);

        } else if (p.hasPermission("LobbySystem.Premium")) {

            e.setFormat(Main.getInstance().getConfig().getString("Chatformat.Premium").replace("&", "§").replace("name", p.getName()) + msg);

        } else if (p.hasPermission("LobbySystem.User")) {

            e.setFormat(Main.getInstance().getConfig().getString("Chatformat.User").replace("&", "§").replace("name", p.getName()) + msg);

        } else {

            e.setFormat(Main.getInstance().getConfig().getString("Chatformat.User").replace("&", "§").replace("name", p.getName()) + msg);

        }
    }

}
