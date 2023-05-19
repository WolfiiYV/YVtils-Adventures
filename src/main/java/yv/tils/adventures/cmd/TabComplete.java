package yv.tils.adventures.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @since 1.0
 */
public class TabComplete implements TabCompleter {

    List<String> arguments = new ArrayList<>();

    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {

        if (args.length == 1) {
            arguments.add("ability");
            arguments.add("difficulty");
        }else if (args.length == 2) {
            if (args[0].equals("ability")) {
                arguments.add("revoke");
            } else if (args[0].equals("difficulty")) {
                arguments.add("reset");
            }
        }else if (args.length == 3) {

        }

        return arguments;
    }
}