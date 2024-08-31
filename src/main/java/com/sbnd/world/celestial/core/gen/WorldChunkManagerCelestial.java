package com.sbnd.world.celestial.core.gen;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;

import java.util.Arrays;
import java.util.List;

public class WorldChunkManagerCelestial extends WorldChunkManager {

    public WorldChunkManagerCelestial(World world, BiomeGenBase... biomes) {

        super(world);

        allowedBiomes.clear();

        allowedBiomes.addAll(Arrays.asList(biomes));

    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getBiomesToSpawnIn() {

        return allowedBiomes;

    }

}