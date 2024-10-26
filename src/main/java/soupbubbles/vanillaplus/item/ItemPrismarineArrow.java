package soupbubbles.vanillaplus.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import soupbubbles.vanillaplus.creativetab.CreativeTab;
import soupbubbles.vanillaplus.entity.EntityPrismarineArrow;
import soupbubbles.vanillaplus.lib.Assets;
import soupbubbles.vanillaplus.lib.Names;
import soupbubbles.vanillaplus.util.Utils;

public class ItemPrismarineArrow extends ItemArrow
{
    public ItemPrismarineArrow()
    {
        setRegistryName(Names.ITEM_PRISMARINE_ARROW);
        setUnlocalizedName(Names.ITEM_PRISMARINE_ARROW);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_TAB);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return String.format(Assets.ITEM_PREFIX, Assets.ASSET_PREFIX, Names.ITEM_PRISMARINE_ARROW);
    }

    @Override
    public EntityArrow createArrow(World world, ItemStack stack, EntityLivingBase shooter)
    {
        return new EntityPrismarineArrow(world, shooter);
    }

    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, EntityPlayer player)
    {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.init.Enchantments.INFINITY, bow);
        return enchant <= 0 ? false : this.getClass() == ItemPrismarineArrow.class;
    }
}
