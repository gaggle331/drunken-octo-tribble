package babbies.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import babbies.mod.reference.Reference;

public class DooperOreBlock extends Block implements LeopoldBlocks
{
	
	public DooperOreBlock(String unlocalizedName, Material material, float localHardness, float localResistance)
	{
		super(material);
		GameRegistry.registerBlock(this, unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setUnlocalizedName(Reference.MODID + "_" + unlocalizedName);
		setHarvestLevel("pickaxe",3);
		setStepSound(soundTypeStone);
		setHardness(localHardness);
		setResistance(localResistance);
	}
	  
	@Override
	public int getRenderType() {
		return 3;
	}
	
	public String getName(){
		return this.getUnlocalizedName().substring(13);
	}
}