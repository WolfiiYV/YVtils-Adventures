package yv.tils.adventures.unlock.LevelPath.XPGain;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import yv.tils.adventures.Adventures;
import yv.tils.adventures.difficulty.Difficultys;
import yv.tils.adventures.unlock.LevelPath.Level;
import yv.tils.adventures.unlock.LevelPath.PlayerEntry;

import java.io.File;
import java.io.IOException;

/**
 * @version 1.0
 * @since 1.0
 */
public class XPManager {

    //level,xp,joinstreak,playtimeall,playtimeday,ablitys,difficulty

    public void onGainEvent(Player player, int xp, String event) {
        String p = Adventures.getInstance().p.get(player.getName());
        String[] plist = p.split(";");
        int pXP = Integer.parseInt(plist[1]);
        int pLevel = Integer.parseInt(plist[0]);


        if (pXP + xp >= Level.valueOf("L" + (pLevel+1)).xp) {
            LevelUp(player, Level.valueOf("L" + (pLevel+1)).level, pXP + xp);
        }else {
            File file = new File(Adventures.getInstance().getDataFolder(), "level-path.yml");
            YamlConfiguration ymlfile = YamlConfiguration.loadConfiguration(file);

            ymlfile.set(player.getName() + ".XP", pXP + xp);
            try {
                ymlfile.save(file);
            } catch (IOException ignored) {}

            new PlayerEntry().configGetter(player);
        }
    }

    private void LevelUp(Player player, int level, int xp) {
        player.sendMessage("You leveled up! New Level: " + level);

        File file = new File(Adventures.getInstance().getDataFolder(), "level-path.yml");
        YamlConfiguration ymlfile = YamlConfiguration.loadConfiguration(file);

        ymlfile.set(player.getName() + ".Level", level);
        ymlfile.set(player.getName() + ".XP", xp-Level.valueOf("L" + level).xp);
        try {
            ymlfile.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        new PlayerEntry().configGetter(player);

        if (xp-Level.valueOf("L" + level).xp >= Level.valueOf("L" + (level+1)).xp) {
            LevelUp(player, Level.valueOf("L" + (level+1)).level, xp-Level.valueOf("L" + level).xp);
        }
    }
}