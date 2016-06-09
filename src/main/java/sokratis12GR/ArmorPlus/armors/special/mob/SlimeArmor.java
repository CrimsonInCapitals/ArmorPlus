package sokratis12GR.ArmorPlus.armors.special.mob;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import sokratis12GR.ArmorPlus.ArmorPlus;
import sokratis12GR.ArmorPlus.resources.ConfigHandler;
import sokratis12GR.ArmorPlus.util.TextHelper;

import java.util.List;

public class SlimeArmor {

    public SlimeArmor() {
    }

    public static Item helmet;
    public static Item chestplate;
    public static Item legs;
    public static Item boots;
    public Object instance;

    public void load(FMLInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {
            ModelLoader.setCustomModelResourceLocation(helmet, 0,
                    new ModelResourceLocation(ArmorPlus.MODID + ":" + "SlimeHelmet", "inventory"));
            ModelLoader.setCustomModelResourceLocation(chestplate, 0,
                    new ModelResourceLocation(ArmorPlus.MODID + ":" + "SlimeChestplate", "inventory"));
            ModelLoader.setCustomModelResourceLocation(legs, 0,
                    new ModelResourceLocation(ArmorPlus.MODID + ":" + "SlimeLeggings", "inventory"));
            ModelLoader.setCustomModelResourceLocation(boots, 0,
                    new ModelResourceLocation(ArmorPlus.MODID + ":" + "SlimeBoots", "inventory"));
        }
        if (ConfigHandler.easyMode && ConfigHandler.enableSlimeArmorRecipes) {
            GameRegistry.addRecipe(new ItemStack(helmet, 1), new Object[]
                    {"XXX", "SSS", "SXS", Character.valueOf('S'), new ItemStack(Items.SLIME_BALL, 1)});
            GameRegistry.addRecipe(new ItemStack(helmet, 1), new Object[]
                    {"SSS", "SXS", "XXX", Character.valueOf('S'), new ItemStack(Items.SLIME_BALL, 1)});
            GameRegistry.addRecipe(new ItemStack(chestplate, 1), new Object[]
                    {"SXS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(Items.SLIME_BALL, 1)});
            GameRegistry.addRecipe(new ItemStack(legs, 1), new Object[]
                    {"SSS", "SXS", "SXS", Character.valueOf('S'), new ItemStack(Items.SLIME_BALL, 1)});
            GameRegistry.addRecipe(new ItemStack(boots, 1), new Object[]
                    {"XXX", "SXS", "SXS", Character.valueOf('S'), new ItemStack(Items.SLIME_BALL, 1)});
            GameRegistry.addRecipe(new ItemStack(boots, 1), new Object[]
                    {"SXS", "SXS", "XXX", Character.valueOf('S'), new ItemStack(Items.SLIME_BALL, 1)});
        }
        if (ConfigHandler.expertMode && ConfigHandler.enableSlimeArmorRecipes) {
            GameRegistry.addRecipe(new ItemStack(helmet, 1), new Object[]
                    {"XXX", "SSS", "SXS", Character.valueOf('S'), new ItemStack(Item.getItemFromBlock(Blocks.SLIME_BLOCK), 1)});
            GameRegistry.addRecipe(new ItemStack(helmet, 1), new Object[]
                    {"SSS", "SXS", "XXX", Character.valueOf('S'), new ItemStack(Item.getItemFromBlock(Blocks.SLIME_BLOCK), 1)});
            GameRegistry.addRecipe(new ItemStack(chestplate, 1), new Object[]
                    {"SXS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(Item.getItemFromBlock(Blocks.SLIME_BLOCK), 1)});
            GameRegistry.addRecipe(new ItemStack(legs, 1), new Object[]
                    {"SSS", "SXS", "SXS", Character.valueOf('S'), new ItemStack(Item.getItemFromBlock(Blocks.SLIME_BLOCK), 1)});
            GameRegistry.addRecipe(new ItemStack(boots, 1), new Object[]
                    {"XXX", "SXS", "SXS", Character.valueOf('S'), new ItemStack(Item.getItemFromBlock(Blocks.SLIME_BLOCK), 1)});
            GameRegistry.addRecipe(new ItemStack(boots, 1), new Object[]
                    {"SXS", "SXS", "XXX", Character.valueOf('S'), new ItemStack(Item.getItemFromBlock(Blocks.SLIME_BLOCK), 1)});
        }
        helmet.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
        chestplate.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
        legs.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
        boots.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
    }

    public void preInit(FMLPreInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {
            ModelLoader.setCustomModelResourceLocation(helmet, 0,
                    new ModelResourceLocation(ArmorPlus.MODID + ":" + "SlimeHelmet", "inventory"));
            ModelLoader.setCustomModelResourceLocation(chestplate, 0,
                    new ModelResourceLocation(ArmorPlus.MODID + ":" + "SlimeChestplate", "inventory"));
            ModelLoader.setCustomModelResourceLocation(legs, 0,
                    new ModelResourceLocation(ArmorPlus.MODID + ":" + "SlimeLeggings", "inventory"));
            ModelLoader.setCustomModelResourceLocation(boots, 0,
                    new ModelResourceLocation(ArmorPlus.MODID + ":" + "SlimeBoots", "inventory"));
        }
    }

    public void registerRenderers() {
    }

    static {
        ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("SLIMEARMOR", ArmorPlus.MODID + ":" + "SlimeArmor", 3, new int[]
                {1, 1, 2, 1}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);

        int armorPreffix = 0;
        helmet = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.HEAD) {
            @Override
            public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
                tooltip.add(TextHelper.getFormattedText("&a" + "Gives you Jump Boost 3"));
            }

            public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
            }

            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return (TextFormatting.GREEN + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
            }

            public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
                return repair.getItem() == Items.SLIME_BALL;
            }
        }).setUnlocalizedName("SlimeHelmet");
        helmet.setMaxStackSize(1);
        chestplate = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.CHEST) {
            @Override
            public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
                tooltip.add(TextHelper.getFormattedText("&a" + "Gives you Jump Boost 3"));
            }

            public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
            }

            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return (TextFormatting.GREEN + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
            }

            public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
                return repair.getItem() == Items.SLIME_BALL;
            }
        }).setUnlocalizedName("SlimeChestplate");
        chestplate.setMaxStackSize(1);
        legs = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.LEGS) {
            @Override
            public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
                tooltip.add(TextHelper.getFormattedText("&a" + "Gives you Jump Boost 3"));
            }

            public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
            }

            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return (TextFormatting.GREEN + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
            }

            public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
                return repair.getItem() == Items.SLIME_BALL;
            }
        }).setUnlocalizedName("SlimeLeggings");
        legs.setMaxStackSize(1);
        boots = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.FEET) {
            @Override
            public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
                tooltip.add(TextHelper.getFormattedText("&a" + "Gives you Jump Boost 3"));
            }

            public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
            }

            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return (TextFormatting.GREEN + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
            }

            public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
                return repair.getItem() == Items.SLIME_BALL;
            }
        }).setUnlocalizedName("SlimeBoots");
        boots.setMaxStackSize(1);

        GameRegistry.registerItem(helmet, "SlimeHelmet");
        GameRegistry.registerItem(chestplate, "SlimeChestplate");
        GameRegistry.registerItem(legs, "SlimeLeggings");
        GameRegistry.registerItem(boots, "SlimeBoots");

    }

}

