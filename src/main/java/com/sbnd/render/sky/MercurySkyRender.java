package com.sbnd.render.sky;

import api.enums.EnumPlanet;
import api.enums.EnumStar;
import api.planets.PlanetSkyRender;

public class MercurySkyRender extends PlanetSkyRender
{

    @Override
    protected boolean canSeeStars() {
        return true;
    }

    @Override
    protected boolean isOrbitingBody() {
        return false;
    }

    @Override
    protected boolean hasMoons() {
        return false;
    }

    @Override
    protected EnumPlanet getPrimaryPlanet() {
        return null;
    }

    @Override
    protected EnumPlanet getCurrentPlanet() {
        return EnumPlanet.MERCURY;
    }

    @Override
    protected EnumStar getPlanetStar() {
        return EnumStar.SOL;
    }

    @Override
    protected EnumPlanet[] getMoons() {
        return new EnumPlanet[0];
    }
}