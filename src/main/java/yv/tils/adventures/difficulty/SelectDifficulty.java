package yv.tils.adventures.difficulty;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import yv.tils.adventures.utils.ConsoleLog;
import yv.tils.adventures.utils.language.LanguageFile;
import yv.tils.adventures.utils.language.LanguageMessage;

import java.util.ArrayList;
import java.util.List;


/**
 * @version 1.0
 * @since 1.0
 */
public class SelectDifficulty implements Listener {
    public void onFirstJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (player.hasPlayedBefore()) return;
        new ConsoleLog("Player (" + player.getName() + ") has joined the first time on this server!");

        //Open GUI for player, which joined first time

        //Send message to console, which difficulty the player selected
        List<String> list1 = new ArrayList();
        List<String> list2 = new ArrayList();
        list1.add("PLAYER");
        list2.add(player.getName());
        list1.add("DIFFICULTY");
        list2.add("XXX");
        Bukkit.getConsoleSender().sendMessage(LanguageFile.ListReplacer(LanguageMessage.STOP_MESSAGE, list1, list2));
    }
}