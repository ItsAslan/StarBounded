package com.sbnd.main;

import lombok.Getter;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

// This is so cool
import static com.sbnd.content.item.ModItems.*;
import static com.sbnd.content.block.ModBlocks.*;
import static com.sbnd.content.item.ItemPrefix.*;

public class OreDictionaryManager {

    //----------------VANILLA----------------//
    public static final DictEntry COAL = new DictEntry("Coal");
    public static final DictEntry IRON = new DictEntry("Iron");
    public static final DictEntry GOLD = new DictEntry("Gold");
    public static final DictEntry DIAMOND = new DictEntry("Diamond");
    public static final DictEntry REDSTONE = new DictEntry("Redstone");
    public static final DictEntry NetherQuartz = new DictEntry("NetherQuartz");
    public static final DictEntry LAPIS = new DictEntry("Lapis");
    public static final DictEntry EMERALD = new DictEntry("Emerald");


    //----------------MODDED----------------//
    private final static DictEntry CU = new DictEntry("Copper");
    private final static DictEntry AL = new DictEntry("Aluminum");
    private final static DictEntry TI = new DictEntry("Titanium");
    private final static DictEntry W = new DictEntry("Tungsten");
    private final static DictEntry SN = new DictEntry("Tin");
    private final static DictEntry PB = new DictEntry("Lead");
    private final static DictEntry LI = new DictEntry("Lithium");
    private final static DictEntry C = new DictEntry("Carbon");

    public static void REGISTER() {

        //----------------VANILLA----------------//

        /*

            Implement Modded Versions of Vanilla ores here (Plates, Dust, etc...)

         */

        //----------------MODDED----------------//
        CU  .addOre(oreCopper)      .addPlate(plateCopper)      .addIngot(ingotCopper)     .addWire(wireCopper)      .addSheet(sheetCopper)      .addPowder(powderCopper);
        AL  .addOre(oreAluminum)    .addPlate(plateAluminum)    .addIngot(ingotAluminum)   .addWire(wireAluminum)    .addSheet(sheetAluminum)    .addPowder(powderAluminum);
        TI  .addOre(oreTitanium)    .addPlate(plateTitanium)    .addIngot(ingotTitanium)   .addWire(wireTitanium)    .addSheet(sheetTitanium)    .addPowder(powderTitanium);
        W   .addOre(oreTungsten)    .addPlate(plateTungsten)    .addIngot(ingotTungsten)   .addWire(wireTungsten)    .addSheet(sheetTungsten)    .addPowder(powderTungsten);
        SN  .addOre(oreTin)         .addPlate(plateTin)         .addIngot(ingotTin)        .addWire(wireTin)         .addSheet(sheetTin)         .addPowder(powderTin);
        PB                          .addPlate(plateLead)        .addIngot(ingotLead)       .addWire(wireLead)        .addSheet(sheetLead)        .addPowder(powderLead);
        LI                                                                                                                                       .addPowder(cubeLithium);
        C                                                                                                                                        .addPowder(cubeGraphite);

    }

    @Getter
    public static class DictEntry {

        String entryName;

        public DictEntry(String entryName) {

            this.entryName = entryName;

        }

        public DictEntry addIngot(Item item) {

            String name = ingot() + entryName;

            initEntry(name, item);

            return this;

        }

        public DictEntry addPowder(Item item) {

            String name = powder() + entryName;

            initEntry(name, item);

            return this;

        }

        public DictEntry addGem(Item item) {

            String name = gem() + entryName;

            initEntry(name, item);

            return this;

        }

        public DictEntry addPlate(Item item) {

            String name = plate() + entryName;

            initEntry(name, item);

            return this;

        }

        public DictEntry addWire(Item item) {

            String name = wire() + entryName;

            initEntry(name, item);

            return this;

        }

        public DictEntry addSheet(Item item) {

            String name = sheet() + entryName;

            initEntry(name, item);

            return this;

        }

        public DictEntry addOre(Block block) {

            String name = ore() + entryName;

            initEntry(name, block);

            return this;

        }

        public DictEntry addBlock(Block block) {

            String name = block() + entryName;

            initEntry(name, block);

            return this;

        }

        public String ingot() { return INGOT; }
        public String powder() { return POWDER; }
        public String gem() { return GEM; }
        public String plate() { return PLATE; }
        public String wire() { return WIRE; }
        public String sheet() { return SHEET; }
        public String ore() { return ORE; }
        public String block() { return BLOCK; }

        private void initEntry(String name, Object object) {

            if(object instanceof Item) { registerItemStack(name, new ItemStack((Item) object)); }
            if(object instanceof Block) { registerItemStack(name, new ItemStack((Block) object)); }
            if(object instanceof ItemStack) { registerItemStack(name, (ItemStack) object); }

        }

        private void registerItemStack(String name, ItemStack stack) {

            OreDictionary.registerOre(name, stack);

        }

    }

}
