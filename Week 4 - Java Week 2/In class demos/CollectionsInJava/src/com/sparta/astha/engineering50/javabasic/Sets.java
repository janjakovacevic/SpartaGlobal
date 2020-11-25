package com.sparta.astha.engineering50.javabasic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Sets {

    private Set<String> mySet = new HashSet<>();

    public Sets()
    {
        mySet.add("one");
        mySet.add("two");
        mySet.add("three");
        mySet.add("four");
        mySet.add("five");
        mySet.add("five");
    }

    public void iterateThroughSet()
    {
        System.out.println("Size of the set::"+mySet.size());
        System.out.println("");
        System.out.println("Sets");
        System.out.println("With iterator:");

        for (Iterator<String> iterator = mySet.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }

        System.out.println("");
        System.out.println("Using forEach:");

        for (String element : mySet) {
            System.out.println(element);
        }
    }
}
