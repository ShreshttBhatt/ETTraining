package com.training.demo;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class TimeOutTests {

	 // timed out after 5 seconds
    @BeforeEach
    @Timeout(5)
    void setUpDB() throws InterruptedException {
        //TimeUnit.SECONDS.sleep(10);
    }

    // timed out after 500 miliseconds
    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void test_this() {
    }
}
