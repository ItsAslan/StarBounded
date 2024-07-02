package com.sbnd.world.celestial;

import com.sbnd.world.celestial.core.CelestialBody;
import com.sbnd.world.celestial.core.CelestialType;
import com.sbnd.world.celestial.sample.moon.MoonBodyData;
import net.minecraftforge.common.DimensionManager;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class SbndCelestialObjects {

    public static AtomicInteger currentId = new AtomicInteger(1);
    public static Set<CelestialBody> celestialBodies = new HashSet<>();


    //---------------SATELLITES---------------//

    static CelestialBody moon;

    static void planetInit() {

        moon = new CelestialBody(celestialBodies, new MoonBodyData(), CelestialType.SATELLITE, "Moon").setParent(EnumCelestial.EARTH).setStar(EnumCelestial.SOL);

    }

    public static void REGISTER() {

        planetInit();

        celestialBodies.forEach(body -> init(body));

    }

    static void init(CelestialBody body) {

        DimensionManager.registerProviderType(currentId.incrementAndGet(), body.getData().getWorldData().getWorldProvider().getClass(), false);
        DimensionManager.registerDimension(currentId.get(), currentId.get());

    }

}
