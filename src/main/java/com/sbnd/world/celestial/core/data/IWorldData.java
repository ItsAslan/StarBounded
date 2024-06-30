package com.sbnd.world.celestial.core.data;

import com.sbnd.world.celestial.core.base.ChunkProviderCelestial;
import com.sbnd.world.celestial.core.base.WorldChunkManagerCelestial;
import com.sbnd.world.celestial.core.base.WorldProviderCelestial;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.Set;

public interface IWorldData {

    String getName();

    WorldProviderCelestial getWorldProvider();

    ChunkProviderCelestial getChunkProvider(World world);

    WorldChunkManagerCelestial getChunkManager();

}
