package babbies.mod.help;

public static void registerBlock(Block block)
{
	GameRegistry.registerBlock(block, block.getUnlocalizedName() .substring(5));
}

public static void registerItem(Item item)
{
	GameRegistry.registerItem(item, item.getUnlocalizedName() .substring(5));
}

public static void registerItemRenderer(Item item)
{
	Minecraft.getMinecraft() .getRenderItem() .getItemModeMesher() .register(item, 0, 
new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName() .substring(5), "inventory"));
}

public static void registerBlockRenderer(Block block)
{
	Item item = Item.getItemFromBlock(block);
	Minecraft.getMinecraft() .getRenderItem() .getItemModelMesher() .register(item, 0,
new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName() .substring(5),
"inventory"));
}

public class RegisterHelper {

}
