package com.sbnd.lib;

import api.enums.EnumPlanet;

import java.util.List;

public class Library
{

    public static int defaultTickInterval()
    {
        return 20;
    }

    public static String getPlanetName(EnumPlanet planet)
    {
        return planet.getName();
    }

    public static int getPlanetId(EnumPlanet planet)
    {
        return planet.getDimensionId();
    }


}
