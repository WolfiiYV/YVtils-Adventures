package yv.tils.adventures.unlock;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import yv.tils.adventures.utils.ConsoleLog;

/**
 * @version 1.0
 * @since 1.0
 */
public class ItemPay {
    public boolean onExecute(Material item, int amount, Player target, String ability) {
        //Check if player has enough of the required item in inventory
        if (!target.getInventory().contains(item, amount)) return false;
        //Remove item from inventory
        target.getInventory().removeItem(new ItemStack(item, amount));
        new ConsoleLog(target + " traded " + amount + " times the item " + item + " for the ability " + ability + "!");
        return true;
    }
}