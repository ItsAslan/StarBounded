package com.sbnd.world.celestial.core.bodies;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public class StarSystem {

    @Setter
    private double sizeAu;

    @Setter
    @Getter
    private Star star;

    @Setter
    private String name;

}
