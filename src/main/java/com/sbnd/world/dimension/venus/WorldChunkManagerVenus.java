package com.sbnd.world.dimension.venus;

import com.sbnd.world.biome.ModBiomes;
import net.minecraft.world.biome.WorldChunkManagerHell;

public class WorldChunkManagerVenus  extends WorldChunkManagerHell
{

    public WorldChunkManagerVenus() {
        super(ModBiomes.venusBiome, 0.0f);
    }

}
