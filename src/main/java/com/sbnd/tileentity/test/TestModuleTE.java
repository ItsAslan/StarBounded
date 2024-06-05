package com.sbnd.tileentity.test;

import api.interfaces.multiblock.base.IMultiblockController;
import api.interfaces.multiblock.base.IMultiblockModule;
import api.util.BlockPos;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TestModuleTE extends TileEntity implements IMultiblockModule {

    @Getter
    @Setter
    private IMultiblockController multiblockController;

    @Override
    public IMultiblockController getController() {
        return getMultiblockController();
    }

    @Override
    public void setController(IMultiblockController controller) {

        if(controller != null) {
            setMultiblockController(controller);
            linkModule();
        }
        else {
            setMultiblockController(null);
        }

    }

    @Override
    public void linkModule() {
        getMultiblockController().getModules().add(this);
    }

    @Override
    public void unlinkModule() {

        if(hasController()) {

            getMultiblockController().getModules().remove(this);
            setController(null);

        }

    }

    @Override
    public boolean hasController() {
        return getMultiblockController() != null;
    }

}
