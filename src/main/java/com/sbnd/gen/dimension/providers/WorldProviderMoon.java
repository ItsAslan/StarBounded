package com.sbnd.gen.dimension.providers;

import com.sbnd.gen.biome.ModBiomes;
import com.sbnd.gen.dimension.DimensionRegistry;
import com.sbnd.gen.dimension.NoCloudRenderer;
import com.sbnd.enums.EnumPlanet;
import com.sbnd.lib.Library;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderMoon extends WorldProvider
{

    private final String name = Library.getPlanetName(EnumPlanet.MOON);

    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new WorldChunkManagerHell(ModBiomes.moonBiome, 1.2f);
        this.dimensionId = Library.getPlanetId(EnumPlanet.MOON);
        setCloudRenderer(new NoCloudRenderer());
    }

    public IChunkProvider createChunkGeneration()
    {
        return null;
    }

    @Override
    public String getDimensionName() {
        return name;
    }

}
