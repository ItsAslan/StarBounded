package com.sbnd.world.tmp.core.gen;

import api.noise.NoiseModule;
import api.noise.perlin.Gradient;
import com.sbnd.content.block.ModBlocks;
import com.sbnd.world.celestial.core.enums.EnumCrater;
import com.sbnd.world.tmp.core.gen.util.Interval;
import com.sbnd.world.tmp.core.gen.util.Pair;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ChunkProviderCelestial extends ChunkProviderGenerate {

    // Basics
    Random rand;

    private final World world;

    // Change these
    protected final NoiseModule noiseGen1;
    protected final NoiseModule noiseGen2;
    protected final NoiseModule noiseGen3;
    protected final NoiseModule noiseGen4;

    @Getter @Setter
    protected static int Y_START = 60;
    @Getter @Setter
    protected static int CRATER_PROBABILITY = 700;
    @Getter @Setter
    protected boolean spawnCraters = false;

    // Blocks
    protected Set<Pair<Block, Interval>> blockLayers;

    // Constants
    private static final int CHUNK_SIZE_X = 16;
    private static final int CHUNK_SIZE_Y = 128;
    private static final int CHUNK_SIZE_Z = 16;

    public ChunkProviderCelestial(World world, long seed, boolean keepLoaded) {

        super(world, seed, keepLoaded);

        rand = new Random(seed);

        noiseGen1 = new Gradient(rand.nextLong(), 4, 0.25f);
        noiseGen2 = new Gradient(rand.nextLong(), 4, 0.25f);
        noiseGen3 = new Gradient(rand.nextLong(), 1, 0.25f);
        noiseGen4 = new Gradient(rand.nextLong(), 1, 0.25f);

        this.world = world;

        blockLayers = new HashSet<>();

        blockLayers.add(createBlockLayer(ModBlocks.blockMoonTurf, 58, 100));
        blockLayers.add(createBlockLayer(ModBlocks.blockMoonTurfMedium, 50, 58));
        blockLayers.add(createBlockLayer(ModBlocks.blockMoonTurfDark, 0, 50));

    }

    public void generateTerrain(int chunkX, int chunkZ, Block[] ids, byte[] meta) {

        noiseGen1.setFrequency(0.0125F);
        noiseGen2.setFrequency(0.015F);
        noiseGen3.setFrequency(0.01F);
        noiseGen4.setFrequency(0.02F);

        for(int x = 0; x < CHUNK_SIZE_X; x++) {

            for(int z = 0; z < CHUNK_SIZE_Z; z++) {

                final double gen1 = noiseGen1.getNoise(x + chunkX * 16, z + chunkZ * 16) * 8;
                final double gen2 = noiseGen2.getNoise(x + chunkX * 16, z + chunkZ * 16) * 24;
                final double gen3 = (noiseGen3.getNoise(x + chunkX * 16, z + chunkZ * 16) - 0.1) * 4;

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

                        for(Pair<Block, Interval> pair : blockLayers) {

                            if(pair.getValue().contains(y)) {

                                ids[this.getIndex(x, y, z)] = pair.getKey();
                                meta[this.getIndex(x, y, z)] = 1;

                            }

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

        Arrays.fill(buffer.getBlocks(), Blocks.air);

        generateTerrain(chunkX, chunkY, buffer.getBlocks(), buffer.getMetas());

        if (spawnCraters) { generateCrater(chunkX, chunkY, buffer.getBlocks(), buffer.getMetas()); }

        Chunk chunk = new Chunk(world, buffer.getBlocks(), buffer.getMetas(), chunkX, chunkY);
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

                        if (Math.abs(randFromPoint((cx * 16) + x, ((cz * 16) + z) * 1000)) < noiseGen4.getNoise(x * CHUNK_SIZE_X + x, cz * CHUNK_SIZE_Z + z) / CRATER_PROBABILITY) {

                            Random random = new Random(cx * 16L + x + (cz * 16L + z) * 5000);

                            EnumCrater craterSize = EnumCrater.sizeArray[random.nextInt(EnumCrater.sizeArray.length)];

                            int size = random.nextInt(craterSize.MAX - craterSize.MIN) + craterSize.MIN;

                            makeCrater((cx * 16) + x, (cz * 16) + z, chunkX * 16, chunkZ * 16, size, blocks, meta);

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

    private double randFromPoint(int x, int z) {

        int n;
        n = x + z * 57;
        n = n << 13 ^ n;
        return 1.0 - (n * (n * n * 15731 + 789221) + 1376312589 & 0x7fffffff) / 1073741824.0;

    }

    protected Pair<Block, Interval> createBlockLayer(Block block, int min, int max) {

        return new Pair<>(block, new Interval(min, max));

    }

    @Getter
    private static class BlockMetaBuffer {

        private final Block[] blocks = new Block[16 * 16 * 256];
        private final byte[] metas = new byte[16 * 16 * 256];

    }

}