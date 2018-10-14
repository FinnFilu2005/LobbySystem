package de.finnfilu.lobbysystem.Main;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.lobbysystem.Commands.*;
import de.finnfilu.lobbysystem.Listener.ChatFormat;
import de.finnfilu.lobbysystem.Listener.CompassListener;
import de.finnfilu.lobbysystem.Listener.JoinListener;
import de.finnfilu.lobbysystem.Listener.MainEvents;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
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

        Bukkit.getConsoleSender().sendMessage(this.getPrefix() + "§aAktiviere LobbySystem");
        Bukkit.getConsoleSender().sendMessage(this.getPrefix() + "§eDie Config.yml wurde geladen");

        Bukkit.getWorld("world").setGameRuleValue("doDaylightCycle", "false");
        Bukkit.getWorld("world").setDifficulty(Difficulty.PEACEFUL);
        Bukkit.getWorld("world").setTime(6000);

    }

    public void register() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new MainEvents(), this);
        pm.registerEvents(new SlowchatCMD(), this);
        pm.registerEvents(new ChatFormat(), this);
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new CompassListener(), this);

        getCommand("setwarp").setExecutor(new SetwarpCMD());
        getCommand("warp").setExecutor(new WarpCMD());
        getCommand("gamemode").setExecutor(new GamemodeCMD());
        getCommand("chatclear").setExecutor(new ChatclearCMD());
        getCommand("fly").setExecutor(new FlyCMD());
        getCommand("slowchat").setExecutor(new SlowchatCMD());
        getCommand("teleport").setExecutor(new TeleportCMD());
        getCommand("teleporthere").setExecutor(new TeleporthereCMD());
        getCommand("buildmode").setExecutor(new BuildCMD());

    }

    public void loadConfig() {
        this.reloadConfig();
        this.getConfig().options().copyDefaults(true);

        this.getConfig().addDefault("LobbySystem.Prefix", "&7[&6LobbySystem&7] &8» &r");
        this.getConfig().addDefault("LobbySystem.NoPermissions", "&cDazu hast du keine Rechte!");
        this.getConfig().addDefault("LobbySystem.Error", "&cEin Fehler ist aufgetreten!");
        this.getConfig().addDefault("LobbySystem.NotAPlayerMessage", "&cDazu musst du ein Spieler sein!");
        this.getConfig().addDefault("LobbySystem.PlayerNotOnline", "&cDieser Spieler ist nicht online!");
        this.getConfig().addDefault("LobbySystem.JoinMessage", "&7[&a+&7] &ename");

        this.getConfig().addDefault("Item.CompassName", "&6Navigator");
        this.getConfig().addDefault("Item.BlazeRodName", "&aSpieler verstecken");
        this.getConfig().addDefault("Item.HeadName", "&eFreunde");

        this.getConfig().addDefault("Compass.Item1Name", "&bBedwars");
        this.getConfig().addDefault("Compass.Item2Name", "&cSkywars");
        this.getConfig().addDefault("Compass.Item3Name", "&eKnockbackFFA");
        this.getConfig().addDefault("Compass.Item4Name", "&5MLGRush");
        this.getConfig().addDefault("Compass.SpawnName", "&6Spawn");

        this.getConfig().addDefault("Friend.PerformedCommand", "friend");

        this.getConfig().addDefault("Chatformat.Owner", "&7[&4Owner&7] &4name &8» &r");
        this.getConfig().addDefault("Chatformat.Admin", "&7[&cAdmin&7] &cname &8» &r");
        this.getConfig().addDefault("Chatformat.SrDeveloper", "&7[&bSrDeveloper&7] &bname &8» &r");
        this.getConfig().addDefault("Chatformat.SrBuilder", "&7[&aSrBuilder&7] &aname &8» &r");
        this.getConfig().addDefault("Chatformat.SrModerator", "&7[&cSrModerator&7] &cname &8» &r");
        this.getConfig().addDefault("Chatformat.Moderator", "&7[&2Moderator&7] &2name &8» &r");
        this.getConfig().addDefault("Chatformat.Supporter", "&7[&1Supporter&7] &1name &8» &r");
        this.getConfig().addDefault("Chatformat.Developer", "&7[&bDeveloper&7] &bname &8» &r");
        this.getConfig().addDefault("Chatformat.Builder", "&7[&aBuilder&7] &aname &8» &r");
        this.getConfig().addDefault("Chatformat.Youtuber+", "&7[&5Youtuber+&7] &5name &8» &r");
        this.getConfig().addDefault("Chatformat.Youtuber", "&7[&5Youtuber&7] &5name &8» &r");
        this.getConfig().addDefault("Chatformat.Hero", "&7[&cHero&7] &cname &8» &r");
        this.getConfig().addDefault("Chatformat.Master", "&7[&eMaster&7] &ename &8» &r");
        this.getConfig().addDefault("Chatformat.Diamond", "&7[&bDiamond&7] &bname &8» &r");
        this.getConfig().addDefault("Chatformat.Emerald", "&7[&1Emerald&7] &1name &8» &r");
        this.getConfig().addDefault("Chatformat.Premium", "&7[&6Premium&7] &6name &8» &r");
        this.getConfig().addDefault("Chatformat.User", "&7[&7User&7] &7name &8» &r");

        this.saveConfig();
    }

    public void playSound(Player p) {

        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);

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
