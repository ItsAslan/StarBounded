package com.sbnd.blocks.test;

import api.util.BlockPos;
import com.sbnd.tileentity.test.TestControllerTE;
import com.sbnd.tileentity.test.TestModuleTE;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TestController extends BlockContainer {


    public TestController(Material material) {
        super(material);
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);

        if(world.getTileEntity(x, y, z) instanceof TestControllerTE) {

            TestControllerTE te = (TestControllerTE) world.getTileEntity(x, y, z);

            te.pingController(world, new BlockPos(x, y, z));

        }

    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {

        TileEntity te = world.getTileEntity(x, y, z);

        if(te instanceof TestControllerTE) {

            TestControllerTE controller = (TestControllerTE) te;

            controller.delete();

        }

        super.breakBlock(world, x, y, z, block, meta);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        super.onNeighborBlockChange(world, x, y, z, block);

        if(world.getTileEntity(x, y, z) instanceof TestModuleTE) {

            TestModuleTE te = (TestModuleTE) world.getTileEntity(x, y, z);

            te.moduleScan(world, new BlockPos(x, y, z));

        }

    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TestControllerTE();
    }

}
