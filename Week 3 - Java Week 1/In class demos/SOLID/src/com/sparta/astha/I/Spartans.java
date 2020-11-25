package com.sparta.astha.I;

import java.util.stream.Stream;

public interface Spartans {
    void getName();
    void getSpartaStream();
    void getGraduationDate();
    void calculatePay();
    void numberOfInterviews();
    void timeSpentInPreassignmentPeriod();
    void timeSpentInBenchPeriod();

}

//Sales, LearningAndDevelopment Team

// can be done through switch as well-Limitation-new constant then new case block needs to be added so constant specific behaviour is better

public String getSymbol(int value) {

        switch (this) {
        case ace:
            return "a";
        case two:
            return "2";
        case three:
            return "3";
        case four:
            return "4";
        case five:
            return "5";
        case six:
            return "6";
        case seven:
            return "7";
        case eight:
            return "8";
        case nine:
            return "9";
        case ten:
            return "10";
        case jack:
            return "j";
        case queen:
            return "q";
        case king:
            return "k";
        }
        return "Please enter the correct Value";
}