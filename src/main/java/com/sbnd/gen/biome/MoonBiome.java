package com.sbnd.gen.biome;

import com.sbnd.blocks.ModBlocks;
import net.minecraft.world.biome.BiomeGenBase;

public class MoonBiome extends BiomeGenBase
{
    public MoonBiome(int id) {
        super(id);
        topBlock = ModBlocks.blockMoonTurf;
        fillerBlock = ModBlocks.blockMoonTurf;
        spawnableMonsterList.clear();
        spawnableCreatureList.clear();
        setDisableRain();
        setHeight(height_LowPlains);
        setBiomeName("Moon");
        setColor(1381653);
        theBiomeDecorator.generateLakes = false;
        theBiomeDecorator.flowersPerChunk=0;
        theBiomeDecorator.grassPerChunk=0;
        theBiomeDecorator.treesPerChunk=0;
        theBiomeDecorator.mushroomsPerChunk=0;
    }
}
