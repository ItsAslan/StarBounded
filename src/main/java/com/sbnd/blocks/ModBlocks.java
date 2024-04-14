package com.sbnd.blocks;

import com.sbnd.blocks.generic.BlockGeneric;
import com.sbnd.blocks.machine.RocketAssembler;
import com.sbnd.blocks.test.interpTest;
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

    //Ore Blocks
    public static Block oreCopper;
    public static Block oreAluminum;
    public static Block oreTitanium;
    public static Block oreTungsten;
    public static Block oreTin;

    //Rocket Blocks
    public static Block interpTest;

    //Machine Blocks
    public static Block rocketAssembler;

    public static void BlockInit()
    {
        //Ore Blocks
        oreCopper = new BlockGeneric(Material.rock).setBlockName("oreCopper").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":oreCopper");
        oreAluminum = new BlockGeneric(Material.rock).setBlockName("oreAluminum").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":oreAluminum");
        oreTitanium = new BlockGeneric(Material.rock).setBlockName("oreTitanium").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":oreTitanium");
        oreTungsten = new BlockGeneric(Material.rock).setBlockName("oreTungsten").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":oreTungsten");
        oreTin = new BlockGeneric(Material.rock).setBlockName("oreTin").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":oreTin");

        //Rocket Blocks
        interpTest = new interpTest(Material.rock).setBlockName("interpTest").setCreativeTab(CreativeTabs.tabBlock);

        //Machine Blocks
        rocketAssembler = new RocketAssembler(Material.rock).setBlockName("rocketAssembler").setCreativeTab(CreativeTabs.tabBlock);
    }

    public static void BlockRegister()
    {
        //Ore Blocks
        GameRegistry.registerBlock(oreCopper, oreCopper.getUnlocalizedName());
        GameRegistry.registerBlock(oreAluminum, oreAluminum.getUnlocalizedName());
        GameRegistry.registerBlock(oreTitanium, oreTitanium.getUnlocalizedName());
        GameRegistry.registerBlock(oreTungsten, oreTungsten.getUnlocalizedName());
        GameRegistry.registerBlock(oreTin, oreTin.getUnlocalizedName());

        //Rocket Blocks
        GameRegistry.registerBlock(interpTest, interpTest.getUnlocalizedName());

        //Machine Blocks
        GameRegistry.registerBlock(rocketAssembler, rocketAssembler.getUnlocalizedName());
    }

}
