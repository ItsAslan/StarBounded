package com.sbnd.crafting;

import com.sbnd.blocks.ModBlocks;
import com.sbnd.items.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

public class BasicSmelting
{
    public static void init()
    {
        oreSmelting();
    }

    public static void oreSmelting()
    {
        GameRegistry.addSmelting(ModBlocks.oreCopper, new ItemStack(ModItems.ingotCopper), 0.5f);
        GameRegistry.addSmelting(ModBlocks.oreAluminum, new ItemStack(ModItems.ingotAluminum), 0.5f);
        GameRegistry.addSmelting(ModBlocks.oreTitanium, new ItemStack(ModItems.ingotTitanium), 0.5f);
        GameRegistry.addSmelting(ModBlocks.oreTungsten, new ItemStack(ModItems.ingotTungsten), 0.5f);
        GameRegistry.addSmelting(ModBlocks.oreTin, new ItemStack(ModItems.ingotTin), 0.5f);
    }
}
