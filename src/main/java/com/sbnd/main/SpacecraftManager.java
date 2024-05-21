package com.sbnd.main;

import api.spacecraft.ISpacecraft;

import java.util.ArrayList;

public class SpacecraftManager {

    private static ArrayList<ISpacecraft> spacecrafts = new ArrayList<>();

    public static void registerSpacecraft(ISpacecraft spacecraft) {
        spacecrafts.add(spacecraft);
    }

    public static void removeSpacecraft(ISpacecraft spacecraft) {
        spacecrafts.remove(spacecraft);
    }

}
