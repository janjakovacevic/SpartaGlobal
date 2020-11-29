package com.sparta.engineering72;

import com.sparta.engineering72.simulation.Simulator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class TotalPopulationTest {
    @Test
    public void TotalPopulationTest5Months()
    {
        Simulator.runSimulation(5, 1);
        BigInteger minimum = BigInteger.valueOf(2);
        BigInteger maximum = BigInteger.valueOf(16);
        BigInteger rabbitSize = Simulator.rabbitFluffle.getRabbitPopulationSize();
        Assertions.assertTrue(rabbitSize.compareTo(minimum) >= 0 && rabbitSize.compareTo(maximum) <= 0);
    }

    @Test
    public void TotalPopulationTest6Months()
    {
        Simulator.runSimulation(6, 1);
        BigInteger minimum = BigInteger.valueOf(2);
        BigInteger rabbitSize = Simulator.rabbitFluffle.getRabbitPopulationSize();
        BigInteger femaleRabbitSize = Simulator.rabbitFluffle.getFemaleRabbitPopulation();
        BigInteger maximum = femaleRabbitSize.multiply(BigInteger.valueOf(14));

        Assertions.assertTrue(rabbitSize.compareTo(minimum) >= 0&& rabbitSize.compareTo(maximum) <= 0);
    }

    @Test
    public void TotalPopulationTest11Months()
    {
        Simulator.runSimulation(11, 1);

        BigInteger minimum = BigInteger.valueOf(2);
        BigInteger rabbitSize = Simulator.rabbitFluffle.getRabbitPopulationSize();
        BigInteger femaleRabbitSize = Simulator.rabbitFluffle.getFemaleRabbitPopulation();
        BigInteger maximum = femaleRabbitSize.multiply(BigInteger.valueOf(14));
        Assertions.assertTrue(rabbitSize.compareTo(minimum) >= 0 && rabbitSize.compareTo(maximum) <= 0);
    }

    @Test
    public void TotalPopulationTest12Months()
    {
        Simulator.runSimulation(12, 1);
        BigInteger minimum = BigInteger.valueOf(2);
        BigInteger femaleRabbitSize = Simulator.rabbitFluffle.getFemaleRabbitPopulation();
        BigInteger maximum = femaleRabbitSize.multiply(BigInteger.valueOf(14));
        BigInteger rabbitSize = Simulator.rabbitFluffle.getRabbitPopulationSize();
        Assertions.assertTrue(rabbitSize.compareTo(minimum) >= 0 && rabbitSize.compareTo(maximum) <= 0);
    }

    @Test
    public void TotalFemalePopulationTest12Months()
    {
        Simulator.runSimulation(12, 1);
        BigInteger totalRabbitPopulation = Simulator.rabbitFluffle.getRabbitPopulationSize();
        BigInteger minimum = (totalRabbitPopulation.divide(BigInteger.valueOf(2)));
        BigInteger maximum = BigInteger.valueOf(0);
        BigInteger rabbitSize = Simulator.rabbitFluffle.getRabbitPopulationSize();
        Assertions.assertTrue(rabbitSize.compareTo(minimum) >= 0 && rabbitSize.compareTo(maximum) <= 0);
    }

    @Test
    public void TotalFoxPopulationTest1Year()
    {
        Simulator.runSimulation(13, 1);
        BigInteger minimum = BigInteger.valueOf(2);
        BigInteger maximum = BigInteger.valueOf(12);
        BigInteger foxSize = Simulator.foxSkulk.getFoxPopulationSize();
        Assertions.assertTrue(foxSize.compareTo(minimum) >= 0 && foxSize.compareTo(maximum) <= 0);
    }
}