package com.sbnd.interfaces.energy;

import com.sbnd.energy.EnergyNetwork;

public interface IEnergySink
{

    int getMaxFull();
    int getMaxDrain();

    EnergyNetwork getNetwork();

}
