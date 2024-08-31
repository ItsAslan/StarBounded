package com.sbnd.world.celestial.core.gen.features;

import com.sbnd.content.block.ModBlocks;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.MapGenBase;

import java.util.ArrayList;
import java.util.Arrays;

@Getter
public class CraterGenerator extends MapGenBase {

    private int probabilityPerChunk = 100;
    private int minimumRadius = 5;
    private int maximumRadius = 40;

    @Getter
    @Setter
    private Block surfaceLayer = ModBlocks.blockMoonRock;

    @Getter
    @Setter
    private Block subsurfaceLayer = ModBlocks.blockMoonBasalt;

    private ArrayList<BiomeGenBase> omittedBiomes;

    public CraterGenerator(int probabilityPerChunk) {

        this.probabilityPerChunk = probabilityPerChunk;

        omittedBiomes = new ArrayList<>();

    }

    public CraterGenerator(int probabilityPerChunk, BiomeGenBase... omittedBiomes) {

        this( probabilityPerChunk );

        this.omittedBiomes.addAll(Arrays.asList(omittedBiomes));

    }

    public void setCraterSize(int minRadius, int maxRadius) {

        this.minimumRadius = minRadius;
        this.maximumRadius = maxRadius;

        this.range = (maxRadius / 5) + 1;

    }

    @Override
    protected void func_151538_a(World world, int xOffset, int zOffset, int chunkX, int chunkZ, Block[] blocks) {

        if(checkForOmittedBiome(world, -xOffset + chunkX, -zOffset + chunkZ)) {

            if (rand.nextInt(probabilityPerChunk) == Math.abs(xOffset) % probabilityPerChunk && rand.nextInt(probabilityPerChunk) == Math.abs(zOffset) % probabilityPerChunk) {

                double radius = rand.nextInt(maximumRadius - minimumRadius) + minimumRadius;
                double depth = radius * 0.25D;

                int xCoord = -xOffset + chunkX;
                int zCoord = -zOffset + chunkZ;

                for (int x = 15; x >= 0; x--) {

                    for (int z = 15; z >= 0; z--) {

                        for (int y = 254; y >= 0; y--) {

                            int index = (x * 16 + z) * 256 + y;

                            if (blocks[index] != null && (blocks[index].isOpaqueCube() || blocks[index].getMaterial().isLiquid())) {

                                int xPos = xCoord * 16 + x;
                                int zPos = zCoord * 16 + z;

                                double distance = Math.sqrt(xPos * xPos + zPos * zPos);

                                if (distance - rand.nextInt(2) <= radius) {

                                    int depthLevel = (int) MathHelper.clamp_double(calculateDepth(distance, radius, depth), 0, y - 1);

                                    for (int i = 0; i < depthLevel; i++) {

                                        blocks[index - i] = null;

                                    }

                                    index -= depthLevel;
                                    y -= depthLevel;

                                    depthLevel = Math.min(3, y - 1);

                                    if (distance + rand.nextInt(2) <= radius / 2D) {

                                        for (int i = 0; i < depthLevel; i++) {

                                            blocks[index - i] = subsurfaceLayer;

                                        }

                                    } else {

                                        for (int i = 0; i < depthLevel; i++) {

                                            blocks[index - i] = surfaceLayer;

                                        }

                                    }

                                }

                                break;

                            }

                        }

                    }

                }

            }

        }

    }

    /**
     *  This is probably temporary, for it doesn't really make much sense why some biomes wouldn't
     *  have craters
     */
    private boolean checkForOmittedBiome(World world, int x, int z) {

        BiomeGenBase biome = (BiomeGenBase) world.getBiomeGenForCoords(x, z);

        for(BiomeGenBase omitted : omittedBiomes) {

            if(omitted.equals(biome)) {

                return false;

            }

        }

        return true;

    }

    private double calculateDepth(double distance, double radius, double depth) {

        return -Math.pow(distance, 5) / Math.pow(radius, 5) * depth + depth;

    }

}
