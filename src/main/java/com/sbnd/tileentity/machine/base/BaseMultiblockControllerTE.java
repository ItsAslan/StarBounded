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
import java.util.List;

public class BaseMultiblockControllerTE extends TileEntity implements IMultiblockController {

    @Getter
    @Setter
    ArrayList<ForgeDirection> validConnections = new ArrayList<>(Arrays.asList(ForgeDirection.VALID_DIRECTIONS));

    @Getter
    private List<IMultiblockModule> connectedModules = new ArrayList<>();

    @Override
    public List<IMultiblockModule> getModules() {
        return getConnectedModules();
    }

    @Override
    public BlockPos getPos(){
        return new BlockPos(this.xCoord, this.yCoord, this.zCoord);
    }

    @Override
    public ArrayList<ForgeDirection> getValidDirections() {
        return getValidConnections();
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