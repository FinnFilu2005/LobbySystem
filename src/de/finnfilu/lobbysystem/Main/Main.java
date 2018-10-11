package de.finnfilu.lobbysystem.Main;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.lobbysystem.Commands.*;
import de.finnfilu.lobbysystem.Listener.MainEvents;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    private final String prefix = this.getConfig().getString("LobbySystem.Prefix");
    private final String noperms = this.getConfig().getString("LobbySystem.NoPermissions");
    private final String error = this.getConfig().getString("LobbySystem.Error");
    private final String notplayer = this.getConfig().getString("LobbySystem.NotAPlayerMessage");
    private final String notonline = this.getConfig().getString("LobbySystem.PlayerNotOnline");

    @Override
    public void onEnable() {
        instance = this;


        loadConfig();
        register();
        init();

    }

    @Override
    public void onDisable() {



    }

    public void init() {

        Bukkit.getConsoleSender().sendMessage("§aAktiviere LobbySystem");
        Bukkit.getConsoleSender().sendMessage("§eDie Config.yml wurde geladen");

        Bukkit.getWorld("world").setGameRuleValue("doDaylightCycle", "false");
        Bukkit.getWorld("world").setDifficulty(Difficulty.PEACEFUL);
        Bukkit.getWorld("world").setTime(6000);

    }

    public void register() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new MainEvents(), this);

        getCommand("setwarp").setExecutor(new SetwarpCMD());
        getCommand("warp").setExecutor(new WarpCMD());
        getCommand("gamemode").setExecutor(new GamemodeCMD());
        getCommand("chatclear").setExecutor(new ChatclearCMD());
        getCommand("fly").setExecutor(new FlyCMD());

    }

    public void loadConfig() {
        this.reloadConfig();
        this.getConfig().options().copyDefaults(true);

        this.getConfig().addDefault("LobbySystem.Prefix", "&7[&5LobbySystem&7] &8» &r");
        this.getConfig().addDefault("LobbySystem.NoPermissions", "&cDazu hast du keine Rechte!");
        this.getConfig().addDefault("LobbySystem.Error", "&cEin Fehler ist aufgetreten!");
        this.getConfig().addDefault("LobbySystem.NotAPlayerMessage", "&cDazu musst du ein Spieler sein!");
        this.getConfig().addDefault("LobbySystem.PlayerNotOnline", "&cDieser Spieler ist nicht online!");

        this.saveConfig();
    }


    public static Main getInstance() {
        return instance;
    }

    public String getPrefix() {
        return prefix.replace("&", "§");
    }

    public String getNoperms() {
        return prefix.replace("&", "§") + noperms.replace("&", "§");
    }

    public String getNotplayer() {
        return prefix.replace("&", "§") + notplayer.replace("&", "§");
    }

    public String getError() {
        return prefix.replace("&", "§") + error.replace("&", "§");
    }

    public String getNotonline() {
        return prefix.replace("&", "§") + notonline.replace("&", "§");
    }
}
