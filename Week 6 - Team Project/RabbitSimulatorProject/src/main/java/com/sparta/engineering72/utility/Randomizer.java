package com.sparta.engineering72.utility;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    public static long[] getRandomGender(long count) {
        return ThreadLocalRandom.current().longs(count, 0, 2).toArray();
    }

    public static int getPregnancyChance(double pregnancyChance) {
        return ThreadLocalRandom.current().nextInt((int) (1 / pregnancyChance))+1;
    }

    public static int getRandomRabbitOffspring() {
        return ThreadLocalRandom.current().nextInt(14)+1;
    }

    public static long[] getRandomFoxOffspring(long pregnancies) {
        return ThreadLocalRandom.current().longs(pregnancies, 1, 11).toArray();
    }

    public static int getRandomHunt() {
        return ThreadLocalRandom.current().nextInt(20)+1;
    }
    public static long getRandomId(long idRange) {
        return ThreadLocalRandom.current().nextLong(idRange);
    }

    public static long[] getRandomRabbitOffspring(long pregnancies) {
        return ThreadLocalRandom.current().longs(pregnancies, 1, 15).toArray();
    }
}