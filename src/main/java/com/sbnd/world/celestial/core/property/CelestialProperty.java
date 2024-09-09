package com.sbnd.world.celestial.core.property;

import com.sbnd.world.celestial.core.property.prop.Property_Atmosphere;

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


    // Referencing subclass `PROPERTY_%` from superclass
    // `CelestialProperty` initializer might lead to class loading deadlock.
    // Using `synchronized` fixes this issue. However, since an error is yet
    // to occur, I will keep the code cleaner and easier to read.

    static {

        registerProperty("atmosphere", Property_Atmosphere.class);

    }

    public static void registerProperty(String name, Class<? extends CelestialProperty> c) {

        propertyList.add(c);
        propertyMap.put(name, c);

    }

}
