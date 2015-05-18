package babbies.mod.blocks;

import babbies.mod.reference.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public final class ModBlocks {
	
	public static Block dooperoreblock;
	public static Block doopblock;
	public static Block compresseddoopblock;
	public static Block portalDoop;
	public static BlockDoopFire doopFire;
	
	public static void addBlocks(){
		dooperoreblock = new DooperOreBlock(BlockNames.dooperoreblock, Material.iron, 2.5F, 10.0F);
		doopblock = new DoopBlock(BlockNames.doopblock, Material.iron, 2.5F, 10.0F);
		compresseddoopblock= new CompressedDoopBlock(BlockNames.compresseddoopblock, Material.iron, 2.5F, 10.0F);
		portalDoop = new BlockPortalDoop(BlockNames.portalDoop, Material.iron, 2.5F, 10.0F);
		doopFire = new BlockDoopFire(BlockNames.doopFire);
	}
}
