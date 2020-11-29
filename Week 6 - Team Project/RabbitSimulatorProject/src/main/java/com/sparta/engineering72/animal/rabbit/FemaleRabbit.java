package com.sparta.engineering72.animal.rabbit;

import com.sparta.engineering72.animal.Animal;
import com.sparta.engineering72.settings.Settings;
import com.sparta.engineering72.utility.Randomizer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FemaleRabbit extends Rabbit {
    public static double PREGNANCY_CHANCE = 0.5d; //TODO: Setters for user input
    private boolean isPregnant;
    private BigInteger count;

    public FemaleRabbit(){
        super(Animal.Gender.FEMALE);
        this.gender= Animal.Gender.FEMALE;
        age = 0;
        isPregnant = false;
        count = BigInteger.valueOf(1);
    }

    public boolean isPregnant(){
        return isPregnant;
    }

    public void getPregnant(){
        isPregnant = true;
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }

    public static double getPregnancyChance() {
        return PREGNANCY_CHANCE;
    }

    public static void setPregnancyChance(double getPregnantChance) {
        PREGNANCY_CHANCE = getPregnantChance;
    }

    public static List<Animal> breed(BigInteger count) {
        final BigInteger averageOffspringCount = BigInteger.valueOf(7);

        List<Animal> animals = new ArrayList<>();

        MaleRabbit maleRabbit = new MaleRabbit();
        FemaleRabbit femaleRabbit = new FemaleRabbit();

        long[] randomGenders;

        if (count.compareTo(Settings.MAX_COUNT_THRESHOLD) > 0){
            BigInteger totalOffspring = count.multiply(averageOffspringCount);
            maleRabbit.setCount(totalOffspring.divide(BigInteger.valueOf(2)));
            femaleRabbit.setCount(totalOffspring.divide(BigInteger.valueOf(2)));
        } else {
            BigInteger countMaleOffspring = BigInteger.valueOf(0);
            BigInteger countFemaleOffspring = BigInteger.valueOf(0);

            BigInteger totalOffspring = BigInteger.valueOf(0);

            long[] childrenArray = Randomizer.getRandomRabbitOffspring(count.longValue());

            for (long child : childrenArray) {
                totalOffspring = totalOffspring.add(BigInteger.valueOf(child));
            }

            randomGenders = Randomizer.getRandomGender(totalOffspring.longValue());

            for(int j = 0; j < totalOffspring.intValue(); j++) {
                if (randomGenders[j] == 1) {
                    countMaleOffspring = countMaleOffspring.add(BigInteger.ONE);
                } else {
                    countFemaleOffspring = countFemaleOffspring.add(BigInteger.ONE);
                }
            }

            maleRabbit.setCount(countMaleOffspring);
            femaleRabbit.setCount(countFemaleOffspring);
        }
        animals.add(maleRabbit);
        animals.add(femaleRabbit);
        return animals;
    }
}
