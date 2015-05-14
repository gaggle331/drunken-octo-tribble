package babbies.mod.proxies;

import babbies.mod.init.ModItems;


public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderers ()
	{
		ModItems.registerItemRenderer();
	}
}
