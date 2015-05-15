package babbies.mod;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import babbies.mod.help.Reference;
import babbies.mod.help.RegisterHelper;
import babbies.mod.init.ModBlocks;
import babbies.mod.items.RenderItemRegister;
import babbies.mod.proxies.CommonProxy;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)

public class Leopold 
{
	public static Item dooperItem;
	public static Block dooperBlock;
	public static Item doopItem;

	public static RegisterHelper registerHelper;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide =
			Reference.COMMON_PROXY)
	public static CommonProxy proxy;

	@Instance(Reference.MODID)
	public static Leopold instance;
	
	@Mod.EventHandler
	public void preInit (FMLPreInitializationEvent event)
	{
		proxy.preInit(event);

	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init(event);
		GameRegistry.addRecipe(new ItemStack(Blocks.obsidian),
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
		);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}

}

//How is babby formed