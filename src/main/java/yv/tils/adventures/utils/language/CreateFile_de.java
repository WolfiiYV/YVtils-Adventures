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
public class CreateFile_de {
    File file = new File(Adventures.getInstance().getDataFolder() + "/Language", "de.yml");
    YamlConfiguration ymlfile = YamlConfiguration.loadConfiguration(file);

    public void StringInput() {
        ymlfile.addDefault("Language File", "DE");
        ymlfile.addDefault("#1", "Bitte benutze immer alle bereits angegebenen Variablen, da ansonsten das Sprachen-System nicht funktioniert! - Variablen sind daran zu erkennen, dass sie komplett in Caps geschrieben sind.");
        ymlfile.addDefault("START_MESSAGE", "PREFIXENABLE §aPlugin startet!");
        ymlfile.addDefault("START_COMPLETED_MESSAGE", "PREFIXENABLE §2YVtils-SMP Start ist abgeschlossen!");
        ymlfile.addDefault("STOP_MESSAGE", "PREFIXDISABLE §cPlugin wird gestoppt!");
        ymlfile.addDefault("STOP_COMPLETED_MESSAGE", "PREFIXDISABLE §4YVtils-SMP wurde gestoppt!");

        ymlfile.addDefault("PLUGIN_UP_TO_DATE", "PREFIXNOUPDATE §fDas Plugin hat keine Updates zur verfügung!");
        ymlfile.addDefault("PLUGIN_UPDATE_AVAILABLE", "PREFIXUPDATE §eDie Plugin Version NEWVERSION ist nun verfügbar. Der Server nutzt noch OLDVERSION! Lade die neue Version über LINK herunter");

        ymlfile.addDefault("UNKNOWN_TIME_FORMAT", "Dieses Zeit Format steht nicht zur Auswahl!");

        ymlfile.addDefault("WHITELIST_EMPTY", "Die Whitelist ist leer!");

        ymlfile.addDefault("PLAYER_NOT_ONLINE", "Dieser Spieler ist nicht online!");
        ymlfile.addDefault("PLAYER_UNKNOWN", "PREFIX §4Unbekannter Spieler");
        ymlfile.addDefault("PLAYER_ALREADY_BANNED", "Dieser Spieler ist bereits gebannt!");
        ymlfile.addDefault("MISSING_PERMISSION", "§cFehlende Berechtigung:");

        ymlfile.addDefault("SPAWN_ELYTRA_BOOST", "§fUm dich zu boosten drücke");

        ymlfile.addDefault("SMP_START_MESSAGE", "§dViel Spaß bei Projektname!");
        ymlfile.addDefault("SMP_ALREADY_STARTED", "§dDieses SMP wurde bereits gestartet!");

        ymlfile.addDefault("CHATMUTE_ENABLE_ANNOUNCEMENT","PREFIXGLOBALMUTE §7Der Globalmute wurde aktiviert!");
        ymlfile.addDefault("CHATMUTE_DISABLE_ANNOUNCEMENT","PREFIXGLOBALMUTE §7Der Globalmute wurde deaktiviert!");
        ymlfile.addDefault("CHATMUTE_ENABLE_FEEDBACK","PREFIXFEEDBACK §7Du hast den Chat deaktiviert!");
        ymlfile.addDefault("CHATMUTE_DISABLE_FEEDBACK","PREFIXFEEDBACK §7Du hast den Chat aktiviert!");
        ymlfile.addDefault("CHATMUTE_TRY_TO_WRITE","PREFIXGLOBALMUTE §7Der Globalmute ist aktiviert!");

        ymlfile.addDefault("FLY_COMMAND_ENABLE","§7Du kannst nun fliegen!");
        ymlfile.addDefault("FLY_COMMAND_DISABLE","§7Du kannst nun nicht mehr fliegen!");
        ymlfile.addDefault("FLY_COMMAND_ENABLE_OTHER","§7PLAYER kann nun fliegen!");
        ymlfile.addDefault("FLY_COMMAND_DISABLE_OTHER","§7PLAYER kann nun nicht mehr fliegen!");

        ymlfile.addDefault("FLYSPEED_CHANGE","§7Du hast deine Flug Geschwindigkeit zu §8SPEED §7geändert!");
        ymlfile.addDefault("WALKSPEED_CHANGE","§7Du hast deine Lauf Geschwindigkeit zu §8SPEED §7geändert!");
        ymlfile.addDefault("FLYSPEED_CHANGE_OTHER","§7Du hast die Flug Geschwindigkeit von §ePLAYER §7zu §8SPEED§7!");
        ymlfile.addDefault("WALKSPEED_CHANGE_OTHER","§7Du hast die Lauf Geschwindigkeit von §ePLAYER §7zu §8SPEED§7!");

        ymlfile.addDefault("HEAL_PLAYER_HEALED","§7Du wurdest §8§lgeheilt!");
        ymlfile.addDefault("HEAL_OTHER_PLAYER_HEALED","§7PLAYER wurde §8§lgeheilt!");

        ymlfile.addDefault("GODMODE_COMMAND_ENABLE","§7God Mode ist nun §8aktiviert§7!");
        ymlfile.addDefault("GODMODE_COMMAND_DISABLE","§7God Mode ist nun §8deaktiviert§7!");
        ymlfile.addDefault("GODMODE_COMMAND_ENABLE_OTHER","§7PLAYER ist nun im God Mode!");
        ymlfile.addDefault("GODMODE_COMMAND_DISABLE_OTHER","§7PLAYER ist nun nicht mehr im God Mode!");

        ymlfile.addDefault("GAMEMODE_SWITCH_SURVIVAL","§7Dein Spielmodus wurde zu §aÜberleben §7geändert!");
        ymlfile.addDefault("GAMEMODE_SWITCH_CREATIVE","§7Dein Spielmodus wurde zu §aKreativ §7geändert!");
        ymlfile.addDefault("GAMEMODE_SWITCH_ADVENTURE","§7Dein Spielmodus wurde zu §aAbenteuer §7geändert!");
        ymlfile.addDefault("GAMEMODE_SWITCH_SPECTATOR","§7Dein Spielmodus wurde zu §aBeobachter §7geändert!");
        ymlfile.addDefault("GAMEMODE_SWITCH_ALREADY_IN_THIS_GAMEMODE","§cDu bist bereits in diesem Spielmodus!");
        ymlfile.addDefault("GAMEMODE_SWITCH_SURVIVAL_OTHER","§7Der Spielmodus von PLAYER wurde zu §aÜberleben §7geändert!");
        ymlfile.addDefault("GAMEMODE_SWITCH_CREATIVE_OTHER","§7Der Spielmodus von PLAYER wurde zu §aKreativ §7geändert!");
        ymlfile.addDefault("GAMEMODE_SWITCH_ADVENTURE_OTHER","§7Der Spielmodus von PLAYER wurde zu §aAbenteuer §7geändert!");
        ymlfile.addDefault("GAMEMODE_SWITCH_SPECTATOR_OTHER","§7Der Spielmodus von PLAYER wurde zu §aBeobachter §7geändert!");
        ymlfile.addDefault("GAMEMODE_SWITCH_ALREADY_IN_THIS_GAMEMODE_OTHER","§cPLAYER ist bereits in diesem Spielmodus!");

        ymlfile.addDefault("MSG_NOTE","§e[§cNotiz§e]§f MESSAGE");
        ymlfile.addDefault("MSG_PLAYER_WENT_OFFLINE","PREFIX §4Der Spieler mit welchem du zuletzt geschriebn hast ist offline gegangen!");
        ymlfile.addDefault("MSG_HAVENT_MESSAGED_A_PLAYER","PREFIX §4Du hast noch niemandem geschrieben!");

        ymlfile.addDefault("MOD_NO_REASON","Kein Grund war angegeben!");
        ymlfile.addDefault("MOD_PLAYER_NOT_BANNED","PREFIXMODERATION §8PLAYER §7 ist nicht gebannt!");
        ymlfile.addDefault("MOD_ANNOUNCEMENT_KICK","PREFIXMODERATION §8PLAYER §7wurde von §8MODERATOR §7geckickt! Grund: §8REASON");
        ymlfile.addDefault("MOD_ANNOUNCEMENT_BAN","PREFIXMODERATION §8PLAYER §7wurde von §8MODERATOR §7gebannt! Grund: §8REASON");
        ymlfile.addDefault("MOD_ANNOUNCEMENT_TEMPBAN","PREFIXMODERATION §8PLAYER §7wurde von §8MODERATOR§7 getempbannt! Reason: §8REASON§7, Duration: §8DURATION");
        ymlfile.addDefault("MOD_ANNOUNCEMENT_UNBAN","PREFIXMODERATION §8PLAYER §7wurde von §8MODERATOR §7entbannt!");

        ymlfile.addDefault("VANISH_DEACTIVATE","PREFIX §7Vanish ist nun deaktiviert!");
        ymlfile.addDefault("VANISH_ACTIVATE","PREFIX §7Vanish ist nun aktiviert!");
        ymlfile.addDefault("VANISH_ITEM_PICKUP_NOT_IN_VANISH","PREFIX §7Du bist nicht im Vanish! Bitte benutze erst /vanish bevor du /v itempickup benutzt!");
        ymlfile.addDefault("VANISH_ITEM_PICKUP_DEACTIVATE","PREFIX §7Item Pick Up ist nun deaktiviert!");
        ymlfile.addDefault("VANISH_ITEM_PICKUP_ACTIVATE","PREFIX §7Item Pick Up ist nun aktiviert!");
        ymlfile.addDefault("VANISH_ALREADY_ACTIVATED","Du bist bereits im Vanish!");
        ymlfile.addDefault("VANISH_ALREADY_DEACTIVATED","Du bist nicht im Vanish!");

        ymlfile.addDefault("MAINTENANCE_PLAYER_NOT_ALLOWED_TO_JOIN_KICK_MESSAGE","Du bist nicht erlaubt, den Server während Wartungsarbeiten zu betreten!");
        ymlfile.addDefault("MAINTENANCE_COMMAND_DEACTIVATE","§7Der Mainteance Modus ist nun §adeaktiviert§7!");
        ymlfile.addDefault("MAINTENANCE_COMMAND_ACTIVATE","§7Der Maintenance Modus ist nun §aaktiviert§7!");
        ymlfile.addDefault("MAINTENANCE_ALREADY_DEACTIVATED","§7Der Maintenance Modus ist bereits §adeaktiviert§7!");
        ymlfile.addDefault("MAINTENANCE_ALREADY_ACTIVATED","§7Der Maintenance Modus ist bereits §aaktiviert§7!");
        ymlfile.addDefault("MAINTENANCE_ILLEGAL_CONFIG_VALUE","Dieser Config Wert ist nicht zulässig!");
        ymlfile.addDefault("MAINTENANCE_STATUS_ENABLED","§7Der Maintenance Modus ist §aaktiviert§7!");
        ymlfile.addDefault("MAINTENANCE_STATUS_DISABLED","§7Der Maintenance Modus ist §adeaktiviert§7!");

        ymlfile.addDefault("COMMAND_USAGE","§7Benutze:");
        ymlfile.addDefault("COMMAND_REPLACE_COPY_COMMAND_TO_CLIPBOARD","§7Klicke um es zu kopieren!");
        ymlfile.addDefault("COMMAND_REPLACE_NEW_COMMAND_INFO","§7Bitte benutze \nCOMMAND");

        ymlfile.addDefault("TAB_COMPLETER_MOD_COMMAND_DURATION","Dauer");
        ymlfile.addDefault("TAB_COMPLETER_MOD_COMMAND_REASON","[Grund]");

        ymlfile.addDefault("MODULE_DISCORD_NO_BOT_TOKEN_GIVEN","Es wurde kein Bot Token erkannt! Deaktiviere das Bot Modul oder trage einen Token ein.");
        ymlfile.addDefault("MODULE_DISCORD_STARTUP_FAILED","Bot Start ist fehlgeschlagen! Bitte überprüfe deine Konfigurationen");
        ymlfile.addDefault("MODULE_DISCORD_STARTUP_FINISHED","Bot Start war erfolgreich! Der Bot sollte nun Online sein!");

        ymlfile.addDefault("MODULE_DISCORD_REGISTERED_NAME_CHANGE","Discord User 'DISCORDUSER' hat seinen gewhitelisteten Account von 'OLDNAME' zu 'NEWNAME' geändert");
        ymlfile.addDefault("MODULE_DISCORD_REGISTERED_NAME_ADD","Discord User 'DISCORDUSER' hat seinen Minecraft Account 'NAME' zur whitelist hinzugefügt");
        ymlfile.addDefault("MODULE_DISCORD_REGISTERED_NAME_WRONG","Discord User 'DISCORDUSER' hat versucht den Minecraft Account 'NAME' zur whitelist hinzuzufügen, aber es ist fehlgeschlagen! -> Account existiert nicht");
        ymlfile.addDefault("MODULE_DISCORD_REGISTERED_NAME_SERVERERROR_CHECK_INPUT","Discord User 'DISCORDUSER' hat versucht den Minecraft Account 'NAME' zur whitelist hinzuzufügen, aber es ist fehlgeschlagen! -> Überprüfungsserver sind nicht erreichbar");

        ymlfile.addDefault("EMBED_BUILDER_TITLE_NAME_CHANGE","Du hast erfolgreich deinen gewhitelisteten Account geändert!");
        ymlfile.addDefault("EMBED_BUILDER_DESCRIPTION_NAME_CHANGE","OLDNAME -> NEWNAME");
        ymlfile.addDefault("EMBED_BUILDER_TITLE_NAME_ADD","Du hast deinen Minecraft Account erfolgreich zur whitelist hinzugefügt!");
        ymlfile.addDefault("EMBED_BUILDER_DESCRIPTION_NAME_ADD","Account Name: ACCOUNTNAME");
        ymlfile.addDefault("EMBED_BUILDER_TITLE_NAME_NOTEXISTING","Dieser Minecraft Account existiert nicht!");
        ymlfile.addDefault("EMBED_BUILDER_DESCRIPTION_NAME_NOTEXISTING","Account Name: ACCOUNTNAME • Überprüfe den Namen und versuche es erneut! Wenn du denkst das es ein Fehler ist, dann kontaktiere denn Developer oder kontaktiere die Server Administration, dass sie es dem Developer mitteilen können!");
        ymlfile.addDefault("EMBED_BUILDER_TITLE_SERVER_ERROR","Überprüfungsserver sind nicht erreichbar!");
        ymlfile.addDefault("EMBED_BUILDER_DESCRIPTION_SERVER_ERROR","Account Name: ACCOUNTNAME • Versuche es in ein paar Minuten/Stunden erneut! Wenn dieser Fehler bestehen bleibt kontaktiere den Developer!");
        ymlfile.addDefault("EMBED_BUILDER_TITLE_NAME_UNALLOWED_CHARACTERS","Dieser Minecraft Account existiert nicht!");
        ymlfile.addDefault("EMBED_BUILDER_DESCRIPTION_NAME_UNALLOWED_CHARACTERS","Account Name: ACCOUNTNAME • Du hast unerlaubte Zeichen verwendet! Erlaubt sind: a-z; A-Z; 0-9; _");
        ymlfile.addDefault("EMBED_BUILDER_TITLE_ACCOUNT_ALREADY_WHITELISTED","Account ist bereits auf der Whitelist!");
        ymlfile.addDefault("EMBED_BUILDER_DESCRIPTION_ACCOUNT_ALREADY_WHITELISTED","Account Name: ACCOUNTNAME • Dieser Account ist bereits auf der Whitelist!");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_CHECK_TITLE","Whitelist Check");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_CHECK_WHITELISTED_DESC","Account Name: MCNAME • Dieser Account ist als 'DCNAME' auf der Whitelist!");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_CHECK_NOT_WHITELISTED_DESC","Account Name: MCNAME • Dieser Account ist nicht auf der Whitelist!");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_ADD_TITLE","Du hast erfolgreich den Minecraft Account gewhitelistet!");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_ADD_DESC","Minecraft Account: MCNAME • Discord Account: DCNAME");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_REPLACE_TITLE","Du hast erfolgreich den gewhitelisteten Account von DCNAME geändert!");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_REPLACE_DESC","OLDNAME -> NEWNAME");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_REMOVE_TITLE","Welchen Account möchtest du von der whitelist entfernen?");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_REMOVE_DESC","￬ Wähle ihn unten aus ￬");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_REMOVED_TITLE","Du hast erfolgreich den Account von MCNAME (DCNAME) von der whitelist entfernt!");
        ymlfile.addDefault("EMBED_CMD_WHITELIST_REMOVED_DESC","Möchtest du noch einen Account entfernen? \n ￬ Wähle ihn unten aus ￬");
        ymlfile.addDefault("MODULE_DISCORD_CMD_REGISTERED_ADD","Discord User 'DISCORDUSER' hat den Minecraft Account 'MCNAME' (verbunden mit 'DCNAME') zur whitelist hinzugefügt");
        ymlfile.addDefault("MODULE_DISCORD_CMD_REGISTERED_CHANGE","Discord User 'DISCORDUSER' hat den gewhitelisteten Account von 'DCNAME' von 'OLDNAME' zu 'NEWNAME' geändert");
        ymlfile.addDefault("MODULE_DISCORD_CMD_REGISTERED_REMOVE","Discord User 'DISCORDUSER' hat den Minecraft Account 'MCNAME' (verbunden mit 'DCNAME') von der whitelist entfernt");

        ymlfile.addDefault("EMBED_CMD_ROLE_ADD_ERROR_TITLE","Es ist ein Fehler beim hinzufügen aufgetreten!");
        ymlfile.addDefault("EMBED_CMD_ROLE_ADD_ERROR_DESC","Die Rolle, welche dem User gegeben werden sollte (ROLE), konnte vom Bot wegen falscher Hierarchie der Rollen nicht hinzugefügt werden! \nBitte setze die Rolle vom Bot über die Rolle welche vergeben werden soll.");

        ymlfile.addDefault("MODULE_STATUS_OTHER_PLAYER_HAS_NO_STATUS","Dieser Spieler hat keinen Status!");
        ymlfile.addDefault("MODULE_STATUS_CLEAR_OTHER_UNALLOWED","§cDu kannst nicht den Status von anderen Spieler löschen!");
        ymlfile.addDefault("MODULE_STATUS_CLEAR_OTHER_CLEARED","§7Du hast erfolgreich den Status von §ePLAYER §7gelöscht!");
        ymlfile.addDefault("MODULE_STATUS_CLEAR_CLEARED","§7Du hast erfolgreich deinen Status §7gelöscht!");
        ymlfile.addDefault("MODULE_STATUS_PLAYER_HAS_NO_STATUS","§7Du hast keinen Status!");
        ymlfile.addDefault("MODULE_STATUS_CUSTOM_STATUS_TOO_LONG","§cDieser custom Status ist zu lang!");
        ymlfile.addDefault("MODULE_STATUS_NOT_ALLOWED_TO_SET_CUSTOM_STATUS","§7Du bist nicht berechtigt dir einen eigenen Status zu setzen!");
        ymlfile.addDefault("MODULE_STATUS_NO_DEFAULT_STATUS","§7Das ist kein Default Status!");
        ymlfile.addDefault("MODULE_STATUS_SET","§7Du hast dir den Status STATUS §7gesetzt!");
        ymlfile.addDefault("MODULE_STATUS_SELECTED_STATUS_JOIN_ANNOUNCEMENT","§7Der Status 'STATUS§7' ist gesetzt!");

        ymlfile.addDefault("MODULE_CCR_ACCEPT_RECIPE","§aCrafting Rezept akzeptieren");

        ymlfile.addDefault("MODULE_INVSEE_INVENTORY","§eInventar von PLAYER");
        ymlfile.addDefault("MODULE_INVSEE_ENDERCHEST","§5Enderchest von PLAYER");
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
