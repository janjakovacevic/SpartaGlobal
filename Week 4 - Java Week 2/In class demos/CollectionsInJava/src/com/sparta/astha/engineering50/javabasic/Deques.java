package com.sparta.astha.engineering50.javabasic;

import java.util.Deque;
import java.util.LinkedList;

public class Deques {

    private Deque<String> deque = new LinkedList<>();

    public Deques() {
        deque.add("one");
        deque.add("two");
        deque.add("three");
        deque.add("four");
        deque.add("five");
        deque.offerFirst("First");
        deque.offerLast("Last");
        deque.offer("Offer");
    }

    public void runDeque() {
        System.out.println("In deque");
        for (String element: deque) {
            System.out.println(element);
        }
        System.out.println("");
        System.out.println(deque.peek());
        System.out.println("first: " + deque.peekFirst());
        System.out.println("Last: " + deque.peekLast());
        System.out.println("");

        /*System.out.println(deque.poll() + " removed");
        System.out.println(deque.pollFirst() + " first removed");
        System.out.println(deque.pollLast() + " last removed" );
        System.out.println("");*/


        deque.addFirst("six");
        for (String element: deque) {
            System.out.println(element);
        }
        deque.remove();
    }
}
