package com.sbnd.blocks.generic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class OreGeneric extends Block
{

    private Item itemToDrop = null;
    private int maxAmount = 0;

    public OreGeneric(Material material) {
        super(material);
        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(3.0F);
    }

    public OreGeneric(Material material, Item itemToDrop, int maxAmount)
    {
        super(material);
        this.itemToDrop = itemToDrop;
        this.maxAmount = maxAmount;

        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(3.0F);
    }

    public Item getItemToDrop()
    {
        return itemToDrop;
    }

    @Override
    public int quantityDropped(Random random) {
        return maxAmount == 0 ? 1 : 1 + random.nextInt(maxAmount);
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return itemToDrop != null ? itemToDrop : super.getItemDropped(p_149650_1_, p_149650_2_, p_149650_3_);
    }
}
