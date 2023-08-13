package yv.tils.adventures.unlock.LevelPath.XPGain;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import yv.tils.adventures.Adventures;

import java.io.File;
import java.io.IOException;

/**
 * @version 1.0
 * @since 1.0
 */
public class DailyJoin {
    public void onDailyJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String p = Adventures.getInstance().p.get(player.getName());
        String[] plist = p.split(";");
        boolean claimed = Boolean.parseBoolean(plist[3]);
        int pJoin = Integer.parseInt(plist[2]);
        int xp = 50;

        if (claimed) return;

        File file = new File(Adventures.getInstance().getDataFolder(), "level-path.yml");
        YamlConfiguration ymlfile = YamlConfiguration.loadConfiguration(file);

        if (pJoin >= 30) {
            xp = 1000;
        }else if (pJoin >= 25) {
            xp = 800;
        }else if (pJoin >= 20) {
            xp = 700;
        }else if (pJoin >= 15) {
            xp = 600;
        }else if (pJoin >= 10) {
            xp = 500;
        }else if (pJoin >= 5) {
            xp = 250;
        }else if (pJoin >= 1) {
            xp = 100;
        }

        ymlfile.set(player.getName() + ".JoinStreak", pJoin + 1);
        ymlfile.set(player.getName() + ".JoinStreakClaimed", true);
        try {
            ymlfile.save(file);
        } catch (IOException ignored) {}

        new XPManager().onGainEvent(player, xp, "DailyJoinEvent");
    }
}