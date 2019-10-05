/*
 * Copyright (c) Sokratis Fotkatzikis (sokratis12GR) 2015-2019.
 */

package com.sofodev.armorplus.common.registry.enchantments;

import com.sofodev.armorplus.common.util.Utils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.potion.PotionEffect;

import static com.sofodev.armorplus.common.config.ModConfig.RegistryConfig.enchantments;
import static com.sofodev.armorplus.common.registry.enchantments.FuriousEnchantment.Levels.limit;
import static net.minecraft.init.MobEffects.SPEED;
import static net.minecraft.init.MobEffects.STRENGTH;

/**
 * @author Sokratis Fotkatzikis
 */
public class FuriousEnchantment extends EnchantmentBase {

    public FuriousEnchantment() {
        super("furious", Enchantment.Rarity.RARE, EnumEnchantmentType.ARMOR,
            new EntityEquipmentSlot[]{EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET},
            1, 3, 10, 15, true, true
        );
    }

    @Override
    public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {
        if (level > limit()) {
            level = limit();
        }
        super.onEntityDamaged(user, target, level);
    }

    @Override
    public void onUserHurt(EntityLivingBase user, Entity attacker, int level) {
        if (enchantments.enableFurious) {
            if (level > limit()) {
                level = limit();
            }
            Levels lvl = Levels.values()[level];
            user.addPotionEffect(new PotionEffect(STRENGTH, Utils.convertToSeconds(lvl.strSecs), lvl.strLevel));
            if (lvl.hasFastLegs) {
                user.addPotionEffect(new PotionEffect(SPEED, Utils.convertToSeconds(lvl.speedSecs), lvl.speedLevel));
            }
        }
    }

    public enum Levels {
        ZERO(),
        ONE(23, 0),
        TWO(23, 0, true, 23, 0),
        THREE(23, 1, true, 46, 0),
        FOUR(30, 2, true, 60, 1);

        public final int strSecs;
        public final int strLevel;
        public final boolean hasFastLegs;
        public final int speedSecs;
        public final int speedLevel;

        Levels() {
            this(0, 0, false, 0, 0);
        }

        Levels(int strSecs, int strLevel) {
            this(strSecs, strLevel, false, 0, 0);
        }

        Levels(int strSecs, int strLevel, boolean hasFastLegs, int speedSecs, int speedLevel) {
            this.strSecs = strSecs;
            this.strLevel = strLevel;
            this.hasFastLegs = hasFastLegs;
            this.speedSecs = speedSecs;
            this.speedLevel = speedLevel;
        }

        public static int limit() {
            return values().length - 1;
        }
    }
}