package yv.tils.adventures.ability.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import yv.tils.adventures.Adventures;

/**
 * @version 1.0
 * @since 1.0
 */
public class LightFlightCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (Adventures.getInstance().LightFlightCooldown.asMap().containsKey(player)) {
            long cooldown_remaining = (Adventures.getInstance().LightFlightCooldown.asMap().get(player) - System.currentTimeMillis())  / (1000 * 60);
            sender.sendMessage("You are still on cooldown. (~" + cooldown_remaining + " Minutes)");
            return false;
        }
        sender.sendMessage("Boosted yourself 50 blocks up! Cooldown: 10 Minutes");
        player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20, 44, false, false, false));
        Adventures.getInstance().LightFlightCooldown.put(player, System.currentTimeMillis() + 600000);
        return false;
    }
}