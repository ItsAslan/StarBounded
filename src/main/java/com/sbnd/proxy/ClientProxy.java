package com.sbnd.proxy;

import com.sbnd.render.tileentity.test.InterpTestSpecialRenderer;
import com.sbnd.tileentity.test.TestInterpTileEntity;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
    public void preInit(FMLPreInitializationEvent $e)
    {
        super.preInit($e);

        ClientRegistry.bindTileEntitySpecialRenderer(TestInterpTileEntity.class, new InterpTestSpecialRenderer());

    }

    public void init(FMLInitializationEvent $e)
    {
        super.init($e);

    }

    public void postInit(FMLPostInitializationEvent $e)
    {
        super.postInit($e);

    }
}
