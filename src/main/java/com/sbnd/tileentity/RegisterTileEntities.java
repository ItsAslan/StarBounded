package com.sbnd.tileentity;

import com.sbnd.tileentity.energy.BlockEnergyPathTE;
import com.sbnd.tileentity.energy.BlockEnergySinkTE;
import com.sbnd.tileentity.energy.BlockEnergySourceTE;
import com.sbnd.tileentity.machine.base.BaseMultiblockControllerTE;
import com.sbnd.tileentity.machine.base.BaseMultiblockModuleTE;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterTileEntities
{
    public static void MainRegistry()
    {

        //Energy
        GameRegistry.registerTileEntity(BlockEnergyPathTE.class, "BlockEnergyPathTileEntity");
        GameRegistry.registerTileEntity(BlockEnergySinkTE.class, "BlockEnergySinkTileEntity");
        GameRegistry.registerTileEntity(BlockEnergySourceTE.class, "BlockEnergySourceTileEntity");

        //Multiblocks
        GameRegistry.registerTileEntity(BaseMultiblockControllerTE.class, "baseMultiblockControllerTileEntity");
        GameRegistry.registerTileEntity(BaseMultiblockModuleTE.class, "baseMultiblockModuleTileEntity");

    }
}
