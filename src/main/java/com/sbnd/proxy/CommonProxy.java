package com.sbnd.proxy;

import com.sbnd.crafting.RegisterCrafting;
import com.sbnd.items.ModItems;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import com.sbnd.blocks.ModBlocks;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent $e)
    {
        ModItems.MainRegistry();
        ModBlocks.MainRegistry();
        RegisterCrafting.MainRegistry();
    }

    public void init(FMLInitializationEvent $e)
    {

    }

    public void postInit(FMLPostInitializationEvent $e)
    {

    }
}
