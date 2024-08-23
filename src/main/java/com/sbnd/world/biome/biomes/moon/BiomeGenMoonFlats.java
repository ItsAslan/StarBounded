package com.sbnd.world.biome.biomes.moon;

import com.sbnd.world.biome.core.BiomeGenCelestial;
import net.minecraftforge.common.BiomeDictionary;

import java.util.Set;

public class BiomeGenMoonFlats extends BiomeGenCelestial {

    public BiomeGenMoonFlats(int id) {
        super(id);
    }

    public BiomeGenMoonFlats(Set<BiomeGenCelestial> registry, int id) {
        super(registry, id);

        this.type = BiomeDictionary.Type.WASTELAND;

    }

    /**
     *  The `BiomeGenMoonFlats` biome will be the
     *  classic "Moon Biome" with some mountains and
     *  craters. Mostly tame and wavy
     */

}
