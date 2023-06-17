package yv.tils.adventures.unlock.LevelPath;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import yv.tils.adventures.Adventures;
import yv.tils.adventures.utils.ConsoleLog;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @since 1.0
 *
 * level,xp,joinstreak,playtimeall,playtimeday,ablitys,difficulty
 *
 */
public class PlayerEntry {
    File file = new File(Adventures.getInstance().getDataFolder(), "level-path.yml");
    YamlConfiguration ymlfile = YamlConfiguration.loadConfiguration(file);

    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if ((ymlfile.get(player.getName() + ".Level") == null)) configEntry(player);
        configGetter(player);
    }

    private void configEntry(Player player) {
        /*
        ymlfile.addDefault("PLAYER.Level", "x");
        ymlfile.addDefault("PLAYER.XP", "x");
        ymlfile.addDefault("PLAYER.JoinStreak", "x");
        ymlfile.addDefault("PLAYER.PlayTimeAll", "x");
        ymlfile.addDefault("PLAYER.PlayTimeDay", "x");
        ymlfile.addDefault("PLAYER.Abilitys", "x");
        ymlfile.addDefault("PLAYER.Difficulty", "x");
         */

        List<String> list = new ArrayList<>();

        ymlfile.set(player.getName() + ".Level", 0);
        ymlfile.set(player.getName() + ".XP", 0);
        ymlfile.set(player.getName() + ".JoinStreak", 0);
        ymlfile.set(player.getName() + ".PlayTimeAll", 0);
        ymlfile.set(player.getName() + ".PlayTimeDay", 0);
        ymlfile.set(player.getName() + ".Abilitys", list);
        ymlfile.set(player.getName() + ".Difficulty", "none");
        try {
            ymlfile.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Adventures.getInstance().p.put(player.getName(), 0 + ";" + 0 + ";" + 0 + ";" + 0 + ";" + 0 + ";" + list + ";" + "none");
    }

    public void configGetter(Player player) {
        int level = ymlfile.getInt(player.getName() + ".Level");
        int xp = ymlfile.getInt(player.getName() + ".XP");
        int joinstreak = ymlfile.getInt(player.getName() + ".JoinStreak");
        int playtimeall = ymlfile.getInt(player.getName() + ".PlayTimeAll");
        int playtimeday = ymlfile.getInt(player.getName() + ".PlayTimeDay");
        List<String> ablitys = ymlfile.getStringList(player.getName() + ".Abilitys");
        String difficulty = ymlfile.getString(player.getName() + ".Difficulty");

        Adventures.getInstance().p.put(player.getName(), level + ";" + xp + ";" + joinstreak + ";" + playtimeall + ";" + playtimeday + ";" + ablitys + ";" + difficulty);

        new ConsoleLog(player.getName() + ": " + level + ";" + xp + ";" + joinstreak + ";" + playtimeall + ";" + playtimeday + ";" + ablitys + ";" + difficulty);
        new ConsoleLog(Adventures.getInstance().p.get(player.getName()));
    }
}