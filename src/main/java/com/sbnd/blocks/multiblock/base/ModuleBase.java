package com.sbnd.blocks.multiblock.base;

import api.interfaces.multiblock.base.IMultiblockController;
import api.interfaces.multiblock.base.IMultiblockModule;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class ModuleBase extends Block implements IMultiblockModule {

    @Getter
    @Setter
    ControllerBase multiblockController;

    public ModuleBase(Material material) {
        super(material);
    }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int metadata, float hitX, float hitY, float hitZ, int itemMetadata) {

        for(ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {

            Block block = world.getBlock(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ);

            if(block instanceof ControllerBase) {

                ControllerBase controller = (ControllerBase) block;

                controller.newBlockAdded(this);
                setController(controller);
                break;

            }
            else if(block instanceof ModuleBase) {

                ModuleBase module = (ModuleBase) block;

                if(module.getController() == null) {
                    continue;
                }

                setMultiblockController(module.getController());

            }

        }

        return super.onBlockPlaced(world, x, y, z, metadata, hitX, hitY, hitZ, itemMetadata);

    }

    @Override
    public ControllerBase getController() {
        return getMultiblockController();
    }

    @Override
    public void setController(ControllerBase controller) {
        setMultiblockController(controller);
    }

}
