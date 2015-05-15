package babbies.mod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import babbies.mod.generation.LeopoldWorldGeneration;
import babbies.mod.proxies.CommonProxy;
import babbies.mod.reference.Reference;
import babbies.mod.reference.RegisterHelper;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)

public class Leopold 
{
	@Instance(Reference.MODID)
	public static Leopold instance;
	LeopoldWorldGeneration eventWorldGen = new LeopoldWorldGeneration();
	public static RegisterHelper registerHelper;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide =
			Reference.COMMON_PROXY)
	public static CommonProxy proxy;

	
	@Mod.EventHandler
	public void preInit (FMLPreInitializationEvent event)
	{
		proxy.preInit(event);

	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init(event);
		GameRegistry.registerWorldGenerator(this.eventWorldGen, 1);
/*		GameRegistry.addRecipe(new ItemStack(Blocks.obsidian),
    		"AAA",
    		"AAA",
    		"AAA",
    		'A', Items.cookie
		);
		
		GameRegistry.addRecipe(new ItemStack(dooperItem, 4),
		    	"AA",
		    	"AA",
		    	'A', Blocks.cobblestone
		);
		
		GameRegistry.addRecipe(new ItemStack(Items.dye, 2, 15), 
		    	"AB ",
		    	"AAC",
		    	"A  ",
		    	'A', Items.cookie, 'B', Blocks.dirt, 'C', new ItemStack(Items.dye, 1, 1)
		);*/
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}

}

//How is babby formed