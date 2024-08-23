package com.sbnd.world.celestial.core.gen;

import lombok.Getter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.List;
import java.util.Random;

public class ChunkProviderCelestial implements IChunkProvider {

    // Default Blocks
    protected Block stoneBlock;
    protected Block seaBlock;
    protected int seaLevel;

    // Basics
    private final Random rand;
    protected final World worldObj;
    private final boolean mapFeaturesEnabled;

    // Noise
    private NoiseGeneratorOctaves firstOctave;
    private NoiseGeneratorOctaves secondOctave;
    private NoiseGeneratorOctaves thirdOctave;
    private NoiseGeneratorPerlin perlin;
    public NoiseGeneratorOctaves heightOrder;

    private final double[] terrainBuffer;
    private final float[] parabolicField;
    private double[] stoneNoise = new double[256];

    private BiomeGenBase[] biomesForGeneration;
    double[] firstOctaveBuffer;
    double[] secondOctaveBuffer;
    double[] thirdOctaveBuffer;
    double[] heightOrderBuffer;

    protected Vec3 firstOctaveFrequency = Vec3.createVectorHelper(684.412D, 684.412D, 684.412D);
    protected Vec3 secondOctaveFrequency = Vec3.createVectorHelper(684.412D, 684.412D, 684.412D);
    protected Vec3 thirdOctaveFrequency = Vec3.createVectorHelper(8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
    protected Vec3 heightOrderFrequency = Vec3.createVectorHelper(200.0D, 200.0D, 0.5D);

    public ChunkProviderCelestial(World world, long seed, boolean hasMapFeatures) {

        this.worldObj = world;
        this.mapFeaturesEnabled = hasMapFeatures;

        this.rand = new Random(seed);

        this.firstOctave = new NoiseGeneratorOctaves(rand, 16);
        this.secondOctave = new NoiseGeneratorOctaves(rand, 16);
        this.thirdOctave = new NoiseGeneratorOctaves(rand, 8);
        this.perlin = new NoiseGeneratorPerlin(rand, 4);
        this.heightOrder = new NoiseGeneratorOctaves(rand, 16);

        this.terrainBuffer = new double[825];
        this.parabolicField = new float[25];

        for (int j = -2; j <= 2; ++j) {

            for (int k = -2; k <= 2; ++k) {

                float f = 10.0F / MathHelper.sqrt_float((float)(j * j + k * k) + 0.2F);
                this.parabolicField[j + 2 + (k + 2) * 5] = f;

            }

        }

        NoiseGenerator[] noiseGens = { firstOctave, secondOctave, thirdOctave, perlin, heightOrder };
        noiseGens = TerrainGen.getModdedNoiseGenerators(world, this.rand, noiseGens);

        this.firstOctave = (NoiseGeneratorOctaves)noiseGens[0];
        this.secondOctave = (NoiseGeneratorOctaves)noiseGens[1];
        this.thirdOctave = (NoiseGeneratorOctaves)noiseGens[2];
        this.perlin = (NoiseGeneratorPerlin)noiseGens[3];
        this.heightOrder = (NoiseGeneratorOctaves)noiseGens[4];

    }

    /**
     *  It works this way in newer versions, this is basically just a backport from 1.8+
     *  Here is where you add things like craters or volcanoes.
     *  Also cave generators
     */
    protected BlockMetaBuffer getChunkPrimer(int x, int z) {

        BlockMetaBuffer buffer = new BlockMetaBuffer();

        generateBlocks(x, z, buffer.getBlocks());
        biomesForGeneration = worldObj.getWorldChunkManager().loadBlockGeneratorData(biomesForGeneration, x * 16, z * 16, 16, 16);
        replaceBlocksForBiome(x, z, buffer.getBlocks(), buffer.getMetas(), biomesForGeneration);

        return buffer;

    }

    public void generateBlocks(int x, int z, Block[] blocks) {

        biomesForGeneration = worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, x * 4 - 2, z * 4 - 2, 10, 10);
        generateNoiseField(x * 4, 0, z * 4);

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

                            int j3 = i3 + k * 4 << 12 | j1 * 4 << 8 | k2 * 8 + l2;
                            short short1 = 256;
                            j3 -= short1;
                            double d14 = 0.25D;
                            double d16 = (d11 - d10) * d14;
                            double d15 = d10 - d16;

                            for (int k3 = 0; k3 < 4; ++k3) {

                                if ((d15 += d16) > 0.0D) {

                                    blocks[j3 += short1] = stoneBlock;

                                }
                                else if (k2 * 8 + l2 < seaLevel) {

                                    blocks[j3 += short1] = seaBlock;

                                }
                                else {

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

    protected void generateNoiseField(int x, int y, int z) {

        heightOrderBuffer = heightOrder.generateNoiseOctaves(heightOrderBuffer, x, z, 5, 5, heightOrderFrequency.xCoord, heightOrderFrequency.yCoord, heightOrderFrequency.zCoord);
        firstOctaveBuffer = firstOctave.generateNoiseOctaves(firstOctaveBuffer, x, y, z, 5, 33, 5, firstOctaveFrequency.xCoord, firstOctaveFrequency.yCoord, firstOctaveFrequency.zCoord);
        secondOctaveBuffer = secondOctave.generateNoiseOctaves(secondOctaveBuffer, x, y, z, 5, 33, 5, secondOctaveFrequency.xCoord, secondOctaveFrequency.yCoord, secondOctaveFrequency.zCoord);
        thirdOctaveBuffer = thirdOctave.generateNoiseOctaves(thirdOctaveBuffer, x, y, z, 5, 33, 5, thirdOctaveFrequency.xCoord, thirdOctaveFrequency.yCoord, thirdOctaveFrequency.zCoord);

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

                        float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);

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

                double d12 = this.heightOrderBuffer[i1] / 8000.0D;

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

                double d13 = f1;
                double d14 = f;

                d13 += d12 * 0.2D;
                d13 = d13 * 8.5D / 8.0D;

                double d5 = 8.5D + d13 * 4.0D;

                for (int j2 = 0; j2 < 33; ++j2) {

                    double d6 = ((double)j2 - d5) * 12.0D * 128.0D / 256.0D / d14;

                    if (d6 < 0.0D) {
                        d6 *= 4.0D;
                    }

                    double d7 = this.firstOctaveBuffer[l] / 512.0D;
                    double d8 = this.secondOctaveBuffer[l] / 512.0D;
                    double d9 = (this.thirdOctaveBuffer[l] / 10.0D + 1.0D) / 2.0D;

                    double d10 = MathHelper.denormalizeClamp(d7, d8, d9) - d6;

                    if (j2 > 29) {
                        double d11 = ((float)(j2 - 29) / 3.0F);
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
        this.stoneNoise = perlin.func_151599_a(stoneNoise, x * 16, z * 16, 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);

        for (int k = 0; k < 16; ++k) {

            for (int l = 0; l < 16; ++l) {

                BiomeGenBase biomegenbase = biomes[l + k * 16];
                biomegenbase.genTerrainBlocks(worldObj, rand, blocks, metas, x * 16 + k, z * 16 + l, stoneNoise[l + k * 16]);

            }

        }

    }

    /**
     *  `provideChunk` provides a chunk at any given `x` and `y` value
     */
    @Override
    public Chunk provideChunk(int x, int z) {

        rand.setSeed((long)x * 341873128712L + (long)z * 132897987541L);

        BlockMetaBuffer buffer = getChunkPrimer(x, z);
        Chunk chunk = new Chunk(worldObj, buffer.getBlocks(), buffer.getMetas(), x, z);

        byte[] bytes = chunk.getBiomeArray();

        for (int k = 0; k < bytes.length; ++k) {
            bytes[k] = (byte)this.biomesForGeneration[k].biomeID;
        }

        chunk.generateSkylightMap();
        return chunk;

    }

    /**
     *  `populate` is called to populate a chunk with features (like ores, trees, etc.).
     */
    @Override
    public void populate(IChunkProvider provider, int x, int z) {

        BlockFalling.fallInstantly = true;

        int k = x * 16;
        int l = z * 16;

        BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
        this.rand.setSeed(this.worldObj.getSeed());

        long i1 = this.rand.nextLong() / 2L * 2L + 1L;
        long j1 = this.rand.nextLong() / 2L * 2L + 1L;

        this.rand.setSeed((long)x * i1 + (long)z * j1 ^ this.worldObj.getSeed());

        biomegenbase.decorate(this.worldObj, this.rand, k, l);

        BlockFalling.fallInstantly = false;

    }

    /**
     *  This one might recreate structures
     */
    @Override
    public void recreateStructures(int x, int z) {

    }

    /**
     *  `getPossibleCreatures` returns a list of possible creatures that can spawn
     *  at the specified coordinates in the chunk.
     */
    @SuppressWarnings("rawtypes")
    @Override
    public List getPossibleCreatures(EnumCreatureType creatureType, int x, int y, int z) {

        BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(x, z);

        return biomegenbase.getSpawnableList(creatureType);

    }

    /**
     *  `loadChunk` loads a chunk at the specified x and z coordinates.
     */
    @Override
    public Chunk loadChunk(int x, int z) {
        return provideChunk(x, z);
    }

    /**
     *  `func_147416_a` (clear and concise name) is used to find a specific structure's position in the world,
     *  given its name and coordinates.
     */
    @Override
    public ChunkPosition func_147416_a(World world, String name, int x, int y, int z) {
        return null;
    }


    //----------------------------------------------------------------------------------//

    /**
     * `saveChunks` saves loaded chunks (no way)
     *  If `forceSave` it true, then the function will save all chunks
     *  If false, it will save up to two chunks
     *  In this override, it always returns true, indicated a successful save
     */
    @Override
    public boolean saveChunks(boolean forceSave, IProgressUpdate progress) {
        return true;
    }

    /**
     *  `getLoadedChunkCount` returns the number of loaded chunks in the dimension.
     *  In this override, it always returns 0, indicating no chunks are loaded.
     */
    @Override
    public int getLoadedChunkCount() {
        return 0;
    }

    /**
     * `unloadQueuedChunks` unloads any chunks that are queued for unloading.
     */
    @Override
    public boolean unloadQueuedChunks() {
        return false;
    }

    /**
     *  This method checks if the dimension can be saved.
     */
    @Override
    public boolean canSave() {
        return true;
    }

    /**
     *  `makeString` returns a string that represents the dimension.
     */
    @Override
    public String makeString() {
        return "SbndDim";
    }

    /**
     *  `chunkExists` checks if a chunk exists at the specified x and z coordinates. (really??)
     */
    @Override
    public boolean chunkExists(int x, int z) {
        return true;
    }

    /**
     *  `saveExtraData` is called to save any extra data related to the dimension.
     */
    @Override
    public void saveExtraData() { }

    //----------------------------------------------------------------------------------//

    @Getter
    public static class BlockMetaBuffer {

        private Block[] blocks = new Block[256 * 16 * 16];
        private byte[] metas = new byte[256 * 16 * 16];

    }

}