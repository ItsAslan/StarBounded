package com.sbnd.gen.dimension;

import com.sbnd.gen.dimension.providers.WorldProviderMoon;
import com.sbnd.enums.EnumPlanet;
import com.sbnd.lib.Library;
import net.minecraftforge.common.DimensionManager;

public class DimensionRegistry
{

    public static void MainRegistry()
    {
        RegisterDimension();
    }

    public static final int moonDimensionID = Library.getPlanetId(EnumPlanet.MOON);

    public static void RegisterDimension()
    {
        DimensionManager.registerProviderType(moonDimensionID, WorldProviderMoon.class, false);
        DimensionManager.registerDimension(moonDimensionID, moonDimensionID);
    }

}
