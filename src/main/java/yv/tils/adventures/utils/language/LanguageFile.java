package yv.tils.adventures.utils.language;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import yv.tils.adventures.Adventures;
import yv.tils.adventures.utils.ConsoleLog;

import java.io.File;
import java.util.List;

/**
 * @since 1.0
 * @version 1.0
 */
public class LanguageFile {

    private static YamlConfiguration yamlConfiguration;

    public static void LanguageFileGet() {
        File file = new File(Adventures.getInstance().getDataFolder() + "/Language",Adventures.getInstance().getConfig().getString("Language") + ".yml");
        if (file.exists()) {
            yamlConfiguration = YamlConfiguration.loadConfiguration(file);
        }else {
            new ConsoleLog(file.getPath());
            Bukkit.getConsoleSender().sendMessage(DirectFormatter("In the config is an unavailable language file given!", "In der Config wurde ein nicht verfügbares Sprachen File angegeben."));
        }
    }

    /**
     * @Use: getMessage(LangaugeMessage.message);
     * @since 1.0
     * @version 1.0
     */
    public static String getMessage(LanguageMessage message) {
        return yamlConfiguration.getString(message.name().toUpperCase());
    }

    /**
     * Set Messages in German/English without the Language Config File
     * @When_to_use? This Method can be used, when a Message shouldn't be configurable over the language File!
     * @since 1.0
     * @version 1.0
     */
    public static String DirectFormatter(String en, String de) {
        String s;
        if (Adventures.getInstance().getConfig().getString("Language").equals("en")) {
            s = en;
        }else if (Adventures.getInstance().getConfig().getString("Language").equals("de")) {
            s = de;
        }else {
            s = en;
        }
        return s;
    }

    /**
     List<String> list1 = new ArrayList();
     List<String> list2 = new ArrayList();
     list1.add("EXAMPLE");
     list2.add(example.value);
     new StringReplacer().ListReplacer(INPUT, list1, list2)
     *
     * @since 1.0
     * @version 1.0
     */
    public static String ListReplacer(LanguageMessage message, List<String> ToReplace, List<String> Insert) {
        String InPut = yamlConfiguration.getString(message.name().toUpperCase());

        new ConsoleLog(InPut);
        new ConsoleLog("StringReplacer1");
        for (int i = 0; i < ToReplace.size(); i++) {
            InPut = InPut.replaceAll(ToReplace.get(i), Insert.get(i));
        }
        new ConsoleLog("StringReplacer2");
        new ConsoleLog(InPut);
        return InPut;
    }
}
