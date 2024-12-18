package soupbubbles.vanillaplus.block;

import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import soupbubbles.vanillaplus.creativetab.CreativeTab;
import soupbubbles.vanillaplus.lib.Assets;

public class BlockWoodenTrapDoor extends BlockTrapDoor
{
    protected final String BASE_NAME;

    public BlockWoodenTrapDoor(String name)
    {
        super(Material.WOOD);
        setRegistryName(name);
        setUnlocalizedName(name);
        setHardness(3.0F);
        setSoundType(SoundType.WOOD);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_TAB);
        
        BASE_NAME = name;
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BASE_NAME);
    }
}
