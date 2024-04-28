package com.sbnd.world.biome;

import com.sbnd.blocks.ModBlocks;
import com.sbnd.world.biomedecorator.MoonBiomeDecorator;
import net.minecraft.world.biome.BiomeDecorator;
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
    }

    @Override
    public BiomeDecorator createBiomeDecorator() {
        return new MoonBiomeDecorator();
    }

}
