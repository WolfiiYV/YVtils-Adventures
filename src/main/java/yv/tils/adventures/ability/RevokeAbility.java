package yv.tils.adventures.ability;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import yv.tils.adventures.cmd.CommandHandler;
import yv.tils.adventures.utils.language.LanguageFile;
import yv.tils.adventures.utils.language.LanguageMessage;

/**
 * @version 1.0
 * @since 1.0
 */
public class RevokeAbility {
    //CMD: /adventure ability revoke [player] [ability]
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("yvtils.adventures.ability.revoke")) {
            sender.sendMessage(LanguageFile.getMessage(LanguageMessage.MISSING_PERMISSION) + " yvtils.adventures.ability.revoke");
            return false;
        }

        if (args.length == 2 || args.length == 3) {
            new CommandHandler().sendUsage(sender);
            return false;
        }

        return false;
    }
}