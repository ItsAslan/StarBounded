package com.sbnd.proxy;

import com.sbnd.content.block.ModBlocks;
import com.sbnd.content.crafting.CraftingRegistry;
import com.sbnd.content.item.ModItems;
import com.sbnd.world.celestial.SbndCelestialObjects;
import com.sbnd.world.gen.SbndGen;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent $e) {

        ModBlocks.REGISTER();
        ModItems.REGISTER();

        GameRegistry.registerWorldGenerator(new SbndGen(), 0);

    }

    public void init(FMLInitializationEvent $e) {

        CraftingRegistry.REGISTER();
        SbndCelestialObjects.REGISTER();

    }

    public void postInit(FMLPostInitializationEvent $e) {

    }

}
