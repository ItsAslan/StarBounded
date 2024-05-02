package com.sbnd.world.dimension.mars;

import com.sbnd.world.biome.ModBiomes;
import net.minecraft.world.biome.WorldChunkManagerHell;

public class WorldChunkManagerMars extends WorldChunkManagerHell
{

    public WorldChunkManagerMars() {
        super(ModBiomes.marsBiome, 0.0f);
    }

}
