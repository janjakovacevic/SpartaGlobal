package com.sparta.astha;

import com.sparta.astha.D.AnotherChangedShapeManager;
import com.sparta.astha.D.PrintShapesArea;
import com.sparta.astha.L.Square;
import com.sparta.astha.O.Printer;
import com.sparta.astha.O.Rectangle;
import com.sparta.astha.S.Spartan;
import com.sparta.astha.S.SpartanPrinter;

public class Main {

    public static void main(String[] args) {
	// write your code here
 Spartan spartan=new Spartan("Svilen", "Java Dev");



 SpartanPrinter.printSpartan(spartan);

        Printer.printArea();

        PrintShapesArea.printArea();


        AnotherChangedShapeManager anotherChangedShapeManager=new AnotherChangedShapeManager(new Rectangle(3,4));
        anotherChangedShapeManager.getArea();
    }
}
