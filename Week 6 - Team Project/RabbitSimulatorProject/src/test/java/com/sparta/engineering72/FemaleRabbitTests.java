package com.sparta.engineering72;

import com.sparta.engineering72.animal.rabbit.RabbitFluffle;
import com.sparta.engineering72.simulation.RabbitLifeCycle;
import com.sparta.engineering72.simulation.Simulator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FemaleRabbitTests {
    @Test
    public void FemaleMatureAt3MonthsTest(){
        Simulator.runSimulation(3, 1);
        Assertions.assertEquals(true, RabbitFluffle.getFemaleRabbitList().get(0).isMature());
    }

    @Test
    public void FemalePregnantTest(){
        Simulator.runSimulation(4, 1);
        Assertions.assertEquals(true, RabbitFluffle.getFemaleRabbitList().get(0).isPregnant());
    }

    @DisplayName("1 Male 1 Female Test")
    @Test
    public void OneMaleOneFemaleTest()
    {
        RabbitFluffle rabbitFluffle = new RabbitFluffle();
        Simulator.runSimulation(21,1);
        Assertions.assertEquals(true , rabbitFluffle.getMaleRabbitPopulation().compareTo(RabbitLifeCycle.pregnancies) >= 0);
    }
}