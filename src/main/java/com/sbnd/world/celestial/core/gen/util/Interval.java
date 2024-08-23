package com.sbnd.world.celestial.core.gen.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Interval {

    public final int min;
    public final int max;

    public boolean contains(int value) {

        return value >= min && value <= max;

    }

    public boolean overlaps(Interval other) {

        return this.min <= other.max && this.max >= other.min;

    }

    public int length() {

        return max - min;

    }

    public boolean isValid() {

        return min <= max;

    }

    public Interval union(Interval other) {

        return new Interval(Math.min(this.min, other.min), Math.max(this.max, other.max));

    }

    public Interval intersection(Interval other) {

        if (!this.overlaps(other)) {

            return null;

        }

        return new Interval(Math.max(this.min, other.min), Math.min(this.max, other.max));

    }

    public String toString() {

        return "[" + min + ", " + max + "]";

    }

}
