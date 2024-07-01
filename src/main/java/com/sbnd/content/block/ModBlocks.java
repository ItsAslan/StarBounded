package com.sbnd.content.block;

import com.sbnd.content.block.core.definitions.basic.OreGeneric;
import com.sbnd.main.ModVars;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

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

    // Terrain
    public static Block blockMoonTurf;

    public static void REGISTER() {

        initBlocks();
        registerTextures();
        registerBlocks();

    }

    static void initBlocks() {

        // Ore
        oreCopper = new OreGeneric(modBlocks, Material.rock, OreGeneric.OreType.NORMAL).setBlockName("oreCopper").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone);
        oreAluminum = new OreGeneric(modBlocks, Material.rock, OreGeneric.OreType.NORMAL).setBlockName("oreAluminum").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone);
        oreTitanium = new OreGeneric(modBlocks, Material.rock, OreGeneric.OreType.NORMAL).setBlockName("oreTitanium").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone);
        oreTungsten = new OreGeneric(modBlocks, Material.rock, OreGeneric.OreType.NORMAL).setBlockName("oreTungsten").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone);
        oreTin = new OreGeneric(modBlocks, Material.rock, OreGeneric.OreType.NORMAL).setBlockName("oreTin").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone);
        oreSulfur = new OreGeneric(modBlocks, Material.rock, OreGeneric.OreType.NORMAL).setBlockName("oreSulfur").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone);

        // Terrain
        blockMoonTurf = new OreGeneric(modBlocks, Material.sand, OreGeneric.OreType.NORMAL).setBlockName("blockMoonTurf").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeSand);

    }

    static void registerTextures() {

        modBlocks.forEach(block -> block.setBlockTextureName(String.format("%s:%s", ModVars.MOD_ID, block.getUnlocalizedName().substring(5))));

    }

    static void registerBlocks() {

        modBlocks.forEach(block -> GameRegistry.registerBlock(block, block.getUnlocalizedName()));

    }

}
