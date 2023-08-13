package yv.tils.adventures.difficulty;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import yv.tils.adventures.Adventures;
import yv.tils.adventures.cmd.CommandHandler;
import yv.tils.adventures.unlock.LevelPath.Level;
import yv.tils.adventures.unlock.LevelPath.PlayerEntry;
import yv.tils.adventures.utils.ConfigModeration;
import yv.tils.adventures.utils.language.LanguageFile;
import yv.tils.adventures.utils.language.LanguageMessage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.bukkit.potion.PotionEffect.INFINITE_DURATION;

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

        Player player = Bukkit.getPlayer(args[2]);

        File file = new File(Adventures.getInstance().getDataFolder(), "level-path.yml");
        YamlConfiguration ymlfile = YamlConfiguration.loadConfiguration(file);

        String p = Adventures.getInstance().p.get(player.getName());
        String[] plist = p.split(";");
        String pabilitys = plist[6];
        pabilitys = pabilitys.replace("[", "");
        pabilitys = pabilitys.replace("]", "");
        List<String> abilitylist = new ArrayList<>(List.of(pabilitys.split(", ")));

        abilitylist.remove(Level.L1.reward);
        ymlfile.set(player.getName() + ".Abilitys", abilitylist);
        try {
            ymlfile.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new ConfigModeration().ConfigContentAdd("level-path", player.getName() + ".Difficulty", "none");
        new PlayerEntry().configGetter(player);

        player.setWalkSpeed(0.2f);
        player.removePotionEffect(PotionEffectType.SLOW_DIGGING);
        player.removePotionEffect(PotionEffectType.FAST_DIGGING);

        sender.sendMessage("You successful removed the Difficulty of " + player.getName());

        return false;
    }
}