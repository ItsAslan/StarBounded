package com.sbnd.world.biome.core.data;

import net.minecraft.block.Block;

public interface IBiomeGenData {

    Block getTopBlock();
    Block getFillerBlock();

    boolean lakeSpawn();

}
