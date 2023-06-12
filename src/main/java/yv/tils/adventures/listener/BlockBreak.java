package yv.tils.adventures.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import yv.tils.adventures.Adventures;
import yv.tils.adventures.difficulty.Difficultys;
import yv.tils.adventures.difficulty.ExecuteDifficulty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @version 1.0
 * @since 1.0
 */
public class BlockBreak implements Listener {
    private final Random random = new Random();

    @EventHandler
    public void onEvent(BlockBreakEvent e) {
        String p = Adventures.getInstance().p.get(e.getPlayer().getName());
        String[] plist = p.split(";");
        String pdifficulty = plist[6];

        if (pdifficulty.equals(ChatColor.stripColor(Difficultys.D4.name))) {
            new ExecuteDifficulty().CarefulSnail_BlockLuck(e, increasedDropItems, random);
        }

        if (pdifficulty.equals(ChatColor.stripColor(Difficultys.D3.name))) {
            new ExecuteDifficulty().CarelessCheetah_BlockLuck(e, increasedDropItems, random);
        }
    }

    private final List<Material> increasedDropItems = new ArrayList<>(Arrays.asList(
            Material.COAL_ORE,
            Material.DEEPSLATE_COAL_ORE,
            Material.IRON_ORE,
            Material.DEEPSLATE_IRON_ORE,
            Material.COPPER_ORE,
            Material.DEEPSLATE_COPPER_ORE,
            Material.GOLD_ORE,
            Material.DEEPSLATE_GOLD_ORE,
            Material.REDSTONE_ORE,
            Material.DEEPSLATE_REDSTONE_ORE,
            Material.LAPIS_ORE,
            Material.DEEPSLATE_LAPIS_ORE,
            Material.EMERALD_ORE,
            Material.DEEPSLATE_EMERALD_ORE,
            Material.DIAMOND_ORE,
            Material.DEEPSLATE_DIAMOND_ORE,
            Material.NETHER_QUARTZ_ORE,
            Material.NETHER_GOLD_ORE
    ));
}