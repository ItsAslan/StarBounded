package com.sbnd;

import api.sbnd.ModVars;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import lombok.Getter;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModVars.MOD_ID, name = ModVars.MOD_NAME, version = ModVars.MOD_VERSION)
public class Starbounded {

    private final static String CLIENT_PROXY = "com.sbnd.client.ClientProxy";
    private final static String SERVER_PROXY = "com.sbnd.server.ServerProxy";

    @Getter private static Logger LOGGER = LogManager.getLogger(ModVars.MOD_ID);

    @Getter
    @Mod.Instance
    private static Starbounded instance = new Starbounded();

    @SidedProxy(
            clientSide = CLIENT_PROXY,
            serverSide = SERVER_PROXY
    )
    public static CommonProxy COMMON_PROXY;

    @EventHandler
    public void preInit(FMLPreInitializationEvent $e) {
        COMMON_PROXY.preInit($e);

        if(LOGGER == null) {

            LOGGER = $e.getModLog();

        }

    }

    @EventHandler
    public void init(FMLInitializationEvent $e) {
        COMMON_PROXY.init($e);

        ;

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent $e) {
        COMMON_PROXY.postInit($e);

        ;

    }

}