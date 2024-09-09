package com.sbnd.world.celestial.core.bodies;

import lombok.Getter;

public class StarSystem {

    @Getter private double sizeAu;

    @Getter private Star star;
    @Getter private String name;

    public StarSystem setSizeAu(double _sizeAu) {

        sizeAu = _sizeAu;

        return this;

    }

    public StarSystem setStar(Star _star) {

        star = _star;

        return this;

    }

    public StarSystem setName(String _name) {

        name = _name;

        return this;

    }

}
