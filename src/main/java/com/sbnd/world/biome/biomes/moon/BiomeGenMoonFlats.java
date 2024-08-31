package com.sbnd.world.biome.biomes.moon;

import com.sbnd.content.block.ModBlocks;
import com.sbnd.world.biome.core.BiomeGenCelestial;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

import java.util.Random;
import java.util.Set;

public class BiomeGenMoonFlats extends BiomeGenCelestial {

    public static final BiomeGenBase.Height height = new BiomeGenBase.Height(0.1F, 0.1F);

    public BiomeGenMoonFlats(int id) {
        super(id);

        biomeInit();

    }

    public BiomeGenMoonFlats(Set<BiomeGenCelestial> registry, int id) {
        super(registry, id);

        biomeInit();

    }

    private void biomeInit() {

        setHeight(height);

        type = BiomeDictionary.Type.WASTELAND;
        topBlock = ModBlocks.blockMoonTurf;
        fillerBlock = ModBlocks.blockMoonRock;

        setBiomeName("Moon Flats");

    }

    /**
     *  The `BiomeGenMoonFlats` biome will be the
     *  classic "Moon Biome" with some mountains and
     *  craters. Mostly tame and wavy
     */

    @Override
    public void genTerrainBlocks(World world, Random random, Block[] blocks, byte[] metadata, int x, int z, double noiseVal) {

        Block top = this.topBlock;
        Block fill = this.fillerBlock;

        int surfaceDepth = -1;
        int seaLevel = 63;

        for (int y = 255; y >= 0; --y) {
            int index = ((z & 15) * 16 + (x & 15)) * (blocks.length / 256) + y;

            if (y <= random.nextInt(5)) {

                blocks[index] = Blocks.bedrock;

            } else {

                Block currentBlock = blocks[index];

                if (currentBlock != null && currentBlock.getMaterial() != Material.air) {

                    if (surfaceDepth == -1) {

                        if (y >= seaLevel - 1) {

                            blocks[index] = top;

                        } else {

                            blocks[index] = fill;

                        }

                        surfaceDepth = y;

                    } else if (surfaceDepth > 0) {

                        blocks[index] = fill;
                        --surfaceDepth;

                    }
                } else {

                    surfaceDepth = -1;

                }

            }

        }

    }

}
