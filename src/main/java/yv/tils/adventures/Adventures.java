package yv.tils.adventures;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import yv.tils.adventures.ability.cmd.VampireHandler;
import yv.tils.adventures.ability.cmd.VampireTabComplete;
import yv.tils.adventures.cmd.CommandHandler;
import yv.tils.adventures.cmd.LevelPathCMD;
import yv.tils.adventures.ability.cmd.LightFlightCMD;
import yv.tils.adventures.cmd.TabComplete;
import yv.tils.adventures.listener.*;
import yv.tils.adventures.utils.ConfigModeration;
import yv.tils.adventures.utils.ConsoleLog;
import yv.tils.adventures.utils.MessagePlaceholder;
import yv.tils.adventures.utils.config.LevelPathConfig;
import yv.tils.adventures.utils.language.CreateFile_de;
import yv.tils.adventures.utils.language.CreateFile_en;
import yv.tils.adventures.utils.language.LanguageFile;
import yv.tils.adventures.utils.language.LanguageMessage;
import yv.tils.adventures.utils.updateutils.JoinAnnouncer;
import yv.tils.adventures.utils.updateutils.database.VersionChecker;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @since 1.0
 * @version 1.0
 */
public final class Adventures extends JavaPlugin {
    public static String PluginVersion = "1.0";

    public boolean database_connection;

    public List<String> diffitimer = new ArrayList<>();
    public Map<String, String> p = new HashMap<>();

    public HashMap<Player, Long> standingPlayers = new HashMap<>();
    public List<Player> onFireAbility = new ArrayList<>();
    public Cache<Player, Long> LightFlightCooldown = CacheBuilder.newBuilder().expireAfterAccess(10, TimeUnit.MINUTES).build();

    public Cache<Player, Long> Vampire_Invis = CacheBuilder.newBuilder().expireAfterAccess(30, TimeUnit.MINUTES).build();
    public Cache<Player, Long> Vampire_Speed = CacheBuilder.newBuilder().expireAfterAccess(15, TimeUnit.MINUTES).build();
    public Cache<Player, Long> Vampire_Transform = CacheBuilder.newBuilder().expireAfterAccess(90, TimeUnit.MINUTES).build();
    public Cache<Player, Long> Vampire_Invis_active = CacheBuilder.newBuilder().expireAfterAccess(5, TimeUnit.MINUTES).build();
    public Cache<Player, Long> Vampire_Speed_active = CacheBuilder.newBuilder().expireAfterAccess(5, TimeUnit.MINUTES).build();
    public Cache<Player, Long> Vampire_Transform_active = CacheBuilder.newBuilder().expireAfterAccess(15, TimeUnit.MINUTES).build();
    public Map<Player, Long> Vampire_Invis_inactive = new HashMap<>();
    public Map<Player, Long> Vampire_Speed_inactive = new HashMap<>();
    public Map<Player, Long> Vampire_Transform_inactive = new HashMap<>();

    public List<UUID> dailyJoinXP = new ArrayList<>();
    public Map<Player, Integer> PlayTimeTracker = new HashMap<>();
    public List<Player> PlayTimeTrackerAFK = new ArrayList<>();

    public final List<UUID> air = new ArrayList<>();

    private static Adventures instance;
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        new ConsoleLog(LanguageFile.DirectFormatter("YVtils-SMP begun loading!", "YVtils-SMP beginnt zu laden!"));
        saveDefaultConfig();
        ConfigModeration configModeration = new ConfigModeration();
        configModeration.onNameGenerate();

        //Language System
        CreateFile_de createFile_de = new CreateFile_de();
        createFile_de.StringInput();
        CreateFile_en createFile_en = new CreateFile_en();
        createFile_en.StringInput();
        LanguageFile.LanguageFileGet();

        //LevelPath
        LevelPathConfig levelPathConfig = new LevelPathConfig();
        levelPathConfig.StringInput();

