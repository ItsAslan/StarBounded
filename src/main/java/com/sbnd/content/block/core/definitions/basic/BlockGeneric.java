package com.sbnd.content.block.core.definitions.basic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.Set;

public class BlockGeneric extends Block {

    public BlockGeneric(Set<Block> registry, Material material) {

        super(material);
        registry.add(this);

    }

}
