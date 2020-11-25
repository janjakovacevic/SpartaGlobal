package org.sparta.astha;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;

// Now because of this implementation the webDriver would be called once
// We will just have one browser window now rather than multiple ones which resulted in test fail


public class DriverFactory {

    private static WebDriver webDriver;

    private DriverFactory(){
        //prevent instantiation
    }

    public static WebDriver getChromeDriver(){
        if (webDriver==null){
          webDriver=new ChromeDriver();
        }
        return webDriver;
    }
}
