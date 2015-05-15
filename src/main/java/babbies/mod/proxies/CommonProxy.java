package babbies.mod.proxies;

import babbies.mod.blocks.Blocks;
import babbies.mod.handler.LeopoldCraftingHandler;
import babbies.mod.handler.LeopoldEventHandler;
import babbies.mod.items.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
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
		LeopoldEventHandler handler = new LeopoldEventHandler();
		MinecraftForge.EVENT_BUS.register(handler);
		FMLCommonHandler.instance().bus().register(handler);
		LeopoldCraftingHandler.init();
	}

	public void init(FMLInitializationEvent event) {
		
	}

	public void postInit(FMLPostInitializationEvent event) {
		// TODO Auto-generated method stub
		
	}

}
