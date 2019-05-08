/*
 * Copyright (c) Sokratis Fotkatzikis (sokratis12GR) 2015-2019.
 */

package com.sofodev.armorplus.common.registry.entity.dungeon.base;

import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIAttackRanged;

/**
 * @author Sokratis Fotkatzikis
 */
public class EntityAIRangedDungeonAttack extends EntityAIAttackRanged {

    public EntityAIRangedDungeonAttack(IRangedAttackMob attacker, EntityAIType type) {
        super(attacker, type.getMoveSpeed(), type.getMaxAttackTime(), type.getMaxAttackDistanceIn());
    }

    public enum EntityAIType {
        GUARDIAN(0.5D, 10, 3.0F),
        WITHER(1.0D, 120, 10.0F),
        ;

        private final double moveSpeed;
        private final int maxAttackTime;
        private final float maxAttackDistanceIn;

        EntityAIType(double moveSpeed, int maxAttackTime, float maxAttackDistanceIn) {
            this.moveSpeed = moveSpeed;
            this.maxAttackTime = maxAttackTime;
            this.maxAttackDistanceIn = maxAttackDistanceIn;
        }

        public double getMoveSpeed() {
            return this.moveSpeed;
        }

        public int getMaxAttackTime() {
            return this.maxAttackTime;
        }

        public float getMaxAttackDistanceIn() {
            return this.maxAttackDistanceIn;
        }
    }
}
