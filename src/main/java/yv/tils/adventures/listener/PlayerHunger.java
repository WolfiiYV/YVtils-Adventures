package yv.tils.adventures.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import yv.tils.adventures.Adventures;
import yv.tils.adventures.difficulty.Difficultys;
import yv.tils.adventures.difficulty.ExecuteDifficulty;

/**
 * @version 1.0
 * @since 1.0
 */
public class PlayerHunger implements Listener {
    @EventHandler
    public void onHungerEvent(FoodLevelChangeEvent e) {
        if (e.getEntityType() != EntityType.PLAYER) return;
        Player player = (Player) e.getEntity();

        String p = Adventures.getInstance().p.get(player.getName());
        String[] plist = p.split(";");
        String pdifficulty = plist[7];

        if (pdifficulty.equals(ChatColor.stripColor(Difficultys.D7.name))) {
            new ExecuteDifficulty().SwiftHunger_Hunger(e, player);
        }
    }
}