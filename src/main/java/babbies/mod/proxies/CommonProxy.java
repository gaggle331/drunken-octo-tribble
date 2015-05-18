package babbies.mod.proxies;

import babbies.mod.Leopold;
import babbies.mod.blocks.ModBlocks;
import babbies.mod.generation.BiomeGenDoop;
import babbies.mod.generation.LeopoldWorldGeneration;
import babbies.mod.generation.LeopoldWorldProvider;
import babbies.mod.handler.LeopoldCraftingHandler;
import babbies.mod.handler.LeopoldEventHandler;
import babbies.mod.items.Items;
import net.minecraftforge.common.DimensionManager;
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
		
		//Register all Blocks and Items
		ModBlocks.addBlocks();
		Items.addItems();
		
		//Add Event Handler
		LeopoldEventHandler handler = new LeopoldEventHandler();
		MinecraftForge.EVENT_BUS.register(handler);
		FMLCommonHandler.instance().bus().register(handler);
		
		//Register Crafting Recipes
		LeopoldCraftingHandler.init();
		
		//Register New Dimensions
		DimensionManager.registerProviderType(Leopold.doopDimID, LeopoldWorldProvider.class, true);
		DimensionManager.registerDimension(Leopold.doopDimID, Leopold.doopDimID);
		
		Leopold.doopBiome = new BiomeGenDoop(100).setBiomeName("Doop Biome");
		
	}

	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new LeopoldWorldGeneration(), 1);
	}

	public void postInit(FMLPostInitializationEvent event) {
		// TODO Auto-generated method stub
		
	}

}
