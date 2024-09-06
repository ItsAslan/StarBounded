package com.sbnd.content.block;

import com.sbnd.content.block.core.definitions.basic.BlockCrystal;
import com.sbnd.content.block.core.definitions.basic.BlockGeneric;
import com.sbnd.content.block.core.definitions.basic.OreGeneric;
import com.sbnd.content.block.core.SbndBlock;
import com.sbnd.content.item.ModItems;
import com.sbnd.main.ModVars;
import com.sbnd.main.Starbounded;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.Teleporter;
import net.minecraftforge.common.DimensionManager;

import java.util.ArrayList;
import java.util.List;

import static com.sbnd.content.block.core.definitions.basic.OreGeneric.OreType.*;

public class ModBlocks extends DimensionManager {

    static List<SbndBlock> modBlocks = new ArrayList<>();

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
    public static Block oreSaltpeter;
    public static Block oreZirconium;
    public static Block oreNiobium;
    public static Block oreTantalum;
    public static Block oreMoonIron;
    public static Block oreMoonTin;
    public static Block oreMoonTitanium;
    public static Block oreMoonRockSaltpeter;
    public static Block oreMoonBasaltSaltpeter;
    public static Block oreIceIron;

    // Terrain
    public static Block blockMoonTurf;
    public static Block blockMoonRock;
    public static Block blockMoonBasalt;
    public static Block blockMarsTurf;

    // Test
    public static Block crystalZirconium;
    public static Block crystalNiobium;
    public static Block crystalTantalum;

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
        oreSaltpeter = new OreGeneric(modBlocks, Material.rock, NORMAL, ModItems.powderSaltpeter, 4).setBlockName("oreSaltpeter").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeStone);
        oreZirconium = new OreGeneric(modBlocks, Material.rock, FREEZING, ModItems.clusterZirconium, 5).setBlockName("oreZirconium").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeStone);
        oreNiobium = new OreGeneric(modBlocks, Material.rock, FREEZING, ModItems.clusterNiobium, 5).setBlockName("oreNiobium").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeStone);
        oreTantalum = new OreGeneric(modBlocks, Material.rock, FREEZING, ModItems.clusterTantalum, 5).setBlockName("oreTantalum").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeStone);
        oreMoonIron = new OreGeneric(modBlocks, Material.rock, NORMAL).setBlockName("oreMoonIron").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeStone);
        oreMoonTin = new OreGeneric(modBlocks, Material.rock, NORMAL).setBlockName("oreMoonTin").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeStone);
        oreMoonTitanium = new OreGeneric(modBlocks, Material.rock, NORMAL).setBlockName("oreMoonTitanium").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeStone);
        oreMoonRockSaltpeter = new OreGeneric(modBlocks, Material.rock, NORMAL, ModItems.powderSaltpeter, 8).setBlockName("oreMoonRockSaltpeter").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeStone);
        oreMoonBasaltSaltpeter = new OreGeneric(modBlocks, Material.rock, NORMAL, ModItems.powderSaltpeter, 8).setBlockName("oreMoonBasaltSaltpeter").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeStone);
        oreIceIron = new OreGeneric(modBlocks, Material.rock, NORMAL).setBlockName("oreIceIron").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeGlass);

        // Terrain
        blockMoonTurf = new BlockGeneric(modBlocks, Material.sand).setBlockName("blockMoonTurf").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeSand);
        blockMoonRock = new BlockGeneric(modBlocks, Material.rock).setBlockName("blockMoonRock").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone);
        blockMoonBasalt = new BlockGeneric(modBlocks, Material.rock).setBlockName("blockMoonBasalt").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeStone);

        blockMarsTurf = new BlockGeneric(modBlocks, Material.rock).setBlockName("blockMarsTurf").setCreativeTab(CreativeTabs.tabBlock).setStepSound(Block.soundTypeSand);

        // Test
        crystalZirconium = new BlockCrystal(modBlocks, Material.glass).setBlockName("crystalZirconium").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeGlass);
        crystalNiobium = new BlockCrystal(modBlocks, Material.glass).setBlockName("crystalNiobium").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeGlass);
        crystalTantalum = new BlockCrystal(modBlocks, Material.glass).setBlockName("crystalTantalum").setCreativeTab(Starbounded.oresTab).setStepSound(Block.soundTypeGlass);

    }

    static void registerTextures() {

        modBlocks.forEach(block -> {

            if (block.isUsingTextureRegistry()) {

                block.setBlockTextureName(String.format("%s:%s", ModVars.MOD_ID, block.getUnlocalizedName().substring(5)));

            }

        });

    }

    static void registerBlocks() {

        modBlocks.forEach(block -> GameRegistry.registerBlock(block, block.getUnlocalizedName()));

    }

}
