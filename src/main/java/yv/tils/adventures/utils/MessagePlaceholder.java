package yv.tils.adventures.utils;

import yv.tils.adventures.utils.language.LanguageFile;
import yv.tils.adventures.utils.language.LanguageMessage;

/**
 * @since 1.0
 * @version 1.0
 */
public class MessagePlaceholder{
    public static String PREFIX = "§9[YVtils]";
    public static String PREFIXENABLE = "§9[YVtils-ON]";
    public static String PREFIXDISABLE = "§9[YVtils-OFF]";
    public static String PREFIXERROR = "§4[YVtils-ERROR]";
    public static String PREFIXUPDATE = "§c[YVtils-UPDATE]";
    public static String PREFIXNOUPDATE = "§7[YVtils-UPDATE]";
    public static String PREFIXHELP = "§9[YVtils-HELP]";
    public static String PERMISSIONERROR = LanguageFile.getMessage(LanguageMessage.MISSING_PERMISSION);
}
