package com.sbnd.world.celestial.core.base;

import api.noise.NoiseModule;
import api.noise.perlin.Gradient;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkProviderGenerate;

import java.util.Arrays;
import java.util.Random;

public class ChunkProviderCelestial extends ChunkProviderGenerate {

    Random rand;

    private final NoiseModule noiseGen1;
    private final NoiseModule noiseGen2;
    private final NoiseModule noiseGen3;
    private final NoiseModule noiseGen4;

    private static final int CHUNK_SIZE_X = 16;
    private static final int CHUNK_SIZE_Y = 128;
    private static final int CHUNK_SIZE_Z = 16;

    private static final int Y_START = 60;

    private final World world;

    public ChunkProviderCelestial(World world, long seed, boolean keepLoaded) {

        super(world, seed, keepLoaded);

        rand = new Random(seed);

        noiseGen1 = new Gradient(rand.nextLong(), 4, 0.25f);
        noiseGen2 = new Gradient(rand.nextLong(), 4, 0.25f);
        noiseGen3 = new Gradient(rand.nextLong(), 1, 0.25f);
        noiseGen4 = new Gradient(rand.nextLong(), 1, 0.25f);

        this.world = world;

    }

    public void generateTerrain(int chunkX, int chunkZ, Block[] idArray, byte[] metaArray) {

        noiseGen1.setFrequency(0.0125F);
        noiseGen2.setFrequency(0.015F);
        noiseGen3.setFrequency(0.01F);
        noiseGen4.setFrequency(0.02F);

        for(int x = 0; x < CHUNK_SIZE_X; x++) {

            for(int z = 0; z < CHUNK_SIZE_Z; z++) {

                final double gen1 = noiseGen1.getNoise(x + chunkX * 16, z + chunkZ * 16) * 8;
                final double gen2 = noiseGen2.getNoise(x + chunkX * 16, z + chunkZ * 16) * 24;
                final double gen3 = (noiseGen3.getNoise(x + chunkX * 16, z + chunkZ * 16) - 0.1) * 4;

                double yDev = 0;

                if (gen3 < 0.0D) {

                    yDev = gen1;

                }
                else if (gen3 > 1.0D) {

                    yDev = gen2;

                }
                else {

                    yDev = gen1 + (gen2 - gen1) * gen3;

                }

                for (int y = 0; y < CHUNK_SIZE_Y; y++) {

                    if (y < Y_START + yDev) {

                        idArray[this.getIndex(x, y, z)] = Blocks.stone;
                        metaArray[this.getIndex(x, y, z)] = 1;

                    }

                }

            }

        }

    }

    @Override
    public Chunk provideChunk(int chunkX, int chunkY) {

        rand.setSeed(chunkX * 341873128712L + chunkY * 132897987541L);

        final Block[] ids = new Block[16 * 16 * 256];
        final byte[] meta = new byte[16 * 16 * 256];

        Arrays.fill(ids, Blocks.air);

        this.generateTerrain(chunkX, chunkY, ids, meta);

        return new Chunk(world, ids, meta, chunkX, chunkY);

    }

    private int getIndex(int x, int y, int z) {

        return (x * 16 + z) * 256 + y;

    }



}