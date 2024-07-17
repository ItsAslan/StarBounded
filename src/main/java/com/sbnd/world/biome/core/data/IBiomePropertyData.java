package com.sbnd.world.biome.core.data;

import net.minecraft.world.biome.BiomeGenBase;

public interface IBiomePropertyData {

    boolean canRain();

    BiomeGenBase.Height getHeight();

    String getName();

    int getColor();

}
