package com.sbnd.world.dimension.moon;

import com.sbnd.world.biome.ModBiomes;
import net.minecraft.world.biome.WorldChunkManagerHell;

public class WorldChunkManagerMoon extends WorldChunkManagerHell
{

    public WorldChunkManagerMoon() {
        super(ModBiomes.moonBiome, 0.0f);
    }

}
