package com.sparta.janja;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FizzBuzzGeneratorTester {
    /**
     * 1. creating the test cases
     * 2. go and write my code - write enough code for your test to pass
     * 3. refactor
     */

    @Test
    public void testFizz(){
        Assertions.assertEquals("Fizz", FizzBuzzGenerator.checkFizzBuzz(5));
    }
}
