package com.sbnd.tileentity.test;

import api.interfaces.multiblock.base.IMultiblockController;
import api.interfaces.multiblock.base.IMultiblockModule;
import lombok.Getter;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;
import java.util.List;

public class TestControllerTE extends TileEntity implements IMultiblockController {

    @Getter
    private List<IMultiblockModule> connectedModules = new ArrayList<>();

    @Override
    public List<IMultiblockModule> getModules() {
        return getConnectedModules();
    }

    @Override
    public void tick() {

        if(!worldObj.isRemote) {
            System.out.printf("%d | %s\n", getConnectedModules().size(), this);
        }

    }

    @Override
    public void updateEntity() {

        tick();

        super.updateEntity();

    }

}
