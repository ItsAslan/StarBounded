package com.sbnd.world.dimension;

import com.sbnd.world.PlanetManager;
import com.sbnd.world.dimension.mars.WorldProviderMars;
import com.sbnd.world.dimension.moon.WorldProviderMoon;
import api.enums.EnumPlanet;
import com.sbnd.lib.Library;
import net.minecraftforge.common.DimensionManager;

public class DimensionRegistry
{

    public static void MainRegistry()
    {
        RegisterDimension();
    }

    public static final int moonDimensionID = PlanetManager.getPlanetId(EnumPlanet.MOON);
    public static final int marsDimensionID = PlanetManager.getPlanetId(EnumPlanet.MARS);

    public static void RegisterDimension()
    {
        DimensionManager.registerProviderType(moonDimensionID, WorldProviderMoon.class, false);
        DimensionManager.registerDimension(moonDimensionID, moonDimensionID);

        DimensionManager.registerProviderType(marsDimensionID, WorldProviderMars.class, false);
        DimensionManager.registerDimension(marsDimensionID, marsDimensionID);
    }

}
