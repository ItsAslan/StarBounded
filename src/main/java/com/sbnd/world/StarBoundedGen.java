package com.sbnd.world;

import com.sbnd.blocks.ModBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class StarBoundedGen implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.dimensionId)
        {
            case -1:
                genNether(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 0:
                genOverworld(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 1:
                genEnd(world, random, chunkX * 16, chunkZ * 16);
                break;
            default:
                genAll(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    private void genNether(World world, Random random, int x, int z)
    {

    }

    private void genOverworld(World world, Random random, int x, int z)
    {
        StarBoundedGenHandler.addOreSpawn(ModBlocks.oreCopper, world, random, x, z, 16, 16, 12, 4, 8, 12, 65);
        StarBoundedGenHandler.addOreSpawn(ModBlocks.oreAluminum, world, random, x, z, 16, 16, 8, 6, 6, 12, 50);
        StarBoundedGenHandler.addOreSpawn(ModBlocks.oreTitanium, world, random, x, z, 16, 16, 8, 6, 6, 12, 50);
        StarBoundedGenHandler.addOreSpawn(ModBlocks.oreTungsten, world, random, x, z, 16, 16, 4, 2, 5, 12, 40);
        StarBoundedGenHandler.addOreSpawn(ModBlocks.oreTin, world, random, x, z, 16, 16, 8, 4, 6, 12, 50);
    }

    private void genEnd(World world, Random random, int x, int z)
    {

    }

    private void genAll(World world, Random random, int x, int z)
    {

    }
}