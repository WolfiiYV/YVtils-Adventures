package yv.tils.adventures.ability;

import org.bukkit.EntityEffect;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import yv.tils.adventures.Adventures;
import yv.tils.adventures.unlock.LevelPath.XPGain.XPManager;

/**
 * @version 1.0
 * @since 1.0
 */
public class Ability {

    //MoreLives Ability
    public void MoreLives(Player player, int level) {
        switch (level) {
            case 1 -> {
                player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(25);
                player.setHealthScale(25);
                player.setHealth(25);
            }
            case 2 -> {
                player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(28);
                player.setHealthScale(28);
                player.setHealth(28);
            }
            case 3 -> {
                player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(30);
                player.setHealthScale(30);
                player.setHealth(30);
            }
            case 4 -> {
                player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(35);
                player.setHealthScale(35);
                player.setHealth(35);
            }
            case 5 -> {
                player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40);
                player.setHealthScale(40);
                player.setHealth(40);
            }
        }
    }

    //IllSpareYourLife Ability
    public void IllSpareYourLife(Player player, int level, EntityDamageEvent e) {
        int xp = player.getLevel();

        System.out.println(xp);

        switch (level) {
            case 1 -> {
                if (xp >= 30) {
                    PotionEffect REGENERATION = new PotionEffect(PotionEffectType.REGENERATION, 900, 1, true);
                    PotionEffect FIRE_RESISTANCE = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 800, 0, true);
                    PotionEffect ABSORPTION = new PotionEffect(PotionEffectType.ABSORPTION, 100, 1, true);

                    e.setCancelled(true);
                    player.setLevel(xp - 30);
                    player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue()/2);
                    player.damage(0.1);
                    player.playSound(player.getLocation(), Sound.ITEM_TOTEM_USE, 1, 1);
                    player.playEffect(EntityEffect.TOTEM_RESURRECT);
                    player.addPotionEffect(REGENERATION);
                    player.addPotionEffect(FIRE_RESISTANCE);
                    player.addPotionEffect(ABSORPTION);
                }
            }
            case 2 -> {
                if (xp >= 20) {
                    PotionEffect REGENERATION = new PotionEffect(PotionEffectType.REGENERATION, 1800, 1, true);
                    PotionEffect FIRE_RESISTANCE = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1600, 0, true);
                    PotionEffect ABSORPTION = new PotionEffect(PotionEffectType.ABSORPTION, 200, 1, true);

                    e.setCancelled(true);
                    player.setLevel(xp - 20);
                    player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
                    player.damage(0.1);
                    player.playSound(player.getLocation(), Sound.ITEM_TOTEM_USE, 1, 1);
                    player.playEffect(EntityEffect.TOTEM_RESURRECT);
                    player.addPotionEffect(REGENERATION);
                    player.addPotionEffect(FIRE_RESISTANCE);
                    player.addPotionEffect(ABSORPTION);
                }
            }
            case 3 -> {
                if (xp >= 10) {
                    PotionEffect REGENERATION = new PotionEffect(PotionEffectType.REGENERATION, 1800, 1, true);
                    PotionEffect FIRE_RESISTANCE = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1600, 0, true);
                    PotionEffect ABSORPTION = new PotionEffect(PotionEffectType.ABSORPTION, 200, 3, true);

                    e.setCancelled(true);
                    player.setLevel(xp - 10);
                    player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
                    player.damage(0.1);
                    player.playSound(player.getLocation(), Sound.ITEM_TOTEM_USE, 1, 1);
                    player.playEffect(EntityEffect.TOTEM_RESURRECT);
                    player.addPotionEffect(REGENERATION);
                    player.addPotionEffect(FIRE_RESISTANCE);
                    player.addPotionEffect(ABSORPTION);
                }
            }
            case 4 -> {
                if (xp >= 10) {
                    PotionEffect REGENERATION = new PotionEffect(PotionEffectType.REGENERATION, 2250, 1, true);
                    PotionEffect FIRE_RESISTANCE = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 2000, 0, true);
                    PotionEffect ABSORPTION = new PotionEffect(PotionEffectType.ABSORPTION, 250, 6, true);

                    e.setCancelled(true);
                    player.setLevel(xp - 10);
                    player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
                    player.damage(0.1);
                    player.playSound(player.getLocation(), Sound.ITEM_TOTEM_USE, 1, 1);
                    player.playEffect(EntityEffect.TOTEM_RESURRECT);
                    player.addPotionEffect(REGENERATION);
                    player.addPotionEffect(FIRE_RESISTANCE);
                    player.addPotionEffect(ABSORPTION);
                }
            }
            case 5 -> {
                if (xp >= 10) {
                    PotionEffect REGENERATION = new PotionEffect(PotionEffectType.REGENERATION, 2700, 1, true);
                    PotionEffect FIRE_RESISTANCE = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 2400, 0, true);
                    PotionEffect ABSORPTION = new PotionEffect(PotionEffectType.ABSORPTION, 300, 1, true);

                    e.setCancelled(true);
                    player.setLevel(xp - 10);
                    player.setHealth(20);
                    player.damage(0.1);
                    player.playSound(player.getLocation(), Sound.ITEM_TOTEM_USE, 1, 1);
                    player.playEffect(EntityEffect.TOTEM_RESURRECT);
                    player.addPotionEffect(REGENERATION);
                    player.addPotionEffect(FIRE_RESISTANCE);
                    player.addPotionEffect(ABSORPTION);
                } else if (xp >= 15) {
                    PotionEffect REGENERATION = new PotionEffect(PotionEffectType.REGENERATION, 2700, 1, true);
                    PotionEffect FIRE_RESISTANCE = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 2400, 0, true);
                    PotionEffect ABSORPTION = new PotionEffect(PotionEffectType.ABSORPTION, 300, 11, true);

                    e.setCancelled(true);
                    player.setLevel(xp - 15);
                    player.setHealth(20);
                    player.damage(0.1);
                    player.playSound(player.getLocation(), Sound.ITEM_TOTEM_USE, 1, 1);
                    player.playEffect(EntityEffect.TOTEM_RESURRECT);
                    player.addPotionEffect(REGENERATION);
                    player.addPotionEffect(FIRE_RESISTANCE);
                    player.addPotionEffect(ABSORPTION);
                }
            }
        }
    }

    //onFire
    public void onFire(Player player, int level) {
        if (Adventures.getInstance().onFireAbility.contains(player)) return;

        switch (level) {
            case 1 -> {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10*20, 4, false, false, false));
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 10*20, 1, false, false, false));
                Adventures.getInstance().onFireAbility.add(player);
            }
            case 2 -> {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*20, 4, false, false, false));
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 20*20, 1, false, false, false));
                Adventures.getInstance().onFireAbility.add(player);
            }
            case 3 -> {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40*20, 4, false, false, false));
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 40*20, 1, false, false, false));
                Adventures.getInstance().onFireAbility.add(player);
            }
            case 4 -> {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80*20, 4, false, false, false));
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 80*20, 1, false, false, false));
                Adventures.getInstance().onFireAbility.add(player);
            }
            case 5 -> {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100*20, 4, false, false, false));
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100*20, 1, false, false, false));
                Adventures.getInstance().onFireAbility.add(player);
            }
        }

        new BukkitRunnable() {
            public void run() {
                Adventures.getInstance().onFireAbility.remove(player);
            }
        }.runTaskLater(Adventures.getInstance(), 2000L);
    }

    //Light Flight
    public void LightFlight(EntityDamageEvent e, Player player, int level) {
        double damage = e.getDamage();
        switch (level) {
            case 1 -> {
                double d = damage/2;
                if (player.getHealth() <= d) {
                    e.setCancelled(false);
                }else {
                    player.damage(d);
                    e.setCancelled(true);
                }
            }
            case 2 -> {
                double d = damage/4;
                if (player.getHealth() <= d) {
                    e.setCancelled(false);
                }else {
                    player.damage(d);
                    e.setCancelled(true);
                }
            }
            case 3 -> {
                double d = damage/6;
                if (player.getHealth() <= d) {
                    e.setCancelled(false);
                }else {
                    player.damage(d);
                    e.setCancelled(true);
                }
            }
            case 4 -> {
                double d = damage/8;
                if (player.getHealth() <= d) {
                    e.setCancelled(false);
                }else {
                    player.damage(d);
                    e.setCancelled(true);
                }
            }
            case 5 -> e.setCancelled(true);
        }
    }

    //Vampire Ability
    public void Vampire(int level, EntityDamageByEntityEvent e) {
        double damage = e.getDamage();
        Player player = (Player) e.getDamager();

        switch (level) {
            case 1 -> {
                double d = damage*((double) 1/3);
                if (player.getHealth() + d <= player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) {
                    player.setHealth(player.getHealth() + d);
                }else {
                    player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                }
            }
            case 2 -> {

            }
            case 3 -> {

            }
            case 4 -> {

            }
            case 5 -> {

            }
        }
    }

    //The End
    public void TheEnd(Player player, int level) {
        switch (level) {
            case 1 -> {
                player.sendMessage("You complete the first Chapter! \n" +
                        "There will soon be more!");
                player.playSound(player.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1F, 1.4F);
                new XPManager().onGainEvent(player, 5000, "The End I");
            }
            case 2 -> {

            }
            case 3 -> {

            }
            case 4 -> {

            }
            case 5 -> {

            }
        }
    }
}