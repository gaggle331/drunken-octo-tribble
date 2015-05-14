package babbies.mod.proxies;

public void registerRenderers ()
{
	
}

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderers ()
	{
		ModItems.registerItemRenderer();
	}
}
