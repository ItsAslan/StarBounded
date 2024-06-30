package com.sbnd.proxy;

import com.sbnd.content.block.ModBlocks;
import com.sbnd.content.item.ModItems;
import com.sbnd.world.celestial.SbndCelestialObjects;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent $e) {

        ModBlocks.REGISTER();
        ModItems.REGISTER();

    }

    public void init(FMLInitializationEvent $e) {

        SbndCelestialObjects.REGISTER();

    }

    public void postInit(FMLPostInitializationEvent $e) {

    }

}
