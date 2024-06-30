package com.sbnd.content.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.HashSet;
import java.util.Set;

public class ModItems {

    static Set<Item> modItems = new HashSet<>();

    public static void REGISTER() {

        initItems();
        registerItems();

    }

    static void initItems() {



    }

    static void registerItems() {

        modItems.forEach(item -> GameRegistry.registerItem(item, item.getUnlocalizedName()));

    }

}
