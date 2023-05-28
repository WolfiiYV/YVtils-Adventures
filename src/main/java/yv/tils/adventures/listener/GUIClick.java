package yv.tils.adventures.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import yv.tils.adventures.difficulty.SelectDifficulty;
import yv.tils.adventures.unlock.LevelPath.LevelPath;

/**
 * @version 1.0
 * @since 1.0
 */
public class GUIClick implements Listener {
    @EventHandler
    public void onGUIClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals("§9Level Path")) {
            Player player = (Player) e.getWhoClicked();
            int slot = e.getSlot();
            switch (slot) {
                case 45,53 -> {
                    e.setCancelled(true);
                    new LevelPath().switchPage(player, slot, e.getInventory().getItem(49).getAmount());
                }
                case 18,19,28,29,30,21,12,13,14,23,32,33,34,25,26 -> {
                    e.setCancelled(true);
                    new LevelPath().claimReward(player, slot, e.getInventory().getItem(49).getAmount(), e.getClick());
                }
                default -> {
                    e.setCancelled(true);
                    return;
                }
            }
        } else if (e.getView().getTitle().equals("§9Difficulty")) {
            Player player = (Player) e.getWhoClicked();
            int slot = e.getSlot();
            switch (slot) {
                case 10,20,12,22,14,24,16 -> {
                    e.setCancelled(true);
                    new SelectDifficulty().selectDifficulty(player, slot);
                }
                default -> {
                    e.setCancelled(true);
                    return;
                }
            }
        }
    }
}