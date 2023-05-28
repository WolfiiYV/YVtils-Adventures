package yv.tils.adventures.unlock;

import org.bukkit.entity.Player;
import yv.tils.adventures.utils.ConsoleLog;

/**
 * @version 1.0
 * @since 1.0
 */
public class XPPay {
    public boolean onExecute(int amount, Player target, String ability) {
        //Check if player has enough levels
        if (target.getLevel() < amount) return false;
        //Player has enough levels, buy ability and remove level price
        target.setLevel(target.getLevel()-amount);
        new ConsoleLog(target + " traded " + amount + " Levels of XP for the ability " + ability + "!");
        //Return 'true' because ability got bought
        return true;
    }
}