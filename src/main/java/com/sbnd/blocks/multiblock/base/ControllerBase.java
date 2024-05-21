package com.sbnd.blocks.multiblock.base;

import api.interfaces.multiblock.base.IMultiblockController;
import api.interfaces.multiblock.base.IMultiblockModule;
import com.sbnd.main.MultiblockManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public abstract class ControllerBase extends Block implements IMultiblockController {

    public ControllerBase(Material material) {
        super(material);
    }

    public int onBlockPlaced(World world, int x, int y, int z, int metadata, float hitX, float hitY, float hitZ, int itemMetadata) {

        MultiblockManager.registerMultiblock(this);

        return super.onBlockPlaced(world, x, y, z, metadata, hitX, hitY, hitZ, itemMetadata);
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {

        MultiblockManager.terminateMultiblock(this);

        super.breakBlock(world, x, y, z, block, meta);
    }

    @Override
    abstract public void newBlockAdded(ModuleBase block);

    @Override
    abstract public void tick();

}
