package yv.tils.adventures.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import yv.tils.adventures.Adventures;
import yv.tils.adventures.difficulty.Difficultys;
import yv.tils.adventures.difficulty.ExecuteDifficulty;
import yv.tils.adventures.difficulty.SelectDifficulty;
import yv.tils.adventures.unlock.LevelPath.LevelPath;
import yv.tils.adventures.unlock.LevelPath.PlayerEntry;
import yv.tils.adventures.unlock.LevelPath.XPGain.DailyJoin;
import yv.tils.adventures.unlock.LevelPath.XPGain.PlayTime;
import yv.tils.adventures.unlock.LevelPath.XPGain.XPManager;

/**
 * @version 1.0
 * @since 1.0
 */
public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        new LevelPath().getXP(e.getPlayer(), "join_streak");
        new PlayerEntry().onJoin(e);
        new DailyJoin().onDailyJoin(e);
        new PlayTime().startTracking(e.getPlayer());

        new XPManager().onGainEvent(e.getPlayer(), 0, "Level Refresh");

        String p = Adventures.getInstance().p.get(e.getPlayer().getName());
        String[] plist = p.split(";");
        String pdifficulty = plist[6];

        if (pdifficulty.equals(ChatColor.stripColor(Difficultys.D7.name))) {
            new ExecuteDifficulty().SwiftHunger_Effects(e.getPlayer());
        }

        if (pdifficulty.equals(ChatColor.stripColor(Difficultys.D4.name))) {
            new ExecuteDifficulty().CarefulSnail_Movement(e.getPlayer());
        }

        if (pdifficulty.equals(ChatColor.stripColor(Difficultys.D3.name))) {
            new ExecuteDifficulty().CarelessCheetah_Movement(e.getPlayer());
        }
    }
}