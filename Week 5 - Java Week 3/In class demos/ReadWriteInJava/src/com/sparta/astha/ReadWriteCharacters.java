package com.sparta.astha;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadWriteCharacters {

    static String inputFile="resources/astha";
    static String outputFile="resources/astha-out";

    public static void read(){
        List<String> data=new ArrayList<>();

            try(BufferedReader bufferedReader=new BufferedReader(new InputStreamReader((new FileInputStream(inputFile))));
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter((new FileOutputStream(outputFile))))){
                String line;
                long startTime, totalTime;
                int count=0;
                startTime=System.nanoTime();
                while((line=bufferedReader.readLine())!=null){
                    //line=bufferedReader.readLine();
                    data.add(line);
                    bufferedWriter.write(line);
                    count++;
                }
                totalTime=System.nanoTime()-startTime;
                Printer.printTime(totalTime);
//                for (String element : data) {
//                    System.out.println(element);
//                }
        } catch(FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(){
        List<String> data=new ArrayList<>();

        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(inputFile));
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(outputFile))){
            String line;
            long startTime, totalTime;
            //int count=0;
            startTime=System.nanoTime();
            while((line=bufferedReader.readLine())!=null){
                //line=bufferedReader.readLine();
                data.add(line);
                bufferedWriter.write(line);
                //count++;
            }
            totalTime=System.nanoTime()-startTime;
            Printer.printTime(totalTime);
//                for (String element : data) {
//                    System.out.println(element);
//                }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
