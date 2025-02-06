package com.sbnd.server.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockGeneric extends Block {

    public BlockGeneric(Material material) {
        this(material.getMaterialMapColor(), material);
    }

    public BlockGeneric(MapColor color, Material material) {

        super(material);

        setHarvestLevel("pickaxe", 1);
        setHardness(2.0F);

    }

}
