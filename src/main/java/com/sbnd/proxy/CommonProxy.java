package com.sbnd.proxy;

import com.sbnd.crafting.RegisterCrafting;
import com.sbnd.world.biome.ModBiomes;
import com.sbnd.world.dimension.DimensionRegistry;
import com.sbnd.world.StarBoundedGen;
import com.sbnd.items.ModItems;
import com.sbnd.tileentity.RegisterTileEntities;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import com.sbnd.blocks.ModBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import lombok.Getter;

public class CommonProxy
{

    public void preInit(FMLPreInitializationEvent $e)
    {

        ModItems.MainRegistry();
        ModBlocks.MainRegistry();
        RegisterCrafting.MainRegistry();
        RegisterTileEntities.MainRegistry();
        ModBiomes.MainRegistry();
        DimensionRegistry.MainRegistry();

        GameRegistry.registerWorldGenerator(new StarBoundedGen(), 0);
    }

    public void init(FMLInitializationEvent $e)
    {

    }

    public void postInit(FMLPostInitializationEvent $e)
    {

    }

}
