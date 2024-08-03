package api.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Vec2D {

    double x;
    double y;

    //------------------BASIC ARITHMETIC---------------------------

    public Vec2D divide(Vec2D other) {

        return new Vec2D(this.x / other.x, this.y / other.y);

    }

    public Vec2D divide(double scale) {

        return new Vec2D(this.x / scale, this.y / scale);

    }

    public Vec2D multiply(Vec2D other) {

        return new Vec2D(this.x * other.x, this.y * other.y);

    }

    public Vec2D add(Vec2D other) {

        return new Vec2D(this.x + other.x, this.y + other.y);

    }

    public Vec2D subtract(Vec2D other) {

        return new Vec2D(this.x - other.x, this.y - other.y);

    }

    //------------------SPECIALIZED ARITHMETIC---------------------------

    public Vec2D normalize() {

        return this.divide(magnitude());

    }

    public double dot(Vec2D other) {

        return x * other.x + y * other.y;

    }

    public double magnitude() {

        return Math.sqrt(x * x + y * y);

    }

}
