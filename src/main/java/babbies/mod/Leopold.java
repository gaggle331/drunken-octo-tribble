package babbies.mod;

import babbies.mod.help.Reference;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
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

public class Leopold 
{
	
}

//How is babby formed