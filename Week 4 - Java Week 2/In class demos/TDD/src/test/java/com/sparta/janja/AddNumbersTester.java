package com.sparta.janja;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import org.junit.jupiter.api.DisplayName;

public class AddNumbersTester {
//    @BeforeAll
//    static Calculate{
//        static void setup(){
//
//        }
//    }

    @Test
    @DisplayName("Testing the result when 2 numbers are added")
    public void addNumbersTest(){
        Assertions.assertEquals(7, Calculate.addTwoNumbers(4,3));
    }
}

/** TDD
 * 1. create a test case based on just the requirement and test
 * 2. you write the code and test
 * 3. refactor the code
 */
