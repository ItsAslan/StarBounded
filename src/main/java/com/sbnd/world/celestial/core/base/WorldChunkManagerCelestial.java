package com.sbnd.world.celestial.core.base;

import com.sbnd.world.celestial.core.data.IGenData;
import lombok.Getter;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;

import java.util.ArrayList;
import java.util.List;

public class WorldChunkManagerCelestial extends WorldChunkManager {

    @Getter
    private IGenData data;

    public WorldChunkManagerCelestial(IGenData data) {
        this.data = data;
    }

    @Override
    public List<BiomeGenBase> getBiomesToSpawnIn() {
        return new ArrayList<>(data.biomes);
    }

}
