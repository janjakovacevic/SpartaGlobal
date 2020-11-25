package com.sparta.astha.javaBasic;

import java.io.*;

public class TryWithoutClass {
    static String inFileStr = "resources/Sunset.jpg";
    static String outFileStr = "resources/Sunset-out.jpg";

    public void fileProcessNoBuffer() {
        System.out.println("----------Inside fileProcessNoBuffer-------");

        long startTime, totalTime;
        int readByte;
        File file = new File(inFileStr);
        System.out.println("File size::" + file.length());
        FileInputStream in = null;
        FileOutputStream out=null;
        try {
            in = new FileInputStream(inFileStr);

            out= new FileOutputStream(outFileStr);
            startTime = System.nanoTime();
            //byte[] buff=new byte[1024];

            while ((readByte = in.read()) != -1) {
                //readByte=in.read();
                //out.write(buff,0,readByte);
                out.write(readByte);

            }
            totalTime = System.nanoTime() - startTime;
            System.out.println("totalTime taken in ms" + totalTime / 1000000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
