package com.sbnd.world.dimension.mercury;

import api.interfaces.planets.IAtmosphere;

public class MercuryAtmosphere implements IAtmosphere
{

    @Override
    public boolean canBreathe() {
        return false;
    }

    @Override
    public boolean isHot() {
        return true;
    }

    @Override
    public double radiationLevel() {
        return 0;
    }

}
