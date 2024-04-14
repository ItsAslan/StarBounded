package com.sbnd.tileentity.machine;

import net.minecraft.tileentity.TileEntity;

public class RocketAssemblerTileEntity extends TileEntity
{
    private int orientation = 0;

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }
}
