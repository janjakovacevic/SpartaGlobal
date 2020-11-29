package com.sparta.engineering72.animal.rabbit;

import java.math.BigInteger;
import java.util.ArrayList;

public class RabbitFluffle {

    public static ArrayList<FemaleRabbit> femaleRabbitList = new ArrayList<>();
    public static ArrayList<MaleRabbit> maleRabbitList = new ArrayList<>();

    public static ArrayList<FemaleRabbit> getFemaleRabbitList() {
        return femaleRabbitList;
    }

    public static ArrayList<MaleRabbit> getMaleRabbitList() {
        return maleRabbitList;
    }

    public BigInteger getRabbitPopulationSize(){
        return getFemaleRabbitPopulation().add(getMaleRabbitPopulation());
    }

    public BigInteger getFemaleRabbitPopulation(){
        BigInteger femalePopulation = BigInteger.valueOf(0);
        for(FemaleRabbit femaleRabbit : femaleRabbitList){
            femalePopulation = femalePopulation.add(femaleRabbit.getCount());
        }
        return femalePopulation;
    }

    public BigInteger getMaleRabbitPopulation(){
        BigInteger malePopulation = BigInteger.valueOf(0);
        for(MaleRabbit maleRabbit : maleRabbitList){
            malePopulation = malePopulation.add(maleRabbit.getCount());
        }
        return malePopulation;
    }

    public void addFemaleRabbit(FemaleRabbit femaleRabbit) {
        femaleRabbitList.add(femaleRabbit);
    }

    public void addMaleRabbit(MaleRabbit maleRabbit) {
        maleRabbitList.add(maleRabbit);
    }

    public void removeFemaleRabbit(FemaleRabbit femaleRabbit) {
        femaleRabbitList.remove(femaleRabbit);
    }

    public void removeMaleRabbit(MaleRabbit maleRabbit) {
        maleRabbitList.remove(maleRabbit);
    }

}
