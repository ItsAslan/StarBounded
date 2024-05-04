package com.sbnd.world;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class StarBoundedGenHandler
{
    public static void addOreSpawn(Block block, Block blockIn, World world, Random random, int blockX, int blockZ, int maxOffsetX, int maxOffsetZ, int maxVeinSize, int minVeinSize, int chanceToSpawn, int minY, int maxY)
    {
        for (int i = 0; i < chanceToSpawn; i++)
        {
            int xPos = blockX + random.nextInt(maxOffsetX);
            int yPos = minY + random.nextInt(maxY - minY);
            int zPos = blockZ + random.nextInt(maxOffsetZ);

            int veinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize + 1);

            System.out.printf("Attempted to Spawn Ore at: (%d, %d, %d)%n", xPos, yPos, zPos);

            (new WorldGenMinable(block, veinSize, blockIn)).generate(world, random, xPos, yPos, zPos);
        }
    }

}
