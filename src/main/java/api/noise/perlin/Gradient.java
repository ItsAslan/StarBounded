package api.noise.perlin;

import api.noise.NoiseModule;

import java.util.Random;

public class Gradient extends NoiseModule {

    private final PerlinNoise noise;

    private final float offsetX;
    private final float offsetY;

    private final int octaves;
    private final float persistence;

    public Gradient(long seed, int octaves, float persistence) {

        this.octaves = octaves;
        this.persistence = persistence;

        Random random = new Random(seed);

        this.offsetX = random.nextFloat() / 2 + 0.1f;
        this.offsetY = random.nextFloat() / 2 + 0.1f;

        this.noise = new PerlinNoise(seed);

    }


    @Override
    public float getNoise(float i) {

        i *= frequencyX;

        float ret = 0;
        float noiseAmplitude = amplitude;

        for (int j = 0; j < octaves; j++) {

            ret += (float) (noise.noise(i + offsetX, offsetY) * noiseAmplitude);
            i *= 2;
            noiseAmplitude *= persistence;

        }

        return ret;

    }

    @Override
    public float getNoise(float i, float j)
    {
        if (octaves == 1) {

            return (float) (noise.noise(i * frequencyX + offsetX, j * frequencyY + offsetY) * amplitude);

        }

        i *= frequencyX;
        j *= frequencyY;

        float ret = 0;
        float noiseAmplitude = amplitude;

        for (int k = 0; k < octaves; k++) {

            ret += (float) (noise.noise(i + offsetX, j + offsetY) * noiseAmplitude);

            i *= 2;
            j *= 2;

            noiseAmplitude *= persistence;

        }

        return ret;

    }

}
