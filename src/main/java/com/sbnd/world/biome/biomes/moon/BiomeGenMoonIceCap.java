package com.sbnd.world.biome.biomes.moon;

import com.sbnd.world.biome.core.BiomeGenCelestial;
import net.minecraftforge.common.BiomeDictionary;

import java.util.Set;

public class BiomeGenMoonIceCap extends BiomeGenCelestial {

    public BiomeGenMoonIceCap(int id) {
        super(id);
    }

    public BiomeGenMoonIceCap(Set<BiomeGenCelestial> registry, int id) {
        super(registry, id);

        this.type = BiomeDictionary.Type.COLD;

    }

    /**
     *  The `BiomeGenMoonIceCap` biome will be the
     *  polar ice caps of the moon (except there are more than 2)
     *  this biome will just be similar to ice glaciers,
     *  covered in snow with an ice block fill
     */

}