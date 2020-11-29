package com.sparta.engineering72.animal.fox;

import com.sparta.engineering72.animal.Animal;

import java.math.BigInteger;

public class MaleFox extends Fox{
    private BigInteger count;

    public MaleFox() {
        super(Animal.Gender.MALE);
        this.age = 0;
        this.count = BigInteger.valueOf(1);
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }
}