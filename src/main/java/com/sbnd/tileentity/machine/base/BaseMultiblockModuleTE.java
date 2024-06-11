package com.sbnd.tileentity.machine.base;

import api.interfaces.multiblock.base.IMultiblockController;
import api.interfaces.multiblock.base.IMultiblockModule;
import api.util.BlockPos;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.Arrays;

public class BaseMultiblockModuleTE extends TileEntity implements IMultiblockModule {

    @Getter
    @Setter
    ArrayList<ForgeDirection> validConnections = new ArrayList<>(Arrays.asList(ForgeDirection.VALID_DIRECTIONS));

    @Getter
    @Setter
    private IMultiblockController multiblockController;

    @Override
    public IMultiblockController getController() {
        return getMultiblockController();
    }

    @Override
    public BlockPos getPos() {
        return new BlockPos(this.xCoord, this.yCoord, this.zCoord);
    }

    @Override
    public ArrayList<ForgeDirection> getValidDirections() {
        return getValidConnections();
    }

    @Override
    public void setController(IMultiblockController controller) {

        if(controller != null) {
            setMultiblockController(controller);
            linkModule();
        }
        else {
            System.out.println("set controlelr to nul");
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

            getController().getModules().remove(this);
            invalidate();

            getController().pingController(worldObj, getController().getPos(), getValidDirections());
            setController(null);

        }


    }

    @Override
    public void notifyControllerDeletion() {

        setController(null);

    }

    @Override
    public boolean hasController() {
        return getController() != null;
    }

}