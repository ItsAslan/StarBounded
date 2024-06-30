package com.sbnd.world.celestial.core.data;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public interface IGenData {

    // Block, Weight [1 is primary, 2 is secondary, 3... is everything else]
    Map<Block, Integer> getBlocksToWeight();

    Set<BiomeGenBase> getBiomes();

}