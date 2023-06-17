package yv.tils.adventures.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.EquipmentSlot;
import yv.tils.adventures.Adventures;
import yv.tils.adventures.ability.Ability;
import yv.tils.adventures.difficulty.Difficultys;
import yv.tils.adventures.difficulty.ExecuteDifficulty;
import yv.tils.adventures.unlock.LevelPath.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @version 1.0
 * @since 1.0
 */
public class PlayerDamage implements Listener {
    @EventHandler
    public void onEvent(EntityDamageEvent e) {
        IllSpareYourLife(e);
        Challenge(e);
        AlmostPeaceful(e);
        OnFire(e);
        LightFlight(e);
        VampireBat(e);
    }

    @EventHandler
    public void onEvent(EntityDamageByEntityEvent e) {
        RuthlessRumble_GetDamage(e);
        RuthlessRumble_MakeDamage(e);
        Vampire_LifeSteal(e);
    }

    private void IllSpareYourLife(EntityDamageEvent e) {
        if (e.getEntityType() != EntityType.PLAYER) return;
        if (!(e.getEntity() instanceof Player player)) return;
        if (((player.getHealth() - e.getFinalDamage()) <= 0)) {

            if (player.getInventory().getItem(EquipmentSlot.OFF_HAND).getType() == Material.TOTEM_OF_UNDYING) return;
            if (player.getInventory().getItem(EquipmentSlot.HAND).getType() == Material.TOTEM_OF_UNDYING) return;

            String p = Adventures.getInstance().p.get(player.getName());
            String[] plist = p.split(";");
            String pabilitys = plist[5];
            pabilitys = pabilitys.replace("[", "");
            pabilitys = pabilitys.replace("]", "");
            List<String> pabilitylist = new ArrayList<>(List.of(pabilitys.split(", ")));

            if (pabilitylist.contains(Level.L10.reward) || pabilitylist.contains(Level.L35.reward)) {
                if (pabilitylist.contains("TBA")) {
                    new Ability().IllSpareYourLife(player, 5, e);
                    return;
                } else if (pabilitylist.contains("TBA")) {
                    new Ability().IllSpareYourLife(player, 4, e);
                    return;
                } else if (pabilitylist.contains("TBA")) {
                    new Ability().IllSpareYourLife(player, 3, e);
                    return;
                } else if (pabilitylist.contains(Level.L35.reward)) {
                    new Ability().IllSpareYourLife(player, 2, e);
                    return;
                } else if (pabilitylist.contains(Level.L10.reward)) {
                    new Ability().IllSpareYourLife(player, 1, e);
                    return;
                }
            }
        }
    }

    private void Challenge(EntityDamageEvent e) {
        if (e.getEntityType() != EntityType.PLAYER) return;
        if (!(e.getEntity() instanceof Player player)) return;

        String p = Adventures.getInstance().p.get(player.getName());
        String[] plist = p.split(";");
        String pdifficulty = plist[6];

        if (pdifficulty.equals(ChatColor.stripColor(Difficultys.D1.name))) {
            double damage = e.getFinalDamage();
            new ExecuteDifficulty().Challenge(player, damage, e);
        }
    }

    private void AlmostPeaceful(EntityDamageEvent e) {
        if (e.getEntityType() != EntityType.PLAYER) return;
        if (!(e.getEntity() instanceof Player player)) return;

        String p = Adventures.getInstance().p.get(player.getName());
        String[] plist = p.split(";");
        String pdifficulty = plist[6];

        if (pdifficulty.equals(ChatColor.stripColor(Difficultys.D2.name))) {
            double damage = e.getFinalDamage();
            new ExecuteDifficulty().AlmostPeaceful_Damage(player, damage, e);
        }


    }

