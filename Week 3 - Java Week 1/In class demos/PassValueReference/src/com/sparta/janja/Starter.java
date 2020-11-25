package com.sparta.janja;

public class Starter {
    public static void start(){
        PrimitivePassByValue primitivePassByValue = new PrimitivePassByValue();
        primitivePassByValue.passByValue();
        ObjectReferencePassByValue objectReferencePassByValue = new ObjectReferencePassByValue();
        objectReferencePassByValue.passByValue();
    }
}
