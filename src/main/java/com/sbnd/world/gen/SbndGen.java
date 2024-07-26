package com.sbnd.world.gen;

import com.sbnd.content.block.ModBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class SbndGen implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

        switch (world.provider.dimensionId) {

            case -1:

                genNether(world, random, chunkX << 4, chunkZ << 4);
                break;

            case 0:

                genOverworld(world, random, chunkX << 4, chunkZ << 4);
                break;

            case 1:

                genEnd(world, random, chunkX << 4, chunkZ << 4);
                break;

            case 2:
                genMoon(world, random, chunkX << 4, chunkZ << 4);
                break;

        }

    }

    private void genNether(World world, Random random, int x, int z) {

    }

    private void genOverworld(World world, Random random, int x, int z) {

        SbndGenToolbox.addOreSpawn(ModBlocks.oreCopper, Blocks.stone, world, random, x, z, 16, 16, 12, 4, 8, 12, 65);
        SbndGenToolbox.addOreSpawn(ModBlocks.oreAluminum, Blocks.stone, world, random, x, z, 16, 16, 8, 6, 6, 12, 50);
        SbndGenToolbox.addOreSpawn(ModBlocks.oreTitanium, Blocks.stone, world, random, x, z, 16, 16, 8, 6, 6, 12, 50);
        SbndGenToolbox.addOreSpawn(ModBlocks.oreTungsten, Blocks.stone, world, random, x, z, 16, 16, 4, 2, 5, 12, 40);
        SbndGenToolbox.addOreSpawn(ModBlocks.oreTin, Blocks.stone, world, random, x, z, 16, 16, 8, 4, 6, 12, 50);
        SbndGenToolbox.addOreSpawn(ModBlocks.oreSulfur, Blocks.stone, world, random, x, z, 16, 16, 8, 4, 6, 12, 50);

    }

    private void genEnd(World world, Random random, int x, int z) {

    }

    private void genMoon(World world, Random random, int x, int z) {

        SbndGenToolbox.addOreSpawn(ModBlocks.oreZirconium, ModBlocks.blockMoonTurf, world, random, x, z, 16, 16, 3, 1, 2, 58, 67);
        SbndGenToolbox.addOreSpawn(ModBlocks.oreNiobium, ModBlocks.blockMoonTurfMedium, world, random, x, z, 16, 16, 4, 1, 3, 50, 57);
        SbndGenToolbox.addOreSpawn(ModBlocks.oreTantalum, ModBlocks.blockMoonTurfDark, world, random, x, z, 16, 16, 2, 1, 7, 40, 57);

    }

}
