/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.armorplus.blocks.base;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thedragonteam.armorplus.ArmorPlus;

import javax.annotation.Nonnull;

import static net.thedragonteam.armorplus.util.Utils.setName;
import static net.thedragonteam.armorplus.util.Utils.setRL;

/**
 * @author Sokratis Fotkatzikis - TheDragonTeam
 */
public class BaseEnergyBlock extends BlockContainer {

    private TileEntity tileEntity;

    public BaseEnergyBlock(Material material, String name, float resistance, float hardness, TileEntity tileEntityIn) {
        this(material, name, resistance, hardness, null, 0, tileEntityIn);
    }

    public BaseEnergyBlock(Material material, String name, float resistance, float hardness, String tool, int harvestLevel, TileEntity tileEntityIn) {
        this(material, name, resistance, hardness, tool, harvestLevel, 0F, tileEntityIn);
    }

    public BaseEnergyBlock(Material material, String name, float resistance, float hardness, String tool, int harvestLevel, float lightLevel, TileEntity tileEntityIn) {
        super(material);
        this.setUnlocalizedName(setName(name));
        this.setRegistryName(setRL(name));
        this.tileEntity = tileEntityIn;
        this.setResistance(resistance);
        this.setHardness(hardness);
        this.setHarvestLevel(tool, harvestLevel);
        this.setLightLevel(lightLevel);
        this.setCreativeTab(ArmorPlus.tabArmorplusBlocks);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isFullCube(IBlockState state) {
        return true;
    }

    @Override
    @Nonnull
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @Nonnull
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.SOLID;
    }

    @Override
    public TileEntity createNewTileEntity(@Nonnull World worldIn, int meta) {
        return this.tileEntity;
    }
}
