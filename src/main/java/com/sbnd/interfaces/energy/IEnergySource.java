package com.sbnd.interfaces.energy;

import com.sbnd.energy.EnergyNetwork;

public interface IEnergySource
{

    void scanForNetwork();

    int getProductionRate();
    int getMaxBuffer();

    EnergyNetwork getNetwork();

}
