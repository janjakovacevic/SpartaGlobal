package com.sparta.engineering72.utility;

import java.math.BigInteger;

public class ReportPacker {

    BigInteger totalRabbits;
    BigInteger maleRabbits;
    BigInteger femaleRabbits;
    BigInteger totalFoxes;
    BigInteger maleFoxes;
    BigInteger femaleFoxes;
    BigInteger rabbitAgeDeaths;
    BigInteger rabbitPreyDeaths;
    BigInteger foxDeaths;

    public ReportPacker(BigInteger totalRabbits, BigInteger maleRabbits, BigInteger femaleRabbits, BigInteger totalFoxes, BigInteger maleFoxes,
                        BigInteger femaleFoxes, BigInteger rabbitAgeDeaths, BigInteger rabbitPreyDeaths, BigInteger foxDeaths) {
        this.totalRabbits = totalRabbits;
        this.femaleRabbits = femaleRabbits;
        this.maleRabbits = maleRabbits;
        this.totalFoxes = totalFoxes;
        this.maleFoxes = maleFoxes;
        this.femaleFoxes = femaleFoxes;
        this.rabbitAgeDeaths = rabbitAgeDeaths;
        this.rabbitPreyDeaths = rabbitPreyDeaths;
        this.foxDeaths = foxDeaths;
    }

    public BigInteger getTotalRabbits() {
        return totalRabbits;
    }
    public BigInteger getFemaleRabbits() {
        return femaleRabbits;
    }
    public BigInteger getMaleRabbits() {
        return maleRabbits;
    }
    public BigInteger getTotalFoxes() {
        return totalFoxes;
    }
    public BigInteger getMaleFoxes() {
        return maleFoxes;
    }
    public BigInteger getFemaleFoxes() {
        return femaleFoxes;
    }
    public BigInteger getRabbitAgeDeaths() {
        return rabbitAgeDeaths;
    }
    public BigInteger getRabbitPreyDeaths() {
        return rabbitPreyDeaths;
    }
    public BigInteger getFoxDeaths() {
        return foxDeaths;
    }
}
