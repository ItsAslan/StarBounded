package com.sbnd.world.tmp.core.gen.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Color4 {

    private float red;
    private float green;
    private float blue;
    private float alpha;

    public Color4() {

        this(0,0,0,0);

    }

    public Color4 blend(Color4 other, float ratio) {

        float inverseRatio = 1.0f - ratio;

        return new Color4(

                this.red * inverseRatio + other.red * ratio,
                this.green * inverseRatio + other.green * ratio,
                this.blue * inverseRatio + other.blue * ratio,
                this.alpha * inverseRatio + other.alpha * ratio

        );

    }

}
