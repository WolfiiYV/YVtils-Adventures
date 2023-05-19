package yv.tils.adventures;

import org.bukkit.plugin.java.JavaPlugin;
import yv.tils.adventures.cmd.CommandHandler;

/**
 * @since 1.0
 * @version 1.0
 */
public final class Adventures extends JavaPlugin {
    public static String PluginVersion = "1.0";

    public boolean database_connection;

    private static Adventures instance;
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic


        getCommand("adventure").setExecutor(new CommandHandler());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Adventures getInstance() {
        return instance;
    }
}
