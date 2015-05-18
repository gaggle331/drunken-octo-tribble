package babbies.mod;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import babbies.mod.proxies.CommonProxy;
import babbies.mod.reference.Reference;
import babbies.mod.reference.RegisterHelper;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)

public class Leopold 
{
	@Instance(Reference.MODID)
	public static Leopold instance;
	public static RegisterHelper registerHelper;
	
	
	public static int doopDimID = 30;
	
	public static BiomeGenBase doopBiome;
	
	
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
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}

}

//How is babby formed