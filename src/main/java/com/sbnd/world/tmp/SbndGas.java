package com.sbnd.world.tmp;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class SbndGas {

    public static SbndGas HYDROGEN;
    public static SbndGas HELIUM;
    public static SbndGas NEON;
    public static SbndGas ARGON;
    public static SbndGas KRYPTON;
    public static SbndGas XENON;
    public static SbndGas RADON;
    public static SbndGas OGANESSON;

    public static SbndGas OXYGEN;
    public static SbndGas NITROGEN;
    public static SbndGas AMMONIA;
    public static SbndGas IODINE;
    public static SbndGas CO;
    public static SbndGas CO2;
    public static SbndGas NITROUS_OXIDE;
    public static SbndGas METHANE;

    @Getter
    private String name;
    @Getter
    private String formula;

    static {

        HYDROGEN = new SbndGas(      "Hydrogen",       "H2");
        HELIUM = new SbndGas(        "Helium",         "He");
        NEON = new SbndGas(          "Neon",           "Ne");
        ARGON = new SbndGas(         "Argon",          "Ar");
        KRYPTON = new SbndGas(       "Krypton",        "Kr");
        XENON = new SbndGas(         "Xenon",          "Xe");
        RADON = new SbndGas(         "Radon",          "Rn");
        OGANESSON = new SbndGas(     "Oganesson",      "Og");

        OXYGEN = new SbndGas(        "Oxygen",         "O2");
        NITROGEN = new SbndGas(      "Nitrogen",       "N2");
        AMMONIA = new SbndGas(       "Ammonia",        "NH3");
        IODINE = new SbndGas(        "Iodine",          "I2");
        CO = new SbndGas(            "Carbon Monoxide", "CO");
        CO2 = new SbndGas(           "Carbon Dioxide",  "CO2");
        NITROUS_OXIDE = new SbndGas( "Nitrous Oxide",   "N2O");
        METHANE = new SbndGas(       "Methane",        "CH4");

    }

}
