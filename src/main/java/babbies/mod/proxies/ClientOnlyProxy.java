package babbies.mod.proxies;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import babbies.mod.blocks.RenderBlockRegister;
import babbies.mod.items.RenderItemRegister;


public class ClientOnlyProxy extends CommonProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
        RenderItemRegister.registerItemIcons();
        RenderBlockRegister.registerBlockIcons();
    }
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
}
