package com.sbnd.content.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

import java.util.HashSet;
import java.util.Set;

public class ModBlocks {

    static Set<Block> modBlocks = new HashSet<>();

    //---------------BLOCKS---------------//

    // Ore
    public static Block oreCopper;
    public static Block oreAluminum;
    public static Block oreTitanium;
    public static Block oreTungsten;
    public static Block oreTin;
    public static Block oreSulfur;

    public static void REGISTER() {

        initBlocks();
        registerBlocks();

    }

    static void initBlocks() {



    }

    static void registerBlocks() {

        modBlocks.forEach(block -> GameRegistry.registerBlock(block, block.getUnlocalizedName()));

    }

}
