package com.training.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("demo")
public class AssumptionsDemoTests {
	
	@BeforeAll
    public static void init(){
		System.setProperty("ENV", "DEV");
    }
	
	@DisplayName("Run this if `assumeTrue` condition is true, else aborting this test")
    @Test
    void testOnlyOnDevEnvElseAbort() {
        assumeTrue("DEV".equals(System.getProperty("ENV")));
        assertEquals(2, 1 + 1);
    }

    @DisplayName("Run this if `assumeTrue` condition is true, else aborting this test (Custom Message)")
    @Test
    void testOnlyOnProdEnvElseAbortWithCustomMsg() {
        assumeTrue("PROD".equals(System.getProperty("ENV")), () -> "Aborting test: not on production environment");
        assertEquals(2, 1 + 1);
    }

    @Test
    void testAssumingThat() {

        // run these assertions always, just like normal test
        assertEquals(2, 1 + 1);

        assumingThat("PROD".equals(System.getProperty("ENV")),
                () -> {
                    // run this only if assumingThat condition is true
                    assertEquals(2, 1 + 1);
                });

        // run these assertions always, just like normal test
        assertEquals(2, 1 + 1);

    }
}
