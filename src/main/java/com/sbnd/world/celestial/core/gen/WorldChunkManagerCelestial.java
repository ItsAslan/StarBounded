package com.sbnd.world.celestial.core.gen;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorldChunkManagerCelestial extends WorldChunkManager {

    protected ArrayList<BiomeGenBase> biomeList;

    public WorldChunkManagerCelestial(World world, BiomeGenBase... biomes) {

        super(world);

        biomeList = new ArrayList<>();

        biomeList.addAll(Arrays.asList(biomes));

    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getBiomesToSpawnIn() {

        return biomeList;

    }

}