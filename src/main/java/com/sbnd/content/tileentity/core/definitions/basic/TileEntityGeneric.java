package com.sbnd.content.tileentity.core.definitions.basic;

import api.backport.BlockPos;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGeneric extends TileEntity {

    public BlockPos getPosition() {

        return new BlockPos(this.xCoord, this.yCoord, this.zCoord);

    }

}
