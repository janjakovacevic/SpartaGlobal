package com.sparta.janja;

import java.util.Random;

public class PETeacher extends Teacher{

    public PETeacher(String name, String subject, int age, boolean currentlyTeaching) {
        super(name, subject, age, currentlyTeaching);
    }

    @Override
    public void favoritePhrase() {
        System.out.println("I'm timing your mile today.");
    }

    @Override
    public char grade() {
        return 'A';
    }
}
