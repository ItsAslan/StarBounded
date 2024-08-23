package com.sbnd.world.biome;

import com.sbnd.world.biome.biomes.moon.BiomeGenMoonFlats;
import com.sbnd.world.biome.biomes.moon.BiomeGenMoonBasaltPlains;
import com.sbnd.world.biome.biomes.moon.BiomeGenMoonIceCap;
import com.sbnd.world.biome.core.BiomeGenCelestial;
import net.minecraftforge.common.BiomeDictionary;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class SbndBiomes {

    public static AtomicInteger currentId = new AtomicInteger(50);
    public static Set<BiomeGenCelestial> biomes = new HashSet<>();

    //---------------BIOMES---------------//
    public static BiomeGenCelestial moonFlats;
    public static BiomeGenCelestial moonBasaltPlains;
    public static BiomeGenCelestial moonIceCap;

    static void biomesInit() {

        moonFlats = new BiomeGenMoonFlats(biomes, currentId.getAndIncrement());
        moonBasaltPlains = new BiomeGenMoonBasaltPlains(biomes, currentId.getAndIncrement());
        moonIceCap = new BiomeGenMoonIceCap(biomes, currentId.getAndIncrement());

    }

    public static void REGISTER() {

        biomesInit();

        biomes.forEach(biome -> init(biome));

    }

    static void init(BiomeGenCelestial biome) {

        BiomeDictionary.registerBiomeType(biome, biome.getType());

    }

}
