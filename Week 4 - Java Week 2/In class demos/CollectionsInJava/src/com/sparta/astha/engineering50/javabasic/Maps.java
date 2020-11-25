package com.sparta.astha.engineering50.javabasic;

import java.util.*;

public class Maps {

    private Map<Integer, String> map = new HashMap<>();

    public Maps() {
        System.out.println("In Maps");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(5, "null");
        map.put(4,"Second four");
        System.out.println(map.size());
    }

    public String getValue(int key) {
        return map.get(key);
    }

    public void iterateThroughMap() {
        System.out.println("Iterating through Map via an iterator");
        Collection<String> values = map.values();
        for (Iterator<String> iterator = values.iterator();iterator.hasNext();) {
            System.out.println(iterator.next());
        }
        System.out.println("Iterating through Map via for each");
        for (String string : values) {
            System.out.println(string);
        }

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        System.out.println("Entry set Implementation of Map");
        for (Map.Entry<Integer, String> entry : entries) {
            //System.out.println(map.get(entry.getKey()) + " " + entry.getValue());
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("Key set Implementation of Map");
        for (Integer key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
