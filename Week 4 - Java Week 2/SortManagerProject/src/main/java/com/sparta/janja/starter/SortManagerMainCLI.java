package com.sparta.janja.starter;

import com.sparta.janja.controller.SortManagerController;

/**
 * @author janjakovacevic on 17/10/2020.
 * @project SortManagerProject
 */

public class SortManagerMainCLI {
    // starts SortManager CLI
    public static void main( String[] args ) {
        SortManagerController.start();
        System.exit(0);
    }
}
