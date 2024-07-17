package com.sbnd.world.biome.core;

import lombok.Getter;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

import java.util.Random;
import java.util.Set;

@Getter
public class SbndBiomeBase extends BiomeGenBase {

    private final IBiomeData data;

    private final BiomeDictionary.Type type;

    public SbndBiomeBase(Set<SbndBiomeBase> registry, IBiomeData data, BiomeDictionary.Type type, int id) {
        super(id);

        this.data = data;
        this.type = type;

        registry.add(this);

        this.fillerBlock = data.getGenData().getFillerBlock();
        this.topBlock = data.getGenData().getTopBlock();
        this.theBiomeDecorator.generateLakes = data.getGenData().lakeSpawn();

        this.setBiomeName(data.getPropertyData().getName());
        this.setHeight(data.getPropertyData().getHeight());
        this.setColor(data.getPropertyData().getColor());

        if(data.getPropertyData().canRain()) {

            this.setDisableRain();

        }

    }

    @Override
    public void decorate(World world, Random random, int i, int j) {
        data.getFaunaData().decorate(world, random, i, j);
    }

}
