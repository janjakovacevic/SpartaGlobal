package com.sparta.janja;

import java.util.Random;

public class EnglishTeacher extends Teacher{

    public EnglishTeacher(String name, String subject, int age, boolean currentlyTeaching) {
        super(name, subject, age, currentlyTeaching);
    }

    @Override
    public void favoritePhrase() {
        System.out.println("I had too much to drink last night.");
    }

    @Override
    public char grade() {
        char[] grades = {'A', 'B', 'C', 'D', 'F'};
        Random random = new Random();
        char grade = grades[random.nextInt(5)];
        System.out.println(grade);
        return grade;
    }
}
