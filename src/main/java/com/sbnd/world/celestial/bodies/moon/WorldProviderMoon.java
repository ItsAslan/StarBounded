package com.sbnd.world.celestial.bodies.moon;

import com.sbnd.world.biome.SbndBiomes;
import com.sbnd.world.biome.biomes.moon.BiomeGenMoonBasaltPlains;
import com.sbnd.world.biome.biomes.moon.BiomeGenMoonFlats;
import com.sbnd.world.biome.biomes.moon.BiomeGenMoonIceCap;
import com.sbnd.world.celestial.core.gen.WorldChunkManagerCelestial;
import com.sbnd.world.celestial.core.gen.WorldProviderCelestial;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderMoon extends WorldProviderCelestial {

    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderMoon(worldObj, getSeed(), false);
    }

    @Override
    protected void registerWorldChunkManager() {

       worldChunkMgr = new WorldChunkManagerCelestial(worldObj,
               new BiomeGenMoonFlats(SbndBiomes.moonFlats.biomeID),
               new BiomeGenMoonBasaltPlains(SbndBiomes.moonBasaltPlains.biomeID),
               new BiomeGenMoonIceCap(SbndBiomes.moonIceCap.biomeID)
       );

    }

    @Override
    public String getDimensionName() {
        return "Moon";
    }

}
