package com.sbnd.crafting;

import com.sbnd.items.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class BasicCrafting
{
    public static void init()
    {
        toolCrafting();
        plateCrafting();
    }

    public static void toolCrafting()
    {
        GameRegistry.addRecipe(new ItemStack(ModItems.itemHammer), "TTT", "S", 'T', Blocks.stone, 'S', Items.stick);
    }

    public static void plateCrafting()
    {
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.plateCopper, 2), ModItems.ingotCopper, ModItems.itemHammer);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.plateAluminum, 2), ModItems.ingotAluminum, ModItems.itemHammer);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.plateTitanium, 2), ModItems.ingotTitanium, ModItems.itemHammer);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.plateTungsten, 2), ModItems.ingotTungsten, ModItems.itemHammer);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.plateTin, 2), ModItems.ingotTin, ModItems.itemHammer);
    }
}
