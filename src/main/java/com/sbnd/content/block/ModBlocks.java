package com.sbnd.content.block;

import com.sbnd.content.block.core.definitions.basic.BlockGeneric;
import com.sbnd.content.block.core.definitions.basic.OreGeneric;
import com.sbnd.content.item.ModItems;
import com.sbnd.main.ModVars;
import com.sbnd.main.Starbounded;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import java.util.ArrayList;
import java.util.List;

import static com.sbnd.content.block.core.definitions.basic.OreGeneric.OreType.*;

public class ModBlocks {

    static List<Block> modBlocks = new ArrayList<>();

    //---------------BLOCKS---------------//

    //Decoration
    public static Block blockComputerRack;
    public static Block blockMonitor1;
    public static Block blockMonitor2;

    // Ore
    public static Block oreCopper;
    public static Block oreAluminum;
    public static Block oreTitanium;
    public static Block oreTungsten;
    public static Block oreTin;
    public static Block oreSulfur;
    public static Block oreZirconium;
    public static Block oreNiobium;
    public static Block oreTantalum;

    // Terrain
    public static Block blockMoonTurf;
    public static Block blockMoonTurfMedium;
    public static Block blockMoonTurfDark;

    public static void REGISTER() {

        initBlocks();
        registerTextures();
        registerBlocks();

    }

    static void initBlocks() {

        //Decoration
        blockComputerRack = new BlockGeneric(modBlocks, Material.rock).setBlockName("blockComputerRack").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeAnvil);
        blockMonitor1 = new BlockGeneric(modBlocks, Material.rock).setBlockName("blockMonitor1").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeAnvil);
        blockMonitor2 = new BlockGeneric(modBlocks, Material.rock).setBlockName("blockMonitor2").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeAnvil);

        // Ore
        oreCopper = new OreGeneric(modBlocks, Material.rock, NORMAL).setBlockName("oreCopper").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeStone);
        oreAluminum = new OreGeneric(modBlocks, Material.rock, NORMAL).setBlockName("oreAluminum").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeStone);
        oreTitanium = new OreGeneric(modBlocks, Material.rock, NORMAL).setBlockName("oreTitanium").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeStone);
        oreTungsten = new OreGeneric(modBlocks, Material.rock, NORMAL).setBlockName("oreTungsten").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeStone);
        oreTin = new OreGeneric(modBlocks, Material.rock, NORMAL).setBlockName("oreTin").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeStone);
        oreSulfur = new OreGeneric(modBlocks, Material.rock, NORMAL, ModItems.cubeSulfur, 4).setBlockName("oreSulfur").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeStone);
        oreZirconium = new OreGeneric(modBlocks, Material.rock, FREEZING, ModItems.clusterZirconium, 5).setBlockName("oreZirconium").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeSand);
        oreNiobium = new OreGeneric(modBlocks, Material.rock, FREEZING, ModItems.clusterNiobium, 5).setBlockName("oreNiobium").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeSand);
        oreTantalum = new OreGeneric(modBlocks, Material.rock, FREEZING, ModItems.clusterTantalum, 5).setBlockName("oreTantalum").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeSand);

        // Terrain
        blockMoonTurf = new OreGeneric(modBlocks, Material.sand, NORMAL).setBlockName("blockMoonTurf").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeSand);
        blockMoonTurfMedium = new OreGeneric(modBlocks, Material.sand, NORMAL).setBlockName("blockMoonTurfMedium").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeSand);
        blockMoonTurfDark = new OreGeneric(modBlocks, Material.sand, NORMAL).setBlockName("blockMoonTurfDark").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeSand);

    }

    static void registerTextures() {

        modBlocks.forEach(block -> block.setBlockTextureName(String.format("%s:%s", ModVars.MOD_ID, block.getUnlocalizedName().substring(5))));

    }

    static void registerBlocks() {

        modBlocks.forEach(block -> GameRegistry.registerBlock(block, block.getUnlocalizedName()));

    }

}
