package com.sbnd.world.biomedecorator;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class MoonBiomeDecorator extends BiomeDecorator
{
    public MoonBiomeDecorator()
    {
        this.generateLakes = false;
    }

    @Override
    protected void genDecorations(BiomeGenBase biome) {

    }
}
