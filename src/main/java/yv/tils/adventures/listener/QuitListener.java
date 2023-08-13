package yv.tils.adventures.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import yv.tils.adventures.Adventures;

/**
 * @version 1.0
 * @since 1.0
 */
public class QuitListener implements Listener {
    @EventHandler
    public void onEvent(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        Vampire(player);
        CancelTimeTracker(player);
    }

    private void Vampire(Player player) {

    }

    private void CancelTimeTracker(Player player) {
        int id = Adventures.getInstance().PlayTimeTracker.get(player);
        Bukkit.getScheduler().cancelTask(id);
    }
}