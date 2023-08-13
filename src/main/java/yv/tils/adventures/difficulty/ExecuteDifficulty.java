package yv.tils.adventures.difficulty;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import yv.tils.adventures.Adventures;

import java.util.*;

import static org.bukkit.potion.PotionEffect.INFINITE_DURATION;

/**
 * @version 1.0
 * @since 1.0
 */
public class ExecuteDifficulty {
    public void Challenge(Player player, double damage, EntityDamageEvent e) {
        if (e.getCause().equals(EntityDamageEvent.DamageCause.CUSTOM)) return;
        if (player.getHealth() <= damage) return;
        e.getCause();
        double d = damage*2;
        if (player.getHealth() <= d) {
            player.damage(damage);
            e.setCancelled(false);
        }else {
            player.damage(d);
            e.setCancelled(true);
        }
    }

    public void AlmostPeaceful_Damage(Player player, double damage, EntityDamageEvent e) {
        if (e.getCause().equals(EntityDamageEvent.DamageCause.CUSTOM)) return;
        if (player.getHealth() <= damage) return;
        double d = damage/2;
        if (player.getHealth() <= d) {
            e.setCancelled(false);
        }else {
            player.damage(d);
            e.setCancelled(true);
        }
    }
    public void AlmostPeaceful_Movement(Player player) {
        long currentTime = System.currentTimeMillis();
        long startTime = Adventures.getInstance().standingPlayers.get(player);
        long standingTime = (currentTime - startTime) / 1000;

        if (standingTime >= 10 && player.getGameMode().equals(GameMode.SURVIVAL)) {
            player.setVisualFire(true);
            double damage = 0.25;
            player.damage(damage);
        }else {
            if (!player.isVisualFire()) return;
            player.setVisualFire(false);
        }
    }

