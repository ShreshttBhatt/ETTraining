package com.training.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class BeforeEachTests {

	@DisplayName("Add operation test")
    @RepeatedTest(5)
    void addNumber(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Running test -> " + repetitionInfo.getCurrentRepetition());
        Calculator calculator = new Calculator();
        Assertions.assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
    }
     
    @BeforeAll
    public static void init(){
        System.out.println("BeforeAll init() method called");
    }
     
    @BeforeEach
    public void initEach(){
        System.out.println("BeforeEach initEach() method called");
    }
}
