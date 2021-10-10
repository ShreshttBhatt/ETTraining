package com.training.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Disabled Class")
public class DisabledClassTests {
	
	@Test
    void testWillBeSkipped() {
		assertTrue(true);
    }
}
