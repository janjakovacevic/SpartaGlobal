package com.sparta.astha.engineering50.javabasic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Lists {

    private List<String> myList = new CopyOnWriteArrayList<>();
    //private List<String> myList = new ArrayList<>();

    public Lists() {
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.add("four");
        myList.add("five");
    }

    public String getElement(int index) {
        return myList.get(index);
    }

    public void sortList() {
        System.out.println("Lists");
        System.out.println("Unsorted: " + myList);
        Collections.sort(myList);
        System.out.println("Sorted: " + myList);
    }

    public void iterateThroughList() {
        System.out.println("With iterator:");
        Iterator<String> iterator = myList.iterator();
        while (iterator.hasNext())
        //for (Iterator<String> iterator = myList.iterator(); iterator.hasNext();)
        {
            String element = iterator.next();
            if (element.equals("one")) {
                System.out.println("Removing elements");
                myList.remove(element);
                //iterator.remove();
                System.out.println("Element Removed::" + element);
                continue;
            }
            System.out.println(element);
        }
        System.out.println("");
        System.out.println("Using forEach:");

        for (String element : myList) {


            if (element.equals("two")) {
                System.out.println("Removing elements");
                myList.remove(element);
                continue;
            }
            System.out.println(element);
        }
    }
}

