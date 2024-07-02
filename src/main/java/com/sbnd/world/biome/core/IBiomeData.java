package com.sbnd.world.biome.core;

import com.sbnd.world.biome.core.data.IBiomeFaunaData;
import com.sbnd.world.biome.core.data.IBiomeGenData;
import com.sbnd.world.biome.core.data.IBiomePropertyData;

public interface IBiomeData {

    IBiomeFaunaData getFaunaData();

    IBiomeGenData getGenData();

    IBiomePropertyData getPropertyData();

}
