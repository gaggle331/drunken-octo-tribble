package babbies.mod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import babbies.mod.help.Reference;
import babbies.mod.init.ModItems;
import babbies.mod.proxies.CommonProxy;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)

public class Leopold 
{

	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide =
			Reference.COMMON_PROXY)
	public static CommonProxy proxy;

	@Instance(Reference.MODID)
	public static Leopold instance;
	
	@Mod.EventHandler
	public void preInit (FMLPreInitializationEvent event)
	{
		ModItems.registerItems();

	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{


	}

}

//How is babby formed