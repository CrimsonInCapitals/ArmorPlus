package com.sofodev.armorplus.registry.items.tools;

import com.sofodev.armorplus.ArmorPlus;
import com.sofodev.armorplus.registry.items.tools.properties.tool.IAPTool;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

import static com.sofodev.armorplus.registry.items.tools.properties.tool.APToolType.BATTLE_AXE;
import static com.sofodev.armorplus.utils.ToolTipUtils.addBuffInformation;

public class APBattleAxeItem extends AxeItem {

    private final IAPTool mat;

    public APBattleAxeItem(IAPTool mat) {
        super(mat.get(), mat.get().getAttackDamage() + BATTLE_AXE.getDmg(), BATTLE_AXE.getAttackSpeed(), new Item.Properties().group(ArmorPlus.AP_WEAPON_GROUP));
        this.mat = mat;
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return mat.getRarity();
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.world.isRemote) {
            Arrays.stream(mat.getBuffInstances()).forEach(instance -> instance.hitEntity(stack, target, attacker));
        }
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        addBuffInformation(mat, tooltip, "on_hit", false);
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}