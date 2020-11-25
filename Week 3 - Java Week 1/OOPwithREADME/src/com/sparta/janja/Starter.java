package com.sparta.janja;

public class Starter {

    public static void start() {
        ChemistryTeacher chemistryTeacher = new ChemistryTeacher("David", "chemistry", 45, true);
        EnglishTeacher englishTeacher = new EnglishTeacher("Mark", "english", 29, true);
        PETeacher peTeacher = new PETeacher("Dayna", "physical education", 27, false);

        Printer.printName(chemistryTeacher.getName());
        Printer.printAge(englishTeacher.getAge());
        Printer.printName(peTeacher.getName());
    }


}
