package babbies.mod.blocks;

import babbies.mod.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class RenderBlockRegister {

	public static void registerBlockIcons() {
		registerBlock(Blocks.dooperoreblock,0);
		registerBlock(Blocks.doopblock,0);
	}

	private static void registerBlock(Block block, int meta) {
		if(block instanceof LeopoldBlocks)
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(Reference.MODID + ":" + ((LeopoldBlocks)block).getName(), "normal"));
		System.out.println(Reference.MODID + ":" + ((LeopoldBlocks)block).getName());
	}

}
