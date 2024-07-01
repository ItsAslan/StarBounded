package com.sbnd.content.item;

import com.sbnd.content.item.core.definitions.basic.ItemGeneric;
import com.sbnd.main.ModVars;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
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

    }

    static void registerTextures() {

        modItems.forEach(item -> item.setTextureName(String.format("%s:%s", ModVars.MOD_ID, item.getUnlocalizedName().substring(5))));

    }

    static void registerItems() {

        modItems.forEach(item -> GameRegistry.registerItem(item, item.getUnlocalizedName()));

    }

}
