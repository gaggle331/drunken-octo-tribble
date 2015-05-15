package babbies.mod.handler;

import babbies.mod.items.*;
import babbies.mod.blocks.*;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class LeopoldCraftingHandler {
	//TODO: Add Crafting Recipes here and add call in CommonProxy to initialize
	public static void init(){

		GameRegistry.addRecipe(new ItemStack(Blocks.doopblock),
				"AAA",
				"AAA",
				"AAA",
				'A', Items.doop
				);
	}
}
