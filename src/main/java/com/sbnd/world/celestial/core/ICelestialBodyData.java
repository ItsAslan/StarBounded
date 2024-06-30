package com.sbnd.world.celestial.core;

import com.sbnd.world.celestial.core.data.IAtmosphereData;
import com.sbnd.world.celestial.core.data.IGenData;
import com.sbnd.world.celestial.core.data.ISkyData;
import com.sbnd.world.celestial.core.data.IWorldData;

public interface ICelestialBodyData {

    IAtmosphereData getAtmosphereData(); // For atmosphere

    IWorldData getWorldData(); // For literally everything else

    ISkyData getSkyData(); // For Sky Renderer Data

    IGenData getGenData(); // Biomes and blocks

}
