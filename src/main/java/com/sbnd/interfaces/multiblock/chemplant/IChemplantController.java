package com.sbnd.interfaces.multiblock.chemplant;

import com.sbnd.interfaces.fluid.IFluidStorage;

import java.util.List;

public interface IChemplantController
{
    List<IChemplantModule> getModules();

    default int getTotalFluidStorageBlocks()
    {
        // Will probably return multiple of 16
        return (int) getModules().stream().filter(module -> module instanceof IFluidStorage).count();
    }

    default int getTotalFluidStorage()
    {
        // What the fuck?
        return getModules().stream().filter(module -> module instanceof IFluidStorage).mapToInt(module -> ((IFluidStorage) module).getMaxStorage()).sum();
    }
}
