package com.sparta.engineering72;
import com.sparta.engineering72.animal.fox.FoxSkulk;
import com.sparta.engineering72.animal.rabbit.RabbitFluffle;
import com.sparta.engineering72.simulation.Simulator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class InitialisationTest {
    @Test
    public void RabbitInitialisationTest() {
        Simulator.runSimulation(0, 1);
        Assertions.assertEquals(2, Simulator.rabbitFluffle.getRabbitPopulationSize());
    }

    @Test
    public void initialisationMaleTest() {
        Simulator.runSimulation(0, 1);
        Assertions.assertEquals(1, Simulator.rabbitFluffle.getMaleRabbitPopulation());
    }
    @Test
    public void initialisationFemaleTest() {
        Simulator.runSimulation(0, 1);
        Assertions.assertEquals(1, Simulator.rabbitFluffle.getFemaleRabbitPopulation());
    }

    @Test
    public void initialisationFemaleMaturityTest(){
        Simulator.runSimulation(0, 1);
        Assertions.assertEquals(false, RabbitFluffle.femaleRabbitList.get(0).isMature());
    }
    @Test
    public void initialisationMaleMaturityTest(){
        Simulator.runSimulation(0, 1);
        Assertions.assertEquals(false, RabbitFluffle.maleRabbitList.get(0).isMature());
    }
    @Test
    public void initialisationAgeTest(){
        Simulator.runSimulation(0, 1);
        Assertions.assertEquals(0, RabbitFluffle.maleRabbitList.get(0).getAge());
    }

    //Fox tests
    @Test
    public void FoxInitialisationTest() {
        Simulator.runSimulation(0, 1);
        Assertions.assertEquals(2, Simulator.foxSkulk.getFoxPopulationSize());
    }

    @Test
    public void Fox11MonthsTest() {
        Simulator.runSimulation(11, 1);
        Assertions.assertEquals(2, Simulator.foxSkulk.getFoxPopulationSize());
    }

    @Test
    public void FoxInitialisationMaleTest() {
        Simulator.runSimulation(0, 1);
        Assertions.assertEquals(1, Simulator.foxSkulk.getMaleFoxPopulation());
    }

    @Test
    public void FoxInitialisationFemaleTest() {
        Simulator.runSimulation(0, 1);
        Assertions.assertEquals(1, Simulator.foxSkulk.getFemaleFoxPopulation());
    }

    @Test
    public void FoxInitialisationFemaleMaturityTest(){
        Simulator.runSimulation(0, 1);
        Assertions.assertEquals(false, FoxSkulk.femaleFoxList.get(0).isMature());
    }

    @Test
    public void FoxInitialisationMaleMaturityTest(){
        Simulator.runSimulation(0, 1);
        Assertions.assertEquals(false, FoxSkulk.maleFoxList.get(0).isMature());
    }

    @Test
    public void FoxInitialisationAgeTest(){
        Simulator.runSimulation(0, 1);
        Assertions.assertEquals(0, FoxSkulk.maleFoxList.get(0).getAge());
    }

    @Test
    public void Fox6MonthsAgeTest(){
        Simulator.runSimulation(6, 1);
        Assertions.assertEquals(6, FoxSkulk.maleFoxList.get(0).getAge());
    }
}


