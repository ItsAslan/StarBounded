package com.sbnd.proxy;

import api.spacecraft.ISpacecraft;

import java.util.ArrayList;

public class SpacecraftManager {

    private ArrayList<ISpacecraft> spacecrafts = new ArrayList<>();

    public void registerSpacecraft(ISpacecraft spacecraft) {
        spacecrafts.add(spacecraft);
    }

    public void removeSpacecraft(ISpacecraft spacecraft) {
        spacecrafts.remove(spacecraft);
    }

}
