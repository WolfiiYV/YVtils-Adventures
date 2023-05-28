package yv.tils.adventures.utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import yv.tils.adventures.Adventures;

import java.io.File;
import java.io.IOException;

/**
 Creates the Config Files for the Plugin, and give them Input with Config Options
 * @since 1.0
 * @version 1.0
 */
public class ConfigModeration {

    /**
     Use all Config Methods!
     You can use as Config 'Langauge; MinecraftDiscordBridge; DoNotEdit; WhitelistedDiscordPlayers; StatusModule; StatusSave
     @since  1.0
     */
    public YamlConfiguration ConfigRequest(String config) {
        File configfile = new File(Adventures.getInstance().getDataFolder(), config + ".yml");
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(configfile);
        try {
            configuration.save(configfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return configuration;
    }

    /**
     Add values to the Config!
     You can use as Config 'Language; MinecraftDiscordBridge; DoNotEdit; WhitelistedDiscordPlayers; StatusModule; StatusSave
     @since  1.0
     */
    public YamlConfiguration ConfigContentAdd(String config, String path, String value) {
        File configfile = new File(Adventures.getInstance().getDataFolder(), config + ".yml");
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(configfile);
        configuration.set(path, value);
        try {
            configuration.save(configfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return configuration;
    }

    /**
     Get values out of the Config!
     You can use as Config 'Langauge; MinecraftDiscordBridge; DoNotEdit; WhitelistedDiscordPlayers; StatusModule; StatusSave
     @since  1.0
     */
    public Object ConfigContentGet(String config, String path) {
        File configfile = new File(Adventures.getInstance().getDataFolder(), config + ".yml");
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(configfile);

        return configuration.get(path);
    }

    /**
     Remove values from the Config!
     You can use as Config 'Langauge; MinecraftDiscordBridge; DoNotEdit; WhitelistedDiscordPlayers; StatusModule; StatusSave
     @since  1.0
     */
    public YamlConfiguration ConfigContentRemove(String config, String path) {
        File configfile = new File(Adventures.getInstance().getDataFolder(), config + ".yml");
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(configfile);
        configuration.set(path, null);
        try {
            configuration.save(configfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return configuration;
    }

    File funmodulefile = new File(Adventures.getInstance().getDataFolder(), "FunModule.yml");
    YamlConfiguration funmodule = YamlConfiguration.loadConfiguration(funmodulefile);

    public void onSave() {
        try {
            funmodule.save(funmodulefile);
        } catch (IOException e) {
            System.out.println("-------");
            Bukkit.getConsoleSender().sendMessage("File creation Error! Please get Support on the YVtils Support Discord");
            System.out.println("-------");
        }
    }

    public void onNameGenerate() {
        try {
            onFolderGenerate("Language");

            onGenerate("Language/de.yml", true);
            onGenerate("Language/en.yml", true);

            onGenerate("level-path.yml", true);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onFolderGenerate(String folder) {
        File dataFolder = new File(Adventures.getInstance().getDataFolder() + "/" + folder);
        if(!dataFolder.exists())
        {
            dataFolder.mkdir();
        }
    }

    public void onGenerate(String name, boolean editable) throws Exception {
        File file = new File(Adventures.getInstance().getDataFolder(), name);
        if (!file.exists()) {
            file.createNewFile();
        }
    }
}