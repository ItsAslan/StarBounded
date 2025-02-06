package com.sbnd;

import com.sbnd.server.init.ModBlocks;
import com.sbnd.server.init.ModTileEntities;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent $e) {

        ModBlocks.register();

    }

    public void init(FMLInitializationEvent $e) {

        ModTileEntities.register();

    }

    public void postInit(FMLPostInitializationEvent $e) {

        ;

    }

}