package yv.tils.adventures.difficulty;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import yv.tils.adventures.Adventures;
import yv.tils.adventures.unlock.LevelPath.PlayerEntry;
import yv.tils.adventures.utils.ConfigModeration;
import yv.tils.adventures.utils.language.LanguageFile;
import yv.tils.adventures.utils.language.LanguageMessage;

import java.util.ArrayList;
import java.util.List;


/**
 * @version 1.0
 * @since 1.0
 */
public class SelectDifficulty {
    private Inventory inv(Player player) {
        return Bukkit.createInventory(player, 36, "§9Difficulty");
    }

    public void DifficultyGUI(Player player) {
        Inventory inv = inv(player);

        //Set slots to difficulty items
        int j = 1;
        for (int i : new int[]{10,20,12,22,14,24,16}) {
            inv.setItem(i, DifficultyItem(Difficultys.valueOf("D" + j).item, Difficultys.valueOf("D" + j).name, Difficultys.valueOf("D" + j).desc, Difficultys.valueOf("D" + j).dability));
            j++;
        }

        //GUI Filler
        ItemStack pane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta meta_pane = pane.getItemMeta();
        meta_pane.setDisplayName(" ");
        pane.setItemMeta(meta_pane);

        for (int i = 0; i < inv.getSize(); i++) {
            if (inv.getItem(i) == null) {
                inv.setItem(i, pane);
            }
        }

        player.closeInventory();
        player.openInventory(inv);
    }

    private ItemStack DifficultyItem(Material material, String name, String desc, String dability) {
        String[] desc_split = desc.split("\n");
        String[] dabilty_split = dability.split("\n");

        ItemStack item = new ItemStack(material);
        ItemMeta meta_item = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        if (material == Material.POTION || material == Material.SPAWNER) {
            meta_item.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        }

        if (material == Material.DIAMOND_SWORD || material == Material.WOODEN_SWORD) {
            meta_item.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        }

        meta_item.setDisplayName(name);
        for (String s : desc_split) {
            lore.add(ChatColor.getLastColors(desc_split[0]) + s);
        }
        for (String s : dabilty_split) {
            lore.add(ChatColor.getLastColors(dabilty_split[0]) + s);
        }
        meta_item.setLore(lore);
        item.setItemMeta(meta_item);
        return item;
    }

    public void selectDifficulty(Player player, int slot) {
        //Set vars to right values
        List<String> list1 = new ArrayList();
        List<String> list2 = new ArrayList();
        list1.add("PLAYER");
        list2.add(player.getName());
        list1.add("DIFFICULTY");

        switch (slot) {
            case 10 -> {
                list2.add(Difficultys.D1.name);
                new ConfigModeration().ConfigContentAdd("level-path", player.getName() + ".Difficulty", ChatColor.stripColor(Difficultys.D1.name));
            }
            case 20 -> {
                list2.add(Difficultys.D2.name);
                new ConfigModeration().ConfigContentAdd("level-path", player.getName() + ".Difficulty", ChatColor.stripColor(Difficultys.D2.name));
            }
            case 12 -> {
                list2.add(Difficultys.D3.name);
                new ConfigModeration().ConfigContentAdd("level-path", player.getName() + ".Difficulty", ChatColor.stripColor(Difficultys.D3.name));
                new ExecuteDifficulty().CarelessCheetah_Movement(player);
            }
            case 22 -> {
                list2.add(Difficultys.D4.name);
                new ConfigModeration().ConfigContentAdd("level-path", player.getName() + ".Difficulty", ChatColor.stripColor(Difficultys.D4.name));
                new ExecuteDifficulty().CarefulSnail_Movement(player);
            }
            case 14 -> {
                list2.add(Difficultys.D5.name);
                new ConfigModeration().ConfigContentAdd("level-path", player.getName() + ".Difficulty", ChatColor.stripColor(Difficultys.D5.name));
            }
            case 24 -> {
                list2.add(Difficultys.D6.name);
                new ConfigModeration().ConfigContentAdd("level-path", player.getName() + ".Difficulty", ChatColor.stripColor(Difficultys.D6.name));
            }
            case 16 -> {
                list2.add(Difficultys.D7.name);
                new ConfigModeration().ConfigContentAdd("level-path", player.getName() + ".Difficulty", ChatColor.stripColor(Difficultys.D7.name));
                new ExecuteDifficulty().SwiftHunger_Effects(player);
            }
        }

        new PlayerEntry().configGetter(player);
        player.closeInventory();
        TextComponent c = new TextComponent("§7Are you sure, that you want to choose this Difficulty (DIFFICULTY)?\n");
        TextComponent c1 = new TextComponent("§7§lYou have 10 seconds\n");
        TextComponent c2 = new TextComponent("§c§lNO");
        c2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/adventure difficulty reselect"));
        c2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("Decline Difficulty")));
        c.addExtra(c1);
        c.addExtra(c2);
        player.spigot().sendMessage(c);
        Adventures.getInstance().diffitimer.add(player.getName());
        runnable(player);

        //Send message to console, which status got selected
        Bukkit.getConsoleSender().sendMessage(LanguageFile.ListReplacer(LanguageMessage.STOP_MESSAGE, list1, list2));
    }

    private void runnable(Player player) {
        new BukkitRunnable() {
            public void run() {
                Adventures.getInstance().diffitimer.remove(player.getName());
            }
        }.runTaskLater(Adventures.getInstance(), 200L);
    }
}