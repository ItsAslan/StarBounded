package com.sbnd.items;

import com.sbnd.items.generic.ItemGeneric;
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

    public static void ItemInit()
    {
        ingotCopper = new ItemGeneric().setUnlocalizedName("ingotCopper").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":ingotCopper");
        ingotAluminum = new ItemGeneric().setUnlocalizedName("ingotAluminum").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":ingotAluminum");
        ingotTitanium = new ItemGeneric().setUnlocalizedName("ingotTitanium").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":ingotTitanium");
        ingotTungsten = new ItemGeneric().setUnlocalizedName("ingotTungsten").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":ingotTungsten");
        ingotTin = new ItemGeneric().setUnlocalizedName("ingotTin").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(ModVars.MOD_ID + ":ingotTin");
    }

    public static void ItemRegister()
    {
        GameRegistry.registerItem(ingotCopper, ingotCopper.getUnlocalizedName());
        GameRegistry.registerItem(ingotAluminum, ingotAluminum.getUnlocalizedName());
        GameRegistry.registerItem(ingotTitanium, ingotTitanium.getUnlocalizedName());
        GameRegistry.registerItem(ingotTungsten, ingotTungsten.getUnlocalizedName());
        GameRegistry.registerItem(ingotTin, ingotTin.getUnlocalizedName());
    }
}
