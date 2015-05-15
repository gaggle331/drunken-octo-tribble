package babbies.mod.items;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import babbies.mod.help.Reference;

public class RenderItemRegister {
	
	public static void registerItemIcons(){
		registerItem(Items.dooper, 0);
		registerItem(Items.doop, 0);
	}
	
	private static void registerItem(Item item, int meta) {
		if(item instanceof Item){
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(Reference.MODID + ":" + ((LeopoldItem) item).getName(), "inventory"));
		}
		
	}
	
}
