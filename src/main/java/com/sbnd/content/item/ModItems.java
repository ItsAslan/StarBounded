package com.sbnd.content.item;

import com.sbnd.content.item.core.definitions.basic.ItemGeneric;
import com.sbnd.content.item.core.definitions.basic.ItemGenericTooltip;
import com.sbnd.main.ModVars;
import com.sbnd.main.Starbounded;
import com.sbnd.world.tmp.core.bodies.CelestialBody;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    static List<Item> modItems = new ArrayList<>();

    //---------------ITEMS---------------//

    // Raw
    public static Item clusterZirconium;
    public static Item clusterNiobium;
    public static Item clusterTantalum;

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

    // Powder
    public static Item powderCopper;
    public static Item powderAluminum;
    public static Item powderTitanium;
    public static Item powderTungsten;
    public static Item powderTin;
    public static Item powderLead;

    public static Item cubeLithium;
    public static Item cubeGraphite;
    public static Item cubeSulfur;

    public static void REGISTER() {

        initItems();
        registerTextures();
        registerItems();

    }

    static void initItems() {

        // Raw
        clusterZirconium = new ItemGenericTooltip(modItems, "Moon").setUnlocalizedName("clusterZirconium").setCreativeTab(Starbounded.materialsTab);
            clusterNiobium = new ItemGenericTooltip(modItems, "Mars").setUnlocalizedName("clusterNiobium").setCreativeTab(Starbounded.materialsTab);
        clusterTantalum = new ItemGenericTooltip(modItems, "Venus").setUnlocalizedName("clusterTantalum").setCreativeTab(Starbounded.materialsTab);

        // Ingot
        ingotCopper = new ItemGeneric(modItems).setUnlocalizedName("ingotCopper").setCreativeTab(Starbounded.materialsTab);
        ingotAluminum = new ItemGeneric(modItems).setUnlocalizedName("ingotAluminum").setCreativeTab(Starbounded.materialsTab);
        ingotTitanium = new ItemGeneric(modItems).setUnlocalizedName("ingotTitanium").setCreativeTab(Starbounded.materialsTab);
        ingotTungsten = new ItemGeneric(modItems).setUnlocalizedName("ingotTungsten").setCreativeTab(Starbounded.materialsTab);
        ingotTin = new ItemGeneric(modItems).setUnlocalizedName("ingotTin").setCreativeTab(Starbounded.materialsTab);
        ingotLead = new ItemGeneric(modItems).setUnlocalizedName("ingotLead").setCreativeTab(Starbounded.materialsTab);

        // Plate
        plateCopper = new ItemGeneric(modItems).setUnlocalizedName("plateCopper").setCreativeTab(Starbounded.materialsTab);
        plateAluminum = new ItemGeneric(modItems).setUnlocalizedName("plateAluminum").setCreativeTab(Starbounded.materialsTab);
        plateTitanium = new ItemGeneric(modItems).setUnlocalizedName("plateTitanium").setCreativeTab(Starbounded.materialsTab);
        plateTungsten = new ItemGeneric(modItems).setUnlocalizedName("plateTungsten").setCreativeTab(Starbounded.materialsTab);
        plateTin = new ItemGeneric(modItems).setUnlocalizedName("plateTin").setCreativeTab(Starbounded.materialsTab);
        plateLead = new ItemGeneric(modItems).setUnlocalizedName("plateLead").setCreativeTab(Starbounded.materialsTab);

        // Wire
        wireCopper = new ItemGeneric(modItems).setUnlocalizedName("wireCopper").setCreativeTab(Starbounded.materialsTab);
        wireAluminum = new ItemGeneric(modItems).setUnlocalizedName("wireAluminum").setCreativeTab(Starbounded.materialsTab);
        wireTitanium = new ItemGeneric(modItems).setUnlocalizedName("wireTitanium").setCreativeTab(Starbounded.materialsTab);
        wireTungsten = new ItemGeneric(modItems).setUnlocalizedName("wireTungsten").setCreativeTab(Starbounded.materialsTab);
        wireTin = new ItemGeneric(modItems).setUnlocalizedName("wireTin").setCreativeTab(Starbounded.materialsTab);
        wireLead = new ItemGeneric(modItems).setUnlocalizedName("wireLead").setCreativeTab(Starbounded.materialsTab);

        // Sheet
        sheetCopper = new ItemGeneric(modItems).setUnlocalizedName("sheetCopper").setCreativeTab(Starbounded.materialsTab);
        sheetAluminum = new ItemGeneric(modItems).setUnlocalizedName("sheetAluminum").setCreativeTab(Starbounded.materialsTab);
        sheetTitanium = new ItemGeneric(modItems).setUnlocalizedName("sheetTitanium").setCreativeTab(Starbounded.materialsTab);
        sheetTungsten = new ItemGeneric(modItems).setUnlocalizedName("sheetTungsten").setCreativeTab(Starbounded.materialsTab);
        sheetTin = new ItemGeneric(modItems).setUnlocalizedName("sheetTin").setCreativeTab(Starbounded.materialsTab);
        sheetLead = new ItemGeneric(modItems).setUnlocalizedName("sheetLead").setCreativeTab(Starbounded.materialsTab);

        // Powder
        powderCopper = new ItemGeneric(modItems).setUnlocalizedName("powderCopper").setCreativeTab(Starbounded.materialsTab);
        powderAluminum = new ItemGeneric(modItems).setUnlocalizedName("powderAluminum").setCreativeTab(Starbounded.materialsTab);
        powderTitanium = new ItemGeneric(modItems).setUnlocalizedName("powderTitanium").setCreativeTab(Starbounded.materialsTab);
        powderTungsten = new ItemGeneric(modItems).setUnlocalizedName("powderTungsten").setCreativeTab(Starbounded.materialsTab);
        powderTin = new ItemGeneric(modItems).setUnlocalizedName("powderTin").setCreativeTab(Starbounded.materialsTab);
        powderLead = new ItemGeneric(modItems).setUnlocalizedName("powderLead").setCreativeTab(Starbounded.materialsTab);

        cubeLithium = new ItemGeneric(modItems).setUnlocalizedName("cubeLithium").setCreativeTab(Starbounded.materialsTab);
        cubeGraphite = new ItemGeneric(modItems).setUnlocalizedName("cubeGraphite").setCreativeTab(Starbounded.materialsTab);
        cubeSulfur = new ItemGeneric(modItems).setUnlocalizedName("cubeSulfur").setCreativeTab(Starbounded.materialsTab);

    }

    static void registerTextures() {

        modItems.forEach(item -> item.setTextureName(String.format("%s:%s", ModVars.MOD_ID, item.getUnlocalizedName().substring(5))));

    }

    static void registerItems() {

        modItems.forEach(item -> GameRegistry.registerItem(item, item.getUnlocalizedName()));

    }

}
