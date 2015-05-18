package babbies.mod.generation;

import babbies.mod.Leopold;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;

public class LeopoldWorldProvider extends WorldProvider {

	@Override
	public String getDimensionName() {
		return "Doop World";
	}

	@Override
	public String getInternalNameSuffix() {
		return "Doop";
	}

	@Override
	public boolean canRespawnHere(){
		return false;
	}
	
	public void registerWorldChunkManager(){
		this.worldChunkMgr = new WorldChunkManagerHell(Leopold.doopBiome, 0.2f);
		this.dimensionId = Leopold.doopDimID;
	}
}