    private void RuthlessRumble_GetDamage(EntityDamageByEntityEvent e) {
        if (e.getEntityType() != EntityType.PLAYER) return;
        if (!(e.getEntity() instanceof Player player)) return;

        String p = Adventures.getInstance().p.get(player.getName());
        String[] plist = p.split(";");
        String pdifficulty = plist[6];

        if (pdifficulty.equals(ChatColor.stripColor(Difficultys.D6.name))) {
            double damage = e.getFinalDamage();
            new ExecuteDifficulty().RuthlessRumble_GetDamage(player, damage, e);
        }


    }
    private void RuthlessRumble_MakeDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() != EntityType.PLAYER) return;
        if (!(e.getDamager() instanceof Player player)) return;

        String p = Adventures.getInstance().p.get(player.getName());
        String[] plist = p.split(";");
        String pdifficulty = plist[6];

        if (pdifficulty.equals(ChatColor.stripColor(Difficultys.D6.name))) {
            double damage = e.getFinalDamage();
            new ExecuteDifficulty().RuthlessRumble_MakeDamage(damage, e);
        }


    }

    private void OnFire(EntityDamageEvent e) {
        if (e.getEntityType() != EntityType.PLAYER) return;
        if (!(e.getEntity() instanceof Player player)) return;
        String p = Adventures.getInstance().p.get(player.getName());
        String[] plist = p.split(";");
        String pabilitys = plist[5];
        pabilitys = pabilitys.replace("[", "");
        pabilitys = pabilitys.replace("]", "");
        List<String> pabilitylist = new ArrayList<>(List.of(pabilitys.split(", ")));

        if (pabilitylist.contains(Level.L15.reward)) {
            if (e.getCause().equals(EntityDamageEvent.DamageCause.FIRE) ||
                    e.getCause().equals(EntityDamageEvent.DamageCause.LAVA) ||
                    e.getCause().equals(EntityDamageEvent.DamageCause.FIRE_TICK) ||
                    e.getCause().equals(EntityDamageEvent.DamageCause.MELTING)||
                    e.getCause().equals(EntityDamageEvent.DamageCause.HOT_FLOOR)) {
                if (pabilitylist.contains(Level.L15.reward)) {
                    if (pabilitylist.contains("TBA")) {
                        new Ability().onFire(player, 5);
                        return;
                    } else if (pabilitylist.contains("TBA")) {
                        new Ability().onFire(player, 4);
                        return;
                    } else if (pabilitylist.contains("TBA")) {
                        new Ability().onFire(player, 3);
                        return;
                    } else if (pabilitylist.contains("TBA")) {
                        new Ability().onFire(player, 2);
                        return;
                    } else if (pabilitylist.contains(Level.L15.reward)) {
                        new Ability().onFire(player, 1);
                        return;
                    }
                }
            }
        }
    }

    private void VampireBat(EntityDamageEvent e) {
        if (e.getEntityType() == EntityType.PLAYER
                && (e.getCause() == EntityDamageEvent.DamageCause.FALL)
                && Adventures.getInstance().air.contains(e.getEntity().getUniqueId())) {
            e.setCancelled(true);
            UUID uuid = e.getEntity().getUniqueId();
            Adventures.getInstance().air.remove(uuid);
        }
    }

    private void Vampire_LifeSteal(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() != EntityType.PLAYER) return;
        if (!(e.getDamager() instanceof Player player)) return;

        String p = Adventures.getInstance().p.get(player.getName());
        String[] plist = p.split(";");
        String pabilitys = plist[5];
        pabilitys = pabilitys.replace("[", "");
        pabilitys = pabilitys.replace("]", "");
        List<String> pabilitylist = new ArrayList<>(List.of(pabilitys.split(", ")));

        if (pabilitylist.contains(Level.L40.reward)) {
            if (pabilitylist.contains("TBA")) {
                new Ability().Vampire(5, e);
                return;
            } else if (pabilitylist.contains("TBA")) {
                new Ability().Vampire(4, e);
                return;
            } else if (pabilitylist.contains("TBA")) {
                new Ability().Vampire(3, e);
                return;
            } else if (pabilitylist.contains("TBA")) {
                new Ability().Vampire(2, e);
                return;
            } else if (pabilitylist.contains(Level.L40.reward)) {
                new Ability().Vampire(1, e);
                return;
            }
        }
    }

    private void LightFlight(EntityDamageEvent e) {
        if (e.getEntityType() != EntityType.PLAYER) return;
        if (!(e.getEntity() instanceof Player player)) return;
        String p = Adventures.getInstance().p.get(player.getName());
        String[] plist = p.split(";");
        String pabilitys = plist[5];
        pabilitys = pabilitys.replace("[", "");
        pabilitys = pabilitys.replace("]", "");
        List<String> pabilitylist = new ArrayList<>(List.of(pabilitys.split(", ")));

        if (pabilitylist.contains(Level.L30.reward)) {
            if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
                if (pabilitylist.contains(Level.L30.reward)) {
                    if (pabilitylist.contains("TBA")) {
                        new Ability().LightFlight(e, player, 5);
                        return;
                    } else if (pabilitylist.contains("TBA")) {
                        new Ability().LightFlight(e, player, 4);
                        return;
                    } else if (pabilitylist.contains("TBA")) {
                        new Ability().LightFlight(e, player, 3);
                        return;
                    } else if (pabilitylist.contains("TBA")) {
                        new Ability().LightFlight(e, player, 2);
                        return;
                    } else if (pabilitylist.contains(Level.L30.reward)) {
                        new Ability().LightFlight(e, player, 1);
                        return;
                    }
                }
            }
        }
    }
}