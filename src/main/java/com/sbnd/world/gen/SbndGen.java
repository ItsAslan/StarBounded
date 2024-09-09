package com.sbnd.world.gen;

import com.sbnd.config.OreConfig;
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

            case 4:
                genMoon(world, random, chunkX << 4, chunkZ << 4);
                break;

        }

    }

    private void genNether(World world, Random random, int x, int z) {

    }

    private void genOverworld(World world, Random random, int x, int z) {

        SbndGenToolbox.addOreSpawn(ModBlocks.oreCopper, Blocks.stone, world, random, x, z, 16, 16, 12, 4, OreConfig.COPPER_SPAWN_RATE, 12, 65);
        SbndGenToolbox.addOreSpawn(ModBlocks.oreAluminum, Blocks.stone, world, random, x, z, 16, 16, 8, 6, OreConfig.ALUMINUM_SPAWN_RATE, 12, 50);
        SbndGenToolbox.addOreSpawn(ModBlocks.oreTitanium, Blocks.stone, world, random, x, z, 16, 16, 8, 6, OreConfig.TITANIUM_SPAWN_RATE, 12, 50);
        SbndGenToolbox.addOreSpawn(ModBlocks.oreTungsten, Blocks.stone, world, random, x, z, 16, 16, 4, 2, OreConfig.TUNGSTEN_SPAWN_RATE, 12, 40);
        SbndGenToolbox.addOreSpawn(ModBlocks.oreTin, Blocks.stone, world, random, x, z, 16, 16, 8, 4, OreConfig.TIN_SPAWN_RATE, 12, 50);
        SbndGenToolbox.addOreSpawn(ModBlocks.oreSulfur, Blocks.stone, world, random, x, z, 16, 16, 8, 4, OreConfig.SULFUR_SPAWN_RATE, 12, 50);
        SbndGenToolbox.addOreSpawn(ModBlocks.oreSaltpeter, Blocks.stone, world, random, x, z, 16, 16, 8, 4, OreConfig.SALTPETER_SPAWN_RATE, 12, 50);

    }

    private void genEnd(World world, Random random, int x, int z) {

    }

    private void genMoon(World world, Random random, int x, int z) {

        SbndGenToolbox.addOreSpawn(ModBlocks.oreZirconium, ModBlocks.blockMoonRock, world, random, x, z, 16, 16, 3, 1, OreConfig.ZIRCONIUM_SPAWN_RATE, 12, 70);
        SbndGenToolbox.addOreSpawn(ModBlocks.oreNiobium, ModBlocks.blockMoonRock, world, random, x, z, 16, 16, 4, 1, OreConfig.NIOBIUM_SPAWN_RATE, 12, 70);
        SbndGenToolbox.addOreSpawn(ModBlocks.oreTantalum, ModBlocks.blockMoonRock, world, random, x, z, 16, 16, 2, 1, OreConfig.TANTALUM_SPAWN_RATE, 12, 70);
        SbndGenToolbox.addOreSpawn(ModBlocks.oreMoonIron, ModBlocks.blockMoonRock, world, random, x, z, 16, 16, 12, 5, OreConfig.MOON_IRON_SPAWN_RATE, 12, 70);
        SbndGenToolbox.addOreSpawn(ModBlocks.oreMoonTin, ModBlocks.blockMoonRock, world, random, x, z, 16, 16, 12, 5, OreConfig.MOON_TIN_SPAWN_RATE, 12, 70);
        SbndGenToolbox.addOreSpawn(ModBlocks.oreMoonTitanium, ModBlocks.blockMoonRock, world, random, x, z, 16, 16, 10, 6, OreConfig.MOON_TITANIUM_SPAWN_RATE, 12, 70);
        SbndGenToolbox.addOreSpawn(ModBlocks.oreMoonRockSaltpeter, ModBlocks.blockMoonRock, world, random, x, z, 16, 16, 10, 5, OreConfig.MOON_ROCK_SALTPETER_SPAWN_RATE, 12, 70);
        SbndGenToolbox.addOreSpawn(ModBlocks.oreMoonBasaltSaltpeter, ModBlocks.blockMoonBasalt, world, random, x, z, 16, 16, 12, 6, OreConfig.MOON_BASALT_SALTPETER_SPAWN_RATE, 12, 70);

    }

}
