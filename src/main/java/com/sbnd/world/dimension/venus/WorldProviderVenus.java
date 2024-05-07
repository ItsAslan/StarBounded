package com.sbnd.world.dimension.venus;

import api.enums.EnumPlanet;
import api.planets.WorldProviderPlanet;

public class WorldProviderVenus extends WorldProviderPlanet
{

    @Override
    protected EnumPlanet getPlanet() {
        return EnumPlanet.VENUS;
    }

    @Override
    protected boolean hasClouds() {
        return false;
    }

    @Override
    public float[] calcSunriseSunsetColors(float p_76560_1_, float p_76560_2_)
    {
        return null;
    }

}
