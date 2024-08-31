package com.sbnd.world.celestial.bodies.moon;

import com.sbnd.world.biome.SbndBiomes;
import com.sbnd.world.biome.biomes.moon.BiomeGenMoonFlats;
import com.sbnd.world.biome.biomes.moon.BiomeGenMoonIceCap;
import com.sbnd.world.celestial.core.bodies.CelestialBody;
import com.sbnd.world.celestial.core.gen.SkyRendererCelestial;
import com.sbnd.world.celestial.core.gen.WorldProviderCelestial;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;

public class WorldProviderMoon extends WorldProviderCelestial {

    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderMoon(worldObj, getSeed(), false);
    }

    @Override
    protected void registerWorldChunkManager() {

        /*
       worldChunkMgr = new WorldChunkManagerCelestial(worldObj,
               new BiomeGenMoonFlats(SbndBiomes.moonFlats.biomeID)
               //new BiomeGenMoonBasaltPlains(SbndBiomes.moonBasaltPlains.biomeID),
               //new BiomeGenMoonIceCap(SbndBiomes.moonIceCap.biomeID)
       )
         */

        worldChunkMgr = new WorldChunkManagerHell(new BiomeGenMoonFlats(SbndBiomes.moonFlats.biomeID), dimensionId);

    }

    @Override
    public IRenderHandler getSkyRenderer() {
        return new SkyRendererCelestial(CelestialBody.getBody("Moon"));
    }

    @Override
    public String getFogString() {
        return "0x171717";
    }

    @Override
    public String getDimensionName() {
        return "Moon";
    }

}
