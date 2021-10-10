package com.training.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class AfterEachTests {

	@DisplayName("Add operation test")
    @RepeatedTest(5)
    void addNumber(TestInfo testInfo, RepetitionInfo repetitionInfo) 
    {
        System.out.println("Running test -> " + repetitionInfo.getCurrentRepetition());
        Calculator calculator = new Calculator();
        Assertions.assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
    }
     
    @AfterAll
    public static void cleanUp(){
        System.out.println("After All cleanUp() method called");
    }
     
    @AfterEach
    public void cleanUpEach(){
        System.out.println("After Each cleanUpEach() method called");
    }
}
