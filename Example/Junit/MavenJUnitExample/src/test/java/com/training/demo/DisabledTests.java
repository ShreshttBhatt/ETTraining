package com.training.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DisabledTests {
	 
	@Disabled("Disabled Test")
    @Test
    void testWillBeSkipped() {
    }

    @Test
    void testWillBeExecuted() {
    }
}
