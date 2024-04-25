package com.sbnd.blocks.energy;

import com.sbnd.tileentity.energy.BlockEnergySourceTileEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEnergySource extends BlockContainer
{
    public BlockEnergySource(Material material) {
        super(material);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new BlockEnergySourceTileEntity();
    }
}
