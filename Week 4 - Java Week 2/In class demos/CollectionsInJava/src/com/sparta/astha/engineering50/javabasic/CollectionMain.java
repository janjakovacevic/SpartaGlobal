package com.sparta.astha.engineering50.javabasic;

public class CollectionMain {

    public static void main(String[] args) {
        //runLists();
        //runSets();
        runMaps();
        //runQueues();
        //runDeques();
    }

    public static void runLists() {
        Lists lists = new Lists();
        lists.sortList();
        lists.iterateThroughList();
    }

    public static void runSets() {
        Sets sets = new Sets();
        sets.iterateThroughSet();
    }

    public static void runMaps() {
        Maps maps = new Maps();
        maps.iterateThroughMap();
    }

    public static void runQueues() {
        Queues queues = new Queues();
        queues.runQueue();
    }

    public static void runDeques() {
        Deques deques = new Deques();
        deques.runDeque();
    }
}
