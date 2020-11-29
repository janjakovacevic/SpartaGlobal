package com.sparta.engineering72.simulation;
import com.sparta.engineering72.animal.fox.FemaleFox;
import com.sparta.engineering72.animal.fox.FoxSkulk;
import com.sparta.engineering72.animal.fox.MaleFox;
import com.sparta.engineering72.animal.rabbit.FemaleRabbit;
import com.sparta.engineering72.animal.rabbit.MaleRabbit;
import com.sparta.engineering72.animal.rabbit.RabbitFluffle;
import com.sparta.engineering72.log.Logger;
import com.sparta.engineering72.view.Display;
import com.sparta.engineering72.view.JSONHandler;
import com.sparta.engineering72.utility.ReportPacker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class Simulator {
    public static RabbitFluffle rabbitFluffle = new RabbitFluffle();
    public static FoxSkulk foxSkulk = new FoxSkulk();

    public static ReportPacker runSimulation(int time, int reportChoice) {
        ReportPacker reportPackerFinal;

        addInitialRabbitPair();
        addInitialFoxPair();

        Display.displaySimulationStart();

        RabbitLifeCycle rabbitLifeCycle = new RabbitLifeCycle();
        FoxLifeCycle foxLifeCycle = new FoxLifeCycle();

        for (int i = 0; i <= time; i++) {
            foxLifeCycle.naturalDeath();
            rabbitLifeCycle.naturalDeath();
            foxLifeCycle.hunt(i);
            rabbitLifeCycle.breed();
            foxLifeCycle.breed();

            if (i % 12 == 0) {
                foxLifeCycle.getPregnancies();
            }

            rabbitLifeCycle.age();
            foxLifeCycle.age();

            updateRabbitFluffleLists();
            updateFoxSkulkLists();

            ReportPacker reportPackerMonthly = getReportPacker();

            displayMonthlyReport(reportChoice, i, reportPackerMonthly);
        }

        reportPackerFinal = getReportPacker();

        produceFinalReport(time, reportChoice, reportPackerFinal);

        Display.displaySimulationCompleted();

        return reportPackerFinal;
    }

    private static void produceFinalReport(int time, int reportChoice, ReportPacker reportPackerFinal) {
        try(BufferedWriter bufferedWriterTxt = new BufferedWriter(new FileWriter("resources/report.txt"));
            BufferedWriter bufferedWriterJson = new BufferedWriter(new FileWriter("resources/report.json"))) {
            bufferedWriterTxt.write("\nSIMULATION REPORT\n");
            produceReportJSON(reportPackerFinal);
            JSONHandler.writeJSONReport(bufferedWriterJson, JSONHandler.jsonArray);

            if(reportChoice == 1) {
                Display.display(reportPackerFinal, time, bufferedWriterTxt);
            }

        } catch (IOException ioException) {
            Logger.logError(ioException);
        }
    }

    private static void produceReportJSON(ReportPacker reportPackerMonthly) {
        JSONHandler.jsonArray = JSONHandler.populateJSON(reportPackerMonthly);
    }

    private static void updateFoxSkulkLists() {
        FoxSkulk.maleFoxList = FoxLifeCycle.maleFoxes;
        FoxSkulk.femaleFoxList = FoxLifeCycle.femaleFoxes;
    }

    private static void updateRabbitFluffleLists() {
        RabbitFluffle.femaleRabbitList = RabbitLifeCycle.femaleRabbits;
        RabbitFluffle.maleRabbitList = RabbitLifeCycle.maleRabbits;
    }

    private static void displayMonthlyReport(int reportChoice, int i, ReportPacker reportPackerMonthly) {
        try(BufferedWriter bufferedWriterTxt = new BufferedWriter(new FileWriter("resources/report.txt"));
            BufferedWriter bufferedWriterJson = new BufferedWriter(new FileWriter("resources/report.json"))) {

            if(reportChoice == 2) {
                produceReportJSON(reportPackerMonthly);
                JSONHandler.writeJSONReport(bufferedWriterJson, JSONHandler.jsonArray);
                Display.display(reportPackerMonthly, i, bufferedWriterTxt);
            }

        } catch (IOException ioException) {
            Logger.logError(ioException);
        }
    }

    private static void addInitialFoxPair() {
        FoxLifeCycle.maleFoxes.add(new MaleFox());
        FoxLifeCycle.femaleFoxes.add(new FemaleFox());
    }

    private static void addInitialRabbitPair() {
        RabbitLifeCycle.maleRabbits.add(new MaleRabbit());
        RabbitLifeCycle.femaleRabbits.add(new FemaleRabbit());
    }

    private static ReportPacker getReportPacker() {
        return new ReportPacker(rabbitFluffle.getRabbitPopulationSize(),
                rabbitFluffle.getMaleRabbitPopulation(),
                rabbitFluffle.getFemaleRabbitPopulation(),
                foxSkulk.getFoxPopulationSize(),
                foxSkulk.getMaleFoxPopulation(),
                foxSkulk.getFemaleFoxPopulation(),
                RabbitLifeCycle.naturalDeathCount,
                FoxLifeCycle.rabbitsHunted,
                FoxLifeCycle.FoxDeathCount);
    }

    public static ReportPacker resetAllStaticValues(int time, int reportChoice){
        resetRabbitFluffle();
        resetFoxSkulk();
        resetRabbitLifeCycle();
        resetFoxLifeCycle();

        return runSimulation(time, reportChoice);
    }

    private static void resetFoxSkulk() {
        foxSkulk = new FoxSkulk();
    }

    private static void resetRabbitFluffle() {
        rabbitFluffle = new RabbitFluffle();
    }

    private static void resetFoxLifeCycle() {
        FoxLifeCycle.rabbitsHunted = BigInteger.valueOf(0);
        FoxLifeCycle.FoxDeathCount = BigInteger.valueOf(0);
        FoxLifeCycle.foxPregnancies = BigInteger.valueOf(0);
        FoxLifeCycle.maleFoxes = new ArrayList<>();
        FoxLifeCycle.femaleFoxes = new ArrayList<>();
    }

    private static void resetRabbitLifeCycle() {
        RabbitLifeCycle.naturalDeathCount = BigInteger.valueOf(0);
        RabbitLifeCycle.pregnancies = BigInteger.valueOf(0);
        RabbitLifeCycle.maleRabbits = new ArrayList<>();
        RabbitLifeCycle.femaleRabbits = new ArrayList<>();
    }

}