package yv.tils.adventures.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import yv.tils.adventures.unlock.LevelPath.LevelPath;

/**
 * @version 1.0
 * @since 1.0
 */
public class LevelPathCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player player)) return false;
        new LevelPath().GUI(player);
        return false;
    }
}