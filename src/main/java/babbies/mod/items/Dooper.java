package babbies.mod.items;

import babbies.mod.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Dooper extends Item implements LeopoldItem
{
	private final String name = "dooper";
	public Dooper()
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