package com.sbnd.gen.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeManager;

public class ModBiomes
{

    private static final int moonBiomeId = 180;

    public static BiomeGenBase moonBiome;

    public static void MainRegistry()
    {
        RegisterBiomes();
    }

    public static void RegisterBiomes()
    {
        moonBiome = new MoonBiome(moonBiomeId);
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(moonBiome, 10));
    }

}
