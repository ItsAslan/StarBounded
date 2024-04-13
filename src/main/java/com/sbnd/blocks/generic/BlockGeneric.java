package com.sbnd.blocks.generic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGeneric extends Block
{

    public BlockGeneric(Material material) {
        super(material);
        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(3.0F);
    }

}
