package com.sbnd.world.celestial;

import com.sbnd.world.celestial.core.CelestialBody;
import com.sbnd.world.celestial.core.CelestialType;
import net.minecraftforge.common.DimensionManager;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class SbndCelestialObjects {

    static AtomicInteger currentId = new AtomicInteger(3);
    static Set<CelestialBody> celestialBodies = new HashSet<>();

    public static void REGISTER() {

        planetInit();

        celestialBodies.forEach(body -> init(body));

    }

    static void planetInit() {

    }

    static void init(CelestialBody body) {

        DimensionManager.registerProviderType(currentId.getAndIncrement(), body.getData().getWorldData().getWorldProvider().getClass(), false);
        DimensionManager.registerDimension(currentId.get(), currentId.get());

    }

}
