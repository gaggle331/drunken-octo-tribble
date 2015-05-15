package babbies.mod.handler;

import java.util.Random;

import babbies.mod.blocks.Blocks;
import babbies.mod.items.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LeopoldEventHandler {
	@SubscribeEvent
	public void onDooperOreDrop(BlockEvent.HarvestDropsEvent event){
		if (event.state.getBlock() == Blocks.dooperoreblock){
			event.drops.clear();
			event.dropChance=1.0f;
			Random rand = new Random();
			for(int i=1; i<3; i++){
				int chance = rand.nextInt(5)+1;
				if(chance == 1){
					event.drops.add(new ItemStack(Items.doop));
				}
			}
			event.drops.add(new ItemStack(Items.doop));
			event.drops.add(new ItemStack(Items.doop));
		}
	}
}
