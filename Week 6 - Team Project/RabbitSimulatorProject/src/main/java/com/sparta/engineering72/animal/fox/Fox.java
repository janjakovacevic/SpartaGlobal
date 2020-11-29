package com.sparta.engineering72.animal.fox;

import com.sparta.engineering72.animal.Animal;

public class Fox extends Animal {
    private static int DEATH_AGE = 60;
    private static int MATURITY_AGE = 12;

    public Fox(Gender gender) {
        this.gender = gender;
        this.age = 0;
    }

    @Override
    public boolean isMature() {
        return this.age >= MATURITY_AGE;
    }

    @Override
    public boolean isReadyToDie() {
        return this.age >= DEATH_AGE;
    }

    public static int getDeathAge() {
        return DEATH_AGE;
    }

    public static void setDeathAge(int deathAge) {
        DEATH_AGE = deathAge;
    }

    public static int getMaturityAge() {
        return MATURITY_AGE;
    }

    public static void setMaturityAge(int maturityAge) {
        MATURITY_AGE = maturityAge;
    }
}


