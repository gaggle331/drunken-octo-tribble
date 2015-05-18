package babbies.mod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import babbies.mod.blocks.ModBlocks;
import babbies.mod.reference.Reference;

public class DoopBrew extends Item implements LeopoldItem
{
	private final String name = "doopbrew";
	public DoopBrew()
	{
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(Reference.MODID + "_" + name);
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
	
	public String getName()
	{
		return this.getUnlocalizedName().substring(13);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		pos = pos.offset(side);

		if (!playerIn.canPlayerEdit(pos, side, stack)) {
			return false;
		}
		else {
			if (worldIn.isAirBlock(pos)) {
				worldIn.playSoundEffect(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
				worldIn.setBlockState(pos, ModBlocks.doopFire.getDefaultState());
			}

			stack.damageItem(1, playerIn);
			return true;
		}
	}
}