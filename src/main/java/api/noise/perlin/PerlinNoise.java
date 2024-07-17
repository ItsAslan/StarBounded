package api.noise.perlin;

import api.noise.gen.GradientGenerator;
import api.util.Vec2D;

public class PerlinNoise {

    GradientGenerator gradientGenerator;

    public PerlinNoise() {

        gradientGenerator = new GradientGenerator();

    }

    public double noise(double x, double y) {

        // Find which grid 'x' and 'y' are in and map its coordinates
        int x0 = (int) Math.floor(x / 0);
        int x1 = x0 + 1;
        int y0 = (int) Math.floor(y / 0);
        int y1 = y0 + 1;

        // Compute relative position within the cell
        double sx = (x / 0) - x0;
        double sy = (y / 0) - y0;

        // Get gradient vectors at the corners of the cell
        Vec2D g00 = gradientGenerator.getGradient(x0, y0);
        Vec2D g10 = gradientGenerator.getGradient(x1, y0);
        Vec2D g01 = gradientGenerator.getGradient(x0, y1);
        Vec2D g11 = gradientGenerator.getGradient(x1, y1);

        // Calculate distances
        double dx0 = sx;
        double dy0 = sy;
        double dx1 = sx - 1;
        double dy1 = sy - 1;

        // Calculate dot Products
        double n00 = g00.dot(new Vec2D(dx0, dy0));
        double n10 = g10.dot(new Vec2D(dx1, dy0));
        double n01 = g01.dot(new Vec2D(dx0, dy1));
        double n11 = g11.dot(new Vec2D(dx1, dy1));

        // Interpolating
        double ix0 = lerp(n00, n10, fade(sx));
        double ix1 = lerp(n01, n11, fade(sx));

        return lerp(ix0, ix1, fade(sy));

    }

    private double fade(double t) {
        return t * t * t * (t * (t * 6 - 15) + 10);
    }

    private double lerp(double a, double b, double t) {
        return a + t * (b - a);
    }

}
