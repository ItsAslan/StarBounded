package com.sbnd.blocks.energy;

import api.util.BlockPos;
import com.sbnd.tileentity.energy.BlockEnergySinkTE;
import com.sbnd.tileentity.energy.BlockEnergySourceTE;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEnergySink extends BlockContainer
{
    public BlockEnergySink(Material material) {
        super(material);
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);

        TileEntity te = world.getTileEntity(x, y, z);

        if(te == null) {
            return;
        }

        if(te instanceof BlockEnergySinkTE) {

            BlockEnergySinkTE source = (BlockEnergySinkTE) te;

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

        if(te instanceof BlockEnergySinkTE) {

            BlockEnergySinkTE sink = (BlockEnergySinkTE) te;

            if(sink.hasNetwork()) {

                sink.getNetwork().removeLink(world, new BlockPos(x, y, z), sink);

            }

        }

    }


    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new BlockEnergySinkTE();
    }

}
