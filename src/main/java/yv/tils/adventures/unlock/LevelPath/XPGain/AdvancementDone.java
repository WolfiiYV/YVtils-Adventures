package yv.tils.adventures.unlock.LevelPath.XPGain;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

/**
 * @version 1.0
 * @since 1.0
 */
public class AdvancementDone {
    public void onAdvancementDone(PlayerAdvancementDoneEvent e) {
        Player player = e.getPlayer();
        String advancementName = e.getAdvancement().getKey().getKey();

        if (advancementName.startsWith("recipes/")) {
            return;
        }

        new XPManager().onGainEvent(player, 100, "Advancement: " + advancementName);
    }
}