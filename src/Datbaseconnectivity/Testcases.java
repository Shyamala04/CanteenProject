package Datbaseconnectivity;

import org.testng.annotations.Test;

public class Testcases {

    @Test
    void setup(){

        System.out.println("I am inside setup");
    }

    @Test
    void testSteps(){

        System.out.println("I am inside teststeps");
    }

    @Test
    void tearDown(){

        System.out.println("I am inside tearDown");
    }
}
