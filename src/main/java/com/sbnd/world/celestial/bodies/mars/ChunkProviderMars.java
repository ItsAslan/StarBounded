package com.sbnd.world.celestial.bodies.mars;

import com.sbnd.content.block.ModBlocks;
import com.sbnd.world.celestial.core.gen.ChunkProviderCelestial;
import com.sbnd.world.celestial.core.gen.features.CraterGenerator;
import net.minecraft.world.World;

public class ChunkProviderMars extends ChunkProviderCelestial {

    private final CraterGenerator craterBig;

    public ChunkProviderMars(World world, long seed, boolean hasMapFeatures) {
        super(world, seed, hasMapFeatures);

        craterBig = new CraterGenerator(40);

        craterBig.setCraterSize(85, 220);

        stoneBlock = ModBlocks.blockMoonRock;
        seaBlock = ModBlocks.blockMoonBasalt;
        seaLevel = 62;

    }

    @Override
    protected BlockMetaBuffer getChunkPrimer(int x, int z) {

        BlockMetaBuffer buffer = super.getChunkPrimer(x, z);

        craterBig.func_151539_a(this, worldObj, x, z, buffer.getBlocks());

        return buffer;

    }

}