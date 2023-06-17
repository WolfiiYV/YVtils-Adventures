package yv.tils.adventures.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import yv.tils.adventures.unlock.LevelPath.XPGain.AdvancementDone;

/**
 * @version 1.0
 * @since 1.0
 */
public class PlayerAdvancement implements Listener {
    @EventHandler
    public void onEvent(PlayerAdvancementDoneEvent e) {
        new AdvancementDone().onAdvancementDone(e);
    }
}