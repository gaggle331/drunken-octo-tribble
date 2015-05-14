package babbies.mod.init;

public static void registerItems()
{
	RegisterHelper.registerItem(dooper);
	
}

public static void registerItemRenderer()
{
	RegisterHelper.registerItemRenderer(dooper);
	
}

public static Item dooper = new ItemLeopold() .setUnlocalizedName("dooper");

public class ModItems {

}
