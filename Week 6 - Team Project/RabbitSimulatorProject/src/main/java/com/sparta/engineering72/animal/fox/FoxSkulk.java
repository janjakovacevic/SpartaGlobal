package com.sparta.engineering72.animal.fox;


import java.math.BigInteger;
import java.util.ArrayList;

public class FoxSkulk {
    public static ArrayList<FemaleFox> femaleFoxList = new ArrayList<>();
    public static ArrayList<MaleFox> maleFoxList = new ArrayList<>();

    public static ArrayList<FemaleFox> getFemaleFoxList() {
        return femaleFoxList;
    }

    public static ArrayList<MaleFox> getMaleFoxList() {
        return maleFoxList;
    }

    public BigInteger getFoxPopulationSize(){
        return getFemaleFoxPopulation().add(getMaleFoxPopulation());
    }

    public BigInteger getFemaleFoxPopulation(){
        BigInteger femalePopulation = BigInteger.valueOf(0);
        for(FemaleFox femaleFox : femaleFoxList){
            femalePopulation = femalePopulation.add(femaleFox.getCount());
        }
        return femalePopulation;
    }

    public BigInteger getMaleFoxPopulation(){
        BigInteger malePopulation = BigInteger.valueOf(0);
        for(MaleFox maleFox : maleFoxList){
            malePopulation = malePopulation.add(maleFox.getCount());
        }
        return malePopulation;
    }

    public void addFemaleFox(FemaleFox femaleFox) {
        femaleFoxList.add(femaleFox);
    }

    public void addMaleFox(MaleFox maleFox) {
        maleFoxList.add(maleFox);
    }

    public void removeFemaleFox(FemaleFox femaleFox) {
        femaleFoxList.remove(femaleFox);
    }

    public void removeMaleFox(MaleFox maleFox) {
        maleFoxList.remove(maleFox);
    }
}
