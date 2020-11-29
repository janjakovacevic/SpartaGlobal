package com.sparta.engineering72;

import com.sparta.engineering72.input.InputCollector;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class InputCollectorTester {

    @Test
    public void getReportChoiceTestInvalidUpperBound(){
        ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
        System.setIn(in);
        InputCollector.getReportChoice();
    }
    @Test
    public void getReportChoiceTestInvalidLowerBound(){
        ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
        System.setIn(in);
        InputCollector.getReportChoice();
    }
    @Test
    public void getReportChoiceTestValidOne(){
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        InputCollector.getReportChoice();
    }
    @Test
    public void getReportChoiceTestValidTwo(){
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        InputCollector.getReportChoice();
    }
}
