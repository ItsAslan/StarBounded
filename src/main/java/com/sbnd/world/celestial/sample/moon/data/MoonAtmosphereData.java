package com.sbnd.world.celestial.sample.moon.data;

import com.sbnd.world.celestial.core.data.IAtmosphereData;

public class MoonAtmosphereData implements IAtmosphereData {

    @Override
    public boolean breathable() {
        return false;
    }

    @Override
    public double getTemp() {
        return 0;
    }

    @Override
    public double getRadiation() {
        return 0;
    }

}
