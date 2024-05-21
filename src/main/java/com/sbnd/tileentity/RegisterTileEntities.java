package com.sbnd.tileentity;

import com.sbnd.tileentity.energy.BlockEnergyPathTileEntity;
import com.sbnd.tileentity.energy.BlockEnergySinkTileEntity;
import com.sbnd.tileentity.energy.BlockEnergySourceTileEntity;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterTileEntities
{
    public static void MainRegistry()
    {
        GameRegistry.registerTileEntity(BlockEnergyPathTileEntity.class, "BlockEnergyPathTileEntity");
        GameRegistry.registerTileEntity(BlockEnergySinkTileEntity.class, "BlockEnergySinkTileEntity");
        GameRegistry.registerTileEntity(BlockEnergySourceTileEntity.class, "BlockEnergySourceTileEntity");
    }
}
