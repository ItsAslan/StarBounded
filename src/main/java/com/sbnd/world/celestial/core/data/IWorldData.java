package com.sbnd.world.celestial.core.data;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Set;

public interface IWorldData {

    String getName();

    WorldProvider getWorldProvider();

    IChunkProvider getChunkProvider();

    WorldChunkManagerHell getChunkManager();

    Set<BiomeGenBase> getBiomes();

}
