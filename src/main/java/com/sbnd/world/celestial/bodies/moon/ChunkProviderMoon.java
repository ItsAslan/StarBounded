package com.sbnd.world.celestial.bodies.moon;

import com.sbnd.content.block.ModBlocks;
import com.sbnd.world.biome.SbndBiomes;
import com.sbnd.world.biome.biomes.moon.BiomeGenMoonIceCap;
import com.sbnd.world.celestial.core.gen.ChunkProviderCelestial;
import com.sbnd.world.celestial.core.gen.features.CraterGenerator;
import net.minecraft.world.World;

public class ChunkProviderMoon extends ChunkProviderCelestial {

    private final CraterGenerator craterSmall;
    private final CraterGenerator craterBig;

    public ChunkProviderMoon(World world, long seed, boolean hasMapFeatures) {
        super(world, seed, hasMapFeatures);

        craterSmall = new CraterGenerator(5, SbndBiomes.moonIceCap);
        craterBig = new CraterGenerator(30, SbndBiomes.moonIceCap);

        craterSmall.setCraterSize(9, 36);
        craterBig.setCraterSize(64, 144);

        stoneBlock = ModBlocks.blockMoonRock;
        seaBlock = ModBlocks.blockMoonBasalt;
        seaLevel = 62;

    }

    @Override
    protected BlockMetaBuffer getChunkPrimer(int x, int z) {

        BlockMetaBuffer buffer = super.getChunkPrimer(x, z);

        craterSmall.func_151539_a(this, worldObj, x, z, buffer.getBlocks());
        craterBig.func_151539_a(this, worldObj, x, z, buffer.getBlocks());

        return buffer;

    }

}
