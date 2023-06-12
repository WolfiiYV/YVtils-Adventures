package yv.tils.adventures.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import yv.tils.adventures.Adventures;
import yv.tils.adventures.difficulty.Difficultys;
import yv.tils.adventures.difficulty.ExecuteDifficulty;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @since 1.0
 */
public class PlayerDeath_Respawn implements Listener {
    @EventHandler
    public void onEvent(PlayerDeathEvent e) {
        if (e.getEntityType() != EntityType.PLAYER) return;
        Player player = e.getEntity();

        String p = Adventures.getInstance().p.get(player.getName());
        String[] plist = p.split(";");
        String pdifficulty = plist[6];

        if (pdifficulty.equals(ChatColor.stripColor(Difficultys.D5.name))) {
            new ExecuteDifficulty().CarefulHolder_Death(e);
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();

        String p = Adventures.getInstance().p.get(player.getName());
        String[] plist = p.split(";");
        String pdifficulty = plist[6];

        if (pdifficulty.equals(ChatColor.stripColor(Difficultys.D5.name))) {
            new ExecuteDifficulty().CarefulHolder_Respawn(player, e);
        }
    }
}