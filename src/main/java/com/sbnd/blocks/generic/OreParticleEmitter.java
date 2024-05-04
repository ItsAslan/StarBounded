package com.sbnd.blocks.generic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

public class OreParticleEmitter extends OreGeneric
{

    public OreParticleEmitter(Material material) {
        super(material);
    }

    public OreParticleEmitter(Material material, Item itemToDrop, int maxAmount) {
        super(material, itemToDrop, maxAmount);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        super.randomDisplayTick(world, x, y, z, random);

        for(ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {

            if(dir == ForgeDirection.DOWN)
                continue;

            if(world.getBlock(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ).getMaterial() == Material.air) {

                double ix = x + 0.5F + dir.offsetX + random.nextDouble() - 0.5D;
                double iy = y + 0.5F + dir.offsetY + random.nextDouble() - 0.5D;
                double iz = z + 0.5F + dir.offsetZ + random.nextDouble() - 0.5D;

                if(dir.offsetX != 0)
                    ix = x + 0.5F + dir.offsetX * 0.5 + random.nextDouble() * 0.125 * dir.offsetX;
                if(dir.offsetY != 0)
                    iy = y + 0.5F + dir.offsetY * 0.5 + random.nextDouble() * 0.125 * dir.offsetY;
                if(dir.offsetZ != 0)
                    iz = z + 0.5F + dir.offsetZ * 0.5 + random.nextDouble() * 0.125 * dir.offsetZ;

                world.spawnParticle("flame", ix, iy, iz, 0.0, 0.0, 0.0);
                world.spawnParticle("smoke", ix, iy, iz, 0.0, 0.0, 0.0);
                world.spawnParticle("smoke", ix, iy, iz, 0.0, 0.1, 0.0);
            }
        }
    }
}
