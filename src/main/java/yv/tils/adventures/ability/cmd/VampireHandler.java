package yv.tils.adventures.ability.cmd;

import org.bukkit.ChatColor;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import yv.tils.adventures.Adventures;
import yv.tils.adventures.unlock.LevelPath.Level;
import yv.tils.adventures.utils.language.LanguageFile;
import yv.tils.adventures.utils.language.LanguageMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @since 1.0
 */
public class VampireHandler implements CommandExecutor {
    private final Adventures main = Adventures.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) return false;

        String p = Adventures.getInstance().p.get(player.getName());
        String[] plist = p.split(";");
        String pabilitys = plist[6];
        pabilitys = pabilitys.replace("[", "");
        pabilitys = pabilitys.replace("]", "");
        List<String> pabilitylist = new ArrayList<>(List.of(pabilitys.split(", ")));

        if (!pabilitylist.contains(Level.L40.reward)) return false;
        if (args.length == 0) {
            sendUsage(sender);
            return false;
        }
        switch (args[0]) {
            case "invis" -> {
                if (main.Vampire_Invis.asMap().containsKey(player)) {
                    if (main.Vampire_Invis_active.asMap().containsKey(player)) {
                        long time_remaining = (main.Vampire_Invis_active.asMap().get(player) - System.currentTimeMillis())  / (1000 * 60);
                        sender.sendMessage("Your ability is active. (~" + time_remaining + " Minutes)");

                        player.removePotionEffect(PotionEffectType.INVISIBILITY);
                        player.sendMessage("You are now visible again!");

                        main.Vampire_Invis_inactive.put(player, main.Vampire_Invis_active.asMap().get(player) - System.currentTimeMillis());
                        main.Vampire_Invis_active.asMap().remove(player);

                        return false;
                    } else if (main.Vampire_Invis_inactive.containsKey(player)) {
                        if (main.Vampire_Invis.asMap().containsKey(player)) {

                            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, PotionEffect.INFINITE_DURATION, 0, false, true, false));

                            long restTime = main.Vampire_Invis_inactive.get(player);
                            long time_remaining = (restTime)  / (1000 * 60);
                            Invis_Cooldown(player, (restTime/1000*20));
                            sender.sendMessage("You have " + time_remaining + " minutes left!");

                            main.Vampire_Invis_active.put(player, System.currentTimeMillis() + restTime);
                            return false;
                        }
                    } else {
                        long cooldown_remaining = (main.Vampire_Invis.asMap().get(player) - System.currentTimeMillis())  / (1000 * 60);
                        sender.sendMessage("You are still on cooldown. (~" + cooldown_remaining + " Minutes)");
                        return false;
                    }
                }
                player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, PotionEffect.INFINITE_DURATION, 0, false, true, false));
                main.Vampire_Invis_active.put(player, System.currentTimeMillis() + 300000);
                main.Vampire_Invis.put(player, System.currentTimeMillis() + 1800000);
                Invis_Cooldown(player, 6000L);
            }
            case "speed" -> {
                if (main.Vampire_Speed.asMap().containsKey(player)) {
                    if (main.Vampire_Speed_active.asMap().containsKey(player)) {
                        long time_remaining = (main.Vampire_Speed_active.asMap().get(player) - System.currentTimeMillis())  / (1000 * 60);
                        sender.sendMessage("Your ability is active. (~" + time_remaining + " Minutes)");

                        player.removePotionEffect(PotionEffectType.SPEED);
                        player.sendMessage("You are now slow again!");

                        main.Vampire_Speed_inactive.put(player, main.Vampire_Speed_active.asMap().get(player) - System.currentTimeMillis());
                        main.Vampire_Speed_active.asMap().remove(player);

                        return false;
                    } else if (main.Vampire_Speed_inactive.containsKey(player)) {
                        if (main.Vampire_Speed.asMap().containsKey(player)) {

                            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, PotionEffect.INFINITE_DURATION, 4, false, false, false));

                            long restTime = main.Vampire_Speed_inactive.get(player);
                            long time_remaining = (restTime)  / (1000 * 60);
                            Speed_Cooldown(player, (restTime/1000*20));
                            sender.sendMessage("You have " + time_remaining + " minutes left!");

                            main.Vampire_Speed_active.put(player, System.currentTimeMillis() + restTime);
                            return false;
                        }
                    } else {
                        long cooldown_remaining = (main.Vampire_Speed.asMap().get(player) - System.currentTimeMillis())  / (1000 * 60);
                        sender.sendMessage("You are still on cooldown. (~" + cooldown_remaining + " Minutes)");
                        return false;
                    }
                }
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, PotionEffect.INFINITE_DURATION, 4, false, false, false));
                main.Vampire_Speed_active.put(player, System.currentTimeMillis() + 300000);
                main.Vampire_Speed.put(player, System.currentTimeMillis() + 900000);
                Speed_Cooldown(player, 6000L);
            }
            case "transform" -> {
                if (main.Vampire_Transform.asMap().containsKey(player)) {
                    if (main.Vampire_Transform_active.asMap().containsKey(player)) {
                        long time_remaining = (main.Vampire_Transform_active.asMap().get(player) - System.currentTimeMillis())  / (1000 * 60);
                        sender.sendMessage("Your ability is active. (~" + time_remaining + " Minutes)");

                        AreaEffectCloud mob2 = (AreaEffectCloud) player.getPassengers().get(0);
                        Entity mob = mob2.getPassengers().get(0);

                        player.sendMessage("You have transformed back!");
                        player.setCustomNameVisible(true);
                        player.setAllowFlight(false);
                        player.setFlying(false);
                        Mob mob1 = (Mob) mob;
                        mob1.setInvulnerable(false);
                        mob1.damage(9999999);
                        mob2.setDuration(1);
                        player.removePotionEffect(PotionEffectType.INVISIBILITY);

                        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().isAir()) {
                            Adventures.getInstance().air.add(player.getUniqueId());
                        }

                        main.Vampire_Transform_inactive.put(player, main.Vampire_Transform_active.asMap().get(player) - System.currentTimeMillis());
                        main.Vampire_Transform_active.asMap().remove(player);

                        return false;
                    } else if (main.Vampire_Transform_inactive.containsKey(player)) {
                        if (main.Vampire_Transform.asMap().containsKey(player)) {
                            Entity mob = player.getWorld().spawnEntity(player.getLocation(), EntityType.BAT);
                            AreaEffectCloud mob2 = (AreaEffectCloud) player.getWorld().spawnEntity(player.getLocation(), EntityType.AREA_EFFECT_CLOUD);

                            mob.setInvulnerable(true);
                            mob.setCustomName(player.getName());
                            mob.setCustomNameVisible(true);

                            mob2.setDuration(36000);
                            mob2.setSilent(true);
                            mob2.setRadius(0);
                            mob2.setInvulnerable(true);

                            player.setCustomNameVisible(false);
                            player.setAllowFlight(true);
                            player.setFlying(true);
                            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, PotionEffect.INFINITE_DURATION, 0, false, false, false));

                            player.addPassenger(mob2);
                            mob2.addPassenger(mob);

                            long restTime = main.Vampire_Transform_inactive.get(player);

                            long time_remaining = (restTime)  / (1000 * 60);
                            sender.sendMessage("You have " + time_remaining + " minutes left!");

                            main.Vampire_Transform_active.put(player, System.currentTimeMillis() + restTime);
                            Transform_Cooldown(player, mob, mob2, (restTime/1000*20));
                            Transform_Direction(player, mob);
                            return false;
                        }
                    } else {
                        long cooldown_remaining = (main.Vampire_Transform.asMap().get(player) - System.currentTimeMillis())  / (1000 * 60);
                        sender.sendMessage("You are still on cooldown. (~" + cooldown_remaining + " Minutes)");
                        return false;
                    }
                }
                Entity mob = player.getWorld().spawnEntity(player.getLocation(), EntityType.BAT);
                AreaEffectCloud mob2 = (AreaEffectCloud) player.getWorld().spawnEntity(player.getLocation(), EntityType.AREA_EFFECT_CLOUD);

                mob.setInvulnerable(true);
                mob.setCustomName(player.getName());
                mob.setCustomNameVisible(true);

                mob2.setDuration(36000);
                mob2.setSilent(true);
                mob2.setRadius(0);
                mob2.setInvulnerable(true);

                player.setCustomNameVisible(false);
                player.setAllowFlight(true);
                player.setFlying(true);
                player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, PotionEffect.INFINITE_DURATION, 0, false, false, false));

                player.addPassenger(mob2);
                mob2.addPassenger(mob);

                main.Vampire_Transform_active.put(player, System.currentTimeMillis() + 600000);
                main.Vampire_Transform.put(player, System.currentTimeMillis() + 5400000);
                Transform_Direction(player, mob);
                Transform_Cooldown(player, mob, mob2, 12000L);
            }
        }
        return false;
    }

    private void Invis_Cooldown(Player player, Long timer) {
        /*
        Unsichtbarkeit-Effekt alle 30 Minuten für 5 Minuten? /vampire invis
         */
        new BukkitRunnable() {
            public void run() {
                if (!main.Vampire_Invis_active.asMap().containsKey(player)) return;
                player.sendMessage("You are visible again in 30 seconds!");

                new BukkitRunnable() {
                    public void run() {
                        player.removePotionEffect(PotionEffectType.INVISIBILITY);
                        player.sendMessage("You are now visible again!");
                    }
                }.runTaskLater(Adventures.getInstance(), 600L);

            }
        }.runTaskLater(Adventures.getInstance(), timer-600);
    }

    private void Speed_Cooldown(Player player, Long timer) {
        /*
        Schneller laufen alle 15 Minuten für 5 Minuten? /vampire speed
         */
        new BukkitRunnable() {
            public void run() {
                if (!main.Vampire_Speed_active.asMap().containsKey(player)) return;
                player.sendMessage("You are slower again in 30 seconds!");

                new BukkitRunnable() {
                    public void run() {
                        player.removePotionEffect(PotionEffectType.SPEED);
                        player.sendMessage("You are now slow again!");
                    }
                }.runTaskLater(Adventures.getInstance(), 600L);

            }
        }.runTaskLater(Adventures.getInstance(), timer-600);
    }

    private void Transform_Cooldown(Player player, Entity mob, AreaEffectCloud mob2, Long timer) {
        /*
        Schneller laufen alle 15 Minuten für 5 Minuten? /vampire speed
         */
        new BukkitRunnable() {
            public void run() {
                if (!main.Vampire_Transform_active.asMap().containsKey(player)) return;
                player.sendMessage("You will transform back in 30 seconds!");

                new BukkitRunnable() {
                    public void run() {
                        player.sendMessage("You have transformed back!");
                        player.setCustomNameVisible(true);
                        player.setAllowFlight(false);
                        player.setFlying(false);
                        Mob mob1 = (Mob) mob;
                        mob1.setInvulnerable(false);
                        mob1.damage(9999999);
                        mob2.setDuration(1);
                        player.removePotionEffect(PotionEffectType.INVISIBILITY);

                        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().isAir()) {
                            Adventures.getInstance().air.add(player.getUniqueId());
                        }

                        main.Vampire_Transform_active.asMap().remove(player);
                        main.Vampire_Transform_inactive.remove(player);
                    }
                }.runTaskLater(Adventures.getInstance(), 600L);

            }
        }.runTaskLater(Adventures.getInstance(), timer-600);
    }

    private void Transform_Direction(Player player, Entity mob) {
        new BukkitRunnable() {
            public void run() {
                if (main.Vampire_Transform_active.asMap().containsKey(player)) {
                    mob.setRotation(player.getLocation().getYaw(), player.getLocation().getPitch());
                }
            }
        }.runTaskTimer(Adventures.getInstance(), 0L, 1L);
    }

    public void sendUsage(CommandSender sender){
        sender.sendMessage( LanguageFile.getMessage(LanguageMessage.COMMAND_USAGE)+ " " + ChatColor.BLUE +
                "/vampire <invis, speed, transform>");
    }
}