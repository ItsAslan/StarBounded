package com.sbnd.tileentity;

import com.sbnd.tileentity.energy.BlockEnergyPathTileEntity;
import com.sbnd.tileentity.energy.BlockEnergySinkTileEntity;
import com.sbnd.tileentity.energy.BlockEnergySourceTileEntity;
import com.sbnd.tileentity.test.TestControllerTE;
import com.sbnd.tileentity.test.TestModuleTE;
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
        GameRegistry.registerTileEntity(TestControllerTE.class, "ControllerTileEntity");
        GameRegistry.registerTileEntity(TestModuleTE.class, "ModuleTileEntity");
    }
}
