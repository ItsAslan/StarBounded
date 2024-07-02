package com.sbnd.world.biome.core;

import com.sbnd.world.celestial.core.ICelestialBodyData;
import lombok.Getter;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

import java.util.Set;

@Getter
public class SbndBiomeBase extends BiomeGenBase {

    private final ICelestialBodyData data;

    private final BiomeDictionary.Type type;

    public SbndBiomeBase(Set<SbndBiomeBase> registry, ICelestialBodyData data, BiomeDictionary.Type type, int id) {
        super(id);

        this.data = data;
        this.type = type;

        registry.add(this);

        // Property Config goes here

    }

}
