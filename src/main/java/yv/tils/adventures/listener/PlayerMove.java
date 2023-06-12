package yv.tils.adventures.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import yv.tils.adventures.Adventures;
import yv.tils.adventures.difficulty.Difficultys;
import yv.tils.adventures.difficulty.ExecuteDifficulty;

/**
 * @version 1.0
 * @since 1.0
 */
public class PlayerMove implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Location movedFrom = e.getFrom();
        Location movedTo = e.getTo();
        Player player = e.getPlayer();
        if (movedFrom.getBlockX() != movedTo.getBlockX() || movedFrom.getBlockY() != movedTo.getBlockY() || movedFrom.getBlockZ() != movedTo.getBlockZ()) {
            Adventures.getInstance().standingPlayers.put(player, System.currentTimeMillis());
        }
    }

    private void AlmostPeaceful() {
        for (Player player : Adventures.getInstance().standingPlayers.keySet()) {
            String p = Adventures.getInstance().p.get(player.getName());
            String[] plist = p.split(";");
            String pdifficulty = plist[6];

            if (pdifficulty.equals(ChatColor.stripColor(Difficultys.D2.name))) {
                new ExecuteDifficulty().AlmostPeaceful_Movement(player);
            }
        }
    }

    public void runnable() {
        new BukkitRunnable() {
            @Override
            public void run() {
                AlmostPeaceful();
            }
        }.runTaskTimer(Adventures.getInstance(), 20L, 20L); // Delay 1 second, repeat every second
    }
}