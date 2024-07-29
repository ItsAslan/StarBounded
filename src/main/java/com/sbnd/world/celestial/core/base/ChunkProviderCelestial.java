package com.sbnd.world.celestial.core.base;

import api.noise.NoiseModule;
import api.noise.perlin.Gradient;
import com.sbnd.content.block.ModBlocks;
import com.sbnd.world.celestial.core.enums.EnumCrater;
import lombok.Getter;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
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

    private static final int CRATER_PROBABILITY = 700;

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

    public void generateTerrain(int chunkX, int chunkZ, Block[] ids, byte[] meta) {

        noiseGen1.setFrequency(0.0125F);
        noiseGen2.setFrequency(0.015F);
        noiseGen3.setFrequency(0.01F);
        noiseGen4.setFrequency(0.02F);

        for(int x = 0; x < CHUNK_SIZE_X; x++) {

            for(int z = 0; z < CHUNK_SIZE_Z; z++) {

                final double gen1 = noiseGen1.getNoise(x + chunkX << 4, z + chunkZ << 4) * 8;
                final double gen2 = noiseGen2.getNoise(x + chunkX << 4, z + chunkZ << 4) * 24;
                final double gen3 = (noiseGen3.getNoise(x + chunkX << 4, z + chunkZ << 4) - 0.1) * 4;

                double yDev;

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

                        if(y >= 58) {

                            ids[this.getIndex(x, y, z)] = ModBlocks.blockMoonTurf;
                            meta[this.getIndex(x, y, z)] = 1;

                        } else if (y >= 50) {

                            ids[this.getIndex(x, y, z)] = ModBlocks.blockMoonTurfMedium;
                            meta[this.getIndex(x, y, z)] = 1;

                        } else {

                            ids[this.getIndex(x, y, z)] = ModBlocks.blockMoonTurfDark;
                            meta[this.getIndex(x, y, z)] = 1;

                        }

                    }

                }

            }

        }

    }

    @Override
    public Chunk provideChunk(int chunkX, int chunkY) {

        rand.setSeed(chunkX * 341873128712L + chunkY * 132897987541L);

        BlockMetaBuffer buffer = new BlockMetaBuffer();

        Arrays.fill(buffer.getIds(), Blocks.air);

        generateTerrain(chunkX, chunkY, buffer.getIds(), buffer.getMeta());

        generateCrater(chunkX, chunkY, buffer.getIds(), buffer.getMeta());

        Chunk chunk = new Chunk(world, buffer.getIds(), buffer.getMeta(), chunkX, chunkY);
        chunk.generateSkylightMap();

        return chunk;

    }

    @Override
    public void populate(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {

        ;

    }

    private void generateCrater(int chunkX, int chunkZ, Block[] blocks, byte[] meta) {

        for (int cx = chunkX - 2; cx <= chunkX + 2; cx++) {

            for (int cz = chunkZ - 2; cz <= chunkZ + 2; cz++) {

                for (int x = 0; x < CHUNK_SIZE_X; x++) {

                    for (int z = 0; z < CHUNK_SIZE_Z; z++) {

                        if (Math.abs(randFromPoint((cx << 4) + x, ((cz << 4) + z) * 1000)) < noiseGen4.getNoise(x * CHUNK_SIZE_X + x, cz * CHUNK_SIZE_Z + z) / CRATER_PROBABILITY) {

                            Random random = new Random(cx * 16L + x + (cz * 16L + z) * 5000);

                            EnumCrater craterSize = EnumCrater.sizeArray[random.nextInt(EnumCrater.sizeArray.length)];

                            int size = random.nextInt(craterSize.MAX - craterSize.MIN) + craterSize.MIN;

                            makeCrater((cx << 4) + x, (cz << 4) + z, chunkX << 4, chunkZ << 4, size, blocks, meta);

                        }

                    }

                }

            }

        }

    }

    public void makeCrater(int craterX, int craterZ, int chunkX, int chunkZ, int size, Block[] blocks, byte[] meta) {

        for (int x = 0; x < CHUNK_SIZE_X; x++) {

            for (int z = 0; z < CHUNK_SIZE_Z; z++) {

                double xDev = craterX - (chunkX + x);
                double zDev = craterZ - (chunkZ + z);
                double distanceSquared = xDev * xDev + zDev * zDev;

                // Check if the block is within the crater radius
                if (distanceSquared < size * size) {

                    xDev /= size;
                    zDev /= size;
                    double sqrtY = xDev * xDev + zDev * zDev;
                    double yDev = sqrtY * sqrtY * 6;
                    yDev = 5 - yDev;

                    yDev *= 2; // Depth

                    int i = 0;

                    for (int y = 127; y > 0; y--) {

                        if (Blocks.air != blocks[getIndex(x, y, z)] && i <= yDev) {

                            blocks[getIndex(x, y, z)] = Blocks.air;
                            meta[getIndex(x, y, z)] = 0;

                            i++;

                        }

                        if (i > yDev) {
                            break;
                        }

                    }

                }

            }

        }

    }

    private int getIndex(int x, int y, int z) {

        return (x * 16 + z) * 256 + y;

    }

    private double randFromPoint(int x, int z)
    {
        int n;
        n = x + z * 57;
        n = n << 13 ^ n;
        return 1.0 - (n * (n * n * 15731 + 789221) + 1376312589 & 0x7fffffff) / 1073741824.0;
    }

    @Getter
    private static class BlockMetaBuffer {

        private final Block[] ids = new Block[16 * 16 * 256];
        private final byte[] meta = new byte[16 * 16 * 256];

    }

}