        List<String> list1 = new ArrayList();
        List<String> list2 = new ArrayList();
        list1.add("PREFIXENABLE");
        list2.add(MessagePlaceholder.PREFIXENABLE);
        Bukkit.getConsoleSender().sendMessage(LanguageFile.ListReplacer(LanguageMessage.START_MESSAGE, list1, list2));


        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinListener(), this);
        manager.registerEvents(new QuitListener(), this);
        manager.registerEvents(new GUIClick(), this);
        manager.registerEvents(new PlayerDeath_Respawn(), this);
        manager.registerEvents(new PlayerDamage(), this);
        manager.registerEvents(new PlayerMove(), this);
        manager.registerEvents(new PlayerHunger(), this);
        manager.registerEvents(new BlockBreak(), this);
        manager.registerEvents(new EntityDeath(), this);
        manager.registerEvents(new PlayerAdvancement(), this);
        getCommand("adventure").setExecutor(new CommandHandler());
        getCommand("adventure").setTabCompleter(new TabComplete());
        getCommand("levelpath").setExecutor(new LevelPathCMD());
        getCommand("lightflight").setExecutor(new LightFlightCMD());
        getCommand("vampire").setExecutor(new VampireHandler());
        getCommand("vampire").setTabCompleter(new VampireTabComplete());

        new PlayerMove().runnable();
        registerUpdateChecker();

        new CheckTime().runnable();
        Bukkit.getConsoleSender().sendMessage(LanguageFile.ListReplacer(LanguageMessage.START_COMPLETED_MESSAGE, list1, list2));
        new ConsoleLog("Everything- Loaded");
    }

    @Override
    public void onDisable() {
        List<String> list1 = new ArrayList();
        List<String> list2 = new ArrayList();
        list1.add("PREFIXDISABLE");
        list2.add(MessagePlaceholder.PREFIXDISABLE);
        Bukkit.getConsoleSender().sendMessage(LanguageFile.ListReplacer(LanguageMessage.STOP_MESSAGE, list1, list2));
        new LevelPathConfig().fileSave();
        new CreateFile_de().fileSave();
        new CreateFile_en().fileSave();
        Bukkit.getConsoleSender().sendMessage(LanguageFile.ListReplacer(LanguageMessage.STOP_COMPLETED_MESSAGE, list1, list2));
    }

    public void registerUpdateChecker() {
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinAnnouncer(), this);
        if (new VersionChecker().VersionChecker_FullRelease(PluginVersion).equals("UA")) {
            List<String> list1ver = new ArrayList();
            List<String> list2ver = new ArrayList();
            list1ver.add("PREFIXUPDATE");
            list2ver.add(MessagePlaceholder.PREFIXUPDATE);
            list1ver.add("NEWVERSION");
            list2ver.add(new VersionChecker().NewestVersion());
            list1ver.add("OLDVERSION");
            list2ver.add(PluginVersion);
            list1ver.add("LINK");
            list2ver.add("https://modrinth.com/plugin/yvtils_smp");

            Bukkit.getConsoleSender().sendMessage(LanguageFile.ListReplacer(LanguageMessage.PLUGIN_UPDATE_AVAILABLE, list1ver, list2ver));
        } else if (new VersionChecker().VersionChecker_FullRelease(PluginVersion).equals("ERROR")) {
            Bukkit.getConsoleSender().sendMessage(LanguageFile.DirectFormatter("The Update Checker has an error! Please contact the Support, if you want to fix this.", "Beim checken nach einem Update ist ein Fehler aufgetreten! Bitte kontaktiere den Support!"));
        } else {
            List<String> list1ver = new ArrayList();
            List<String> list2ver = new ArrayList();
            list1ver.add("PREFIXNOUPDATE");
            list2ver.add(MessagePlaceholder.PREFIXNOUPDATE);

            Bukkit.getConsoleSender().sendMessage(LanguageFile.ListReplacer(LanguageMessage.PLUGIN_UP_TO_DATE, list1ver, list2ver));
        }
    }

    public static Adventures getInstance() {
        return instance;
    }
}
