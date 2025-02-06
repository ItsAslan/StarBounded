package com.sbnd.server.tileentity;

import api.sbnd.utility.BlockPos;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGeneric extends TileEntity {

    public BlockPos getPosition() { return new BlockPos(xCoord, yCoord, zCoord); }

}
