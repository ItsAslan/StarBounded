package com.sbnd.items;

import com.sbnd.items.generic.ItemGeneric;
import com.sbnd.items.tools.ItemHammer;
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

    // INGOTS

    public static Item ingotCopper;
    public static Item ingotAluminum;
    public static Item ingotTitanium;
    public static Item ingotTungsten;
    public static Item ingotTin;

    // PLATES

    public static Item plateCopper;
    public static Item plateAluminum;
    public static Item plateTitanium;
    public static Item plateTungsten;
    public static Item plateTin;

    //TOOLS

    public static Item itemHammer;

    public static void ItemInit()
    {

        // INGOTS
        ingotCopper = new ItemGeneric().setUnlocalizedName("ingotCopper").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":ingotCopper");
        ingotAluminum = new ItemGeneric().setUnlocalizedName("ingotAluminum").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":ingotAluminum");
        ingotTitanium = new ItemGeneric().setUnlocalizedName("ingotTitanium").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":ingotTitanium");
        ingotTungsten = new ItemGeneric().setUnlocalizedName("ingotTungsten").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":ingotTungsten");
        ingotTin = new ItemGeneric().setUnlocalizedName("ingotTin").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":ingotTin");

        //PLATES
        plateCopper = new ItemGeneric().setUnlocalizedName("plateCopper").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":plateCopper");
        plateAluminum = new ItemGeneric().setUnlocalizedName("plateAluminum").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":plateAluminum");
        plateTitanium = new ItemGeneric().setUnlocalizedName("plateTitanium").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":plateTitanium");
        plateTungsten = new ItemGeneric().setUnlocalizedName("plateTungsten").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":plateTungsten");
        plateTin = new ItemGeneric().setUnlocalizedName("plateTin").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":plateTin");

        //TOOLS
        itemHammer = new ItemHammer().setUnlocalizedName("itemHammer").setCreativeTab(CreativeTabs.tabTools).setContainerItem(itemHammer).setTextureName(ModVars.MOD_ID + ":itemHammer");

    }

    public static void ItemRegister()
    {

        //INGOTS
        GameRegistry.registerItem(ingotCopper, ingotCopper.getUnlocalizedName());
        GameRegistry.registerItem(ingotAluminum, ingotAluminum.getUnlocalizedName());
        GameRegistry.registerItem(ingotTitanium, ingotTitanium.getUnlocalizedName());
        GameRegistry.registerItem(ingotTungsten, ingotTungsten.getUnlocalizedName());
        GameRegistry.registerItem(ingotTin, ingotTin.getUnlocalizedName());

        //PLATES
        GameRegistry.registerItem(plateCopper, plateCopper.getUnlocalizedName());
        GameRegistry.registerItem(plateAluminum, plateAluminum.getUnlocalizedName());
        GameRegistry.registerItem(plateTitanium, plateTitanium.getUnlocalizedName());
        GameRegistry.registerItem(plateTungsten, plateTungsten.getUnlocalizedName());
        GameRegistry.registerItem(plateTin, plateTin.getUnlocalizedName());

        //TOOLS
        GameRegistry.registerItem(itemHammer, itemHammer.getUnlocalizedName());

    }
}
