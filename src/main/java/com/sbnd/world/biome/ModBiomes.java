package com.sbnd.world.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

public class ModBiomes
{

    private static final int moonBiomeId = 50;
    private static final int marsBiomeId = 51;

    public static BiomeGenBase moonBiome = new MoonBiome(moonBiomeId);
    public static BiomeGenBase marsBiome = new MarsBiome(moonBiomeId);

    public static void MainRegistry()
    {
        RegisterBiomes();
    }

    public static void RegisterBiomes()
    {
        BiomeDictionary.registerBiomeType(moonBiome, BiomeDictionary.Type.COLD);
        BiomeDictionary.registerBiomeType(marsBiome, BiomeDictionary.Type.HOT);
    }

}
