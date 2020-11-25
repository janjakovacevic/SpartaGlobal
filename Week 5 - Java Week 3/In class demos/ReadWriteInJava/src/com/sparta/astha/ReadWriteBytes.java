package com.sparta.astha;

import java.io.*;

public class ReadWriteBytes {
    static String inFileStr="resources/Sunset.jpg";
    static String outFileStr="resources/Sunset-out.jpg";

    public void fileProcessNoBuffer(){
        Printer.printMessage("----------Inside fileProcessNoBuffer-------");

        long startTime, totalTime;
        int readByte;
//        File file=new File(inFileStr);
//        System.out.println("File size::"+file.length());
        FileInputStream in=null;
        FileOutputStream out=null;
        try{
            in=new FileInputStream(inFileStr);

            out=new FileOutputStream(outFileStr);
            startTime=System.nanoTime();
            //byte[] buff=new byte[1024];

            while((readByte=in.read())!=-1){
                //readByte=in.read();
                //out.write(buff,0,readByte);
                out.write(readByte);

            }
            totalTime=System.nanoTime()-startTime;
            Printer.printTime(totalTime);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (out != null) {

                    out.close();
                }

                }  catch (IOException e) {
            e.printStackTrace();
        }
        }
        }




    public void fileProcessWithBuffer(){

    }
}
