package com.sbnd.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import com.sbnd.blocks.ModBlocks;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent $e)
    {
        ModBlocks.MainRegistry();
    }

    public void init(FMLInitializationEvent $e)
    {

    }

    public void postInit(FMLPostInitializationEvent $e)
    {

    }
}
