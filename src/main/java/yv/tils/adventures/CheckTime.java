package yv.tils.adventures;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import yv.tils.adventures.utils.ConsoleLog;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @version 1.0
 * @since 1.0
 */
public class CheckTime {
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");

    public void runnable() {
        new BukkitRunnable() {
            public void run() {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                new ConsoleLog("Current Time: " + sdf1.format(timestamp));

                try {
                    Date time1 = new SimpleDateFormat("HH:mm:ss").parse("03:00:00");
                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.setTime(time1);
                    calendar1.add(Calendar.DATE, 1);

                    Date time2 = new SimpleDateFormat("HH:mm:ss").parse("03:00:15");
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.setTime(time2);
                    calendar2.add(Calendar.DATE, 1);

                    Calendar calendar3 = Calendar.getInstance();
                    calendar3.setTime(new SimpleDateFormat("HH:mm:ss").parse(sdf1.format(timestamp)));
                    calendar3.add(Calendar.DATE, 1);

                    Date x = calendar3.getTime();
                    if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
                        new ConsoleLog("Resetting daily stats");

                        File file = new File(Adventures.getInstance().getDataFolder(), "level-path.yml");
                        YamlConfiguration ymlfile = YamlConfiguration.loadConfiguration(file);

                        for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
                            ymlfile.set(player.getName() + ".JoinStreakClaimed", false);
                            new ConsoleLog("The Daily-Join of " + player.getName() + " got cleared!");
                        }

                        try {
                            ymlfile.save(file);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } catch (ParseException ignored) {}
            }
        }.runTaskTimerAsynchronously(Adventures.getInstance(), 0L, 200L);
    }
}