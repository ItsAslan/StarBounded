package com.sbnd.world.celestial.sample.moon;

import com.sbnd.world.celestial.core.ICelestialBodyData;
import com.sbnd.world.celestial.core.data.IAtmosphereData;
import com.sbnd.world.celestial.core.data.IGenData;
import com.sbnd.world.celestial.core.data.ISkyData;
import com.sbnd.world.celestial.core.data.IWorldData;
import com.sbnd.world.celestial.sample.moon.data.MoonAtmosphereData;
import com.sbnd.world.celestial.sample.moon.data.MoonGenData;
import com.sbnd.world.celestial.sample.moon.data.MoonSkyData;
import com.sbnd.world.celestial.sample.moon.data.MoonWorldData;

public class MoonBodyData implements ICelestialBodyData {

    @Override
    public IAtmosphereData getAtmosphereData() {
        return new MoonAtmosphereData();
    }

    @Override
    public IWorldData getWorldData() {
        return new MoonWorldData();
    }

    @Override
    public ISkyData getSkyData() {
        return new MoonSkyData();
    }

    @Override
    public IGenData getGenData() {
        return new MoonGenData();
    }

}
