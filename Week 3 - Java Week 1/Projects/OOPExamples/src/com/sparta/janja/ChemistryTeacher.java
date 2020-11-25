package com.sparta.janja;

import java.util.Random;

public class ChemistryTeacher extends Teacher{

    public ChemistryTeacher(String name, String subject, int age, boolean currentlyTeaching) {
        super(name, subject, age, currentlyTeaching);
    }

    @Override
    public void favoritePhrase() {
        System.out.println("Turn to page 394!");
    }

    @Override
    public char grade() {
        return 'F';
    }
}
