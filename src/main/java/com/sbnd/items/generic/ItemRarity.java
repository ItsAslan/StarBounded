package com.sbnd.items.generic;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemRarity extends Item {

    EnumRarity rarity;

    public ItemRarity(EnumRarity rarity) {
        this.rarity = rarity;
    }

    @Override
    public EnumRarity getRarity(ItemStack p_77613_1_) {
        return rarity;
    }
}
