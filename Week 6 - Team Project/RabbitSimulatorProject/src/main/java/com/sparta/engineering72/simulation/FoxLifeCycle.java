package com.sparta.engineering72.simulation;

import com.sparta.engineering72.animal.Animal;
import com.sparta.engineering72.animal.fox.FemaleFox;
import com.sparta.engineering72.animal.fox.FoxSkulk;
import com.sparta.engineering72.animal.fox.MaleFox;
import com.sparta.engineering72.animal.rabbit.FemaleRabbit;
import com.sparta.engineering72.animal.rabbit.MaleRabbit;
import com.sparta.engineering72.animal.rabbit.RabbitFluffle;
import com.sparta.engineering72.settings.Settings;
import com.sparta.engineering72.utility.Randomizer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FoxLifeCycle implements LifeCycle {

    static ArrayList<FemaleFox> femaleFoxes = FoxSkulk.getFemaleFoxList();
    static ArrayList<MaleFox> maleFoxes = FoxSkulk.getMaleFoxList();
    public static BigInteger foxPregnancies = BigInteger.valueOf(0);
    public static BigInteger FoxDeathCount = BigInteger.valueOf(0);
    public static BigInteger rabbitsHunted = BigInteger.valueOf(0);

    @Override
    public void naturalDeath() {
        Iterator<MaleFox> maleFoxIterator = maleFoxes.iterator();
        while (maleFoxIterator.hasNext()) {
            MaleFox fox = maleFoxIterator.next();
            if (fox.isReadyToDie()) {
                FoxDeathCount = FoxDeathCount.add(fox.getCount());
                maleFoxIterator.remove();
            }
        }

        Iterator<FemaleFox> femaleFoxIterator = femaleFoxes.iterator();

        while(femaleFoxIterator.hasNext()) {
            FemaleFox fox = femaleFoxIterator.next();
            if (fox.isReadyToDie()){
                FoxDeathCount = FoxDeathCount.add(fox.getCount());
                femaleFoxIterator.remove();
            }
        }
    }

    @Override
    public void breed() {
        if (foxPregnancies.compareTo(BigInteger.valueOf(0)) > 0) {
            List<Animal> animals = FemaleFox.breedFoxes(foxPregnancies);
            for (Animal animal : animals) {
                if (animal.getGender() == Animal.Gender.MALE) {
                    maleFoxes.add((MaleFox) animal);
                } else {
                    femaleFoxes.add((FemaleFox) animal);
                }
            }
            foxPregnancies = BigInteger.valueOf(0);
        }
    }

    public void getPregnancies() {
        BigInteger maleFoxCount = BigInteger.valueOf(0);
        for (MaleFox fox : maleFoxes) {
            if (fox.isMature()) {
                maleFoxCount = maleFoxCount.add(fox.getCount());
            }
        }
        BigInteger femaleFoxCount = BigInteger.valueOf(0);
        for (FemaleFox fox : femaleFoxes) {
            if (fox.isMature()) {
                femaleFoxCount = femaleFoxCount.add(fox.getCount());
            }
        }
        BigInteger potentialPregnancies = maleFoxCount.min(femaleFoxCount);
        BigInteger totalPregnancies = BigInteger.valueOf(0);
        if (FemaleFox.getPregnancyChance() == 1.0d) {
            totalPregnancies = potentialPregnancies;
        } else if (potentialPregnancies.compareTo(Settings.MAX_COUNT_THRESHOLD) > 0) {
            int pregnancyChance = (int) (1/FemaleFox.getPregnancyChance());
            totalPregnancies = potentialPregnancies.divide(BigInteger.valueOf(pregnancyChance));
        } else {
            int potentialPregnanciesInt = potentialPregnancies.intValue();
            for (int i = 0; i < potentialPregnanciesInt; i++) {
                if (Randomizer.getPregnancyChance(FemaleFox.getPregnancyChance()) == 1) {
                    totalPregnancies = totalPregnancies.add(BigInteger.valueOf(1));
                }
            }
        }
        foxPregnancies = totalPregnancies;
    }

    public void hunt(int time) {
        RabbitFluffle fluffle = new RabbitFluffle();
        FoxSkulk skulk = new FoxSkulk();
        BigInteger foxPopulation = skulk.getFoxPopulationSize();
        if (time < 60) {
            foxPopulation = foxPopulation.subtract(BigInteger.valueOf(2));
        }
        BigInteger rabbitsEaten = BigInteger.valueOf(0);
        BigInteger rabbitPopulation = fluffle.getRabbitPopulationSize();
        if (foxPopulation.compareTo(Settings.MAX_COUNT_THRESHOLD) > 0) {
            rabbitsEaten = foxPopulation.multiply(BigInteger.valueOf(11));
        } else {
            int foxPopulationInt = foxPopulation.intValue();
            for (int i = 0; i < foxPopulationInt; i++) {
                rabbitsEaten = rabbitsEaten.add(BigInteger.valueOf(Randomizer.getRandomHunt()));
            }
        }
        BigInteger rabbitsToHunt = rabbitsEaten.min(rabbitPopulation);
        rabbitsHunted = rabbitsHunted.add(rabbitsEaten.min(rabbitPopulation));
        ArrayList<MaleRabbit> maleRabbits = RabbitFluffle.getMaleRabbitList();
        ArrayList<FemaleRabbit> femaleRabbits = RabbitFluffle.getFemaleRabbitList();
        long idRange = maleRabbits.size() + femaleRabbits.size();
        while (rabbitsToHunt.compareTo(BigInteger.valueOf(0)) > 0) {
            long id = Randomizer.getRandomId(idRange);
            if (id > maleRabbits.size() - 1) {
                FemaleRabbit femaleRabbit = femaleRabbits.get((int) id - maleRabbits.size());
                BigInteger count = femaleRabbit.getCount();
                if (count.compareTo(rabbitsToHunt) > 0) {
                    count = count.subtract(rabbitsToHunt);
                    if (count.intValue() == 0) {
                        femaleRabbits.remove((int) id - maleRabbits.size());
                    }
                    idRange--;
                    rabbitsToHunt = BigInteger.valueOf(0);
                } else {
                    rabbitsToHunt = rabbitsToHunt.subtract(count);
                    femaleRabbits.remove((int) id - maleRabbits.size());
                    idRange--;
                }
            } else {
                MaleRabbit maleRabbit = maleRabbits.get((int) id);
                BigInteger count = maleRabbit.getCount();
                if (count.compareTo(rabbitsToHunt) > 0) {
                    count = count.subtract(rabbitsToHunt);
                    if (count.intValue() == 0) {
                        maleRabbits.remove((int) id);
                    }
                    idRange--;
                    rabbitsToHunt = BigInteger.valueOf(0);
                } else {
                    rabbitsToHunt = rabbitsToHunt.subtract(count);
                    maleRabbits.remove((int) id);
                    idRange--;
                }
            }
        }
    }

    @Override
    public void age() {
        for (MaleFox fox: maleFoxes) {
            fox.incrementAge();
        }
        for (FemaleFox fox: femaleFoxes) {
            fox.incrementAge();
        }
    }
}