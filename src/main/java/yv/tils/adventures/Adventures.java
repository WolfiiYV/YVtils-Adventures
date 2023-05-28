package yv.tils.adventures;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import yv.tils.adventures.cmd.CommandHandler;
import yv.tils.adventures.cmd.LevelPathCMD;
import yv.tils.adventures.cmd.TabComplete;
import yv.tils.adventures.listener.JoinListener;
import yv.tils.adventures.listener.GUIClick;
import yv.tils.adventures.unlock.LevelPath.PlayerEntry;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @since 1.0
 * @version 1.0
 */
public final class Adventures extends JavaPlugin {
    public static String PluginVersion = "1.0";

    public boolean database_connection;

    public List<String> diffitimer = new ArrayList<>();
    public Map<String, String> p = new HashMap<String, String>();
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
        manager.registerEvents(new GUIClick(), this);
        getCommand("adventure").setExecutor(new CommandHandler());
        getCommand("adventure").setTabCompleter(new TabComplete());
        getCommand("levelpath").setExecutor(new LevelPathCMD());

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
