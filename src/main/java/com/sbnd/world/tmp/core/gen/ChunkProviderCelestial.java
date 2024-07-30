package com.sbnd.world.tmp.core.gen;

import com.sbnd.world.tmp.core.gen.util.BlockLayer;
import javafx.util.Pair;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChunkProviderCelestial implements IChunkProvider {

    // Basics
    protected World world;
    protected Random random;

    // Blocks
    @Setter @Getter
    protected Block seaLayer;
    @Setter @Getter
    protected int seaLevel;
    @Getter
    protected ArrayList<BlockLayer> blockLayers;

    // Noise
    protected NoiseGeneratorOctaves heightOrder;
    protected NoiseGeneratorOctaves noiseGen1;
    protected NoiseGeneratorOctaves noiseGen2;
    protected NoiseGeneratorOctaves noiseGen3;
    protected NoiseGeneratorPerlin perlinGen1;

    private double[] stoneNoise = new double[256];

    protected BiomeGenBase[] biomesForGeneration;
    private final float[] parabolicField;
    private final double[] terrainBuffer;

    double[] orderBuffer;
    double[] genBuffer1;
    double[] genBuffer2;
    double[] genBuffer3;

    public ChunkProviderCelestial(World world, long seed, boolean bool) {

        random = new Random(seed);

        this.heightOrder = new NoiseGeneratorOctaves(random, 16);
        this.noiseGen1 = new NoiseGeneratorOctaves(random, 16);
        this.noiseGen2 = new NoiseGeneratorOctaves(random, 16);
        this.noiseGen3 = new NoiseGeneratorOctaves(random, 8);
        this.perlinGen1 = new NoiseGeneratorPerlin(random, 4);

        this.world = world;

        this.parabolicField = new float[25];
        terrainBuffer = new double[825];

        for (int j = -2; j <= 2; ++j) {

            for (int k = -2; k <= 2; ++k) {

                float f = 10.0F / MathHelper.sqrt_float((float)(j * j + k * k) + 0.2F);
                this.parabolicField[j + 2 + (k + 2) * 5] = f;

            }

        }

        blockLayers = new ArrayList<>();
        seaLayer = Blocks.water;
        seaLevel = 63;

        NoiseGenerator[] noiseGens = {noiseGen1, noiseGen2, noiseGen3, perlinGen1 };
        noiseGens = TerrainGen.getModdedNoiseGenerators(world, random, noiseGens);

        this.noiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
        this.noiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
        this.noiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];

        this.perlinGen1 = (NoiseGeneratorPerlin)noiseGens[3];

    }

    //---------------------------------------------------//

    public void genBlocks(int x, int z, Block[] blocks) {

        this.biomesForGeneration = world.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, x * 4 - 2, z * 4 - 2, 10, 10);
        genNoiseField(x * 4, 0, z * 4);

        for (int k = 0; k < 4; ++k) {

            int l = k * 5;
            int i1 = (k + 1) * 5;

            for (int j1 = 0; j1 < 4; ++j1) {

                int k1 = (l + j1) * 33;
                int l1 = (l + j1 + 1) * 33;
                int i2 = (i1 + j1) * 33;
                int j2 = (i1 + j1 + 1) * 33;

                for (int k2 = 0; k2 < 32; ++k2) {

                    double d0 = 0.125D;
                    double d1 = terrainBuffer[k1 + k2];
                    double d2 = terrainBuffer[l1 + k2];
                    double d3 = terrainBuffer[i2 + k2];
                    double d4 = terrainBuffer[j2 + k2];
                    double d5 = (terrainBuffer[k1 + k2 + 1] - d1) * d0;
                    double d6 = (terrainBuffer[l1 + k2 + 1] - d2) * d0;
                    double d7 = (terrainBuffer[i2 + k2 + 1] - d3) * d0;
                    double d8 = (terrainBuffer[j2 + k2 + 1] - d4) * d0;

                    for (int l2 = 0; l2 < 8; ++l2) {

                        double d9 = 0.25D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;

                        for (int i3 = 0; i3 < 4; ++i3) {

                            int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
                            short short1 = 256;
                            j3 -= short1;
                            double d14 = 0.25D;
                            double d16 = (d11 - d10) * d14;
                            double d15 = d10 - d16;

                            for (int k3 = 0; k3 < 4; ++k3) {

                                int height = k2 * 8 + l2;
                                Block blockToPlace = Blocks.air;

                                for (BlockLayer blockLayer : blockLayers) {

                                    Pair<Block, Pair<Integer, Integer>> blockToInterval = blockLayer.blockToIntervalPair;
                                    Block block = blockToInterval.getKey();
                                    int minHeight = blockToInterval.getValue().getKey();
                                    int maxHeight = blockToInterval.getValue().getValue();

                                    if (height >= minHeight && height <= maxHeight) {

                                        blockToPlace = block;
                                        break;

                                    }

                                }

                                if ((d15 += d16) > 0.0D) {

                                    blocks[j3 += short1] = blockToPlace;

                                } else if (height < seaLevel) {

                                    blocks[j3 += short1] = seaLayer;

                                } else {

                                    blocks[j3 += short1] = Blocks.air;

                                }

                            }

                            d10 += d12;
                            d11 += d13;

                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;

                    }
                }

            }

        }

    }


    private void genNoiseField(int x, int y, int z) {

        orderBuffer = heightOrder.generateNoiseOctaves(orderBuffer, x, y, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
        genBuffer1 = noiseGen1.generateNoiseOctaves(genBuffer1, x, y, z, 5, 200.0D, 200.0D, 0.5D);
        genBuffer2 = noiseGen2.generateNoiseOctaves(genBuffer2, x, y, z, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
        genBuffer3 = noiseGen3.generateNoiseOctaves(genBuffer3, x, y, 5, 5, 33, 5, 684.412D, 684.412D, 684.412D);

        int l = 0;
        int i1 = 0;

        for (int j1 = 0; j1 < 5; ++j1) {

            for (int k1 = 0; k1 < 5; ++k1) {

                float f = 0.0F;
                float f1 = 0.0F;
                float f2 = 0.0F;
                byte b0 = 2;

                BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];

                for (int l1 = -b0; l1 <= b0; ++l1) {

                    for (int i2 = -b0; i2 <= b0; ++i2) {

                        BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];

                        float f3 = biomegenbase1.rootHeight;
                        float f4 = biomegenbase1.heightVariation;

                        float f5 = parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);

                        if (biomegenbase1.rootHeight > biomegenbase.rootHeight) {

                            f5 /= 2.0F;

                        }

                        f += f4 * f5;
                        f1 += f3 * f5;
                        f2 += f5;

                    }

                }

                f /= f2;
                f1 /= f2;
                f = f * 0.9F + 0.1F;
                f1 = (f1 * 4.0F - 1.0F) / 8.0F;
                double d12 = orderBuffer[i1] / 8000.0D;

                if (d12 < 0.0D) {

                    d12 = -d12 * 0.3D;

                }

                d12 = d12 * 3.0D - 2.0D;

                if (d12 < 0.0D) {

                    d12 /= 2.0D;

                    if (d12 < -1.0D) {

                        d12 = -1.0D;

                    }

                    d12 /= 1.4D;
                    d12 /= 2.0D;
                }
                else {

                    if (d12 > 1.0D) {

                        d12 = 1.0D;

                    }

                    d12 /= 8.0D;

                }

                ++i1;
                double d13 = (double)f1;
                double d14 = (double)f;
                d13 += d12 * 0.2D;
                d13 = d13 * 8.5D / 8.0D;
                double d5 = 8.5D + d13 * 4.0D;

                for (int j2 = 0; j2 < 33; ++j2) {

                    double d6 = ((double)j2 - d5) * 12.0D * 128.0D / 256.0D / d14;

                    if (d6 < 0.0D) {

                        d6 *= 4.0D;

                    }

                    double d7 = this.genBuffer1[l] / 512.0D;
                    double d8 = this.genBuffer2[l] / 512.0D;
                    double d9 = (this.genBuffer3[l] / 10.0D + 1.0D) / 2.0D;

                    double d10 = MathHelper.denormalizeClamp(d7, d8, d9) - d6;

                    if (j2 > 29) {

                        double d11 = (float)(j2 - 29) / 3.0F;
                        d10 = d10 * (1.0D - d11) + -10.0D * d11;

                    }

                    this.terrainBuffer[l] = d10;
                    ++l;

                }

            }

        }

    }

    public void replaceBlocksForBiome(int x, int z, Block[] blocks, byte[] metas, BiomeGenBase[] biomes) {

        double d0 = 0.03125D;
        this.stoneNoise = this.perlinGen1.func_151599_a(stoneNoise, x * 16, z * 16, 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);

        for (int k = 0; k < 16; ++k) {

            for (int l = 0; l < 16; ++l) {

                BiomeGenBase biomegenbase = biomes[l + k * 16];
                biomegenbase.genTerrainBlocks(world, random, blocks, metas, x * 16 + k, z * 16 + l, stoneNoise[l + k * 16]);
            }

        }

    }

    @Override
    public Chunk provideChunk(int x, int z) {

        random.setSeed((long)x * 341873128712L + (long)z * 132897987541L);

        BlockMetaBuffer buffer = new BlockMetaBuffer();

        genBlocks(x, z, buffer.getBlocks());
        biomesForGeneration = world.getWorldChunkManager().loadBlockGeneratorData(biomesForGeneration, x * 16, z * 16, 16, 16);
        replaceBlocksForBiome(x, z, buffer.getBlocks(), buffer.getMetas(), biomesForGeneration);

        Chunk chunk = new Chunk(world, buffer.getBlocks(), buffer.getMetas(), x, z);

        byte[] blockBuffer = chunk.getBiomeArray();

        for (int k = 0; k < blockBuffer.length; ++k)
        {
            blockBuffer[k] = (byte) biomesForGeneration[k].biomeID;
        }

        chunk.generateSkylightMap();

        return chunk;

    }

    @Override
    public void populate(IChunkProvider provider, int x, int y) {

        ;

    }

    @SuppressWarnings("rawtypes") // stop complaining please 'RaW UsE Of PaRAMeTerIZed CLasS 'LISt'
    @Override
    public List getPossibleCreatures(EnumCreatureType creatureType, int x, int y, int z) {
        BiomeGenBase biomegenbase = world.getBiomeGenForCoords(x, z);

        return biomegenbase.getSpawnableList(creatureType);

    }

    @Override
    public void recreateStructures(int x, int y) {

        ;

    }

    //---------------------------------------------------//

    @Override
    public String makeString() {
        return "SbndDimension";
    }

    @Override
    public boolean saveChunks(boolean bool, IProgressUpdate update) {
        return true;
    }

    @Override
    public boolean unloadQueuedChunks() {
        return false;
    }

    @Override
    public boolean canSave() {
        return true;
    }

    @Override
    public boolean chunkExists(int x, int y) {
        return true;
    }

    @Override
    public Chunk loadChunk(int x, int y) {
        return provideChunk(x, y);
    }

    @Override
    public int getLoadedChunkCount() {
        return 0;
    }

    @Override
    public ChunkPosition func_147416_a(World world, String structureName, int x, int y, int z) {
        return null;
    }

    @Override
    public void saveExtraData() { ; }

    //---------------------------------------------------//

    @Getter
    private static class BlockMetaBuffer {

        private final Block[] blocks = new Block[16 * 16 * 256];
        private final byte[] metas = new byte[16 * 16 * 256];

    }

}
