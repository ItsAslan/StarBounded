package com.sbnd.world.celestial.core.gen.features;

import lombok.Getter;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;

@Getter
public class CraterGenerator extends MapGenBase {

    private final int CHANCE_TO_SPAWN;

    private int MIN_SIZE;
    private int MAX_SIZE;

    public CraterGenerator(int chance) {

        CHANCE_TO_SPAWN = chance;

    }

    public void setCraterSize(int minSize, int maxSize) {

        MIN_SIZE = minSize;
        MAX_SIZE = maxSize;

    }

    @Override
    protected void func_151538_a(World world, int offsetX, int offsetZ, int chunkX, int chunkZ, Block[] blocks) {

        int craterX = chunkX * 16 + rand.nextInt(16);
        int craterZ = chunkZ * 16 + rand.nextInt(16);
        int craterY = getY(craterX, craterZ);

        int radius = rand.nextInt(MAX_SIZE - MIN_SIZE + 1) + MIN_SIZE;
        float depth = radius * 0.5F;

        for(int x = -radius; x <= radius; ++x) {

            for(int z = -radius; z <= radius; ++z) {

                double distance = Math.sqrt(x * x + z * z);

                if(distance <= radius) {

                    int craterDepth = craterFunction(depth, distance, radius);

                    for(int y = 0; y >= -craterDepth; --y) {

                        int blockX = craterX + x;
                        int blockY = craterY + y;
                        int blockZ = craterZ + z;

                        world.setBlockToAir(blockX, blockY, blockZ);

                    }

                }

            }

        }

    }

    private int craterFunction(float depth, double distance, int radius) {

        return (int) (depth * (1 - Math.pow(distance / radius, 2)));

    }

    private int getY(int x, int z) {

        for(int y = 255; y > 0; --y) {

            if(!worldObj.isAirBlock(x, y, z)) {

                return y;

            }

        }

        return 0;

    }

}
