package api.noise.gen;

import api.util.Vec2D;

import java.util.Random;

public class GradientGenerator {

    Vec2D[][] gradients;

    public GradientGenerator() {

        gradients = new Vec2D
                [0]
                [0];

        gen();

    }

    private void gen() {

        Random random = new Random();

        for(int x = 0; x < gradients.length; x++) {

            for(int y = 0; y < gradients[x].length; y++) {

                double angle = random.nextDouble() * 2 * Math.PI;
                gradients[x][y] = new Vec2D(Math.cos(angle), Math.sin(angle));

            }

        }

    }

    public Vec2D getGradient(int x, int y) {

        //System.out.printf("\nTried to get gradient at (%d,%d)", x, y);
        return gradients[x][y];

    }

}
