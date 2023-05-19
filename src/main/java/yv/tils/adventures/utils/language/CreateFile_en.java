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

        ymlfile.addDefault("WHITELIST_EMPTY", "The whitelist is empty!");

        ymlfile.addDefault("PLAYER_NOT_ONLINE","This player isn't online!");
        ymlfile.addDefault("PLAYER_UNKNOWN","PREFIX §4Unknown Player");
        ymlfile.addDefault("PLAYER_ALREADY_BANNED","This player is already banned!");
        ymlfile.addDefault("MISSING_PERMISSION","§cMissing Permission:");

        ymlfile.addDefault("SPAWN_ELYTRA_BOOST","§fTo boost you press");

        ymlfile.addDefault("SMP_START_MESSAGE","§dHave Fun by Projectname");
        ymlfile.addDefault("SMP_ALREADY_STARTED","§dThis SMP already got started!");

        ymlfile.addDefault("CHATMUTE_ENABLE_ANNOUNCEMENT","PREFIXGLOBALMUTE §7The Globalmute got enabled!");
        ymlfile.addDefault("CHATMUTE_DISABLE_ANNOUNCEMENT","PREFIXGLOBALMUTE §7The Globalmute got disabled!");
        ymlfile.addDefault("CHATMUTE_ENABLE_FEEDBACK","PREFIXFEEDBACK §7You disabled the Chat!");
        ymlfile.addDefault("CHATMUTE_DISABLE_FEEDBACK","PREFIXFEEDBACK §7You enabled the Chat!");
        ymlfile.addDefault("CHATMUTE_TRY_TO_WRITE","PREFIXGLOBALMUTE §7The Globalmute is activated!");

        ymlfile.addDefault("FLY_COMMAND_ENABLE","§7Fly is now §8enabled§7!");
        ymlfile.addDefault("FLY_COMMAND_DISABLE","§7Fly is now §8disabled§7!");
        ymlfile.addDefault("FLY_COMMAND_ENABLE_OTHER","§7Fly is now §8enabled§7 for PLAYER!");
        ymlfile.addDefault("FLY_COMMAND_DISABLE_OTHER","§7Fly is now §8disabled§7 for PLAYER!");

        ymlfile.addDefault("FLYSPEED_CHANGE","§7You changed your Fly Speed to §8SPEED§7!");
        ymlfile.addDefault("WALKSPEED_CHANGE","§7You changed your Walk Speed to §8SPEED§7!");
        ymlfile.addDefault("FLYSPEED_CHANGE_OTHER","§7You changed the Fly Speed from §ePLAYER §7to §8SPEED§7!");
        ymlfile.addDefault("WALKSPEED_CHANGE_OTHER","§7You changed the Walk Speed from §ePLAYER §7to §8SPEED§7!");

        ymlfile.addDefault("HEAL_PLAYER_HEALED","§7You got §8§lhealed!");
        ymlfile.addDefault("HEAL_OTHER_PLAYER_HEALED","§7PLAYER got §8§lhealed!");

        ymlfile.addDefault("GODMODE_COMMAND_ENABLE","§7God Mode is now §8enabled§7!");
        ymlfile.addDefault("GODMODE_COMMAND_DISABLE","§7God Mode is now §8disabled§7!");
        ymlfile.addDefault("GODMODE_COMMAND_ENABLE_OTHER","§7God Mode is now §8enabled§7 for PLAYER!");
        ymlfile.addDefault("GODMODE_COMMAND_DISABLE_OTHER","§7God Mode is now §8disabled§7 for PLAYER!");

        ymlfile.addDefault("GAMEMODE_SWITCH_SURVIVAL","§7Your Gamemode has been changed to §aSurvival§7!");
        ymlfile.addDefault("GAMEMODE_SWITCH_CREATIVE","§7Your Gamemode has been changed to §aCreative§7!");
        ymlfile.addDefault("GAMEMODE_SWITCH_ADVENTURE","§7Your Gamemode has been changed to §aAdventure§7!");
        ymlfile.addDefault("GAMEMODE_SWITCH_SPECTATOR","§7Your Gamemode has been changed to §aSpectator§7!");
        ymlfile.addDefault("GAMEMODE_SWITCH_ALREADY_IN_THIS_GAMEMODE","§cYou are already in this Gamemode!");
        ymlfile.addDefault("GAMEMODE_SWITCH_SURVIVAL_OTHER","§7The Gamemode from PLAYER has been changed to §aSurvival§7!");
        ymlfile.addDefault("GAMEMODE_SWITCH_CREATIVE_OTHER","§7The Gamemode from PLAYER has been changed to §aCreative§7!");
        ymlfile.addDefault("GAMEMODE_SWITCH_ADVENTURE_OTHER","§7The Gamemode from PLAYER has been changed to §aAdventure§7!");
        ymlfile.addDefault("GAMEMODE_SWITCH_SPECTATOR_OTHER","§7The Gamemode from PLAYER has been changed to §aSpectator§7!");
        ymlfile.addDefault("GAMEMODE_SWITCH_ALREADY_IN_THIS_GAMEMODE_OTHER","§cPLAYER is already in this Gamemode!");

        ymlfile.addDefault("MSG_NOTE","§e[§cNote§e]§f MESSAGE");
        ymlfile.addDefault("MSG_PLAYER_WENT_OFFLINE","PREFIX §4The Person you had messaged has gone offline!");
        ymlfile.addDefault("MSG_HAVENT_MESSAGED_A_PLAYER","PREFIX §4You haven't messaged anyone yet!");

        ymlfile.addDefault("MOD_NO_REASON","No Reason was given!");
        ymlfile.addDefault("MOD_PLAYER_NOT_BANNED","PREFIXMODERATION §8PLAYER §7isn't banned!");
        ymlfile.addDefault("MOD_ANNOUNCEMENT_KICK","PREFIXMODERATION §8PLAYER §7got kicked from §8MODERATOR§7! Reason: §8REASON");
        ymlfile.addDefault("MOD_ANNOUNCEMENT_BAN","PREFIXMODERATION §8PLAYER §7got banned from §8MODERATOR§7! Reason: §8REASON");
        ymlfile.addDefault("MOD_ANNOUNCEMENT_TEMPBAN","PREFIXMODERATION §8PLAYER §7got temp banned from §8MODERATOR§7! Reason: §8REASON§7, Duration: §8DURATION");
        ymlfile.addDefault("MOD_ANNOUNCEMENT_UNBAN","PREFIXMODERATION §8PLAYER §7got unbanned from §8MODERATOR!");

        ymlfile.addDefault("VANISH_DEACTIVATE","PREFIX §7Vanish is now deactivated!");
        ymlfile.addDefault("VANISH_ACTIVATE","PREFIX §7Vanish is now activated!");
        ymlfile.addDefault("VANISH_ITEM_PICKUP_NOT_IN_VANISH","You are not vanished! Please use /vanish before using /v itempickup!");
        ymlfile.addDefault("VANISH_ITEM_PICKUP_DEACTIVATE","PREFIX §7Item Pick Up is now deactivated!");
        ymlfile.addDefault("VANISH_ITEM_PICKUP_ACTIVATE","PREFIX §7Item Pick Up is now activated!");
        ymlfile.addDefault("VANISH_ALREADY_ACTIVATED","You are already vanished!");
        ymlfile.addDefault("VANISH_ALREADY_DEACTIVATED","You are not vanished!");

        ymlfile.addDefault("MAINTENANCE_PLAYER_NOT_ALLOWED_TO_JOIN_KICK_MESSAGE","You aren't allowed to Join the Server, because of Mainteance works!");
        ymlfile.addDefault("MAINTENANCE_COMMAND_DEACTIVATE","§7The Mainteance Mode is now §adeactivated§7!");
        ymlfile.addDefault("MAINTENANCE_COMMAND_ACTIVATE","§7The Maintenance Mode is now §aactivated§7!");
        ymlfile.addDefault("MAINTENANCE_ALREADY_DEACTIVATED","§7The Maintenance Mode is already §adeactivated§7!");
        ymlfile.addDefault("MAINTENANCE_ALREADY_ACTIVATED","§7The Maintenance Mode is already §aactivated§7!");
        ymlfile.addDefault("MAINTENANCE_ILLEGAL_CONFIG_VALUE","This Config Value is not allowed!");
        ymlfile.addDefault("MAINTENANCE_STATUS_ENABLED","§7The Maintenance Mode is now §aactivated§7!");
        ymlfile.addDefault("MAINTENANCE_STATUS_DISABLED","§7The Maintenance Mode is now §adeactivated§7!");

        ymlfile.addDefault("COMMAND_USAGE","§7Usage:");
        ymlfile.addDefault("COMMAND_REPLACE_COPY_COMMAND_TO_CLIPBOARD","§7Click to copy to Clipboard!");
        ymlfile.addDefault("COMMAND_REPLACE_NEW_COMMAND_INFO","§7Please use \nCOMMAND");

        ymlfile.addDefault("TAB_COMPLETER_MOD_COMMAND_DURATION","duration");
        ymlfile.addDefault("TAB_COMPLETER_MOD_COMMAND_REASON","[Reason]");

        ymlfile.addDefault("MODULE_DISCORD_NO_BOT_TOKEN_GIVEN","No Bot Token was given! Deactivate the Discord Bot Module or insert a valid Token!");
        ymlfile.addDefault("MODULE_DISCORD_STARTUP_FAILED","Bot Startup Failed! Please check your Config of the Bot");
        ymlfile.addDefault("MODULE_DISCORD_STARTUP_FINISHED","Bot Startup Finished! Bot should be Online now!");
        ymlfile.addDefault("MODULE_DISCORD_REGISTERED_NAME_CHANGE","Discord User 'DISCORDUSER' changed their whitelisted Minecraft Account from 'OLDNAME' to 'NEWNAME'");
        ymlfile.addDefault("MODULE_DISCORD_REGISTERED_NAME_ADD","Discord User 'DISCORDUSER' has whitelisted their Minecraft Account 'NAME'");
        ymlfile.addDefault("MODULE_DISCORD_REGISTERED_NAME_WRONG","Discord User 'DISCORDUSER' has tried to whitelisted the Minecraft Account 'NAME', but it failed! -> Account doesn't exist");
        ymlfile.addDefault("MODULE_DISCORD_REGISTERED_NAME_SERVERERROR_CHECK_INPUT","Discord User 'DISCORDUSER' has tried to whitelisted the Minecraft Account 'NAME', but it failed! -> Server for checking Names isn't available");

        ymlfile.addDefault("EMBED_BUILDER_TITLE_NAME_CHANGE","You changed your whitelisted Minecraft Account successfully!");
        ymlfile.addDefault("EMBED_BUILDER_DESCRIPTION_NAME_CHANGE","OLDNAME -> NEWNAME");
        ymlfile.addDefault("EMBED_BUILDER_TITLE_NAME_ADD","You whitelisted your Minecraft Account successfully!");
        ymlfile.addDefault("EMBED_BUILDER_DESCRIPTION_NAME_ADD","Account Name: ACCOUNTNAME");
        ymlfile.addDefault("EMBED_BUILDER_TITLE_NAME_NOTEXISTING","This Minecraft Account doesn't exist!");
        ymlfile.addDefault("EMBED_BUILDER_DESCRIPTION_NAME_NOTEXISTING","Account Name: ACCOUNTNAME • Check your Name and try it again! When you think this is an Bug report it directly to the Developer or contact your Server Administration, that thy can contact the Developer!");
        ymlfile.addDefault("EMBED_BUILDER_TITLE_SERVER_ERROR","Name Check Servers aren't available!");
        ymlfile.addDefault("EMBED_BUILDER_DESCRIPTION_SERVER_ERROR","Account Name: ACCOUNTNAME • Try it again in a few Minutes/Hours! When this Error don't fix contact the Developer!");
        ymlfile.addDefault("EMBED_BUILDER_TITLE_NAME_UNALLOWED_CHARACTERS","This Minecraft Account doesn't exist!");
        ymlfile.addDefault("EMBED_BUILDER_DESCRIPTION_NAME_UNALLOWED_CHARACTERS","Account Name: ACCOUNTNAME • You used unallowed characters! Allowed are: a-z; A-Z; 0-9; _");
        ymlfile.addDefault("EMBED_BUILDER_TITLE_ACCOUNT_ALREADY_WHITELISTED","Account already whitelisted!");
        ymlfile.addDefault("EMBED_BUILDER_DESCRIPTION_ACCOUNT_ALREADY_WHITELISTED","Account Name: ACCOUNTNAME • This Account is already whitelisted!");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_CHECK_TITLE","Whitelist Check");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_CHECK_WHITELISTED_DESC","Account Name: MCNAME • This Account is whitelisted with 'DCNAME'!");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_CHECK_NOT_WHITELISTED_DESC","Account Name: MCNAME • This Account is not whitelisted!");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_ADD_TITLE","You whitelisted the Minecraft Account successfully!");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_ADD_DESC","Minecraft Account: MCNAME • Discord Account: DCNAME");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_REPLACE_TITLE","You changed the whitelisted Minecraft Account from DCNAME successfully!");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_REPLACE_DESC","OLDNAME -> NEWNAME");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_REMOVE_TITLE","Which account do you want to remove from the whitelist?");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_REMOVE_DESC","￬ Select it down there ￬");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_REMOVED_TITLE","You have successfully removed the Account MCNAME (DCNAME) from the whitelist!");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_REMOVED_DESC","You want to remove one more account? \n ￬ Select it down there ￬");
        ymlfile.addDefault("MODULE_DISCORD_CMD_REGISTERED_ADD","Discord User 'DISCORDUSER' has whitelisted the Minecraft Account 'MCNAME' (linked with 'DCNAME')");
        ymlfile.addDefault("MODULE_DISCORD_CMD_REGISTERED_CHANGE","Discord User 'DISCORDUSER' has changed the whitelisted Minecraft Account from 'DCNAME' from 'OLDNAME' to 'NEWNAME'");
        ymlfile.addDefault("MODULE_DISCORD_CMD_REGISTERED_REMOVE","Discord User 'DISCORDUSER' has removed the Minecraft Account 'MCNAME' (linked with 'DCNAME') from the whitelist");

        ymlfile.addDefault("EMBED_CMD_ROLE_ADD_ERROR_TITLE","There occurred a error while adding the user!");
        ymlfile.addDefault("EMBED_CMD_ROLE_ADD_ERROR_DESC","The Role, which should be given to the player (ROLE), was not able to be given, because of wrong Hierarchy. \nPlease set the bot role above the role which should be given to users!");

        ymlfile.addDefault("MODULE_STATUS_OTHER_PLAYER_HAS_NO_STATUS","This Player hasn't a Status!");
        ymlfile.addDefault("MODULE_STATUS_CLEAR_OTHER_UNALLOWED","§cYou can't clear the Status of a other Player!");
        ymlfile.addDefault("MODULE_STATUS_CLEAR_OTHER_CLEARED","§7You have successfully cleared the Status of §ePLAYER§7!");
        ymlfile.addDefault("MODULE_STATUS_CLEAR_CLEARED","§7You have successfully cleared your Status");
        ymlfile.addDefault("MODULE_STATUS_PLAYER_HAS_NO_STATUS","§7You don't have a Status!");
        ymlfile.addDefault("MODULE_STATUS_CUSTOM_STATUS_TOO_LONG","§cThis Custom Status is too long!");
        ymlfile.addDefault("MODULE_STATUS_NOT_ALLOWED_TO_SET_CUSTOM_STATUS","§7You aren't allowed to set a custom Status!");
        ymlfile.addDefault("MODULE_STATUS_NO_DEFAULT_STATUS","§7This isn't a default Status!");
        ymlfile.addDefault("MODULE_STATUS_SET","§7You have set your Status to STATUS§7!");
        ymlfile.addDefault("MODULE_STATUS_SELECTED_STATUS_JOIN_ANNOUNCEMENT","§7You have the Status 'STATUS§7' selected!");

        ymlfile.addDefault("MODULE_CCR_ACCEPT_RECIPE","§aAccept Crafting Recipe");

        ymlfile.addDefault("MODULE_INVSEE_INVENTORY","§eInventory of PLAYER");
        ymlfile.addDefault("MODULE_INVSEE_ENDERCHEST","§5Enderchest of PLAYER");
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
