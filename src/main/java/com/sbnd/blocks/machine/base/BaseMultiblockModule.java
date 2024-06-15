package com.sbnd.blocks.machine.base;

import api.util.BlockPos;
import com.sbnd.blocks.generic.BlockContainerGeneric;
import com.sbnd.tileentity.machine.base.BaseMultiblockModuleTE;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BaseMultiblockModule extends BlockContainerGeneric {

    public BaseMultiblockModule(Material material) {
        super(material);
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);

        if(world.getTileEntity(x, y, z) instanceof BaseMultiblockModuleTE) {

            BaseMultiblockModuleTE te = (BaseMultiblockModuleTE) world.getTileEntity(x, y, z);

            te.moduleScan(world, new BlockPos(x, y, z), te.getValidDirections());

        }

    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {

        TileEntity te = world.getTileEntity(x, y, z);

        if(te instanceof BaseMultiblockModuleTE) {

            BaseMultiblockModuleTE module = (BaseMultiblockModuleTE) te;

            module.unlinkModule();

        }

        super.breakBlock(world, x, y, z, block, meta);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new BaseMultiblockModuleTE();
    }

}