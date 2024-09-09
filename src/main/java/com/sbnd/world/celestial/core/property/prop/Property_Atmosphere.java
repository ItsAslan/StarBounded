package com.sbnd.world.celestial.core.property.prop;

import com.sbnd.content.transport.fluid.gas.ModGasses;
import com.sbnd.world.celestial.core.property.CelestialProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Property_Atmosphere extends CelestialProperty {

    private final ArrayList<AtmosphereGas> gasses;

    @Getter
    @AllArgsConstructor
    private static class AtmosphereGas {

        private ModGasses gas;
        private double pressurePsi;

    }

    public Property_Atmosphere() {

        gasses = new ArrayList<>();

    }

    public Property_Atmosphere(ModGasses fluid, double pressurePsi) {

        gasses = new ArrayList<>();

        gasses.add(new AtmosphereGas(fluid, pressurePsi));

    }

    public Property_Atmosphere and(ModGasses fluid, double pressurePsi) {

        gasses.add(new AtmosphereGas(fluid, pressurePsi));

        return this;

    }

    public Property_Atmosphere clone() {

        Property_Atmosphere clone = new Property_Atmosphere();

        for(AtmosphereGas gas : getGasses()) {

            clone.getGasses().add(new AtmosphereGas(gas.getGas(), gas.getPressurePsi()));

        }

        return clone;

    }

    public double getPressure() {

        double pressure = 0;

        for (AtmosphereGas gas : gasses) {

            pressure += gas.getPressurePsi();

        }

        return pressure;

    }

}
