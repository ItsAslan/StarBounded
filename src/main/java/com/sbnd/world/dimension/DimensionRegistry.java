package com.sbnd.world.dimension;

import com.sbnd.world.PlanetManager;
import com.sbnd.world.dimension.mars.WorldProviderMars;
import com.sbnd.world.dimension.mercury.WorldProviderMercury;
import com.sbnd.world.dimension.moon.WorldProviderMoon;
import api.enums.EnumPlanet;
import com.sbnd.world.dimension.venus.WorldProviderVenus;
import net.minecraftforge.common.DimensionManager;

public class DimensionRegistry
{

    public static void MainRegistry()
    {
        RegisterDimension();
    }

    public static final int moonDimensionID = PlanetManager.getPlanetId(EnumPlanet.MOON);
    public static final int marsDimensionID = PlanetManager.getPlanetId(EnumPlanet.MARS);
    public static final int mercuryDimensionID = PlanetManager.getPlanetId(EnumPlanet.MERCURY);
    public static final int venusDimensionID = PlanetManager.getPlanetId(EnumPlanet.VENUS);

    public static void RegisterDimension()
    {
        DimensionManager.registerProviderType(moonDimensionID, WorldProviderMoon.class, false);
        DimensionManager.registerDimension(moonDimensionID, moonDimensionID);

        DimensionManager.registerProviderType(marsDimensionID, WorldProviderMars.class, false);
        DimensionManager.registerDimension(marsDimensionID, marsDimensionID);

        DimensionManager.registerProviderType(mercuryDimensionID, WorldProviderMercury.class, false);
        DimensionManager.registerDimension(mercuryDimensionID, mercuryDimensionID);

        DimensionManager.registerProviderType(venusDimensionID, WorldProviderVenus.class, false);
        DimensionManager.registerDimension(venusDimensionID, venusDimensionID);
    }

}
