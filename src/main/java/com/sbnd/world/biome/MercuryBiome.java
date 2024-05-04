package com.sbnd.world.biome;

import com.sbnd.blocks.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.Random;

public class MercuryBiome extends BiomeGenBase
{
    public MercuryBiome(int id) {
        super(id);
        this.topBlock = ModBlocks.blockMercurySurface;
        this.fillerBlock = ModBlocks.blockMercurySurface;
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.setDisableRain();
        this.setTemperatureRainfall(2.0f, 0.0f);
        this.setHeight(height_Shores);
        this.setBiomeName("Mercury");
        this.setColor(854921);

        this.theBiomeDecorator.generateLakes = false;
    }

    public void decorate(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_)
    { }
}
