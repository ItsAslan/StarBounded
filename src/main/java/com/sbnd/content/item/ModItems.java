package com.sbnd.content.item;

import com.sbnd.content.item.core.definitions.basic.ItemGeneric;
import com.sbnd.main.ModVars;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.HashSet;
import java.util.Set;

public class ModItems {

    static Set<Item> modItems = new HashSet<>();

    //---------------ITEMS---------------//

    // Ingot
    public static Item ingotCopper;
    public static Item ingotAluminum;
    public static Item ingotTitanium;
    public static Item ingotTungsten;
    public static Item ingotTin;
    public static Item ingotLead;

    // Plate
    public static Item plateCopper;
    public static Item plateAluminum;
    public static Item plateTitanium;
    public static Item plateTungsten;
    public static Item plateTin;
    public static Item plateLead;

    // Wire
    public static Item wireCopper;
    public static Item wireAluminum;
    public static Item wireTitanium;
    public static Item wireTungsten;
    public static Item wireTin;
    public static Item wireLead;

    // Sheet
    public static Item sheetCopper;
    public static Item sheetAluminum;
    public static Item sheetTitanium;
    public static Item sheetTungsten;
    public static Item sheetTin;
    public static Item sheetLead;

    public static void REGISTER() {

        initItems();
        registerTextures();
        registerItems();

    }

    static void initItems() {

        // Ingot
        ingotCopper = new ItemGeneric(modItems).setUnlocalizedName("ingotCopper").setCreativeTab(CreativeTabs.tabMaterials);
        ingotAluminum = new ItemGeneric(modItems).setUnlocalizedName("ingotAluminum").setCreativeTab(CreativeTabs.tabMaterials);
        ingotTitanium = new ItemGeneric(modItems).setUnlocalizedName("ingotTitanium").setCreativeTab(CreativeTabs.tabMaterials);
        ingotTungsten = new ItemGeneric(modItems).setUnlocalizedName("ingotTungsten").setCreativeTab(CreativeTabs.tabMaterials);
        ingotTin = new ItemGeneric(modItems).setUnlocalizedName("ingotTin").setCreativeTab(CreativeTabs.tabMaterials);
        ingotLead = new ItemGeneric(modItems).setUnlocalizedName("ingotLead").setCreativeTab(CreativeTabs.tabMaterials);

        // Plate
        plateCopper = new ItemGeneric(modItems).setUnlocalizedName("plateCopper").setCreativeTab(CreativeTabs.tabMaterials);
        plateAluminum = new ItemGeneric(modItems).setUnlocalizedName("plateAluminum").setCreativeTab(CreativeTabs.tabMaterials);
        plateTitanium = new ItemGeneric(modItems).setUnlocalizedName("plateTitanium").setCreativeTab(CreativeTabs.tabMaterials);
        plateTungsten = new ItemGeneric(modItems).setUnlocalizedName("plateTungsten").setCreativeTab(CreativeTabs.tabMaterials);
        plateTin = new ItemGeneric(modItems).setUnlocalizedName("plateTin").setCreativeTab(CreativeTabs.tabMaterials);
        plateLead = new ItemGeneric(modItems).setUnlocalizedName("plateLead").setCreativeTab(CreativeTabs.tabMaterials);

        // Wire
        wireCopper = new ItemGeneric(modItems).setUnlocalizedName("wireCopper").setCreativeTab(CreativeTabs.tabMaterials);
        wireAluminum = new ItemGeneric(modItems).setUnlocalizedName("wireAluminum").setCreativeTab(CreativeTabs.tabMaterials);
        wireTitanium = new ItemGeneric(modItems).setUnlocalizedName("wireTitanium").setCreativeTab(CreativeTabs.tabMaterials);
        wireTungsten = new ItemGeneric(modItems).setUnlocalizedName("wireTungsten").setCreativeTab(CreativeTabs.tabMaterials);
        wireTin = new ItemGeneric(modItems).setUnlocalizedName("wireTin").setCreativeTab(CreativeTabs.tabMaterials);
        wireLead = new ItemGeneric(modItems).setUnlocalizedName("wireLead").setCreativeTab(CreativeTabs.tabMaterials);

        // Sheet
        sheetCopper = new ItemGeneric(modItems).setUnlocalizedName("sheetCopper").setCreativeTab(CreativeTabs.tabMaterials);
        sheetAluminum = new ItemGeneric(modItems).setUnlocalizedName("sheetAluminum").setCreativeTab(CreativeTabs.tabMaterials);
        sheetTitanium = new ItemGeneric(modItems).setUnlocalizedName("sheetTitanium").setCreativeTab(CreativeTabs.tabMaterials);
        sheetTungsten = new ItemGeneric(modItems).setUnlocalizedName("sheetTungsten").setCreativeTab(CreativeTabs.tabMaterials);
        sheetTin = new ItemGeneric(modItems).setUnlocalizedName("sheetTin").setCreativeTab(CreativeTabs.tabMaterials);
        sheetLead = new ItemGeneric(modItems).setUnlocalizedName("sheetLead").setCreativeTab(CreativeTabs.tabMaterials);

    }

    static void registerTextures() {

        modItems.forEach(item -> item.setTextureName(String.format("%s:%s", ModVars.MOD_ID, item.getUnlocalizedName().substring(5))));

    }

    static void registerItems() {

        modItems.forEach(item -> GameRegistry.registerItem(item, item.getUnlocalizedName()));

    }

}
