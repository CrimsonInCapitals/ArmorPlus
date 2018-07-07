package net.thedragonteam.armorplus.blocks.castle.base;

import net.minecraft.block.BlockWall;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thedragonteam.armorplus.ArmorPlus;
import net.thedragonteam.armorplus.iface.IModdedBlock;

import static net.thedragonteam.armorplus.util.Utils.setName;
import static net.thedragonteam.armorplus.util.Utils.setRL;
import static net.thedragonteam.thedragonlib.util.ItemStackUtils.getItemStack;

/**
 * @author Sokratis Fotkatzikis - TheDragonTeam
 */
public class BlockStonebrickWall extends BlockWall implements IModdedBlock {

    private BlockStoneBrick stoneBricks;

    public BlockStonebrickWall(BlockStoneBrick modelState) {
        super(modelState);
        this.stoneBricks = modelState;
        this.setRegistryName(setRL(stoneBricks.name + "_wall"));
        this.setUnlocalizedName(setName(stoneBricks.name + "_wall"));
        this.setResistance(10f);
        this.setHardness(5f);
        this.setCreativeTab(ArmorPlus.tabArmorplusBlocks);
    }

    @SuppressWarnings("deprecation")
    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return this.stoneBricks.color;
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        items.add(getItemStack(this));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void initModel() {
        this.initModel("stone_bricks", 0);
    }

}

