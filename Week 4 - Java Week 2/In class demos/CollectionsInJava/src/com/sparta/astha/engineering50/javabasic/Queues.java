package com.sparta.astha.engineering50.javabasic;

import java.util.LinkedList;
import java.util.Queue;

public class Queues {

    private Queue<String> queue = new LinkedList<>();

    public Queues() {
        queue.add("one");
        queue.add("two");
        queue.add("three");
        queue.add("four");
        queue.add("five");
    }

    public void runQueue() {
        System.out.println("In queue");
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.add("six"));

        System.out.println("Iterating through the queue");
        for (String element: queue) {
            System.out.println(element);
        }
        queue.remove();
    }
}
