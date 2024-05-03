package com.sbnd.world.dimension.mercury;

import com.sbnd.world.biome.ModBiomes;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;

public class WorldChunkManagerMercury extends WorldChunkManagerHell
{

    public WorldChunkManagerMercury() {
        super(ModBiomes.mercuryBiome, 0.0f);
    }

}
