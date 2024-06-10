package com.sbnd.proxy;

import com.sbnd.blocks.ModBlocks;
import com.sbnd.render.item.machine.MixerItemRenderer;
import com.sbnd.render.tileentity.machine.MixerTileRenderer;
import com.sbnd.tileentity.machine.mixer.MixerModuleTE;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{

    public void preInit(FMLPreInitializationEvent $e)
    {
        super.preInit($e);

    }

    public void init(FMLInitializationEvent $e)
    {
        super.init($e);

        // TESR Renderers
        ClientRegistry.bindTileEntitySpecialRenderer(MixerModuleTE.class, new MixerTileRenderer());

        // Item Renderers
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.mixerModule), new MixerItemRenderer());

    }

    public void postInit(FMLPostInitializationEvent $e)
    {
        super.postInit($e);

    }
}
