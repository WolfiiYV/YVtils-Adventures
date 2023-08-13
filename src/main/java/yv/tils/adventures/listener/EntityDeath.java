package yv.tils.adventures.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import yv.tils.adventures.Adventures;
import yv.tils.adventures.difficulty.Difficultys;
import yv.tils.adventures.difficulty.ExecuteDifficulty;

import java.util.Random;

/**
 * @version 1.0
 * @since 1.0
 */
public class EntityDeath implements Listener {
    private final Random random = new Random();

    @EventHandler
    public void onEvent(EntityDeathEvent e) {
        try {
            if (e.getEntity().getKiller().getType() != EntityType.PLAYER) return;
        } catch (NullPointerException ignored) {
            return;
        }
        Player player = e.getEntity().getKiller();

        String p = Adventures.getInstance().p.get(player.getName());
        String[] plist = p.split(";");
        String pdifficulty = plist[7];

        if (pdifficulty.equals(ChatColor.stripColor(Difficultys.D4.name))) {
            new ExecuteDifficulty().CarefulSnail_MobLuck(e, player, random);
        }

        if (pdifficulty.equals(ChatColor.stripColor(Difficultys.D3.name))) {
            new ExecuteDifficulty().CarelessCheetah_MobLuck(e, player, random);
        }
    }
}