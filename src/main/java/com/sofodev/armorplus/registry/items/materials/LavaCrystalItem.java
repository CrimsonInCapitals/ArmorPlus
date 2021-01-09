package com.sofodev.armorplus.registry.items.materials;

import com.sofodev.armorplus.registry.items.APItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.Color;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

import static com.sofodev.armorplus.utils.ToolTipUtils.translate;
import static com.sofodev.armorplus.utils.Utils.getAPItem;
import static net.minecraft.util.text.TextFormatting.DARK_PURPLE;
import static net.minecraft.util.text.TextFormatting.GOLD;

/**
 * @author Sokratis Fotkatzikis
 **/
public class LavaCrystalItem extends APItem {

    private final boolean isInfused;

    private int[] burnTime = new int[]{20000, 22000};

    public LavaCrystalItem(boolean isInfused) {
        super(new Properties().isImmuneToFire());
        this.isInfused = isInfused;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (!isInfused) {
            tooltip.add(translate("item.armorplus.lava_crystal.how_to_infuse").setStyle(Style.EMPTY.setItalic(true).setColor(Color.fromHex("#670067"))));
        } else
            tooltip.add(translate("item.armorplus.lava_crystal.lore").setStyle(Style.EMPTY.setItalic(true).setColor(Color.fromHex("#670067"))));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    /**
     * We use this method to `infuse` lava crystals to infused lava crystals.
     * <p>
     * We just check if the entity item of the lava crystal is inside lava, and if its not the infused variant
     * and then we drop a new entity item that contains the infused lava crystal with the same stack size as the last
     * entity item's item size, then we set the old's entity size to 0 so it "despawns" safely.
     */
    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        boolean isInLava = entity.getEntityWorld().getFluidState(entity.getPosition()).getFluid().isIn(FluidTags.LAVA);
        if (!isInfused && isInLava) {
            entity.entityDropItem(new ItemStack(getAPItem("infused_lava_crystal"), entity.getItem().getCount()));
            entity.getItem().setCount(0);
            return true;
        }
        return false;
    }

    @Override
    public boolean isDamageable(DamageSource damageSource) {
        return super.isDamageable(damageSource);
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.create("Lava Crystalic", GOLD);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return isInfused ? burnTime[1] : burnTime[0];
    }

}