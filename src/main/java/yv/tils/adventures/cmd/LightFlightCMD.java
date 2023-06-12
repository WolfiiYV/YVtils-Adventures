package yv.tils.adventures.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import yv.tils.adventures.Adventures;

/**
 * @version 1.0
 * @since 1.0
 */
public class LightFlightCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (Adventures.getInstance().LightFlightCooldown.contains(player)) return false;
        sender.sendMessage("Boosted yourself 50 blocks up! Cooldown: 10 Minutes");
        player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20, 44, false, false, false));
        Adventures.getInstance().LightFlightCooldown.add(player);
        runnable(player);
        return false;
    }

    public void runnable(Player player) {
        new BukkitRunnable() {
            public void run() {
                Adventures.getInstance().LightFlightCooldown.remove(player);
            }
        }.runTaskLater(Adventures.getInstance(), 12000L);
    }
}