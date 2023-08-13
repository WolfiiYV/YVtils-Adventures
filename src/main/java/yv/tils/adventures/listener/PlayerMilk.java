package yv.tils.adventures.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.scheduler.BukkitRunnable;
import yv.tils.adventures.Adventures;
import yv.tils.adventures.difficulty.Difficultys;
import yv.tils.adventures.difficulty.ExecuteDifficulty;

/**
 * @version 1.0
 * @since 1.0
 */
public class PlayerMilk implements Listener {
    @EventHandler
    public void onMilkEvent(PlayerItemConsumeEvent e) {
        if (e.getItem().getType().equals(Material.MILK_BUCKET)) {
            Player player = e.getPlayer();

            String p = Adventures.getInstance().p.get(player.getName());
            String[] plist = p.split(";");
            String pdifficulty = plist[7];

            new BukkitRunnable() {
                public void run() {
                    if (pdifficulty.equals(ChatColor.stripColor(Difficultys.D7.name))) {
                        new ExecuteDifficulty().SwiftHunger_Effects(player);
                    }

                    if (pdifficulty.equals(ChatColor.stripColor(Difficultys.D4.name))) {
                        new ExecuteDifficulty().CarefulSnail_Movement(player);
                    }

                    if (pdifficulty.equals(ChatColor.stripColor(Difficultys.D3.name))) {
                        new ExecuteDifficulty().CarelessCheetah_Movement(player);
                    }
                }
            }.runTaskLater(Adventures.getInstance(), 20L);
        }
    }
}