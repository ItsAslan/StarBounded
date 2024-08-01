package com.sbnd.main;

import com.sbnd.commands.CommandTeleportDimension;
import com.sbnd.config.OreConfig;
import com.sbnd.config.PlanetConfig;
import com.sbnd.content.block.ModBlocks;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import com.sbnd.proxy.CommonProxy;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = ModVars.MOD_ID, name = ModVars.MOD_NAME, version = ModVars.MOD_VERSION)
public class Starbounded {

    @Mod.Instance
    public static Starbounded instance = new Starbounded();

    @SidedProxy(clientSide = "com.sbnd.proxy.ClientProxy", serverSide = "com.sbnd.proxy.ServerProxy")
    public static CommonProxy PROXY;

    // Achievements
    public static Achievement moonLanding;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent $e) {
        PROXY.preInit($e);

        Configuration config = new Configuration($e.getSuggestedConfigurationFile());
        config.load();

        PlanetConfig.loadFromConfig(config);
        OreConfig.loadFromConfig(config);

        if(config.hasChanged()) {

            config.save();

        }

        // Register `ModEventListener`
        FMLCommonHandler.instance().bus().register(new ModEventListener());
        MinecraftForge.EVENT_BUS.register(new ModEventListener());

    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent $e) {
        PROXY.init($e);

        moonLanding = new Achievement("achievement.moonLanding", "moonLanding", 0, 0, new ItemStack(ModBlocks.blockMoonTurf), AchievementList.openInventory).initIndependentStat().registerStat();

        OreDictionaryManager.REGISTER();

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
