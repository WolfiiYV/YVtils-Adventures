package yv.tils.adventures.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import yv.tils.adventures.ability.RevokeAbility;
import yv.tils.adventures.difficulty.ReselectDifficulty;
import yv.tils.adventures.difficulty.ResetDifficulty;
import yv.tils.adventures.unlock.LevelPath.LevelPath;
import yv.tils.adventures.utils.language.LanguageFile;
import yv.tils.adventures.utils.language.LanguageMessage;

/**
 * @version 1.0
 * @since 1.0
 */
public class CommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player player)) return false;
        if (args.length == 0) {
            sendUsage(sender);
            return false;
        }
        switch (args[0]) {
            case "difficulty" -> {
                if (args.length == 1) {
                    sendUsage(sender);
                    return false;
                }
                switch (args[1])
                {
                    case "reset" -> new ResetDifficulty().onCommand(sender, cmd, label, args);
                    case "reselect" -> new ReselectDifficulty().onCommand(sender, cmd, label, args);
                    default -> sendUsage(sender);
                }
            }
            case "ability" -> {
                if (args.length == 1) {
                    sendUsage(sender);
                    return false;
                }
                switch (args[1]) {
                    case "revoke" -> new RevokeAbility().onCommand(sender, cmd, label, args);
                    case "path" -> new LevelPath().GUI(player);
                    default -> sendUsage(sender);
                }
            }
            case "help" -> sendUsage(sender);
            default -> sendUsage(sender);
        }
        return false;
    }

    public void sendUsage(CommandSender sender){
        sender.sendMessage( LanguageFile.getMessage(LanguageMessage.COMMAND_USAGE)+ " " + ChatColor.BLUE +
                "\n/adventure difficulty reset [player]\n" +
                "/adventure ability revoke [player] [ability]\n" +
                "/adventure ability path\n" +
                "/adventure help");
    }
}