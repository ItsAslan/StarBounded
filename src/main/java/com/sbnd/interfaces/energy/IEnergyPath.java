package com.sbnd.interfaces.energy;

import com.sbnd.energy.EnergyNetwork;

public interface IEnergyPath
{

    void scanForNetwork();
    EnergyNetwork getNetwork();

}
