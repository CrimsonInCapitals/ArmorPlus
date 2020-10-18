package com.sofodev.armorplus.registry.items.tools;

import com.sofodev.armorplus.ArmorPlus;
import com.sofodev.armorplus.registry.items.tools.properties.APToolMaterial;
import com.sofodev.armorplus.registry.items.tools.properties.IAPTool;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShovelItem;

import static com.sofodev.armorplus.registry.items.tools.properties.APToolType.SHOVEL;

import net.minecraft.item.Item.Properties;

public class APShovelItem extends ShovelItem {

    private final IAPTool mat;

    public APShovelItem(IAPTool mat) {
        super(mat.get(), mat.get().getAttackDamage() + SHOVEL.getDmg(), SHOVEL.getAttackSpeed(), new Properties().group(ArmorPlus.AP_WEAPON_GROUP));
        this.mat = mat;
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return mat.getRarity();
    }
}