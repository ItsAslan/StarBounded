package com.sbnd.blocks;

import com.sbnd.blocks.generic.BlockGeneric;
import com.sbnd.blocks.generic.BlockGlassGeneric;
import com.sbnd.blocks.generic.OreGeneric;
import com.sbnd.blocks.generic.OreParticleEmitter;
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
    public static Block blockMarsTurf;
    public static Block blockMercurySurface;

    //Ore Blocks
    public static Block oreCopper;
    public static Block oreAluminum;
    public static Block oreTitanium;
    public static Block oreTungsten;
    public static Block oreTin;
    public static Block oreSulfur;
    public static Block oreMoonStone;
    public static Block oreSmokeyQuartz;
    public static Block oreCadmium;
    public static Block oreMagnesium;
    public static Block orePhosphorus;

    //Decoration Blocks
    public static Block blockBlackTile;
    public static Block blockBlackTileHazard;
    public static Block blockGreyTile;
    public static Block blockGreyTileHazard;
    public static Block blockGlassTungsten;

    //Rocket Blocks
    public static Block interpTest;

    //Machine Blocks


    public static void BlockInit()
    {

        //Terrain Blocks
        blockMoonTurf = new BlockGeneric(Material.sand).setBlockName("blockMoonTurf").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeSand).setBlockTextureName(ModVars.MOD_ID + ":blockMoonTurf");
        blockMarsTurf = new BlockGeneric(Material.sand).setBlockName("blockMarsTurf").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeSand).setBlockTextureName(ModVars.MOD_ID + ":blockMarsTurf");
        blockMercurySurface = new BlockGeneric(Material.rock).setBlockName("blockMercurySurface").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":blockMercurySurface");

        //Ore Blocks
        oreCopper = new OreGeneric(Material.rock).setBlockName("oreCopper").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":oreCopper");
        oreAluminum = new OreGeneric(Material.rock).setBlockName("oreAluminum").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":oreAluminum");
        oreTitanium = new OreGeneric(Material.rock).setBlockName("oreTitanium").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":oreTitanium");
        oreTungsten = new OreGeneric(Material.rock).setBlockName("oreTungsten").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":oreTungsten");
        oreTin = new OreGeneric(Material.rock).setBlockName("oreTin").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":oreTin");
        oreSulfur = new OreGeneric(Material.rock, ModItems.cubeSulfur, 3).setBlockName("oreSulfur").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":oreSulfur");
        oreMoonStone = new OreGeneric(Material.rock, ModItems.shardMoonStone, 4).setBlockName("oreMoonStone").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeSand).setBlockTextureName(ModVars.MOD_ID + ":oreMoonStone");
        oreSmokeyQuartz = new OreGeneric(Material.rock, ModItems.clusterSmokeyQuartz, 1).setBlockName("oreSmokeyQuartz").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeSand).setBlockTextureName(ModVars.MOD_ID + ":oreSmokeyQuartz");
        oreCadmium = new OreGeneric(Material.rock, ModItems.clusterCadmium, 2).setBlockName("oreCadmium").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeSand).setBlockTextureName(ModVars.MOD_ID + ":oreCadmium");
        oreMagnesium = new OreGeneric(Material.rock, ModItems.shardMagnesium, 3).setBlockName("oreMagnesium").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeSand).setBlockTextureName(ModVars.MOD_ID + ":oreMagnesium");
        orePhosphorus = new OreParticleEmitter(Material.rock, ModItems.cubePhosphorus, 3).setBlockName("orePhosphorus").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":orePhosphorus");

        //Decoration Blocks
        blockBlackTile = new BlockGeneric(Material.rock).setBlockName("blockBlackTile").setCreativeTab(CreativeTabs.tabDecorations).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":blockBlackTile");
        blockBlackTileHazard = new BlockGeneric(Material.rock).setBlockName("blockBlackTileHazard").setCreativeTab(CreativeTabs.tabDecorations).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":blockBlackTileHazard");
        blockGreyTile = new BlockGeneric(Material.rock).setBlockName("blockGreyTile").setCreativeTab(CreativeTabs.tabDecorations).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":blockGreyTile");
        blockGreyTileHazard = new BlockGeneric(Material.rock).setBlockName("blockGreyTileHazard").setCreativeTab(CreativeTabs.tabDecorations).setStepSound(Block.soundTypeStone).setBlockTextureName(ModVars.MOD_ID + ":blockGreyTileHazard");
        blockGlassTungsten = new BlockGlassGeneric(ModVars.MOD_ID + ":blockGlassTungsten", Material.glass, false).setBlockName("blockGlassTungsten").setCreativeTab(CreativeTabs.tabDecorations).setStepSound(Block.soundTypeGlass).setBlockTextureName(ModVars.MOD_ID + ":blockGlassTungsten");

        //Rocket Blocks
        interpTest = new interpTest(Material.rock).setBlockName("interpTest").setCreativeTab(CreativeTabs.tabBlock);

        //Machine Blocks

    }

    public static void BlockRegister()
    {

        //Terrain Blocks
        GameRegistry.registerBlock(blockMoonTurf, blockMoonTurf.getUnlocalizedName());
        GameRegistry.registerBlock(blockMarsTurf, blockMarsTurf.getUnlocalizedName());
        GameRegistry.registerBlock(blockMercurySurface, blockMercurySurface.getUnlocalizedName());

        //Ore Blocks
        GameRegistry.registerBlock(oreCopper, oreCopper.getUnlocalizedName());
        GameRegistry.registerBlock(oreAluminum, oreAluminum.getUnlocalizedName());
        GameRegistry.registerBlock(oreTitanium, oreTitanium.getUnlocalizedName());
        GameRegistry.registerBlock(oreTungsten, oreTungsten.getUnlocalizedName());
        GameRegistry.registerBlock(oreTin, oreTin.getUnlocalizedName());
        GameRegistry.registerBlock(oreSulfur, oreSulfur.getUnlocalizedName());
        GameRegistry.registerBlock(oreMoonStone, oreMoonStone.getUnlocalizedName());
        GameRegistry.registerBlock(oreSmokeyQuartz, oreSmokeyQuartz.getUnlocalizedName());
        GameRegistry.registerBlock(oreCadmium, oreCadmium.getUnlocalizedName());
        GameRegistry.registerBlock(oreMagnesium, oreMagnesium.getUnlocalizedName());
        GameRegistry.registerBlock(orePhosphorus, orePhosphorus.getUnlocalizedName());

        //Decoration Blocks
        GameRegistry.registerBlock(blockBlackTile, blockBlackTile.getUnlocalizedName());
        GameRegistry.registerBlock(blockBlackTileHazard, blockBlackTileHazard.getUnlocalizedName());
        GameRegistry.registerBlock(blockGreyTile, blockGreyTile.getUnlocalizedName());
        GameRegistry.registerBlock(blockGreyTileHazard, blockGreyTileHazard.getUnlocalizedName());
        GameRegistry.registerBlock(blockGlassTungsten, blockGlassTungsten.getUnlocalizedName());

        //Rocket Blocks
        GameRegistry.registerBlock(interpTest, interpTest.getUnlocalizedName());

        //Machine Blocks


    }

}
