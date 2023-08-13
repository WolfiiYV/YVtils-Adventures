package yv.tils.adventures.utils.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import yv.tils.adventures.Adventures;

import java.io.File;
import java.io.IOException;

/**
 * @version 1.0
 * @since 1.0
 */
public class LevelPathConfig {
    File file = new File(Adventures.getInstance().getDataFolder(), "level-path.yml");
    YamlConfiguration ymlfile = YamlConfiguration.loadConfiguration(file);

    /*
    WolfiiYV:
    	- Level: 1
    	- XP: 500
    	- JoinStreak: 4
    	- JoinStreakClaimed: false
    	- PlayTimeAll: 4.3 (4h 30min) / 4 (4h) / 4.24 (4h 24min)
    	- PlaytimeDay:
    	- Abilitys: [Fly,Vampire]
    	- Difficulty: xxx
    */

    public void StringInput() {
        ymlfile.addDefault("PLAYER.Level", "x");
        ymlfile.addDefault("PLAYER.XP", "x");
        ymlfile.addDefault("PLAYER.JoinStreak", "x");
        ymlfile.addDefault("PLAYER.JoinStreakClaimed", "x");
        ymlfile.addDefault("PLAYER.PlayTimeAll", "x");
        ymlfile.addDefault("PLAYER.PlayTimeDay", "x");
        ymlfile.addDefault("PLAYER.Abilitys", "x");
        ymlfile.addDefault("PLAYER.Difficulty", "x");

        ymlfile.options().copyDefaults(true);
        fileSave();
    }

    public void fileSave() {
        try {
            ymlfile.save(file);
        } catch (IOException e) {
            System.out.println("-------");
            Bukkit.getConsoleSender().sendMessage("File creation Error! Please get Support on the YVtils Support Discord");
            System.out.println("-------");
        }
    }
}