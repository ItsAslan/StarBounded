package com.sbnd.items;

import com.sbnd.enums.EnumPlanet;
import com.sbnd.enums.ToolMaterials;
import com.sbnd.items.generic.ItemGeneric;
import com.sbnd.items.generic.ItemOreGeneric;
import com.sbnd.items.tools.AoePickaxeBase;
import com.sbnd.items.tools.crafting.ItemHammer;
import com.sbnd.lib.ModVars;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

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

    public static void ItemInit()
    {

        //Materials
        cubeGraphite = new ItemOreGeneric(EnumPlanet.EARTH).setUnlocalizedName("cubeGraphite").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":cubeGraphite");
        cubeLithium = new ItemOreGeneric(EnumPlanet.EARTH).setUnlocalizedName("cubeLithium").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":cubeLithium");
        cubeSulfur = new ItemOreGeneric(EnumPlanet.EARTH).setUnlocalizedName("cubeSulfur").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":cubeSulfur");
        shardMoonStone = new ItemOreGeneric(EnumPlanet.MOON).setUnlocalizedName("shardMoonStone").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":shardMoonStone");
        clusterSmokeyQuartz = new ItemOreGeneric(EnumPlanet.MOON).setUnlocalizedName("clusterSmokeyQuartz").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":clusterSmokeyQuartz");
        clusterCadmium = new ItemOreGeneric(EnumPlanet.MOON).setUnlocalizedName("clusterCadmium").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":clusterCadmium");

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

    }
}
