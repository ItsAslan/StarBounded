package com.sbnd.proxy;

import com.sbnd.content.block.ModBlocks;
import com.sbnd.content.crafting.CraftingRegistry;
import com.sbnd.content.item.ModItems;
import com.sbnd.content.transport.fluid.gas.ModGasses;
import com.sbnd.content.transport.fluid.liquid.ModFluids;
import com.sbnd.world.biome.SbndBiomes;
import com.sbnd.world.celestial.SbndCelestialObjects;
import com.sbnd.world.gen.SbndGen;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent $e) {

        ModItems.REGISTER();
        ModBlocks.REGISTER();
        ModGasses.REGISTER();
        ModFluids.REGISTER();

        CraftingRegistry.REGISTER();

        GameRegistry.registerWorldGenerator(new SbndGen(), 0);

    }

    public void init(FMLInitializationEvent $e) {

        SbndCelestialObjects.REGISTER();
        SbndBiomes.REGISTER();

    }

    public void postInit(FMLPostInitializationEvent $e) {

    }

}
