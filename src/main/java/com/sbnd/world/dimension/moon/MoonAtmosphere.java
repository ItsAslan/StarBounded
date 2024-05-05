package com.sbnd.world.dimension.moon;

import api.interfaces.planets.IAtmosphere;

public class MoonAtmosphere implements IAtmosphere
{

    @Override
    public boolean canBreathe() {
        return false;
    }

    @Override
    public boolean isHot() {
        return false;
    }

    @Override
    public double radiationLevel() {
        return 0;
    }

}
