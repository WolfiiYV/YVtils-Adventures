package yv.tils.adventures.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import yv.tils.adventures.difficulty.SelectDifficulty;
import yv.tils.adventures.unlock.LevelPath.LevelPath;
import yv.tils.adventures.unlock.LevelPath.PlayerEntry;

/**
 * @version 1.0
 * @since 1.0
 */
public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        new LevelPath().getXP(e.getPlayer(), "join_streak");
        new PlayerEntry().onJoin(e);
    }
}