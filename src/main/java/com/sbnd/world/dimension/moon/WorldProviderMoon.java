package com.sbnd.world.dimension.moon;

import api.enums.EnumPlanet;
import api.planets.WorldProviderPlanet;

public class WorldProviderMoon extends WorldProviderPlanet
{

    @Override
    protected EnumPlanet getPlanet() {
        return EnumPlanet.MOON;
    }

    @Override
    protected boolean hasClouds() {
        return false;
    }

}