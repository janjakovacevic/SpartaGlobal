package com.sparta.engineering72;

import com.sparta.engineering72.simulation.FoxLifeCycle;
import com.sparta.engineering72.simulation.RabbitLifeCycle;
import com.sparta.engineering72.simulation.Simulator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class DeathTest{
    @Test
    public void deathTestBefore1Year() {
        Simulator.runSimulation(11,1);
        Assertions.assertEquals(true, FoxLifeCycle.rabbitsHunted.equals(BigInteger.valueOf(0)));
    }
    @Test
    public void deathTestAfter1Year() {
        Simulator.runSimulation(13, 1);
        BigInteger ra = BigInteger.valueOf(22);
        Assertions.assertEquals(true,FoxLifeCycle.rabbitsHunted.compareTo(BigInteger.valueOf(20)) < 0);
    }

    @Test
    public void NaturalRabbitDeathsTest() {
        Simulator.runSimulation(61, 1);
        Assertions.assertEquals(true, RabbitLifeCycle.naturalDeathCount.compareTo(BigInteger.valueOf(2)) >= 0);
    }

    @Test
    public void FoxLivesBeforeFiveYears() {
        Simulator.runSimulation(59, 1);
        Assertions.assertEquals(true, FoxLifeCycle.FoxDeathCount.compareTo(BigInteger.valueOf(0))==0);
    }
    @Test
    public void FoxDiesAfterFiveYears() {
        Simulator.runSimulation(61, 1);
        Assertions.assertEquals(true, FoxLifeCycle.FoxDeathCount.compareTo(BigInteger.valueOf(2)) == 0);
    }

}
