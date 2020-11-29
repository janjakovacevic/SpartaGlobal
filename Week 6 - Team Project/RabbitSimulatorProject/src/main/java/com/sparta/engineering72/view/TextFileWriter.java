package com.sparta.engineering72.view;

import com.sparta.engineering72.utility.ReportPacker;

import java.io.BufferedWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class TextFileWriter {

    static DecimalFormat myFormatter = new DecimalFormat("###,###,###");

    public static void writeReportToFile(BufferedWriter bufferedWriter, ReportPacker reportPacker, int time) throws IOException {
        int years = time/12;
        int months = time % 12;
        bufferedWriter.write("\n\n==============================================================");
        bufferedWriter.write("\n The Simulation ran for " + years + " years and " + months + " months");
        bufferedWriter.write("\n==============================================================");
        bufferedWriter.write("\n == RABBIT POPULATION REPORT == ");
        bufferedWriter.write("\nThe total population of Rabbits: " + myFormatter.format(reportPacker.getTotalRabbits()));
        bufferedWriter.write("\nThe male population of Rabbits: " + myFormatter.format(reportPacker.getMaleRabbits()));
        bufferedWriter.write("\nThe female population of Rabbits: " + myFormatter.format(reportPacker.getFemaleRabbits()));
        bufferedWriter.write("\n--------------------------------------------------------------");
        bufferedWriter.write("\n == FOX POPULATION REPORT == ");
        bufferedWriter.write("\nThe total population of Foxes: " + myFormatter.format(reportPacker.getTotalFoxes()));
        bufferedWriter.write("\nThe male population of Foxes: " + myFormatter.format(reportPacker.getMaleFoxes()));
        bufferedWriter.write("\nThe female population of Foxes: " + myFormatter.format(reportPacker.getFemaleFoxes()));
        bufferedWriter.write("\n--------------------------------------------------------------");
        bufferedWriter.write("\n == DEATH REPORT == ");
        bufferedWriter.write("\nThe total number of Rabbits that died: " + myFormatter.format(reportPacker.getRabbitAgeDeaths()));
        bufferedWriter.write("\nThe total number of Rabbits that were eaten: " + myFormatter.format(reportPacker.getRabbitPreyDeaths()));
        bufferedWriter.write("\nThe total number of Foxes that died: " + myFormatter.format(reportPacker.getFoxDeaths()));
        bufferedWriter.write("\n==============================================================\n");
    }

}
