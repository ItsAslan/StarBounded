package com.sbnd.world.tmp.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CelestialProperty {

    // Most planets will have properties assigned to them. These properties
    // will determine how the player reacts to the body, how rockets react
    // to the body, and how life reacts to the body.

    // `CelestialProperty` also give some extra information about the body such as
    //
    // GREENHOUSE_EFFECT
    // ACID_RAIN
    // etc...

    // More common properties such as
    //
    // HOT
    // COLD
    // FREEZING
    // WATER
    //
    // are also determined by the `CelestialProperty`

    public static final List<Class<? extends CelestialProperty>> propertyList = new ArrayList<>();
    public static final Map<String, Class<? extends CelestialProperty>> propertyMap = new HashMap<>();

    public static class PROPERTY_COLD extends CelestialProperty { }
    public static class PROPERTY_HOT extends CelestialProperty { }
    public static class PROPERTY_FREEZING extends CelestialProperty { }
    public static class PROPERTY_BREATHABLE extends CelestialProperty { }
    public static class PROPERTY_PATHOGENIC extends CelestialProperty { }
    public static class PROPERTY_WATER extends CelestialProperty { }
    public static class PROPERTY_GREENHOUSE extends CelestialProperty { }

    public static PROPERTY_COLD COLD = new PROPERTY_COLD();
    public static PROPERTY_HOT HOT = new PROPERTY_HOT();
    public static PROPERTY_FREEZING FREEZING = new PROPERTY_FREEZING();
    public static PROPERTY_BREATHABLE BREATHABLE = new PROPERTY_BREATHABLE();
    public static PROPERTY_PATHOGENIC PATHOGENIC = new PROPERTY_PATHOGENIC();
    public static PROPERTY_WATER WATER = new PROPERTY_WATER();
    public static PROPERTY_GREENHOUSE GREENHOUSE = new PROPERTY_GREENHOUSE();

    // Referencing subclass `PROPERTY_%` from superclass
    // `CelestialProperty` initializer might lead to class loading deadlock.
    // Using `synchronized` fixes this issue. However, since an error is yet
    // to occur, I will keep the code cleaner and easier to read.

    static {

        registerProperty("cold", PROPERTY_COLD.class);
        registerProperty("hot", PROPERTY_HOT.class);
        registerProperty("freezing", PROPERTY_FREEZING.class);
        registerProperty("breathable", PROPERTY_BREATHABLE.class);
        registerProperty("pathogenic", PROPERTY_PATHOGENIC.class);
        registerProperty("water", PROPERTY_WATER.class);
        registerProperty("greenhouse", PROPERTY_GREENHOUSE.class);

    }

    public static void registerProperty(String name, Class<? extends CelestialProperty> c) {

        propertyList.add(c);
        propertyMap.put(name, c);

    }

}
