package yv.tils.adventures.unlock.LevelPath.XPGain;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import yv.tils.adventures.Adventures;

/**
 * @version 1.0
 * @since 1.0
 */
public class PlayTime {
    public void startTracking(Player player) {
        int i = new BukkitRunnable() {
            public void run() {
                if (!Adventures.getInstance().PlayTimeTrackerAFK.contains(player)) {
                    new XPManager().onGainEvent(player, 50, "PlayTime");
                }
            }
        }.runTaskTimer(Adventures.getInstance(), 36000L, 36000L).getTaskId();
        Adventures.getInstance().PlayTimeTracker.put(player, i);
    }
}