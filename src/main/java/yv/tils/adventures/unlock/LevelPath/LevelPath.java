package yv.tils.adventures.unlock.LevelPath;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import yv.tils.adventures.Adventures;
import yv.tils.adventures.ability.Ability;
import yv.tils.adventures.difficulty.SelectDifficulty;
import yv.tils.adventures.utils.ConsoleLog;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @version 1.0
 * @since 1.0
 */
public class LevelPath {
    private Inventory inv(Player player) {
        return Bukkit.createInventory(player, 54, "§9Level Path");
    }


    //Create the LevelPath GUI
    public void GUI(Player player) {

        Inventory inv = inv(player);

        sideSwitch(inv, 1);

        String p = Adventures.getInstance().p.get(player.getName());
        String[] plist = p.split(";");

        int plevel = Integer.parseInt(plist[0]);
        int pxp = Integer.parseInt(plist[1]);

        int j = 1;
        for (int i : new int[]{18,19,28,29,30,21,12,13,14,23,32,33,34,25,26}) {
            inv.setItem(i, LevelItem(j, pxp, Level.valueOf("L" + j).xp, plevel, Level.valueOf("L" + j).reward));
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

        //Open inventory for Player
        player.openInventory(inv);
    }

    private ItemStack LevelItem(int level, int player_xp, int needed_xp, int playerlevel, String reward) {
        if (Objects.equals(reward, "null")) reward = "§7There is no reward for this level!";
        if (playerlevel >= level) {
            //Player has level
            ItemStack pane = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            ItemMeta meta_pane = pane.getItemMeta();
            List<String> lore = new ArrayList<>();
            meta_pane.setDisplayName("§l§aLevel " + level + " §8(§7" + needed_xp + "§8/§7" + needed_xp + "§8)");
            lore.add("§fReward: §6" + reward);
            lore.add("§fLeft-click: §7Claim");
            lore.add("§fRight-click: §7Ability Info");

            meta_pane.setLore(lore);
            pane.setItemMeta(meta_pane);
            return pane;
        } else {
            //Player does not have level
            ItemStack pane = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            ItemMeta meta_pane = pane.getItemMeta();
            List<String> lore = new ArrayList<>();
            if (playerlevel + 1 == level) meta_pane.setDisplayName("§l§cLevel " + level + " §8(§7" + player_xp + "§8/§7" + needed_xp + "§8)");
            else meta_pane.setDisplayName("§l§cLevel " + level + " §8(§7" + "0" + "§8/§7" + needed_xp + "§8)");
            lore.add("§fReward: §6" + reward);
            lore.add("§fLeft-click: §7Claim");
            lore.add("§fRight-click: §7Ability Info");

            meta_pane.setLore(lore);
            pane.setItemMeta(meta_pane);
            return pane;
        }
    }

    private void sideSwitch(Inventory inv, int side) {
        //Next Side
        ItemStack previousside_switch = new ItemStack(Material.ARROW);
        ItemMeta previousside_switch_meta = previousside_switch.getItemMeta();
        previousside_switch_meta.setDisplayName("§7Previous side");
        previousside_switch.setItemMeta(previousside_switch_meta);
        inv.setItem(45, previousside_switch);

        //Next Side
        ItemStack nextside_switch = new ItemStack(Material.ARROW);
        ItemMeta nextside_switch_meta = nextside_switch.getItemMeta();
        nextside_switch_meta.setDisplayName("§7Next side");
        nextside_switch.setItemMeta(nextside_switch_meta);
        inv.setItem(53, nextside_switch);

        //Next Side
        ItemStack side_count = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
        ItemMeta side_count_meta = side_count.getItemMeta();
        side_count_meta.setDisplayName("§7Side: " + side);
        side_count.setAmount(side);
        side_count.setItemMeta(side_count_meta);
        inv.setItem(49, side_count);
    }

    //Claim achieved rewards
    public void claimReward(Player player, int slot, int page, ClickType click) {

        File file = new File(Adventures.getInstance().getDataFolder(), "level-path.yml");
        YamlConfiguration ymlfile = YamlConfiguration.loadConfiguration(file);

        String p = Adventures.getInstance().p.get(player.getName());
        String[] plist = p.split(";");
        String pabilitys = plist[5];
        pabilitys = pabilitys.replace("[", "");
        pabilitys = pabilitys.replace("]", "");
        List<String> pabilitylist = new ArrayList<>(List.of(pabilitys.split(", ")));

        int plevel = Integer.parseInt(plist[0]);

        if (page == 1) {
            switch (slot) {
                //1-15
                //18,19,28,29,30,21,12,13,14,23,32,33,34,25,26
                case 18 -> {
                    if (click.isLeftClick()) {
                        if (plevel < 1) return;
                        if (!pabilitylist.contains(Level.L1.reward)) {
                            new ConsoleLog(player.getName() + " claimed Level 1.\n" +
                                    Level.L1.reward);
                            new SelectDifficulty().DifficultyGUI(player);
                            pabilitylist.add(Level.L1.reward);
                            ymlfile.set(player.getName() + ".Abilitys", pabilitylist);
                        }
                    } else if (click.isRightClick()) {

                    }
                }
                case 30 -> {
                    if (click.isLeftClick()) {
                        if (plevel < 5) return;
                        if (!pabilitylist.contains(Level.L5.reward) && !pabilitylist.contains(Level.L20.reward) && !pabilitylist.contains(Level.L25.reward)) {
                            new ConsoleLog(player.getName() + " claimed Level 5.\n" +
                                    Level.L5.reward);
                            new Ability().MoreLives(player, 1);
                            pabilitylist.add(Level.L5.reward);
                            ymlfile.set(player.getName() + ".Abilitys", pabilitylist);
                        }
                    } else if (click.isRightClick()) {

                    }
                }
                case 23 -> {
                    if (click.isLeftClick()) {
                        if (plevel < 10) return;
                        if (!pabilitylist.contains(Level.L10.reward) && !pabilitylist.contains(Level.L35.reward)) {
                            new ConsoleLog(player.getName() + " claimed Level 10.\n" +
                                    Level.L10.reward);
                            pabilitylist.add(Level.L10.reward);
                            ymlfile.set(player.getName() + ".Abilitys", pabilitylist);
                        }
                    } else if (click.isRightClick()) {

                    }
                }
                case 26 -> {
                    if (click.isLeftClick()) {
                        if (plevel < 15) return;
                        if (!pabilitylist.contains(Level.L15.reward)) {
                            new ConsoleLog(player.getName() + " claimed Level 15.\n" +
                                    Level.L15.reward);
                            pabilitylist.add(Level.L15.reward);
                            ymlfile.set(player.getName() + ".Abilitys", pabilitylist);
                        }
                    } else if (click.isRightClick()) {

                    }
                }
                default -> {
                    return;
                }
            }
        } else if (page == 2) {
            switch (slot) {
                //16-30
                //18,19,28,29,30,21,12,13,14,23,32,33,34,25,26
                case 30 -> {
                    if (click.isLeftClick()) {
                        if (plevel < 20) return;
                        if (!pabilitylist.contains(Level.L20.reward) && !pabilitylist.contains(Level.L25.reward)) {
                            new ConsoleLog(player.getName() + " claimed Level 20.\n" +
                                    Level.L20.reward);
                            new Ability().MoreLives(player, 2);
                            pabilitylist.add(Level.L20.reward);
                            ymlfile.set(player.getName() + ".Abilitys", pabilitylist);
                        }
                    } else if (click.isRightClick()) {

                    }
                }
                case 23 -> {
                    if (click.isLeftClick()) {
                        if (plevel < 25) return;
                        if (!pabilitylist.contains(Level.L25.reward)) {
                            new ConsoleLog(player.getName() + " claimed Level 25.\n" +
                                    Level.L25.reward);
                            new Ability().MoreLives(player, 3);
                            pabilitylist.add(Level.L25.reward);
                            ymlfile.set(player.getName() + ".Abilitys", pabilitylist);
                        }
                    } else if (click.isRightClick()) {

                    }
                }
                case 26 -> {
                    if (click.isLeftClick()) {
                        if (plevel < 30) return;
                        if (!pabilitylist.contains(Level.L30.reward)) {
                            new ConsoleLog(player.getName() + " claimed Level 30.\n" +
                                    Level.L30.reward);
                            pabilitylist.add(Level.L30.reward);
                            ymlfile.set(player.getName() + ".Abilitys", pabilitylist);
                        }
                    } else if (click.isRightClick()) {

                    }
                }
                default -> {
                    return;
                }
            }
        } else if (page == 3) {
            switch (slot) {
                //31-45
                //18,19,28,29,30,21,12,13,14,23,32,33,34,25,26
                case 30 -> {
                    if (click.isLeftClick()) {
                        if (plevel < 35) return;
                        if (!pabilitylist.contains(Level.L35.reward)) {
                            new ConsoleLog(player.getName() + " claimed Level 35.\n" +
                                    Level.L35.reward);
                            pabilitylist.add(Level.L35.reward);
                            ymlfile.set(player.getName() + ".Abilitys", pabilitylist);
                        }
                    } else if (click.isRightClick()) {

                    }
                }
                case 23 -> {
                    if (click.isLeftClick()) {
                        if (plevel < 40) return;
                        if (!pabilitylist.contains(Level.L40.reward)) {
                            new ConsoleLog(player.getName() + " claimed Level 40.\n" +
                                    Level.L40.reward);
                            pabilitylist.add(Level.L40.reward);
                            ymlfile.set(player.getName() + ".Abilitys", pabilitylist);
                        }
                    } else if (click.isRightClick()) {

                    }
                }
                case 26 -> {
                    if (click.isLeftClick()) {
                        if (plevel < 45) return;
                        if (!pabilitylist.contains(Level.L45.reward)) {
                            new ConsoleLog(player.getName() + " claimed Level 45.\n" +
                                    Level.L45.reward);
                            pabilitylist.add(Level.L45.reward);
                            ymlfile.set(player.getName() + ".Abilitys", pabilitylist);
                        }
                    } else if (click.isRightClick()) {

                    }
                }
                default -> {
                    return;
                }
            }
        }
        try {
            ymlfile.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new PlayerEntry().configGetter(player);
    }

    public void getXP(Player player, String method) {
        switch (method) {
            case "playtime_day" -> {
            }
            case "playtime_all" -> {
            }
            case "advancement" -> {
            }
            case "item_sell" -> {
            }
            case "join_streak" -> {
                System.out.println(player.getName() + " has joined today.");
            }
        }
    }

    public void switchPage(Player player, int slot, int side) {
        if (slot == 45) {
            if (side == 1) return;
            Inventory inv = inv(player);

            sideSwitch(inv, side-1);

            String p = Adventures.getInstance().p.get(player.getName());
            String[] plist = p.split(";");

            int plevel = Integer.parseInt(plist[0]);
            int pxp = Integer.parseInt(plist[1]);

            int j = 1;
            if (side - 1 == 1) j = 1;
            if (side - 1 == 2) j = 16;
            if (side - 1 == 3) j = 31;
            for (int i : new int[]{18,19,28,29,30,21,12,13,14,23,32,33,34,25,26}) {
                inv.setItem(i, LevelItem(j, pxp, Level.valueOf("L" + j).xp, plevel, Level.valueOf("L" + j).reward));
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

            //Open inventory for Player
            player.openInventory(inv);
        } else if (slot == 53) {
            if (side == 3) return;
            Inventory inv = inv(player);

            sideSwitch(inv, side+1);

            String p = Adventures.getInstance().p.get(player.getName());
            String[] plist = p.split(";");

            int plevel = Integer.parseInt(plist[0]);
            int pxp = Integer.parseInt(plist[1]);

            int j = 1;
            if (side + 1 == 2) j = 16;
            if (side + 1 == 3) j = 31;
            for (int i : new int[]{18,19,28,29,30,21,12,13,14,23,32,33,34,25,26}) {
                inv.setItem(i, LevelItem(j, pxp, Level.valueOf("L" + j).xp, plevel, Level.valueOf("L" + j).reward));
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

            //Open inventory for Player
            player.openInventory(inv);
        }
    }
}

