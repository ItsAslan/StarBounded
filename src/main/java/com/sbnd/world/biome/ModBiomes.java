package com.sbnd.world.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

public class ModBiomes
{

    private static final int moonBiomeId = 180;

    public static BiomeGenBase moonBiome = new MoonBiome(moonBiomeId);

    public static void MainRegistry()
    {
        RegisterBiomes();
    }

    public static void RegisterBiomes()
    {
        BiomeDictionary.registerBiomeType(moonBiome, BiomeDictionary.Type.COLD);
    }

}
