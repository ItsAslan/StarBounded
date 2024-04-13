package com.sbnd.gen;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class StarBoundedGenHandler
{
    public static void addOreSpawn(Block block, World world, Random random, int blockX, int blockZ, int maxX, int maxZ, int maxVeinSize, int minVeinSize, int chanceToSpawn, int minY, int maxY)
    {
        for(int i = 0; i < chanceToSpawn; i++)
        {
            int xPos = blockX + random.nextInt(maxX);
            int yPos = minY + random.nextInt(maxY - minY);
            int zPos = blockZ + random.nextInt(maxZ);

            (new WorldGenMinable(block, maxVeinSize)).generate(world, random, xPos, yPos, zPos);
        }
    }
}
