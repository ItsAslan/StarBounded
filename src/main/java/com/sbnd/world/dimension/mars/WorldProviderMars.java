package com.sbnd.world.dimension.mars;

import api.enums.EnumPlanet;
import api.planets.WorldProviderPlanet;

public class WorldProviderMars extends WorldProviderPlanet
{

    @Override
    protected EnumPlanet getPlanet() {
        return EnumPlanet.MARS;
    }

    @Override
    protected boolean hasClouds() {
        return false;
    }

}
