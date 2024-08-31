package com.sbnd.content.block.core.definitions.basic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.List;

public class BlockGeneric extends SbndBlock {

    public BlockGeneric(List<SbndBlock> registry, Material material) {

        super(material);
        registry.add(this);

        // Basic for Stone
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 2);

    }

}
