package com.sbnd.energy;

import api.interfaces.energy.IEnergyComponent;
import api.interfaces.energy.IEnergyPath;
import api.interfaces.energy.IEnergySink;
import api.interfaces.energy.IEnergySource;
import api.util.BlockPos;
import com.sbnd.main.Starbounded;
import lombok.Getter;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EnergyNetwork {

    @Getter
    private List<IEnergyComponent> links = new ArrayList<>();

    public void addLink(IEnergyComponent link) {

        getLinks().add(link);

    }

    public void removeLink(World world, BlockPos pos, IEnergyComponent link) {

        EnergyNetwork cacheNet = link.getNetwork();

        refreshNetwork(world, pos, link.getNetwork());

        getLinks().remove(link);

        if(cacheNet.isEmpty()) {

            Starbounded.NETWORKHANDLER.deleteNetwork(cacheNet);

        }

    }

    public void refreshNetwork(World world, BlockPos pos, EnergyNetwork net) {

        for(IEnergySource source : net.getSources()) {

            Starbounded.NETWORKHANDLER.createNetwork(source);
            source.scan(world, pos);

        }

    }

    public ArrayList<IEnergySource> getSources() {

        return getLinks().stream()
                .filter(link -> link instanceof IEnergySource)
                .map(link -> (IEnergySource) link)
                .collect(Collectors.toCollection(ArrayList::new));

    }

    public ArrayList<IEnergySink> getSinks() {

        return getLinks().stream()
                .filter(link -> link instanceof IEnergySink)
                .map(link -> (IEnergySink) link)
                .collect(Collectors.toCollection(ArrayList::new));

    }

    public void tick() {

        System.out.println("augh");

    }

    public void delete() {

        List<IEnergyComponent> deleteBuffer = new ArrayList<>(getLinks());

        for(IEnergyComponent link : deleteBuffer) {

            getLinks().remove(link);

        }

    }

    public boolean isEmpty() {

        return getLinks().isEmpty();

    }

}
