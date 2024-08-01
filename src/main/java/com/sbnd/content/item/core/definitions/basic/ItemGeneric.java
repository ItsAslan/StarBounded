package com.sbnd.content.item.core.definitions.basic;

import net.minecraft.item.Item;

import java.util.List;
import java.util.Set;

public class ItemGeneric extends Item {

    public ItemGeneric(List<Item> registry) {

        registry.add(this);

    }

}
