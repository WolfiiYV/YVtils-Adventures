package yv.tils.adventures.listener;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import yv.tils.adventures.Adventures;
import yv.tils.adventures.difficulty.SelectDifficulty;
import yv.tils.adventures.unlock.LevelPath.LevelPath;
import yv.tils.adventures.unlock.LevelPath.PlayerEntry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @EventHandler
    public void onGUICLose(InventoryCloseEvent e) {
        if (e.getView().getTitle().equals("§9Difficulty")) {
            Player player = (Player) e.getPlayer();

            //Check in config if difficulty is still none -> Then remove it from claimed ability's, else ignore

            String p = Adventures.getInstance().p.get(player.getName());
            String[] plist = p.split(";");
            String pdifficulty = plist[7];

            if (!pdifficulty.equals("none")) return;

            File file = new File(Adventures.getInstance().getDataFolder(), "level-path.yml");
            YamlConfiguration ymlfile = YamlConfiguration.loadConfiguration(file);

            String pabilitys = plist[6];
            pabilitys = pabilitys.replace("[", "");
            pabilitys = pabilitys.replace("]", "");
            List<String> abilitylist = new ArrayList<>(List.of(pabilitys.split(", ")));

            for (String s : abilitylist) {
                System.out.println(s);
            }

            String ability = "The Beginning";
            abilitylist.remove(ability);
            ymlfile.set(player.getName() + ".Abilitys", abilitylist);
            try {
                ymlfile.save(file);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            new PlayerEntry().configGetter(player);
        }
    }
}