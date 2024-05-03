package com.sbnd.world.dimension.mercury;

import api.enums.EnumPlanet;
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

}
