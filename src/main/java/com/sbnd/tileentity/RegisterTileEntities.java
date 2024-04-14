package com.sbnd.tileentity;

import com.sbnd.tileentity.machine.RocketAssemblerTileEntity;
import com.sbnd.tileentity.test.TestInterpTileEntity;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterTileEntities
{
    public static void MainRegistry()
    {
        GameRegistry.registerTileEntity(TestInterpTileEntity.class, "TestInterpTileEntity");
        GameRegistry.registerTileEntity(RocketAssemblerTileEntity.class, "RocketAssemblerTileEntity");
    }
}
