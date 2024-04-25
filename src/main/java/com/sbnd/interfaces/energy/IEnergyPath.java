package com.sbnd.interfaces.energy;

import com.sbnd.api.BlockCoordinate;
import com.sbnd.energy.EnergyNetwork;

import java.util.List;

public interface IEnergyPath
{

    List<BlockCoordinate> scanForNetwork();
    EnergyNetwork getNetwork();

}
