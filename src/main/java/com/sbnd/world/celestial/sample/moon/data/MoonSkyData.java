package com.sbnd.world.celestial.sample.moon.data;

import com.sbnd.world.celestial.EnumCelestial;

import com.sbnd.world.celestial.core.data.ISkyData;
import com.sbnd.world.tmp.core.bodies.CelestialBody;
import com.sbnd.world.tmp.core.gen.SkyRendererCelestial;

import java.util.Collections;
import java.util.Set;

public class MoonSkyData implements ISkyData {

    @Override
    public boolean canSeeStars() {
        return true;
    }

    @Override
    public int starAmount() {
        return 9000;
    }

    @Override
    public boolean isOrbitingBody() {
        return true;
    }

    @Override
    public String getSkyColor() {
        return "0x000000";
    }

    @Override
    public String getFogColor() {
        return "0x171717";
    }

    @Override
    public EnumCelestial getPrimaryPlanet() {
        return EnumCelestial.EARTH;
    }

    @Override
    public float getPrimaryPlanetRotation() {
        return 70;
    }

    @Override
    public float getPrimaryPlanetSize() {
        return 1;
    }

    @Override
    public EnumCelestial getCurrentPlanet() {
        return EnumCelestial.MOON;
    }

    @Override
    public EnumCelestial getPlanetStar() {
        return EnumCelestial.SOL;
    }

    @Override
    public float getStarRotation() {
        return 200;
    }

    @Override
    public float getStarSize() {
        return 20;
    }

    @Override
    public Set<EnumCelestial> getMoons() {
        return Collections.emptySet();
    }

    @Override
    public SkyRendererCelestial getSkyRenderer() {
        return new SkyRendererCelestial(CelestialBody.getBody("Moon"));
    }

}
