package com.sbnd.tileentity;

import com.sbnd.tileentity.energy.BlockEnergyPathTileEntity;
import com.sbnd.tileentity.energy.BlockEnergySinkTileEntity;
import com.sbnd.tileentity.energy.BlockEnergySourceTileEntity;
import com.sbnd.tileentity.machine.base.BaseMultiblockControllerTE;
import com.sbnd.tileentity.machine.base.BaseMultiblockModuleTE;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterTileEntities
{
    public static void MainRegistry()
    {

        //Energy
        GameRegistry.registerTileEntity(BlockEnergyPathTileEntity.class, "BlockEnergyPathTileEntity");
        GameRegistry.registerTileEntity(BlockEnergySinkTileEntity.class, "BlockEnergySinkTileEntity");
        GameRegistry.registerTileEntity(BlockEnergySourceTileEntity.class, "BlockEnergySourceTileEntity");

        //Multiblocks
        GameRegistry.registerTileEntity(BaseMultiblockControllerTE.class, "baseMultiblockControllerTileEntity");
        GameRegistry.registerTileEntity(BaseMultiblockModuleTE.class, "baseMultiblockModuleTileEntity");

    }
}
