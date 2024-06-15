package com.sbnd.blocks.energy;

import api.util.BlockPos;
import com.sbnd.tileentity.energy.BlockEnergySourceTE;
import com.sbnd.tileentity.machine.base.BaseMultiblockControllerTE;
import net.minecraft.block.Block;
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
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);

        TileEntity te = world.getTileEntity(x, y, z);

        if(te == null) {
            return;
        }

        if(te instanceof BlockEnergySourceTE) {

            BlockEnergySourceTE source = (BlockEnergySourceTE) te;

            source.scan(world, new BlockPos(x, y, z));

        }

    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {

        TileEntity te = world.getTileEntity(x, y, z);

        super.breakBlock(world, x, y, z, block, meta);

        if(te == null) {
            return;
        }

        if(te instanceof BlockEnergySourceTE) {

            BlockEnergySourceTE source = (BlockEnergySourceTE) te;

            if(source.hasNetwork()) {

                source.getNetwork().removeLink(world, new BlockPos(x, y, z), source);

            }

        }

    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new BlockEnergySourceTE();
    }

}
