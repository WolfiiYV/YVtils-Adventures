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
        ymlfile.addDefault("PLAYER_NOT_ONLINE", "Dieser Spieler ist nicht online!");
        ymlfile.addDefault("PLAYER_UNKNOWN", "PREFIX §4Unbekannter Spieler");
        ymlfile.addDefault("MISSING_PERMISSION", "§cFehlende Berechtigung:");
        ymlfile.addDefault("COMMAND_USAGE","§7Benutze:");
        ymlfile.addDefault("COMMAND_REPLACE_COPY_COMMAND_TO_CLIPBOARD","§7Klicke um es zu kopieren!");
        ymlfile.addDefault("COMMAND_REPLACE_NEW_COMMAND_INFO","§7Bitte benutze \nCOMMAND");


        //ADDED

        ymlfile.addDefault("DIFFICULTY_DESC_CHALLENGE", "Du willst einen neuen Rekord? \nLass dich nicht töten, sagen sie, aber was wäre wenn du mehr Schaden abbekommst?");
        ymlfile.addDefault("DIFFICULTY_DESC_DETAILED_CHALLENGE", "Doppelter Schaden von allem, \ndas ist eine Challenge, somit ist das alles.");
        ymlfile.addDefault("DIFFICULTY_DESC_ALMOST_PEACEFUL", "Du wurdest schon wieder von etwas getötet? \nSei nicht traurig, denn nun hast du es gefunden, \ndie ultimative Strategie, oder sogar den aller besten Schatz?\n Wer weiß!\n Aber bleibe nicht zu lange still stehen, brich doch zur nächsten Schatzsuche auf.");
        ymlfile.addDefault("DIFFICULTY_DESC_DETAILED_ALMOST_PEACEFUL", "Weniger Schaden von allem, \naber bleibe nicht zu lange irgendwo stehen, nicht das du noch selbst im Wasser in Flammen aufgehst");
        ymlfile.addDefault("DIFFICULTY_DESC_CARELESS_CHEETAH", "Du willst so schnell wie ein Gepard sein? \nDann ist das hier perfekt für dich! Aber sei vorsichtig, nicht das du noch Items vergisst mitzunehmen");
        ymlfile.addDefault("DIFFICULTY_DESC_DETAILED_CARELESS_CHEETAH", "Schnelligkeit & Eile, aber verringerte Drop Raten");
        ymlfile.addDefault("DIFFICULTY_DESC_CAREFUL_SNAIL", "Schnecken sind nicht schnell, aber daher können sie doch gar keine Items vergessen oder?");
        ymlfile.addDefault("DIFFICULTY_DESC_DETAILED_CAREFUL_SNAIL", "Langsamkeit & Abbaulähmung, aber verbesserte Drop Raten");
        ymlfile.addDefault("DIFFICULTY_DESC_CAREFUL_HOLDER", "Stirb bloß nicht mit meinem guten Equip, sonst musst du es neu holen! Denk nicht soviel darüber nach, ich werde es schon nicht verlieren! Dann sei wenigstens vorsichtig, damit ich nicht zu viel XP brauche zum reparieren.");
        ymlfile.addDefault("DIFFICULTY_DESC_DETAILED_CAREFUL_HOLDER", "Du hast Keep Inventory aktiviert, aber wundere dich nicht wenn sich die Durability stark verschlechtert.");
        ymlfile.addDefault("DIFFICULTY_DESC_RUTHLESS_RUMBLE", "§7WARNUNG! THE PURGE startet nun! \nDas war ein Witz, aber etwas ähnliches wird auf dich zu kommen.");
        ymlfile.addDefault("DIFFICULTY_DESC_DETAILED_RUTHLESS_RUMBLE", "§dHostile Mobs wie zum Beispiel \nZombies, Skelete, Blazes, Ghasts und mehr \nwerden dir mehr Schaden machen, aber du machst allen anderen Monstern mehr Schaden");
        ymlfile.addDefault("DIFFICULTY_DESC_SWIFT_HUNGER", "§7Mach nicht so viel Sport! \nWir hatten doch entschieden, dass wir nur was kleines heute Abend essen.");
        ymlfile.addDefault("DIFFICULTY_DESC_DETAILED_SWIFT_HUNGER", "§dDu verlierst schneller Hunger, aber dafür kannst du dich schneller bewegen und schneller abbauen.");


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
