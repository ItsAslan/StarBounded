package com.sbnd.world.celestial.core.data;

import com.sbnd.world.celestial.EnumCelestial;
import com.sbnd.world.tmp.core.gen.SkyRendererCelestial;


import java.util.Set;

public interface ISkyData {

    boolean canSeeStars();
    int starAmount();

    boolean isOrbitingBody();

    String getSkyColor(); // Returns a '0xabcde` value

    String getFogColor(); // Returns a '0xabcde` value

    EnumCelestial getPrimaryPlanet();
    float getPrimaryPlanetRotation();
    float getPrimaryPlanetSize();

    EnumCelestial getCurrentPlanet();

    EnumCelestial getPlanetStar();
    float getStarRotation();
    float getStarSize();

    Set<EnumCelestial> getMoons();

    SkyRendererCelestial getSkyRenderer();

}