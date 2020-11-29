package com.sparta.engineering72.sakilaproject;

import com.sparta.engineering72.sakilaproject.controller.MainController;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SakilaProjectApplicationTests {

    @Test
    public void MainController1() {
        MainController mainController = new MainController();
        String result = mainController.home();
        assertEquals(result, "home");
    }

    @Test
    public void MainController2() {
        MainController mainController = new MainController();
        String result = mainController.account();
        assertEquals(result, "account");
    }

    @Test
    public void MainController3() {
        MainController mainController = new MainController();
        String result = mainController.login();
        assertEquals(result, "login");
    }

}
