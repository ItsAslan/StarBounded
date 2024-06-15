package com.sbnd.tileentity.energy;

import api.interfaces.energy.IEnergySource;
import com.sbnd.energy.EnergyNetwork;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.tileentity.TileEntity;

public class BlockEnergySourceTE extends TileEntity implements IEnergySource {

    @Getter
    @Setter
    private EnergyNetwork net;

    @Override
    public boolean hasNetwork() {
        return getNetwork() != null;
    }

    @Override
    public EnergyNetwork getNetwork() {
        return getNet();
    }

    @Override
    public void joinNetwork(EnergyNetwork net) {
        setNet(net);
    }

}
