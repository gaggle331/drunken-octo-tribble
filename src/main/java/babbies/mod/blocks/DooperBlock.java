package babbies.mod.blocks;


import babbies.mod.help.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DooperBlock extends Block
{
	private final String name = "dooperBlock";
	
	public DooperBlock()
	{
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setHarvestLevel("pickaxe",3);
		setStepSound(soundTypeStone);
		setHardness(2.5F);
		setResistance(10.0F);
		setCreativeTab(CreativeTabs.tabBlock);
		this.setUnlocalizedName(Reference.MODID + "_" + name);
	}
	
	public int getRenderType() {
		return 3;
	}
	
	public String getName(){
		return this.getUnlocalizedName().substring(5);
	}
}