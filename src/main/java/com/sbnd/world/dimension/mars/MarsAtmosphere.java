package com.sbnd.world.dimension.mars;

import api.interfaces.planets.IAtmosphere;

public class MarsAtmosphere implements IAtmosphere
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
