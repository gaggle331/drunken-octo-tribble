package babbies.mod.blocks;

import babbies.mod.reference.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public final class Blocks {
	
	public static Block dooperoreblock;
	public static Block doopblock;
	
	public static void addBlocks(){
		dooperoreblock = new DooperOreBlock(BlockNames.dooperoreblock, Material.iron, 2.5F, 10.0F);
		doopblock = new DoopBlock(BlockNames.doopblock, Material.iron, 2.5F, 10.0F);
	}
}
