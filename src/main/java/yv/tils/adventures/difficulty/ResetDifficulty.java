package yv.tils.adventures.difficulty;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import yv.tils.adventures.cmd.CommandHandler;
import yv.tils.adventures.utils.language.LanguageFile;
import yv.tils.adventures.utils.language.LanguageMessage;

/**
 * @version 1.0
 * @since 1.0
 */
public class ResetDifficulty {
    //CMD: /adventure difficulty reset [player]
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("yvtils.adventures.difficulty.reset")) {
            sender.sendMessage(LanguageFile.getMessage(LanguageMessage.MISSING_PERMISSION) + " yvtils.adventures.difficulty.reset");
            return false;
        }

        if (args.length == 2) {
            new CommandHandler().sendUsage(sender);
            return false;
        }

        return false;
    }
}