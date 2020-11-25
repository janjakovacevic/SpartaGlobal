package com.sparta.astha.javaBasic;

import java.io.*;

public class TryWithClass {
    static String inFileStr="resources/Tulips.jpg";
    static String outFileStr="resources/Tulips-out.jpg";
    public void fileProcessNoBufferUsingTryWith(){

        System.out.println("----------Inside fileProcessNoBufferTryWith-------");

        long startTime, totalTime;
        int readByte;
        File file=new File(inFileStr);
        System.out.println("File size::"+file.length());

        try(FileInputStream in=new FileInputStream(inFileStr);
            FileOutputStream out=new FileOutputStream(outFileStr)){
            startTime=System.nanoTime();
            while((readByte=in.read())!=-1){
                //readByte=in.read();
                out.write(readByte);

            }
            totalTime=System.nanoTime()-startTime;
            System.out.println("totalTime taken in ms"+totalTime/1000000);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
