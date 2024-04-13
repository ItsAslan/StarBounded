package com.sbnd.crafting;

import com.sbnd.items.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class BasicCrafting
{
    public static void init()
    {
        craftingToolCrafting();
        toolCrafting();
        plateCrafting();
    }

    public static void craftingToolCrafting()
    {
        GameRegistry.addRecipe(new ItemStack(ModItems.itemHammer), new Object[] { "TTT", " S ", 'T', Blocks.stone, 'S', Items.stick } );
    }

    public static void toolCrafting()
    {
        GameRegistry.addRecipe(new ItemStack(ModItems.copperAoePickaxe), new Object[] { "CAC", " S ", " S ", 'C', ModItems.ingotCopper, 'A', ModItems.ingotTitanium, 'S', Items.stick } );
    }

    public static void plateCrafting()
    {
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.plateCopper, 2), ModItems.ingotCopper, new ItemStack(ModItems.itemHammer, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.plateAluminum, 2), ModItems.ingotAluminum, new ItemStack(ModItems.itemHammer, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.plateTitanium, 2), ModItems.ingotTitanium, new ItemStack(ModItems.itemHammer, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.plateTungsten, 2), ModItems.ingotTungsten, new ItemStack(ModItems.itemHammer, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.plateTin, 2), ModItems.ingotTin, new ItemStack(ModItems.itemHammer, 1, OreDictionary.WILDCARD_VALUE));
    }
}
