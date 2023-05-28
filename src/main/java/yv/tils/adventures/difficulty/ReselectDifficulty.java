package yv.tils.adventures.difficulty;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import yv.tils.adventures.Adventures;
import yv.tils.adventures.unlock.LevelPath.Level;
import yv.tils.adventures.utils.ConsoleLog;

/**
 * @version 1.0
 * @since 1.0
 */
public class ReselectDifficulty {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (!Adventures.getInstance().diffitimer.contains(player.getName())) return false;
        new ConsoleLog(player.getName() + " changed their mind about the difficulty, in the right moment.");
        new SelectDifficulty().DifficultyGUI(player);
        return false;
    }
}