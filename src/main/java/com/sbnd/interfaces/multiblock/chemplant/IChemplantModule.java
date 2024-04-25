package com.sbnd.interfaces.multiblock.chemplant;

import com.sbnd.api.BlockCoordinate;

public interface IChemplantModule
{

    boolean isFluidContainer();

    void setController(IChemplantController controller);
    IChemplantController getController();

}
