package babbies.mod.init;
import net.minecraft.item.Item;
import babbies.mod.help.RegisterHelper;
import babbies.mod.items.ItemLeopold;

public class ModItems {

	public static void registerItems()
	{
		RegisterHelper.registerItem(dooper);
		
	}

	public static void registerItemRenderer()
	{
		RegisterHelper.registerItemRenderer(dooper);
		
	}

	public static Item dooper = new ItemLeopold() .setUnlocalizedName("dooper");
}
