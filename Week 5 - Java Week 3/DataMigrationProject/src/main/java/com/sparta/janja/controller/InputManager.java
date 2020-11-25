package com.sparta.janja.controller;

import java.util.Scanner;

/**
 * @author janjakovacevic
 * @project DataMigrationProject
 */

public class InputManager {
    static Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        return scanner.nextInt();
    }

    public static String getString() {
        return scanner.nextLine();
    }
}
