package com.sbnd.content.transport.fluid.gas;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ModGasses {

    public static ModGasses HYDROGEN;
    public static ModGasses HELIUM;
    public static ModGasses NEON;
    public static ModGasses ARGON;
    public static ModGasses KRYPTON;
    public static ModGasses XENON;
    public static ModGasses RADON;
    public static ModGasses OGANESSON;

    public static ModGasses OXYGEN;
    public static ModGasses NITROGEN;
    public static ModGasses AMMONIA;
    public static ModGasses IODINE;
    public static ModGasses CO;
    public static ModGasses CO2;
    public static ModGasses NITROUS_OXIDE;
    public static ModGasses METHANE;

    @Getter private String color;
    @Getter private String name;
    @Getter private String formula;

    public static void REGISTER() {



    }

}
