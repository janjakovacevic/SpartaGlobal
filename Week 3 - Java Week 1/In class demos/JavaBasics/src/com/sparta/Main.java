package com.sparta;

public class Main {

    public static void main(String[] args) {
	// write your code here

        LoopsInJava loop = new LoopsInJava();
//        loop.forLoop();
//        loop.whileLoop();
//        loop.doWhile();
//        loop.forEach();

        loop.swap(4,7);
        System.out.println("Sum of odd number from 1 to n inclusive: " + loop.sumOdd(7));
        System.out.println("Sum of even number from 1 to n inclusive: " + loop.sumEven(8));
        System.out.println("Fibonacci sequence, non-recursive solution: " + loop.fib(7));
        System.out.println("Fibonacci sequence, recursive solution: " + loop.fibRecurssive(7));

    }
}
