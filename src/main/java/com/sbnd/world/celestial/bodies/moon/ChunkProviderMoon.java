package com.sbnd.world.celestial.bodies.moon;

import com.sbnd.content.block.ModBlocks;
import com.sbnd.world.biome.SbndBiomes;
import com.sbnd.world.celestial.core.gen.ChunkProviderCelestial;
import com.sbnd.world.celestial.core.gen.features.CraterGenerator;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenCaves;

public class ChunkProviderMoon extends ChunkProviderCelestial {

    private final CraterGenerator craterSmall;
    private final CraterGenerator craterBig;

    private final MapGenCaves caveGen;

    public ChunkProviderMoon(World world, long seed, boolean hasMapFeatures) {
        super(world, seed, hasMapFeatures);

        craterSmall = new CraterGenerator(5);
        craterBig = new CraterGenerator(30);

        craterSmall.setCraterSize(9, 36);
        craterBig.setCraterSize(64, 144);

        caveGen = new MapGenCaves();

        stoneBlock = ModBlocks.blockMoonRock;
        seaBlock = ModBlocks.blockMoonBasalt;
        seaLevel = 62;

    }

    @Override
    protected BlockMetaBuffer getChunkPrimer(int x, int z) {

        BlockMetaBuffer buffer = super.getChunkPrimer(x, z);

        craterSmall.func_151539_a(this, worldObj, x, z, buffer.getBlocks());
        craterBig.func_151539_a(this, worldObj, x, z, buffer.getBlocks());

        caveGen.func_151539_a(this, worldObj, x, z, buffer.getBlocks());

        return buffer;

    }

}
