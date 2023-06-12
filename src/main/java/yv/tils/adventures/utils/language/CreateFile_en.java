package yv.tils.adventures.utils.language;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import yv.tils.adventures.Adventures;

import java.io.File;
import java.io.IOException;

/**
 * @since 1.0
 * @version 1.0
 */
public class CreateFile_en {
    File file = new File(Adventures.getInstance().getDataFolder() + "/Language", "en.yml");
    YamlConfiguration ymlfile = YamlConfiguration.loadConfiguration(file);

    public void StringInput() {
        ymlfile.addDefault("Language File", "EN");
        ymlfile.addDefault("#1", "Please always use all the variables that are already specified, otherwise, the language system won't work! - Variables can be seen from the fact that they are written completely in caps.");
        ymlfile.addDefault("START_MESSAGE","PREFIXENABLE §aPlugin is starting!");
        ymlfile.addDefault("START_COMPLETED_MESSAGE","PREFIXENABLE §2Plugin start is completed!");
        ymlfile.addDefault("STOP_MESSAGE","PREFIXDISABLE §cPlugin is stopping!");
        ymlfile.addDefault("STOP_COMPLETED_MESSAGE","PREFIXDISABLE §4YVtils-SMP stop is completed!");
        ymlfile.addDefault("PLUGIN_UP_TO_DATE","PREFIXNOUPDATE §fPlugin is up to date.");
        ymlfile.addDefault("PLUGIN_UPDATE_AVAILABLE","PREFIXUPDATE §eThe Plugin Version NEWVERSION is now available. The Server uses OLDVERSION! Download the new Version here LINK");
        ymlfile.addDefault("UNKNOWN_TIME_FORMAT","This time Format is not a Option to use!");
        ymlfile.addDefault("PLAYER_NOT_ONLINE","This player isn't online!");
        ymlfile.addDefault("PLAYER_UNKNOWN","PREFIX §4Unknown Player");
        ymlfile.addDefault("MISSING_PERMISSION","§cMissing Permission:");
        ymlfile.addDefault("COMMAND_USAGE","§7Usage:");
        ymlfile.addDefault("COMMAND_REPLACE_COPY_COMMAND_TO_CLIPBOARD","§7Click to copy to Clipboard!");
        ymlfile.addDefault("COMMAND_REPLACE_NEW_COMMAND_INFO","§7Please use \nCOMMAND");



        //ADDED

        ymlfile.addDefault("DIFFICULTY_DESC_CHALLENGE", "§7You want a new record? \nDon't let them kill you, they say, but what if they make more damage than you want them to?");
        ymlfile.addDefault("DIFFICULTY_DESC_DETAILED_CHALLENGE", "§dDouble damage from everything, \nit's a Challenge so that's all");
        ymlfile.addDefault("DIFFICULTY_DESC_ALMOST_PEACEFUL", "§7You were killed by something again? \nDon't be sad, now you have found it, \nthe ultimate strategy, or maybe even the best treasure ever? \nWho knows! But don't stand still for too long, search another treasure.");
        ymlfile.addDefault("DIFFICULTY_DESC_DETAILED_ALMOST_PEACEFUL", "§dLess Damage from everything. \nIf you stand still for too long, you will receive Fire Damage, even in Water");
        ymlfile.addDefault("DIFFICULTY_DESC_CARELESS_CHEETAH", "§7You want to be as fast as a Cheetah? \nThen this is perfect for you! \nBut be carefully you maybe forget to pick up Items");
        ymlfile.addDefault("DIFFICULTY_DESC_DETAILED_CARELESS_CHEETAH", "§dSpeed & Haste, but lower Drop Rates");
        ymlfile.addDefault("DIFFICULTY_DESC_CAREFUL_SNAIL", "§7Snails are not fast, but then they can't forget any Items");
        ymlfile.addDefault("DIFFICULTY_DESC_DETAILED_CAREFUL_SNAIL", "§dSlowness & Mining Fatigue, but better Drop Rate");
        ymlfile.addDefault("DIFFICULTY_DESC_CAREFUL_HOLDER", "§7Don't die, I gave you my good equip, \nor else you need to farm it again for me! \nDon't think about it, I won't lose it! \nThen be at least careful, so I don't need to get too much XP!");
        ymlfile.addDefault("DIFFICULTY_DESC_DETAILED_CAREFUL_HOLDER", "§dKeep Inventory is active, but Items will lose durability when dying");
        ymlfile.addDefault("DIFFICULTY_DESC_RUTHLESS_RUMBLE", "§7WARNING! THE PURGE IS STARTING NOW! \nThat was a joke, but something alike is coming on to you.");
        ymlfile.addDefault("DIFFICULTY_DESC_DETAILED_RUTHLESS_RUMBLE", "§dHostile Mobs like \nZombies, Skeletons, Blazes, Ghasts and more \nwill make you more damage, but you make all other Mobs more damage");
        ymlfile.addDefault("DIFFICULTY_DESC_SWIFT_HUNGER", "§7Don't rush you, or you will be hungry. \nYou know, that we wanted to eat something small tonight.");
        ymlfile.addDefault("DIFFICULTY_DESC_DETAILED_SWIFT_HUNGER", "§dYou lose faster hunger, but you are faster in walking and mining.");


        ymlfile.options().copyDefaults(true);
        fileSave();
    }

    public void fileSave() {
        try {
            ymlfile.save(file);
        } catch (IOException e) {
            System.out.println("-------");
            Bukkit.getConsoleSender().sendMessage("File creation Error! Please get Support on the YVtils Support Discord");
            System.out.println("-------");
        }
    }
}
