package com.sofodev.armorplus.registry.enchantments;

import com.sofodev.armorplus.utils.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;

import static com.sofodev.armorplus.registry.enchantments.FuriousEnchantment.Levels.limit;
import static net.minecraft.enchantment.Enchantment.Rarity.RARE;
import static net.minecraft.enchantment.EnchantmentType.ARMOR;
import static net.minecraft.enchantment.EnchantmentType.WEARABLE;
import static net.minecraft.inventory.EquipmentSlotType.*;
import static net.minecraft.potion.Effects.SPEED;
import static net.minecraft.potion.Effects.STRENGTH;

public class FuriousEnchantment extends APEnchantment {

    public FuriousEnchantment() {
        super(RARE, WEARABLE, new EquipmentSlotType[]{HEAD, CHEST, LEGS, FEET},
                1, 3, 10, 15, true, true
        );
    }

    @Override
    public void onEntityDamaged(LivingEntity user, Entity target, int level) {
        if (level > limit()) {
            level = limit();
        }
        super.onEntityDamaged(user, target, level);
    }

    @Override
    public void onUserHurt(LivingEntity user, Entity attacker, int level) {
        if (level > limit()) {
            level = limit();
        }
        Levels lvl = Levels.values()[level];
        user.addPotionEffect(new EffectInstance(STRENGTH, Utils.convertToSeconds(lvl.strSecs), lvl.strLevel));
        if (lvl.hasFastLegs) {
            user.addPotionEffect(new EffectInstance(SPEED, Utils.convertToSeconds(lvl.speedSecs), lvl.speedLevel));
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