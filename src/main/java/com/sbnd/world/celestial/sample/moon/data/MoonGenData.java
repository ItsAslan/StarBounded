package com.sbnd.world.celestial.sample.moon.data;

import com.sbnd.content.block.ModBlocks;
import com.sbnd.world.celestial.core.data.IGenData;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MoonGenData implements IGenData {

    @Override
    public Map<Block, Integer> getBlocksToWeight() {

        Map<Block, Integer> blocks = new HashMap<>();

        blocks.put(ModBlocks.blockMoonTurf, 1);

        return blocks;

    }

    @Override
    public Set<BiomeGenBase> getBiomes() {

        Set<BiomeGenBase> biomes = new HashSet<>();

        biomes.add(BiomeGenBase.desert);

        return biomes;

    }

}
