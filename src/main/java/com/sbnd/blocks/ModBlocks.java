package com.sbnd.blocks;

import com.sbnd.blocks.generic.BlockGeneric;
import com.sbnd.blocks.generic.OreGeneric;
import com.sbnd.blocks.test.interpTest;
import com.sbnd.items.ModItems;
import com.sbnd.lib.ModVars;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ModBlocks
{

    public static void MainRegistry()
    {
        BlockInit();
        BlockRegister();
    }

    //Terrain Blocks
    public static Block blockMoonTurf;

    //Ore Blocks
    public static Block oreCopper;
    public static Block oreAluminum;
    public static Block oreTitanium;
    public static Block oreTungsten;
    public static Block oreTin;
    public static Block oreMoonStone;

    //Rocket Blocks
    public static Block interpTest;

    //Machine Blocks


    public static void BlockInit()
    {

        //Terrain Blocks
        blockMoonTurf = new BlockGeneric(Material.sand).setBlockName("blockMoonTurf").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeSand).setBlockTextureName(ModVars.MOD_ID + ":blockMoonTurf");

        //Ore Blocks
        oreCopper = new OreGeneric(Material.rock).setBlockName("oreCopper").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":oreCopper");
        oreAluminum = new OreGeneric(Material.rock).setBlockName("oreAluminum").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":oreAluminum");
        oreTitanium = new OreGeneric(Material.rock).setBlockName("oreTitanium").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":oreTitanium");
        oreTungsten = new OreGeneric(Material.rock).setBlockName("oreTungsten").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":oreTungsten");
        oreTin = new OreGeneric(Material.rock).setBlockName("oreTin").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":oreTin");
        oreMoonStone = new OreGeneric(Material.rock, ModItems.shardMoonStone, 4).setBlockName("oreMoonStone").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":oreMoonStone");

        //Rocket Blocks
        interpTest = new interpTest(Material.rock).setBlockName("interpTest").setCreativeTab(CreativeTabs.tabBlock);

        //Machine Blocks

    }

    public static void BlockRegister()
    {

        //Terrain Blocks
        GameRegistry.registerBlock(blockMoonTurf, blockMoonTurf.getUnlocalizedName());

        //Ore Blocks
        GameRegistry.registerBlock(oreCopper, oreCopper.getUnlocalizedName());
        GameRegistry.registerBlock(oreAluminum, oreAluminum.getUnlocalizedName());
        GameRegistry.registerBlock(oreTitanium, oreTitanium.getUnlocalizedName());
        GameRegistry.registerBlock(oreTungsten, oreTungsten.getUnlocalizedName());
        GameRegistry.registerBlock(oreTin, oreTin.getUnlocalizedName());
        GameRegistry.registerBlock(oreMoonStone, oreMoonStone.getUnlocalizedName());

        //Rocket Blocks
        GameRegistry.registerBlock(interpTest, interpTest.getUnlocalizedName());

        //Machine Blocks

    }

}
