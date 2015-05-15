package babbies.mod.proxies;

import babbies.mod.blocks.Blocks;
import babbies.mod.items.Items;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void registerRenderers ()
	{
		
	}

	public void preInit(FMLPreInitializationEvent event) {
		Items.addItems();
		Blocks.addBlocks();
		
	}

	public void init(FMLInitializationEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void postInit(FMLPostInitializationEvent event) {
		// TODO Auto-generated method stub
		
	}

}
