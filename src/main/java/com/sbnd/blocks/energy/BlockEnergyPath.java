package com.sbnd.blocks.energy;

import com.sbnd.tileentity.energy.BlockEnergyPathTileEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEnergyPath extends BlockContainer
{
    protected BlockEnergyPath(Material material) {
        super(material);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new BlockEnergyPathTileEntity();
    }
}
