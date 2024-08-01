package com.sbnd.content.item.core.definitions.basic;

import net.minecraft.item.Item;

import java.util.List;

public class ItemGeneric extends Item {

    public ItemGeneric(List<Item> registry) {

        registry.add(this);

    }

}
