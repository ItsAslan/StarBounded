package com.sbnd.world.biome;

import com.sbnd.world.biome.biomes.mars.BiomeGenMarsFlats;
import com.sbnd.world.biome.biomes.moon.BiomeGenMoonFlats;
import com.sbnd.world.biome.core.BiomeGenCelestial;
import net.minecraftforge.common.BiomeDictionary;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class SbndBiomes {

    public static AtomicInteger currentId = new AtomicInteger(60);
    public static Set<BiomeGenCelestial> biomes = new HashSet<>();

    //---------------BIOMES---------------//
    public static BiomeGenCelestial moonFlats;

    public static BiomeGenCelestial marsFlats;

    static void biomesInit() {

        moonFlats = new BiomeGenMoonFlats(biomes, currentId.getAndIncrement());

        marsFlats = new BiomeGenMarsFlats(biomes, currentId.getAndIncrement());

    }

    public static void REGISTER() {

        biomesInit();

        biomes.forEach(biome -> init(biome));

    }

    static void init(BiomeGenCelestial biome) {

        BiomeDictionary.registerBiomeType(biome, biome.getType());

    }

}
