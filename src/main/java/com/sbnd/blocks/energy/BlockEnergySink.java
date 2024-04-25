package com.sbnd.blocks.energy;

import com.sbnd.tileentity.energy.BlockEnergySinkTileEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEnergySink extends BlockContainer
{
    protected BlockEnergySink(Material material) {
        super(material);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new BlockEnergySinkTileEntity();
    }
}
