package babbies.mod.proxies;

import babbies.mod.blocks.Blocks;
import babbies.mod.generation.LeopoldWorldGeneration;
import babbies.mod.handler.LeopoldCraftingHandler;
import babbies.mod.handler.LeopoldEventHandler;
import babbies.mod.items.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void registerRenderers ()
	{
		
	}

	public void preInit(FMLPreInitializationEvent event) {
		Blocks.addBlocks();
		Items.addItems();
		LeopoldEventHandler handler = new LeopoldEventHandler();
		MinecraftForge.EVENT_BUS.register(handler);
		FMLCommonHandler.instance().bus().register(handler);
		LeopoldCraftingHandler.init();
	}

	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new LeopoldWorldGeneration(), 1);
	}

	public void postInit(FMLPostInitializationEvent event) {
		// TODO Auto-generated method stub
		
	}

}
