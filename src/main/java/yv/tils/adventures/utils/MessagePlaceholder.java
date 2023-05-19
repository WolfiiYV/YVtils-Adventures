package yv.tils.adventures.utils;

/**
 * @since 1.0
 * @version 1.0
 */
public class MessagePlaceholder{
    public static String PREFIX = SMPPlugin.getInstance().getConfig().getString("Placeholder.PREFIX");
    public static String PREFIXENABLE = SMPPlugin.getInstance().getConfig().getString("Placeholder.PREFIXENABLE");
    public static String PREFIXDISABLE = SMPPlugin.getInstance().getConfig().getString("Placeholder.PREFIXDISABLE");
    public static String PREFIXERROR = SMPPlugin.getInstance().getConfig().getString("Placeholder.PREFIXERROR");
    public static String PREFIXUPDATE = SMPPlugin.getInstance().getConfig().getString("Placeholder.PREFIXUPDATE");
    public static String PREFIXNOUPDATE = SMPPlugin.getInstance().getConfig().getString("Placeholder.PREFIXNOUPDATE");
    public static String PREFIXHELP = SMPPlugin.getInstance().getConfig().getString("Placeholder.PREFIXHELP");
    public static String PREFIXFEEDBACK = SMPPlugin.getInstance().getConfig().getString("Placeholder.PREFIXFEEDBACK");
    public static String PREFIXMODERATION = SMPPlugin.getInstance().getConfig().getString("Placeholder.PREFIXMODERATION");
    public static String PERMISSIONERROR = LanguageFile.getMessage(LanguageMessage.MISSING_PERMISSION);
}
