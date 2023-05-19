package yv.tils.adventures.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * @version 1.0
 * @since 1.0
 */
public class CommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        switch (args[0]) {
            case "difficulty" -> {}
            case "ability" -> {}
            case "help" -> {}
            default -> {}
        }
        return false;
    }
}