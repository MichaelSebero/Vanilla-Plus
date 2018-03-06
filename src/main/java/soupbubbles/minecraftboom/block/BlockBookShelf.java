package soupbubbles.minecraftboom.block;

import net.minecraft.block.BlockBookshelf;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.block.slab.BlockModSlab;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Names;
import soupbubbles.minecraftboom.util.IBlockMeta;

public class BlockBookShelf extends BlockBookshelf implements IBlockMeta
{
    public static final PropertyEnum<BlockBookShelf.EnumType> VARIANT = PropertyEnum.<BlockBookShelf.EnumType>create(Assets.VARIANT_NAME_VARIANT, BlockBookShelf.EnumType.class);
    
    protected final String BASE_NAME = Names.BLOCK_BOOKSHELF;

    public BlockBookShelf()
    {
        super();
        setDefaultState(blockState.getBaseState().withProperty(VARIANT, BlockBookShelf.EnumType.SPRUCE));
        setRegistryName(BASE_NAME);
        setUnlocalizedName(BASE_NAME);
        setHardness(2.0F);
        setResistance(5.0F);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_TAB);
        setSoundType(SoundType.WOOD);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BASE_NAME);
    }
    
    @Override
    public String getSpecialName(int meta)
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BlockBookShelf.EnumType.byMetadata(meta).getName() + "_" + BASE_NAME);
    }
    
    @Override
    public int damageDropped(IBlockState state)
    {
        return ((BlockBookShelf.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    
	@Override
	public float getEnchantPowerBonus(World world, BlockPos pos) 
	{
		return 1;
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        for (BlockBookShelf.EnumType blockbookshelf$enumtype : BlockBookShelf.EnumType.values())
        {
            list.add(new ItemStack(this, 1, blockbookshelf$enumtype.getMetadata()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(VARIANT, BlockBookShelf.EnumType.byMetadata(meta));
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return ((BlockBookShelf.EnumType)state.getValue(VARIANT)).getMapColor();
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockBookShelf.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }  

    @Override
    public PropertyEnum getVariants()
    {
        return VARIANT;
    }
    
    @Override
    public String getVariantName()
    {
        return Assets.VARIANT_NAME_VARIANT;
    }
    
    public static enum EnumType implements IStringSerializable
    {
        SPRUCE(0, Names.SPRUCE, MapColor.OBSIDIAN),
        BIRCH(1, Names.BIRCH, MapColor.SAND),
        JUNGLE(2, Names.JUNGLE, MapColor.DIRT),
        ACACIA(3, Names.ACACIA, MapColor.ADOBE),
        DARK_OAK(4, Names.DARK_OAK, MapColor.BROWN);

        private static final BlockBookShelf.EnumType[] META_LOOKUP = new BlockBookShelf.EnumType[values().length];
        private final int meta;
        private final String name;
        private final MapColor mapColor;

        private EnumType(int metaIn, String nameIn, MapColor mapColorIn)
        {
            meta = metaIn;
            name = nameIn;
            mapColor = mapColorIn;
        }

        public int getMetadata()
        {
            return meta;
        }

        public MapColor getMapColor()
        {
            return mapColor;
        }

        @Override
        public String toString()
        {
            return name;
        }

        public static BlockBookShelf.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        @Override
        public String getName()
        {
            return name;
        }

        static
        {
            for (BlockBookShelf.EnumType blockbookshelf$enumtype : values())
            {
                META_LOOKUP[blockbookshelf$enumtype.getMetadata()] = blockbookshelf$enumtype;
            }
        }
    }
}
