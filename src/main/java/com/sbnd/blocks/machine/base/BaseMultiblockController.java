package com.sbnd.blocks.machine.base;

import api.util.BlockPos;
import com.sbnd.tileentity.machine.base.BaseMultiblockControllerTE;
import com.sbnd.tileentity.machine.base.BaseMultiblockModuleTE;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BaseMultiblockController extends BlockContainer {

    public BaseMultiblockController(Material material) {
        super(material);
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);

        if(world.getTileEntity(x, y, z) instanceof BaseMultiblockControllerTE) {

            BaseMultiblockControllerTE te = (BaseMultiblockControllerTE) world.getTileEntity(x, y, z);

            te.pingController(world, new BlockPos(x, y, z), te.getValidDirections());

        }

    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {

        TileEntity te = world.getTileEntity(x, y, z);

        super.breakBlock(world, x, y, z, block, meta);

        if(te instanceof BaseMultiblockControllerTE) {

            BaseMultiblockControllerTE controller = (BaseMultiblockControllerTE) te;

            controller.delete();

        }

    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        super.onNeighborBlockChange(world, x, y, z, block);

        if(world.getTileEntity(x, y, z) instanceof BaseMultiblockModuleTE) {

            BaseMultiblockModuleTE te = (BaseMultiblockModuleTE) world.getTileEntity(x, y, z);

            te.moduleScan(world, new BlockPos(x, y, z), te.getValidDirections());

        }

    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new BaseMultiblockControllerTE();
    }

}