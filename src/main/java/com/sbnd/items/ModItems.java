package com.sbnd.items;

import api.enums.EnumPlanet;
import api.enums.materials.ToolMaterials;
import com.sbnd.items.armor.AstronautSuitBasic;
import com.sbnd.items.generic.*;
import com.sbnd.items.tools.AoePickaxeBase;
import com.sbnd.items.tools.crafting.ItemHammer;
import com.sbnd.lib.ModVars;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class ModItems
{

    public static void MainRegistry()
    {
        ItemInit();
        ItemRegister();
    }

    //Materials
    public static Item cubeGraphite;
    public static Item cubeLithium;
    public static Item cubeSulfur;
    public static Item shardMoonStone;
    public static Item clusterSmokeyQuartz;
    public static Item clusterCadmium;
    public static Item shardMagnesium;
    public static Item cubePhosphorus;
    public static Item clumpWulfenite;

    //Ingots
    public static Item ingotCopper;
    public static Item ingotAluminum;
    public static Item ingotTitanium;
    public static Item ingotTungsten;
    public static Item ingotTin;

    //Plates
    public static Item plateCopper;
    public static Item plateAluminum;
    public static Item plateTitanium;
    public static Item plateTungsten;
    public static Item plateTin;

    //Crafting Tools
    public static Item itemHammer;

    //Tools
    public static Item copperAoePickaxe;

    //Armor
    public static Item suitWhiteHelmet;
    public static Item suitWhiteChestplate;
    public static Item suitWhiteLeggings;
    public static Item suitWhiteBoots;

    // Circuits

    public static Item circuitOscillator;
    public static Item circuitCapacitorBank;
    public static Item circuitAmplifier;
    public static Item circuitComparator;
    public static Item circuitFilter;
    public static Item circuitRectifier;
    public static Item circuitRegulator;

    public static Item circuitClock;
    public static Item circuitPowerSupply;
    public static Item circuitSignalGenerator;
    public static Item circuitModulator;
    public static Item circuitCounter;
    public static Item circuitAnalogChip;
    public static Item circuitDigitalChip;

    public static Item circuitALU;
    public static Item circuitRegister;
    public static Item circuitBuffer;
    public static Item circuitBus;
    public static Item circuitPWM;

    public static Item circuitCPU;
    public static Item circuitVideoInterface;
    public static Item circuitComInterface;
    public static Item circuitSensorInterface;


    public static void ItemInit()
    {

        //Materials
        cubeGraphite = new ItemOreGeneric().setUnlocalizedName("cubeGraphite").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":cubeGraphite");
        cubeLithium = new ItemOreGeneric().setUnlocalizedName("cubeLithium").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":cubeLithium");
        cubeSulfur = new ItemOreGeneric().setUnlocalizedName("cubeSulfur").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":cubeSulfur");
        shardMoonStone = new ItemOreGeneric(EnumPlanet.MOON).setUnlocalizedName("shardMoonStone").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":shardMoonStone");
        clusterSmokeyQuartz = new ItemOreGeneric(EnumPlanet.MOON).setUnlocalizedName("clusterSmokeyQuartz").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":clusterSmokeyQuartz");
        clusterCadmium = new ItemOreGeneric(EnumPlanet.MOON).setUnlocalizedName("clusterCadmium").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":clusterCadmium");
        shardMagnesium = new ItemOreGeneric(EnumPlanet.MARS).setUnlocalizedName("shardMagnesium").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":shardMagnesium");
        cubePhosphorus = new ItemHot(EnumPlanet.MERCURY).setUnlocalizedName("cubePhosphorus").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":cubePhosphorus");
        clumpWulfenite = new ItemHot(EnumPlanet.VENUS).setUnlocalizedName("clumpWulfenite").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":clumpWulfenite");

        //Ingots
        ingotCopper = new ItemGeneric().setUnlocalizedName("ingotCopper").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":ingotCopper");
        ingotAluminum = new ItemGeneric().setUnlocalizedName("ingotAluminum").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":ingotAluminum");
        ingotTitanium = new ItemGeneric().setUnlocalizedName("ingotTitanium").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":ingotTitanium");
        ingotTungsten = new ItemGeneric().setUnlocalizedName("ingotTungsten").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":ingotTungsten");
        ingotTin = new ItemGeneric().setUnlocalizedName("ingotTin").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":ingotTin");

        //Plates
        plateCopper = new ItemGeneric().setUnlocalizedName("plateCopper").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":plateCopper");
        plateAluminum = new ItemGeneric().setUnlocalizedName("plateAluminum").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":plateAluminum");
        plateTitanium = new ItemGeneric().setUnlocalizedName("plateTitanium").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":plateTitanium");
        plateTungsten = new ItemGeneric().setUnlocalizedName("plateTungsten").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":plateTungsten");
        plateTin = new ItemGeneric().setUnlocalizedName("plateTin").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":plateTin");

        //Crafting Tools
        itemHammer = new ItemHammer(20).setUnlocalizedName("itemHammer").setCreativeTab(CreativeTabs.tabTools).setTextureName(ModVars.MOD_ID + ":itemHammer");

        //Tools
        copperAoePickaxe = new AoePickaxeBase(ToolMaterials.AOEMATERIAL, 3, 3).setUnlocalizedName("copperAoePickaxe").setCreativeTab(CreativeTabs.tabTools).setTextureName(ModVars.MOD_ID + ":copperAoePickaxe");

        //Armor
        suitWhiteHelmet = new AstronautSuitBasic(ItemArmor.ArmorMaterial.IRON, 0, 0, "suitWhite").setUnlocalizedName("suitWhiteHelmet").setCreativeTab(CreativeTabs.tabCombat);
        suitWhiteChestplate = new AstronautSuitBasic(ItemArmor.ArmorMaterial.IRON, 0, 1, "suitWhite").setUnlocalizedName("suitWhiteChestplate").setCreativeTab(CreativeTabs.tabCombat);
        suitWhiteLeggings = new AstronautSuitBasic(ItemArmor.ArmorMaterial.IRON, 0, 2, "suitWhite").setUnlocalizedName("suitWhiteLeggings").setCreativeTab(CreativeTabs.tabCombat);
        suitWhiteBoots = new AstronautSuitBasic(ItemArmor.ArmorMaterial.IRON, 0, 3, "suitWhite").setUnlocalizedName("suitWhiteBoots").setCreativeTab(CreativeTabs.tabCombat);

        // Circuits
        createCircuitBoard(circuitOscillator, "Oscillator", EnumRarity.common);
        createCircuitBoard(circuitCapacitorBank, "CapacitorBank", EnumRarity.common);
        createCircuitBoard(circuitAmplifier, "Amplifier", EnumRarity.common);
        createCircuitBoard(circuitComparator, "Comparator", EnumRarity.common);
        createCircuitBoard(circuitFilter, "Filter", EnumRarity.common);
        createCircuitBoard(circuitRectifier, "Rectifier", EnumRarity.common);
        createCircuitBoard(circuitRegulator, "Regulator", EnumRarity.common);

        createCircuitBoard(circuitClock, "Clock", EnumRarity.uncommon);
        createCircuitBoard(circuitPowerSupply, "PowerSupply", EnumRarity.uncommon);
        createCircuitBoard(circuitSignalGenerator, "SignalGenerator", EnumRarity.uncommon);
        createCircuitBoard(circuitModulator, "Modulator", EnumRarity.uncommon);
        createCircuitBoard(circuitCounter, "Counter", EnumRarity.uncommon);
        createCircuitBoard(circuitAnalogChip, "AnalogChip", EnumRarity.uncommon);
        createCircuitBoard(circuitDigitalChip, "DigitalChip", EnumRarity.uncommon);

        createCircuitBoard(circuitALU, "ALU", EnumRarity.rare);
        createCircuitBoard(circuitRegister, "Register", EnumRarity.rare);
        createCircuitBoard(circuitBuffer, "Buffer", EnumRarity.rare);
        createCircuitBoard(circuitBus, "Bus", EnumRarity.rare);
        createCircuitBoard(circuitPWM, "PWM", EnumRarity.rare);

        createCircuitBoard(circuitCPU, "CPU", EnumRarity.epic);
        createCircuitBoard(circuitVideoInterface, "VideoInterface", EnumRarity.epic);
        createCircuitBoard(circuitComInterface, "ComInterface", EnumRarity.epic);
        createCircuitBoard(circuitSensorInterface, "SensorInterface", EnumRarity.epic);

    }

    public static void ItemRegister()
    {

        //Materials
        GameRegistry.registerItem(cubeGraphite, cubeGraphite.getUnlocalizedName());
        GameRegistry.registerItem(cubeLithium, cubeLithium.getUnlocalizedName());
        GameRegistry.registerItem(cubeSulfur, cubeSulfur.getUnlocalizedName());
        GameRegistry.registerItem(shardMoonStone, shardMoonStone.getUnlocalizedName());
        GameRegistry.registerItem(clusterSmokeyQuartz, clusterSmokeyQuartz.getUnlocalizedName());
        GameRegistry.registerItem(clusterCadmium, clusterCadmium.getUnlocalizedName());
        GameRegistry.registerItem(shardMagnesium, shardMagnesium.getUnlocalizedName());
        GameRegistry.registerItem(cubePhosphorus, cubePhosphorus.getUnlocalizedName());
        GameRegistry.registerItem(clumpWulfenite, clumpWulfenite.getUnlocalizedName());

        //Ingots
        GameRegistry.registerItem(ingotCopper, ingotCopper.getUnlocalizedName());
        GameRegistry.registerItem(ingotAluminum, ingotAluminum.getUnlocalizedName());
        GameRegistry.registerItem(ingotTitanium, ingotTitanium.getUnlocalizedName());
        GameRegistry.registerItem(ingotTungsten, ingotTungsten.getUnlocalizedName());
        GameRegistry.registerItem(ingotTin, ingotTin.getUnlocalizedName());

        //Plates
        GameRegistry.registerItem(plateCopper, plateCopper.getUnlocalizedName());
        GameRegistry.registerItem(plateAluminum, plateAluminum.getUnlocalizedName());
        GameRegistry.registerItem(plateTitanium, plateTitanium.getUnlocalizedName());
        GameRegistry.registerItem(plateTungsten, plateTungsten.getUnlocalizedName());
        GameRegistry.registerItem(plateTin, plateTin.getUnlocalizedName());

        //Crafting Tools
        GameRegistry.registerItem(itemHammer, itemHammer.getUnlocalizedName());

        //Tools
        GameRegistry.registerItem(copperAoePickaxe, copperAoePickaxe.getUnlocalizedName());

        //Armor
        GameRegistry.registerItem(suitWhiteHelmet, suitWhiteHelmet.getUnlocalizedName());
        GameRegistry.registerItem(suitWhiteChestplate, suitWhiteChestplate.getUnlocalizedName());
        GameRegistry.registerItem(suitWhiteLeggings, suitWhiteLeggings.getUnlocalizedName());
        GameRegistry.registerItem(suitWhiteBoots, suitWhiteBoots.getUnlocalizedName());

    }

    public static void createCircuitBoard(Item var, String name, EnumRarity rarity) {

        var = new ItemRarity(rarity).setUnlocalizedName("circuit" + name).setCreativeTab(CreativeTabs.tabMaterials).setTextureName(String.format("%s:circuit%s", ModVars.MOD_ID, name));
        GameRegistry.registerItem(var, var.getUnlocalizedName());

    }

}
