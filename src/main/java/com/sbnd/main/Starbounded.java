package com.sbnd.main;

import com.sbnd.commands.CommandTeleportDimension;
import com.sbnd.config.PlanetConfig;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import com.sbnd.proxy.CommonProxy;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = ModVars.MOD_ID, name = ModVars.MOD_NAME, version = ModVars.MOD_VERSION)
public class Starbounded {

    @Mod.Instance
    public static Starbounded instance = new Starbounded();

    @SidedProxy(clientSide = "com.sbnd.proxy.ClientProxy", serverSide = "com.sbnd.proxy.ServerProxy")
    public static CommonProxy PROXY;

    private Configuration config;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent $e) {
        PROXY.preInit($e);

        config = new Configuration($e.getSuggestedConfigurationFile());
        config.load();

        PlanetConfig.loadFromConfig(config);

        if(config.hasChanged()) {

            config.save();

        }

    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent $e) {
        PROXY.init($e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent $e) {
        PROXY.postInit($e);
    }

    @Mod.EventHandler
    public void serverStart(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandTeleportDimension());
    }

}
