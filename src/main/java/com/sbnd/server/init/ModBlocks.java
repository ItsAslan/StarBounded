package com.sbnd.server.init;

import api.sbnd.ct.BlockConnectedTexture;
import api.sbnd.forge.ForgeRegistry;
import com.sbnd.server.block.spacecraft.BlockController;
import com.sbnd.server.block.spacecraft.BlockFuselage;
import com.sbnd.server.block.spacecraft.BlockThruster;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ModBlocks {

    private static ForgeRegistry<Block> registry;

    public static Block fuselage;
    public static Block controller;
    public static Block thruster;

    public static Block ctTest;

    public static void register() {

        registry = new ForgeRegistry<>();

        initBlocks();
        registerBlocks();

    }

    private static void initBlocks() {

        fuselage = registry.register(new BlockFuselage(Material.rock).setBlockName("fuselage").setBlockTextureName("sbnd:fuselage").setCreativeTab(CreativeTabs.tabBlock));
        controller = registry.register(new BlockController(Material.rock).setBlockName("controller").setBlockTextureName("sbnd:controller").setCreativeTab(CreativeTabs.tabBlock));
        thruster = registry.register(new BlockThruster(Material.rock).setBlockName("thruster").setBlockTextureName("sbnd:thruster").setCreativeTab(CreativeTabs.tabBlock));

        ctTest = registry.register(new BlockConnectedTexture(Material.rock).setBlockName("test").setCreativeTab(CreativeTabs.tabBlock));

    }

    private static void registerBlocks(){

        registry.forEach(block -> GameRegistry.registerBlock(block, block.getUnlocalizedName()));

    }

}
