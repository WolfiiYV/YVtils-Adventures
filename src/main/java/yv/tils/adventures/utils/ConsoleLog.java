package yv.tils.adventures.utils;

import org.bukkit.Bukkit;
import yv.tils.adventures.Adventures;

/**
 * @since 1.0
 * @version 1.0
 */
public class ConsoleLog {
    public ConsoleLog(String WhatLog) {
        if (Adventures.getInstance().getConfig().getBoolean("Debug")) {
            Bukkit.getConsoleSender().sendMessage("§c----- DEBUG START -----");
            Bukkit.getConsoleSender().sendMessage("§9YVtils-SMP Plugin");
            Bukkit.getConsoleSender().sendMessage(WhatLog);
            Bukkit.getConsoleSender().sendMessage("§c----- DEBUG END -----");
        }
    }
}
