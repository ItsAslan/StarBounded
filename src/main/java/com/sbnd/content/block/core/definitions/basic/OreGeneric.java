package com.sbnd.content.block.core.definitions.basic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lombok.Getter;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;
import java.util.Set;

public class OreGeneric extends Block {

    OreType type;

    private Item itemToDrop = null;

    private int maxAmount = 1;

    public enum OreType {

        NORMAL(null, null),
        BURNING("flame", "smoke"),
        FREEZING("----", "----"),
        WET("----", "----");

        @Getter
        private final String particle;

        @Getter
        private final String secondaryParticle;

        OreType(String particle, String secondaryParticle) {

            this.particle = particle;
            this.secondaryParticle = secondaryParticle;

        }

    }

    public OreGeneric(Set<Block> registry, Material material, OreType type) {

        super(material);
        registry.add(this);

        this.type = type;

    }

    public OreGeneric(Set<Block> registry, Material material, OreType type, Item itemToDrop, int maxAmount) {

        super(material);
        registry.add(this);

        this.type = type;

        this.itemToDrop = itemToDrop;
        this.maxAmount = maxAmount;

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        super.randomDisplayTick(world, x, y, z, random);

        if(type != OreType.NORMAL) {

            for(ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {

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

                    world.spawnParticle(type.getParticle(), ix, iy, iz, 0.0, 0.0, 0.0);
                    world.spawnParticle(type.getSecondaryParticle(), ix, iy, iz, 0.0, 0.0, 0.0);
                    world.spawnParticle(type.getSecondaryParticle(), ix, iy, iz, 0.0, 0.1, 0.0);
                }

            }

        }

    }

    @Override
    public int quantityDropped(Random random) {
        return 1 + random.nextInt(maxAmount);
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return itemToDrop != null ? itemToDrop : super.getItemDropped(meta, random, fortune);
    }

}
