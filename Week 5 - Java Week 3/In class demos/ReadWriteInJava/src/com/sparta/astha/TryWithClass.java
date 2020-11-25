package com.sparta.astha;

import java.io.*;

public class TryWithClass {
    static String inputFile="resources/Tulips.jpg";
    static String outputFile="resources/Tulips-out.jpg";
    public static void fileProcessNoBufferUsingTryWith(){

        System.out.println("----------Inside fileProcessNoBufferTryWith-------");

        long startTime, totalTime;
        int readByte;
        File file=new File(inputFile);
        System.out.println("File size::"+file.length());

        try(FileInputStream in=new FileInputStream(inputFile);
            FileOutputStream out=new FileOutputStream(outputFile)){
            startTime=System.nanoTime();
            while((readByte=in.read())!=-1){
                //readByte=in.read();
                out.write(readByte);

            }
            totalTime=System.nanoTime()-startTime;
            Printer.printTime(totalTime);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileProcessBufferUsingTryWith() {
        System.out.println("----------Inside fileProcessBufferTryWith-------");

        long startTime, totalTime;
        int readByte;
        File file=new File(inputFile);
        System.out.println("File size::"+file.length());
       //Decorator pattern-here the BufferedInputStream/BufferedOutputStream is decorating the FileInputStream with a buffer
        try(BufferedInputStream in=new BufferedInputStream(new FileInputStream(inputFile));
            BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(outputFile))){
            startTime=System.nanoTime();
            //byte[] buff=new byte[1000];
            //while((readByte=in.read(buff))!=-1){
            while((readByte=in.read())!=-1){
               // readByte=in.read(buff);
                out.write(readByte);
                //out.write(buff, 0,readByte);

            }
            totalTime=System.nanoTime()-startTime;
            Printer.printTime(totalTime);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
