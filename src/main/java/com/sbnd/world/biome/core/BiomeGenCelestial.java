package com.sbnd.world.biome.core;

import lombok.Getter;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static net.minecraft.entity.EnumCreatureType.*;

public class BiomeGenCelestial extends BiomeGenBase {

    protected ArrayList<SpawnListEntry> surfaceCreatures = new ArrayList<>();
    protected ArrayList<SpawnListEntry> caveCreatures = new ArrayList<>();
    protected ArrayList<SpawnListEntry> waterCreatures = new ArrayList<>();

    private final HashMap<EnumCreatureType, ArrayList<SpawnListEntry>> creatureMap = new HashMap<>();

    @Getter
    protected BiomeDictionary.Type type;

    public BiomeGenCelestial(int id) {
        super(id);

        creatureMap.put(creature, surfaceCreatures);
        creatureMap.put(waterCreature, waterCreatures);
        creatureMap.put(ambient, caveCreatures);

    }

    public BiomeGenCelestial(Set<BiomeGenCelestial> registry, int id) {

        this( id );

        registry.add(this);

    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getSpawnableList(EnumCreatureType type) {

        return (List) creatureMap.get(type).clone();

    }

}
