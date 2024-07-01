package com.sbnd.content.item.core.definitions.basic;

import lombok.NoArgsConstructor;
import net.minecraft.item.Item;

import java.util.Set;

@NoArgsConstructor
public class ItemGeneric extends Item {

    public ItemGeneric(Set<Item> registry) {

        registry.add(this);

    }

}
