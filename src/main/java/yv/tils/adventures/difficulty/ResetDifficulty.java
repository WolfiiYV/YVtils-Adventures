package yv.tils.adventures.difficulty;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @version 1.0
 * @since 1.0
 */
public class ResetDifficulty implements CommandExecutor {
    //CMD: /adventure difficulty reset [player]
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        if (args.length == 0) return false;

        //Define players
        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);

        //Send message to console, that player x has reseted the difficulty of player y, also show the old difficulty of player y
        return false;
    }
}