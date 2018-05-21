package soupbubbles.minecraftboom.creativetab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Ordering;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.init.ModItems;
import soupbubbles.minecraftboom.reference.Reference;

public class CreativeTab
{
    public static final CreativeTabs MINECRAFTBOOM_TAB = new CreativeTabs(Reference.MOD_ID + "_tab")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return getIcon(new ItemStack(ModBlocks.BLOCK_TERRACOTTA_BRICKS));
        }
        
        @SideOnly(Side.CLIENT)
        @Override
        public void displayAllRelevantItems(NonNullList<ItemStack> stack)
        {
            super.displayAllRelevantItems(stack);
        }
    };
    
    public static final CreativeTabs MINECRAFTBOOM_STAIRS_AND_SLABS_TAB = new CreativeTabs(Reference.MOD_ID + "_stairs_and_slabs_tab")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return getIcon(new ItemStack(ModBlocks.BLOCK_STAIRS_DARK_PRISMARINE));
        }
        
        @SideOnly(Side.CLIENT)
        @Override
        public void displayAllRelevantItems(NonNullList<ItemStack> stack)
        {
            super.displayAllRelevantItems(stack);
        }
    };
    
    private static ItemStack getIcon(ItemStack stack)
    {
        if (stack == null || stack.getItem() == null)
        {
            stack = new ItemStack(Blocks.DIRT);
        }
        
        return stack;
    }
}