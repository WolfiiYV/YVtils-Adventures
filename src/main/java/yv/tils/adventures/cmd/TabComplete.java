package yv.tils.adventures.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import yv.tils.adventures.Adventures;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @since 1.0
 */
public class TabComplete implements TabCompleter {

    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        List<String> results = new ArrayList<>();

        if (args.length == 1) {
            results.add("ability");
            results.add("difficulty");
            results.add("help");
        }else if (args.length == 2) {
            if (args[0].equals("ability")) {
                results.add("revoke");
                results.add("path");
                results.add("lightflight");
            } else if (args[0].equals("difficulty")) {
                results.add("reset");
            }
        }else if (args.length == 3) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                results.add(player.getName());
            }
        }else if (args.length == 4) {
            if (args[1].equals("revoke")) {
                String p = Adventures.getInstance().p.get(args[2]);
                String[] plist = p.split(";");

                //30;200;0;0;0;[1, 2, 3];Almost Peaceful

                String pabilitys = plist[6];
                pabilitys = pabilitys.replace("[", "");
                pabilitys = pabilitys.replace("]", "");
                String[] abilitylist = pabilitys.split(", ");

                for (String s : abilitylist) {
                    results.add(s);
                }
            }
        }

        return results;
    }
}