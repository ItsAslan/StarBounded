package com.sbnd.content.block.core.definitions.basic;

import lombok.Getter;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SbndBlock extends Block {

    @Getter
    private boolean usingTextureRegistry = true;

    protected SbndBlock(Material material) {

        super(material);

    }

    public void disableTextureRegistry() {

        usingTextureRegistry = false;

    }

}
