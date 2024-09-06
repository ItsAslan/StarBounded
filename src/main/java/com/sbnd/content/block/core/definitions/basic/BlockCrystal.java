package com.sbnd.content.block.core.definitions.basic;

import com.sbnd.content.block.core.SbndBlock;
import net.minecraft.block.material.Material;

import java.util.List;

public class BlockCrystal extends SbndBlock {

    public BlockCrystal(List<SbndBlock> registry, Material material) {

        super(material);
        registry.add(this);

        // Basic for Stone
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 2);

    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType()
    {
        return 1;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }
    
}
