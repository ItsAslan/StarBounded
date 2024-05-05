package com.sbnd.world.dimension.mercury;

import api.enums.EnumPlanet;
import api.interfaces.planets.IAtmosphere;
import api.planets.WorldProviderPlanet;

public class WorldProviderMercury extends WorldProviderPlanet
{

    @Override
    protected EnumPlanet getPlanet() {
        return EnumPlanet.MERCURY;
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
