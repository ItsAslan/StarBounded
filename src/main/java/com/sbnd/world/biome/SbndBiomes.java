package com.sbnd.world.biome;

import com.sbnd.world.biome.core.SbndBiomeBase;
import net.minecraftforge.common.BiomeDictionary;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class SbndBiomes {

    public static AtomicInteger currentId = new AtomicInteger(50);
    public static Set<SbndBiomeBase> biomes = new HashSet<>();

    //---------------BIOMES---------------//

    public static SbndBiomeBase test1;


    static void planetInit() {

        //test1 = new SbndBiomeBase(biomes, null, null, currentId.getAndIncrement());

    }

    public static void REGISTER() {

        planetInit();

        biomes.forEach(biome -> init(biome));

    }

    static void init(SbndBiomeBase biome) {

        BiomeDictionary.registerBiomeType(biome, biome.getType());

    }

}
