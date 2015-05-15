package babbies.mod.init;
import net.minecraft.block.Block;
import babbies.mod.blocks.DooperBlock;
import babbies.mod.help.RegisterHelper;

public class ModBlocks {
	
	public static void registerBlocks()
	{
		DooperBlock();
		
	}

	public static void registerBlockRenderer()
	{
		RegisterHelper.registerBlockRenderer(dooperBlock);
		
	}

}
