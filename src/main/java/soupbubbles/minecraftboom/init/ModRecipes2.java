package soupbubbles.minecraftboom.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import soupbubbles.minecraftboom.util.JsonRecipeGenerator;

public class ModRecipes2
{

    public static void init()
    {
        JsonRecipeGenerator.init();
        
        initFurnaceRecipes();
        initBrewingRecipes();
    }

    private static void initFurnaceRecipes()
    {
        GameRegistry.addSmelting(Blocks.SOUL_SAND, new ItemStack(ModBlocks.BLOCK_SOUL_GLASS), 0.0F);
        GameRegistry.addSmelting(Blocks.PUMPKIN, new ItemStack(Items.DYE, 1, EnumDyeColor.ORANGE.getDyeDamage()), 0.1F);
    }

    private static void initBrewingRecipes()
    {
    }
}