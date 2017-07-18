/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.armorplus.compat.tinkers;

import net.thedragonteam.armorplus.compat.tinkers.modifiers.TiCModifiers;
import net.thedragonteam.armorplus.compat.tinkers.modifiers.TiCTraits;
import net.thedragonteam.armorplus.compat.tinkers.parts.APItemCore;
import net.thedragonteam.armorplus.compat.tinkers.parts.APItemPart;
import net.thedragonteam.armorplus.compat.tinkers.parts.Helmet;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.shared.TinkerFluids;
import slimeknights.tconstruct.tools.AbstractToolPulse;
import slimeknights.tconstruct.tools.TinkerMaterials;

import static net.thedragonteam.armorplus.compat.tinkers.TinkersUtils.registerItemPart;
import static net.thedragonteam.armorplus.compat.tinkers.TinkersUtils.registerToolForgeCrafting;
import static slimeknights.tconstruct.library.TinkerRegistry.getMaterial;

public class TiC extends AbstractToolPulse {

    public static TiCModifiers tinkersModifiers;
    public static TiCMaterials tinkersMaterials;
    public static MaterialIntegration lavacrystalInt = new MaterialIntegration(TiCMaterials.lavacrystal);
    public static MaterialIntegration steelInt = new MaterialIntegration(TinkerMaterials.steel, TinkerFluids.steel);
    public static MaterialIntegration obsidianInt = new MaterialIntegration(TiCMaterials.compressed_obsidian);
    public static MaterialIntegration infusedObsidianInt = new MaterialIntegration(TiCMaterials.lava_infused_obsidian);
    public static TiCTraits tinkersTraits;
    public static APItemPart helmetRight;
    public static APItemPart helmetMiddle;
    public static APItemPart helmetLeft;
    public static APItemCore helmet;
    public static final Category ARMOR = new Category("armor");


    public static void preInit() {
        tinkersTraits = new TiCTraits();
        tinkersMaterials = new TiCMaterials();
        intMaterials(lavacrystalInt);
        intMaterials(infusedObsidianInt);
        intMaterials(obsidianInt);
        if (getMaterial("steel") == null) intMaterials(steelInt);
        tinkersModifiers = new TiCModifiers();
        tinkersMaterials.setupMaterials();
    }

    public static void init() {
    }

    public static void postInit() {
        tinkersMaterials.postInit();
        initRepresentativeItem(lavacrystalInt, "blockInfusedLavaCrystal");
        initRepresentativeItem(infusedObsidianInt, "blockLavaInfusedObsidian");
        initRepresentativeItem(obsidianInt, "blockCompressedObsidian");
    }

    public static void registerItems() {
        helmet = registerItem(new Helmet(), "helmet");
        registerToolForgeCrafting(helmet);
        helmetRight = registerItemPart(new APItemPart(Material.VALUE_Ingot * 2), "helmet_right");
        helmetMiddle = registerItemPart(new APItemPart(Material.VALUE_Ingot), "helmet_middle");
        helmetLeft = registerItemPart(new APItemPart(Material.VALUE_Ingot * 2), "helmet_left");
    }

    public static void intMaterials(MaterialIntegration material) {
        material.toolforge();
        material.integrate();
    }

    public static void initRepresentativeItem(MaterialIntegration material, String oreDictItem) {
        material.setRepresentativeItem(oreDictItem);
        material.registerRepresentativeItem();
    }
}