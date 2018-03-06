package soupbubbles.minecraftboom.block.base;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.util.IBlockMeta;

public abstract class BlockSlabBase extends BlockSlab implements IBlockMeta
{
    protected final String BASE_NAME;

    public BlockSlabBase(Material material, String name)
    {
        super(material);
        IBlockState iblockstate = blockState.getBaseState();

        if (!isDouble())
        {
            iblockstate = iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
        }

        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_STAIRS_AND_SLABS_TAB);

        useNeighborBrightness = true;
        BASE_NAME = name;
    }

    @Override
    public String getSpecialName(int meta)
    {
        return getUnlocalizedName(meta);
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return isDouble() ? getStateFromMeta(meta) : facing != EnumFacing.DOWN && (facing == EnumFacing.UP || hitY <= 0.5D) ? getStateFromMeta(meta).withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM) : getStateFromMeta(meta).withProperty(HALF, BlockSlab.EnumBlockHalf.TOP);
    }
    
    @Override
    public String getVariantName()
    {
        return Assets.VARIANT_NAME_VARIANT;
    }
}
