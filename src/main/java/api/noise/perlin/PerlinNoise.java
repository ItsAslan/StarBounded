package api.noise.perlin;

import java.util.Random;

public class PerlinNoise {

    private static final int PERMUTATION[] = new int[512];

    public PerlinNoise(long seed) {

        final Random rand = new Random(seed);

        for(int i = 0; i < 512; i++) {

            PERMUTATION[i] = i;

        }

        for(int i = 0; i < 256; i++) {

            final int j = rand.nextInt(256);

            PERMUTATION[i] = PERMUTATION[i] ^ PERMUTATION[j];
            PERMUTATION[j] = PERMUTATION[i] ^ PERMUTATION[j];
            PERMUTATION[i] = PERMUTATION[i] ^ PERMUTATION[j];

        }

        for (int i = 0; i < 256; i++) {

            PERMUTATION[i + 256] = PERMUTATION[i];

        }

    }

    private int hash(int x, int y) {

        return PERMUTATION[PERMUTATION[x] + y];

    }

    private double fade(double t) {

        return t * t * t * (t * (6 * t - 15) + 10);

    }

    private double lerp(double t, double a, double b) {

        return a + t * (b - a);

    }

    private double grad(int hash, double x, double y) {

        int h = hash & 15;
        double u = h < 8 ? x : y;
        double v = h < 4 ? y : h == 12 || h == 14 ? x : 0;
        return ((h & 1) == 0 ? u : -u) + ((h & 2) == 0 ? v : -v);

    }

    public double noise(double x, double y) {

        int X = (int) Math.floor(x) & 255;
        int Y = (int) Math.floor(y) & 255;

        x -= Math.floor(x);
        y -= Math.floor(y);

        double u = fade(x);
        double v = fade(y);

        int aa = hash(X, Y);
        int ab = hash(X, Y + 1);
        int ba = hash(X + 1, Y);
        int bb = hash(X + 1, Y + 1);

        double gradAA = grad(aa, x, y);
        double gradBA = grad(ba, x - 1, y);
        double gradAB = grad(ab, x, y - 1);
        double gradBB = grad(bb, x - 1, y - 1);

        double lerpX1 = lerp(u, gradAA, gradBA);
        double lerpX2 = lerp(u, gradAB, gradBB);

        return lerp(v, lerpX1, lerpX2);

    }

}
