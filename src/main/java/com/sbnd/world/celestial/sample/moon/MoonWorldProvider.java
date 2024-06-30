package com.sbnd.world.celestial.sample.moon;

import com.sbnd.world.celestial.core.base.WorldProviderCelestial;
import com.sbnd.world.celestial.core.data.ISkyData;
import com.sbnd.world.celestial.core.data.IWorldData;
import com.sbnd.world.celestial.sample.moon.data.MoonSkyData;
import com.sbnd.world.celestial.sample.moon.data.MoonWorldData;

public class MoonWorldProvider extends WorldProviderCelestial {

    @Override
    public IWorldData getWorldData() {
        return new MoonWorldData();
    }

    @Override
    public ISkyData getSkyData() {
        return new MoonSkyData();
    }

}
