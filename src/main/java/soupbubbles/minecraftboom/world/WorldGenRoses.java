package soupbubbles.minecraftboom.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import soupbubbles.minecraftboom.block.BlockRose;
import soupbubbles.minecraftboom.init.ModBlocks;

public class WorldGenRoses extends WorldGenerator
{
    private Block rose = ModBlocks.BLOCK_ROSE;
    private IBlockState state = rose.getDefaultState();
    
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255) && ((BlockRose) rose).canBlockStay(worldIn, blockpos, state))
            {
                worldIn.setBlockState(blockpos, state, 2);
            }
        }

        return true;
    }
}