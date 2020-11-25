package com.sparta.astha.javaBasic;

import java.io.*;
import java.net.URL;

public class CheckedException {

    public void runChecked()  {
        Printer.print("Enter A number::");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int s= 0;


        try {
            s = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(s);
        //URL fileURL = this.getClass().getResource("astha1.txt");
        //File file = new File(fileURL.getPath());

        File file=null;


        try {
             file = new File("astha1.txt");
            FileInputStream stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }
}
