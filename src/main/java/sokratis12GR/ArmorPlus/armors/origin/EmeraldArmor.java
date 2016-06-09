package sokratis12GR.ArmorPlus.armors.origin;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
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

public class EmeraldArmor {

    public EmeraldArmor() {
    }

    public static Item helmet;
    public static Item chestplate;
    public static Item legs;
    public static Item boots;
    public Object instance;

    public void load(FMLInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {

            ModelLoader.setCustomModelResourceLocation(helmet, 0,
                    new ModelResourceLocation("armorplus:EmeraldHelmet", "inventory"));
            ModelLoader.setCustomModelResourceLocation(chestplate, 0,
                    new ModelResourceLocation("armorplus:EmeraldChestplate", "inventory"));
            ModelLoader.setCustomModelResourceLocation(legs, 0,
                    new ModelResourceLocation("armorplus:EmeraldLeggings", "inventory"));
            ModelLoader.setCustomModelResourceLocation(boots, 0,
                    new ModelResourceLocation("armorplus:EmeraldBoots", "inventory"));
        }
        if (ConfigHandler.easyMode && ConfigHandler.enableEmeraldArmorRecipes) {
            GameRegistry.addRecipe(new ItemStack(helmet, 1), new Object[]
                    {"XXX", "EEE", "EXE", Character.valueOf('E'), new ItemStack(Items.EMERALD, 1),});
            GameRegistry.addRecipe(new ItemStack(helmet, 1), new Object[]
                    {"EEE", "EXE", "XXX", Character.valueOf('E'), new ItemStack(Items.EMERALD, 1),});
            GameRegistry.addRecipe(new ItemStack(chestplate, 1), new Object[]
                    {"EXE", "EEE", "EEE", Character.valueOf('E'), new ItemStack(Items.EMERALD, 1),});
            GameRegistry.addRecipe(new ItemStack(legs, 1), new Object[]
                    {"EEE", "EXE", "EXE", Character.valueOf('E'), new ItemStack(Items.EMERALD, 1),});
            GameRegistry.addRecipe(new ItemStack(boots, 1), new Object[]
                    {"XXX", "EXE", "EXE", Character.valueOf('E'), new ItemStack(Items.EMERALD, 1),});
            GameRegistry.addRecipe(new ItemStack(boots, 1), new Object[]
                    {"EXE", "EXE", "XXX", Character.valueOf('E'), new ItemStack(Items.EMERALD, 1),});
        }
        if (ConfigHandler.expertMode && ConfigHandler.enableEmeraldArmorRecipes) {
        GameRegistry.addRecipe(new ItemStack(helmet, 1), new Object[]
                {"XXX", "EEE", "EXE", Character.valueOf('E'), new ItemStack(Item.getItemFromBlock(Blocks.EMERALD_BLOCK), 1),});
        GameRegistry.addRecipe(new ItemStack(helmet, 1), new Object[]
                {"EEE", "EXE", "XXX", Character.valueOf('E'), new ItemStack(Item.getItemFromBlock(Blocks.EMERALD_BLOCK), 1),});
        GameRegistry.addRecipe(new ItemStack(chestplate, 1), new Object[]
                {"EXE", "EEE", "EEE", Character.valueOf('E'), new ItemStack(Item.getItemFromBlock(Blocks.EMERALD_BLOCK), 1),});
        GameRegistry.addRecipe(new ItemStack(legs, 1), new Object[]
                {"EEE", "EXE", "EXE", Character.valueOf('E'), new ItemStack(Item.getItemFromBlock(Blocks.EMERALD_BLOCK), 1),});
        GameRegistry.addRecipe(new ItemStack(boots, 1), new Object[]
                {"XXX", "EXE", "EXE", Character.valueOf('E'), new ItemStack(Item.getItemFromBlock(Blocks.EMERALD_BLOCK), 1),});
        GameRegistry.addRecipe(new ItemStack(boots, 1), new Object[]
                {"EXE", "EXE", "XXX", Character.valueOf('E'), new ItemStack(Item.getItemFromBlock(Blocks.EMERALD_BLOCK), 1),});
    }
        helmet.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
        chestplate.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
        legs.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
        boots.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
    }

