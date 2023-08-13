package yv.tils.adventures.ability;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import yv.tils.adventures.Adventures;
import yv.tils.adventures.cmd.CommandHandler;
import yv.tils.adventures.unlock.LevelPath.Level;
import yv.tils.adventures.unlock.LevelPath.PlayerEntry;
import yv.tils.adventures.utils.language.LanguageFile;
import yv.tils.adventures.utils.language.LanguageMessage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        Player player = Bukkit.getPlayer(args[2]);

        File file = new File(Adventures.getInstance().getDataFolder(), "level-path.yml");
        YamlConfiguration ymlfile = YamlConfiguration.loadConfiguration(file);

        String p = Adventures.getInstance().p.get(player.getName());
        String[] plist = p.split(";");
        String pabilitys = plist[6];
        pabilitys = pabilitys.replace("[", "");
        pabilitys = pabilitys.replace("]", "");
        List<String> abilitylist = new ArrayList<>(List.of(pabilitys.split(", ")));

        StringBuilder builder = new StringBuilder();
        for (int x = 3; x < args.length; x++) {
            builder.append(args[x]).append(" ");
        }
        String ability = builder.toString();
        ability = ability.trim();

        abilitylist.remove(ability);
        ymlfile.set(player.getName() + ".Abilitys", abilitylist);
        try {
            ymlfile.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        new PlayerEntry().configGetter(player);

        sender.sendMessage("You successful removed the Ability \"" + ability + "\" from " + player.getName());

        return false;
    }
}