    public void CarelessCheetah_Movement(Player player) {
        player.setWalkSpeed(0.3F);
        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, INFINITE_DURATION, 1, false, false, false));
    }
    public void CarelessCheetah_BlockLuck(BlockBreakEvent e, List<Material> increasedDropItems, Random random) {
        if (!e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) return;

        Block block = e.getBlock();
        Player player = e.getPlayer();
        Material blockType = block.getType();
        if (increasedDropItems.contains(blockType)) {
            if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.SILK_TOUCH)) return;

            e.setDropItems(false);

            int minExtraDropAmount = 1;
            int maxExtraDropAmount = 3;

            int extraDrops = random.nextInt(maxExtraDropAmount - minExtraDropAmount + 1) + minExtraDropAmount;

            List<ItemStack> drops = (List<ItemStack>) block.getDrops(e.getPlayer().getInventory().getItemInMainHand());

            for (int i = 0; i < drops.size(); i++) {
                ItemStack drop = drops.get(i);
                drop.setAmount(drop.getAmount() / extraDrops);
                if (drop.getAmount() < 0.5) drop.setAmount(1);
                drops.set(i, drop);
            }

            // Drop the items into the world
            for (ItemStack drop : drops) {
                block.getWorld().dropItemNaturally(block.getLocation(), drop);
            }
        }
    }
    public void CarelessCheetah_MobLuck(EntityDeathEvent e, Player player, Random random) {
        if (!player.getGameMode().equals(GameMode.SURVIVAL)) return;

        int minExtraDropAmount = 1;
        int maxExtraDropAmount = 3;

        int extraDrops = random.nextInt(maxExtraDropAmount - minExtraDropAmount + 1) + minExtraDropAmount;

        List<ItemStack> drops = e.getDrops();
        List<ItemStack> modifiedDrops = new ArrayList<>();

        for (ItemStack drop : drops) {
            ItemStack modifiedDrop = drop.clone();
            modifiedDrop.setAmount(modifiedDrop.getAmount() / extraDrops);
            if (drop.getAmount() < 0.5) drop.setAmount(1);
            modifiedDrops.add(modifiedDrop);
        }

        drops.clear();
        drops.addAll(modifiedDrops);
    }

    public void CarefulSnail_Movement(Player player) {
        player.setWalkSpeed(0.03F);
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, INFINITE_DURATION, 1, false, false, false));
    }
    public void CarefulSnail_BlockLuck(BlockBreakEvent e, List<Material> increasedDropItems, Random random) {
        if (!e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) return;

        Block block = e.getBlock();
        Player player = e.getPlayer();
        Material blockType = block.getType();
        if (increasedDropItems.contains(blockType)) {
            if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.SILK_TOUCH)) return;

            e.setDropItems(false);

            int minExtraDropAmount = 1;
            int maxExtraDropAmount = 3;

            int extraDrops = random.nextInt(maxExtraDropAmount - minExtraDropAmount + 1) + minExtraDropAmount;

            List<ItemStack> drops = (List<ItemStack>) block.getDrops(e.getPlayer().getInventory().getItemInMainHand());

            for (int i = 0; i < drops.size(); i++) {
                ItemStack drop = drops.get(i);
                drop.setAmount(drop.getAmount() * extraDrops);
                drops.set(i, drop);
            }

            // Drop the items into the world
            for (ItemStack drop : drops) {
                block.getWorld().dropItemNaturally(block.getLocation(), drop);
            }
        }
    }
    public void CarefulSnail_MobLuck(EntityDeathEvent e, Player player, Random random) {
        if (!player.getGameMode().equals(GameMode.SURVIVAL)) return;

        int minExtraDropAmount = 1;
        int maxExtraDropAmount = 3;

        int extraDrops = random.nextInt(maxExtraDropAmount - minExtraDropAmount + 1) + minExtraDropAmount;

        List<ItemStack> drops = e.getDrops();
        List<ItemStack> modifiedDrops = new ArrayList<>();

        for (ItemStack drop : drops) {
            ItemStack modifiedDrop = drop.clone();
            modifiedDrop.setAmount(modifiedDrop.getAmount() * extraDrops);
            modifiedDrops.add(modifiedDrop);
        }

        drops.clear();
        drops.addAll(modifiedDrops);
    }

    public void CarefulHolder_Death(PlayerDeathEvent e) {
        e.setKeepInventory(true);
        e.setKeepLevel(true);
        e.getDrops().clear();
        e.setDroppedExp(0);
    }
    public void CarefulHolder_Respawn(Player player, PlayerRespawnEvent e) {
        new BukkitRunnable() {
            public void run() {
                for (int i = 0; i < player.getInventory().getSize(); i++) {
                    ItemStack item = player.getInventory().getItem(i);

                    if (item != null) {
                        if ((item.getType().getMaxDurability() > 0)) {
                            Damageable damageable = (Damageable) item.getItemMeta();
                            damageable.setDamage(damageable.getDamage() + 30);
                            item.setItemMeta(damageable);

                            if (damageable.getDamage() >= item.getType().getMaxDurability()) {
                                item.setType(Material.AIR);
                                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1, 1);
                            }
                            player.getInventory().setItem(i, item);
                        }
                    }
                }
            }
        }.runTaskLater(Adventures.getInstance(), 20L);
    }

    public void RuthlessRumble_GetDamage(Player player, double damage, EntityDamageByEntityEvent e) {
        if (e.getCause().equals(EntityDamageEvent.DamageCause.CUSTOM)) return;
        Set<EntityType> validTypes = new HashSet<>(Set.of(
                EntityType.BLAZE,
                EntityType.CHICKEN,
                EntityType.CREEPER,
                EntityType.DROWNED,
                EntityType.ELDER_GUARDIAN,
                EntityType.ENDERMITE,
                EntityType.EVOKER,
                EntityType.EVOKER_FANGS,
                EntityType.GHAST,
                EntityType.GUARDIAN,
                EntityType.HOGLIN,
                EntityType.HUSK,
                EntityType.MAGMA_CUBE,
                EntityType.PHANTOM,
                EntityType.PIGLIN_BRUTE,
                EntityType.PILLAGER,
                EntityType.RAVAGER,
                EntityType.SHULKER,
                EntityType.SILVERFISH,
                EntityType.SKELETON,
                EntityType.SKELETON_HORSE,
                EntityType.SLIME,
                EntityType.SPIDER,
                EntityType.STRAY,
                EntityType.VEX,
                EntityType.VINDICATOR,
                EntityType.WARDEN,
                EntityType.WITCH,
                EntityType.WITHER_SKELETON,
                EntityType.ZOMBIE_VILLAGER,
                EntityType.ZOMBIE,
                EntityType.ZOGLIN
        ));

        Entity damager = e.getDamager();
        EntityType damagerType = damager.getType();

        switch (damagerType) {
            case ARROW, SHULKER_BULLET, SMALL_FIREBALL, TRIDENT, FIREBALL -> {
                if (damager instanceof Projectile projectile) {
                    Entity shooter = (Entity) projectile.getShooter();
                    if (validTypes.contains(shooter.getType())) {
                        validTypes.add(damagerType);
                    }
                }
            }
        }

        if (validTypes.contains(e.getDamager().getType())) {
            if (player.getHealth() <= damage) return;
            double d = damage*2;
            if (player.getHealth() <= d) {
                player.damage(damage);
                e.setCancelled(false);
            }else {
                player.damage(d);
                e.setCancelled(true);
            }
        }
    }
    public void RuthlessRumble_MakeDamage(double damage, EntityDamageByEntityEvent e) {
        if (e.getCause().equals(EntityDamageEvent.DamageCause.CUSTOM)) return;
        Set<EntityType> validTypes = new HashSet<>(Set.of(
                EntityType.BLAZE,
                EntityType.CHICKEN,
                EntityType.CREEPER,
                EntityType.DROWNED,
                EntityType.ELDER_GUARDIAN,
                EntityType.ENDERMITE,
                EntityType.EVOKER,
                EntityType.EVOKER_FANGS,
                EntityType.GHAST,
                EntityType.GUARDIAN,
                EntityType.HOGLIN,
                EntityType.HUSK,
                EntityType.MAGMA_CUBE,
                EntityType.PHANTOM,
                EntityType.PIGLIN_BRUTE,
                EntityType.PILLAGER,
                EntityType.RAVAGER,
                EntityType.SHULKER,
                EntityType.SILVERFISH,
                EntityType.SKELETON,
                EntityType.SKELETON_HORSE,
                EntityType.SLIME,
                EntityType.SPIDER,
                EntityType.STRAY,
                EntityType.VEX,
                EntityType.VINDICATOR,
                EntityType.WARDEN,
                EntityType.WITCH,
                EntityType.WITHER_SKELETON,
                EntityType.ZOMBIE_VILLAGER,
                EntityType.ZOMBIE,
                EntityType.ZOGLIN,
                EntityType.PLAYER
        ));

        Entity damager = e.getDamager();

        if (!damager.getType().equals(EntityType.PLAYER)) return;
        if (!validTypes.contains(e.getEntity().getType())) {
            double d = damage*2;
            if (e.getEntity() instanceof LivingEntity entity) {
                entity.damage(d);
            }
        }
    }

    public void SwiftHunger_Effects(Player player) {
        player.setWalkSpeed(0.3F);
        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, INFINITE_DURATION, 1, false, false, false));
    }
    public void SwiftHunger_Hunger(FoodLevelChangeEvent e, Player player) {
        int oldFoodLevel = player.getFoodLevel();
        int newFoodLevel = e.getFoodLevel();
        if (oldFoodLevel > newFoodLevel) {
            int lostHunger = oldFoodLevel - newFoodLevel;
            e.setFoodLevel(oldFoodLevel-(lostHunger*2));
        }
    }
}