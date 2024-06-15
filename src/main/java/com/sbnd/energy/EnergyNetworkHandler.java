package com.sbnd.energy;

import api.interfaces.energy.IEnergyComponent;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class EnergyNetworkHandler {

    @Getter
    @Setter
    private static EnergyNetworkHandler instance;

    public static EnergyNetworkHandler INSTANCE() {

        if (getInstance() == null)
        {
            setInstance(new EnergyNetworkHandler());
        }
        return getInstance();

    }

    @Getter
    private List<EnergyNetwork> networks = new ArrayList<>();

    public void createNetwork(IEnergyComponent root) {

        EnergyNetwork net = new EnergyNetwork();

        net.addLink(root);

        getNetworks().add(net);

    }

    public void deleteNetwork(EnergyNetwork... networks) {

        for(EnergyNetwork net : networks) {

            net.delete();

            System.out.println("Deleted network");
            getNetworks().remove(net);

        }

    }

    public void linkNetworks(EnergyNetwork net1, EnergyNetwork net2) {

        EnergyNetwork joinedNet = new EnergyNetwork();

        net1.getLinks().forEach(joinedNet::addLink);
        net2.getLinks().forEach(joinedNet::addLink);

        // Do not call 'delete' because you are not deleting the network, just moving it
        getNetworks().remove(net1);
        getNetworks().remove(net2);

    }

    public void tickNetworks() {

        for(EnergyNetwork net : getNetworks()) {

            net.tick();

        }

    }

}
