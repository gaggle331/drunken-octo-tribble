package babbies.mod.items;

import babbies.mod.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Doop extends Item implements LeopoldItem
{
	private final String name = "doop";
	public Doop()
	{
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(Reference.MODID + "_" + name);
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
	
	public String getName()
	{
		return this.getUnlocalizedName().substring(13);
	}
}