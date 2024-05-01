package com.sbnd.render.sky;

import api.enums.EnumPlanet;
import api.enums.EnumStar;
import api.planets.PlanetSkyRender;

public class MoonSkyRender extends PlanetSkyRender {

    @Override
    protected boolean canSeeStars() {
        return true;
    }

    @Override
    protected boolean isOrbitingBody() {
        return true;
    }

    @Override
    protected boolean hasMoons() {
        return false;
    }

    @Override
    protected EnumPlanet getPrimaryPlanet() {
        return EnumPlanet.EARTH;
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
