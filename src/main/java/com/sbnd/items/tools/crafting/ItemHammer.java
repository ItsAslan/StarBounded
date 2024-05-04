package com.sbnd.items.tools.crafting;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemHammer extends ItemPickaxe
{

    public ItemHammer(int durability) {
        super(ToolMaterial.STONE);
        this.setContainerItem(this);
        this.setMaxDamage(durability);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack)
    {
        itemStack = new ItemStack(this, itemStack.getMaxStackSize(), itemStack.getItemDamage());
        itemStack.attemptDamageItem(1, null);
        return itemStack;
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack p_77630_1_) {
        return false;
    }
}
