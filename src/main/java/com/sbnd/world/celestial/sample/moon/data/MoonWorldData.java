package com.sbnd.world.celestial.sample.moon.data;

import com.sbnd.world.celestial.core.base.ChunkProviderCelestial;
import com.sbnd.world.celestial.core.base.WorldChunkManagerCelestial;
import com.sbnd.world.celestial.core.base.WorldProviderCelestial;
import com.sbnd.world.celestial.core.data.IWorldData;
import com.sbnd.world.celestial.sample.moon.MoonWorldProvider;
import net.minecraft.world.World;

public class MoonWorldData implements IWorldData {

    @Override
    public String getName() {
        return "Moon";
    }

    @Override
    public WorldProviderCelestial getWorldProvider() {
        return new MoonWorldProvider();
    }

    @Override
    public ChunkProviderCelestial getChunkProvider(World world) {
        return new ChunkProviderCelestial(world, world.getSeed(), false);
    }

    @Override
    public WorldChunkManagerCelestial getChunkManager() {
        return new WorldChunkManagerCelestial(new MoonGenData());
    }

}
