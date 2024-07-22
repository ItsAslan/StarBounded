package com.sbnd.world.celestial.core.enums;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum EnumCrater {

    SMALL(8, 12, 14),
    MEDIUM(13, 17, 8),
    LARGE(18, 25, 2),
    EXTREME(26, 30, 1);

    public final int MIN;
    public final int MAX;
    private final int PROBABILITY;

    public static final EnumCrater[] sizeArray;

    static {

        sizeArray = initializeSizeArray();

    }

    private static EnumCrater[] initializeSizeArray() {

        int totalProbability = Arrays.stream(EnumCrater.values())
                .mapToInt(e -> e.PROBABILITY)
                .sum();

        EnumCrater[] array = new EnumCrater[totalProbability];
        int i = 0;

        for (EnumCrater size : EnumCrater.values()) {

            Arrays.fill(array, i, i + size.PROBABILITY, size);
            i += size.PROBABILITY;

        }

        return array;

    }

}
