package com.sbnd.world.biome.biomes.moon;

import com.sbnd.world.biome.core.BiomeGenCelestial;
import net.minecraftforge.common.BiomeDictionary;

import java.util.Set;

public class BiomeGenMoonBasaltPlains extends BiomeGenCelestial {

    public BiomeGenMoonBasaltPlains(int id) {
        super(id);
    }

    public BiomeGenMoonBasaltPlains(Set<BiomeGenCelestial> registry, int id) {
        super(registry, id);

        this.type = BiomeDictionary.Type.PLAINS;

    }

    /**
     *  The `BiomeGenMoonBasaltPlains` biome will be similar to
     *  the Dead Sea. This biome will be VERY flat
     *  and will have "Seas" of basalt
     */

}
