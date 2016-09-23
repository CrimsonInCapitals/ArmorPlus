/*******************************************************************************
 * Copyright (c) TheDragonTeam 2016.
 ******************************************************************************/

package net.thedragonteam.armorplus.util;

import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.common.Optional;

public class ARPTeslaUtils {

    @Optional.Method(modid = "tesla")
    public static boolean isPoweredItem(ItemStack stack) {
        if (stack.hasCapability(TeslaCapabilities.CAPABILITY_HOLDER, EnumFacing.DOWN))
            return true;
        return false;
    }

    @Optional.Method(modid = "tesla")
    public static long getStoredPower(ItemStack stack) {
        if (isPoweredItem(stack)) {
            BaseTeslaContainer container = getContainer(stack);
            return getContainer(stack).getStoredPower();
        } else return 0;
    }

    @Optional.Method(modid = "tesla")
    public static long getMaxCapacity(ItemStack stack) {
        if (isPoweredItem(stack)) {
            return getContainer(stack).getCapacity();
        } else return 0;
    }

    @Optional.Method(modid = "tesla")
    public static void addPower(ItemStack stack, long amount) {
        if (isPoweredItem(stack)) {
            getContainer(stack).givePower(amount, false);
        }
    }

    @Optional.Method(modid = "tesla")
    public static BaseTeslaContainer getContainer(ItemStack stack) {
        if (isPoweredItem(stack)) {
            BaseTeslaContainer container = (BaseTeslaContainer) stack.getCapability(TeslaCapabilities.CAPABILITY_HOLDER, EnumFacing.DOWN);
            return container;
        }
        return null;
    }

    @Optional.Method(modid = "tesla")
    public static void setMaxCapacity(ItemStack stack, long amount) {
        if (isPoweredItem(stack)) {
            getContainer(stack).setCapacity(amount);
        }
    }

    @Optional.Method(modid = "tesla")
    public static void usePower(ItemStack stack, long amount) {
        if (isPoweredItem(stack)) {
            getContainer(stack).takePower(amount, false);
        }
    }

    @Optional.Method(modid = "tesla")
    public static long getMaxInput(ItemStack stack) {
        if (isPoweredItem(stack)) {
            return getContainer(stack).getInputRate();
        }
        return 0;
    }

    @Optional.Method(modid = "tesla")
    public static long getMaxOutput(ItemStack stack) {
        if (isPoweredItem(stack)) {
            return getContainer(stack).getOutputRate();
        }
        return 0;
    }

    @Optional.Method(modid = "tesla")
    public static ItemStack createChargedStack(ItemStack stack) {
        if (isPoweredItem(stack)) {
            ItemStack chargedstack = stack.copy();
            getContainer(chargedstack).setInputRate(ARPTeslaUtils.getMaxCapacity(stack));
            addPower(chargedstack, getMaxCapacity(stack));
            getContainer(chargedstack).setInputRate(ARPTeslaUtils.getMaxInput(stack));
            return chargedstack;
        }
        return null;
    }

    /**
     * Blocks
     */
    @Optional.Method(modid = "tesla")
    public static boolean isTelsaBlock(TileEntity tileEntity) {
        if (tileEntity.hasCapability(TeslaCapabilities.CAPABILITY_HOLDER, EnumFacing.DOWN))
            return true;
        return false;
    }

    @Optional.Method(modid = "tesla")
    public static BaseTeslaContainer getContainer(TileEntity tileEntity) {
        if (isTelsaBlock(tileEntity)) {
            BaseTeslaContainer container = (BaseTeslaContainer) tileEntity.getCapability(TeslaCapabilities.CAPABILITY_HOLDER, EnumFacing.DOWN);
            return container;
        }
        return null;
    }

    @Optional.Method(modid = "tesla")
    public static boolean isConsumer(TileEntity tileEntity) {
        if (tileEntity.hasCapability(TeslaCapabilities.CAPABILITY_CONSUMER, EnumFacing.DOWN))
            return true;
        return false;
    }

    @Optional.Method(modid = "tesla")
    public static long getMaxCapacity(TileEntity tile) {
        return getContainer(tile).getCapacity();
    }

    @Optional.Method(modid = "tesla")
    public static long getStoredPower(TileEntity tile) {
        return getContainer(tile).getStoredPower();
    }

    @Optional.Method(modid = "tesla")
    public static long getMissingPower(TileEntity tileEntity) {
        return getMaxCapacity(tileEntity) - getStoredPower(tileEntity);
    }

    @Optional.Method(modid = "tesla")
    public static boolean canAcceptPower(TileEntity tile, long amount) {
        if (getMissingPower(tile) >= amount) {
            return true;
        }
        return false;
    }

    @Optional.Method(modid = "tesla")
    public static void addPower(TileEntity tileEntity, long amount) {
        getContainer(tileEntity).givePower(amount, false);
    }
}