    public void preInit(FMLPreInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {

            ModelLoader.setCustomModelResourceLocation(helmet, 0,
                    new ModelResourceLocation("armorplus:EmeraldHelmet", "inventory"));
            ModelLoader.setCustomModelResourceLocation(chestplate, 0,
                    new ModelResourceLocation("armorplus:EmeraldChestplate", "inventory"));
            ModelLoader.setCustomModelResourceLocation(legs, 0,
                    new ModelResourceLocation("armorplus:EmeraldLeggings", "inventory"));
            ModelLoader.setCustomModelResourceLocation(boots, 0,
                    new ModelResourceLocation("armorplus:EmeraldBoots", "inventory"));
        }
    }

    public void registerRenderers() {
    }

    static {

        ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("EMERALDARMOR", ArmorPlus.MODID + ":" + "EmeraldArmor", 35, new int[]
                {3, 6, 9, 4}, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);

        int armorPreffix = 0;
        helmet = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.HEAD) {
            @Override
            public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
                int emeraldArmorEffectlevel = ConfigHandler.emeraldArmorEffectlevel + 1;
                tooltip.add(TextHelper.getFormattedText("&2" + "Gives you Haste " + emeraldArmorEffectlevel));
            }

            public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
                if (ConfigHandler.enableEmeraldHHaste && entity instanceof EntityLivingBase && !ConfigHandler.enableFullEmeraldArmorEffect) {
                    ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.HASTE, 120, ConfigHandler.emeraldArmorEffectlevel, true, true));
                }
            }

            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return (TextFormatting.DARK_GREEN + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
            }

            public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
                return repair.getItem() == Items.EMERALD;
            }
        }).setUnlocalizedName("EmeraldHelmet");
        helmet.setMaxStackSize(1);

        chestplate = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.CHEST) {
            @Override
            public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
                int emeraldArmorEffectlevel = ConfigHandler.emeraldArmorEffectlevel + 1;
                tooltip.add(TextHelper.getFormattedText("&2" + "Gives you Haste " + emeraldArmorEffectlevel));
            }

            public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
                if (ConfigHandler.enableEmeraldCHaste && entity instanceof EntityLivingBase && !ConfigHandler.enableFullEmeraldArmorEffect) {
                    ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.HASTE, 120, ConfigHandler.emeraldArmorEffectlevel, true, true));
                }
            }

            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return (TextFormatting.DARK_GREEN + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
            }

            public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
                return repair.getItem() == Items.EMERALD;
            }
        }).setUnlocalizedName("EmeraldChestplate");
        chestplate.setMaxStackSize(1);

        legs = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.LEGS) {
            @Override
            public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
                int emeraldArmorEffectlevel = ConfigHandler.emeraldArmorEffectlevel + 1;
                tooltip.add(TextHelper.getFormattedText("&2" + "Gives you Haste " + emeraldArmorEffectlevel));
            }

            public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
                if (ConfigHandler.enableEmeraldLHaste && entity instanceof EntityLivingBase && !ConfigHandler.enableFullEmeraldArmorEffect) {
                    ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.HASTE, 120, ConfigHandler.emeraldArmorEffectlevel, true, true));
                }
            }

            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return (TextFormatting.DARK_GREEN + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
            }

            public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
                return repair.getItem() == Items.EMERALD;
            }
        }).setUnlocalizedName("EmeraldLeggings");
        legs.setMaxStackSize(1);

        boots = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.FEET) {
            @Override
            public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
                int emeraldArmorEffectlevel = ConfigHandler.emeraldArmorEffectlevel + 1;
                tooltip.add(TextHelper.getFormattedText("&2" + "Gives you Haste " + emeraldArmorEffectlevel));
            }

            public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
                if (ConfigHandler.enableEmeraldBHaste && entity instanceof EntityLivingBase && !ConfigHandler.enableFullEmeraldArmorEffect) {
                    ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.HASTE, 120, ConfigHandler.emeraldArmorEffectlevel, true, true));
                }
            }

            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return (TextFormatting.DARK_GREEN + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
            }

            public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
                return repair.getItem() == Items.EMERALD;
            }
        }).setUnlocalizedName("EmeraldBoots");
        boots.setMaxStackSize(1);

        GameRegistry.registerItem(helmet, "EmeraldHelmet");
        GameRegistry.registerItem(chestplate, "EmeraldChestplate");
        GameRegistry.registerItem(legs, "EmeraldLeggings");
        GameRegistry.registerItem(boots, "EmeraldBoots");

    }
}
