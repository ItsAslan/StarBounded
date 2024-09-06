package com.sbnd.world.celestial.bodies.mars;

import com.sbnd.world.biome.SbndBiomes;
import com.sbnd.world.biome.biomes.mars.BiomeGenMarsFlats;
import com.sbnd.world.biome.biomes.moon.BiomeGenMoonFlats;
import com.sbnd.world.celestial.bodies.moon.ChunkProviderMoon;
import com.sbnd.world.celestial.core.bodies.CelestialBody;
import com.sbnd.world.celestial.core.gen.SkyRendererCelestial;
import com.sbnd.world.celestial.core.gen.WorldProviderCelestial;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;

public class WorldProviderMars extends WorldProviderCelestial {

    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderMars(worldObj, getSeed(), false);
    }

    @Override
    protected void registerWorldChunkManager() {

        worldChunkMgr = new WorldChunkManagerHell(new BiomeGenMarsFlats(SbndBiomes.moonFlats.biomeID), dimensionId);

    }

    @Override
    public IRenderHandler getSkyRenderer() {
        return new SkyRendererCelestial(CelestialBody.getBody("Mars"));
    }

    @Override
    public String getFogString() {
        return "0xcc7718";
    }

    @Override
    public String getDimensionName() {
        return "Mars";
    }

}
