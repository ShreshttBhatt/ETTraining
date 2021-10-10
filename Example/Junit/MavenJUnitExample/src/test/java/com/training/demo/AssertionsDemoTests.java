package com.training.demo;

import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("demo")
public class AssertionsDemoTests {
	
	private final Calculator calculator = new Calculator();

    private final Person person = new Person("Jane", "Doe");

    @Test
    void standardAssertions() {
        assertEquals(2, calculator.add(1, 1));
        assertEquals(4, calculator.multiply(2, 2),
                "The optional failure message is now the last parameter");
        assertTrue('a' < 'b', () -> "Assertion messages can be lazily evaluated -- "
                + "to avoid constructing complex messages unnecessarily.");
    }

    @Test
    void groupedAssertions() {
        // In a grouped assertion all assertions are executed, and all
        // failures will be reported together.
        assertAll("person",
            () -> assertEquals("Jane", person.getFirstName()),
            () -> assertEquals("Doe", person.getLastName())
        );
    }

    @Test
    void dependentAssertions() {
        // Within a code block, if an assertion fails the
        // subsequent code in the same block will be skipped.
        assertAll("properties",
            () -> {
                String firstName = person.getFirstName();
                assertNotNull(firstName);

                // Executed only if the previous assertion is valid.
                assertAll("first name",
                    () -> assertTrue(firstName.startsWith("J")),
                    () -> assertTrue(firstName.endsWith("e"))
                );
            },
            () -> {
                // Grouped assertion, so processed independently
                // of results of first name assertions.
                String lastName = person.getLastName();
                assertNotNull(lastName);

                // Executed only if the previous assertion is valid.
                assertAll("last name",
                    () -> assertTrue(lastName.startsWith("D")),
                    () -> assertTrue(lastName.endsWith("e"))
                );
            }
        );
    }

    @Test
    void exceptionTesting() {
        Exception exception = assertThrows(ArithmeticException.class, () ->
            calculator.divide(1, 0));
        assertEquals("/ by zero", exception.getMessage());
    }
    
    @Test
    void whenAssertingException_thenThrown() {
        Throwable exception = assertThrows(
          IllegalArgumentException.class, 
          () -> {
              throw new IllegalArgumentException("Exception message");
          }
        );
        assertEquals("Exception message", exception.getMessage());
    }

    @Test
    void timeoutNotExceeded() {
        // The following assertion succeeds.
        assertTimeout(ofMinutes(2), () -> {
            // Perform task that takes less than 2 minutes.
        });
    }
    
    @Test
    void matchString()
    {
    	String originalObject = "ET_Training";
    	String cloneObject = originalObject;
    	String otherObject = "Training";
    	
    	assertNotSame(originalObject, otherObject);
    	assertEquals(cloneObject, originalObject);
    }
    
    @Test
    public void whenAssertingEqualityWithDelta_thenEqual() {
        float square = 2 * 2;
        float rectangle = 3 * 2;
        float delta = 2;

        assertEquals(square, rectangle, delta);
    }
    
    @Test
    public void givenTwoLists_whenAssertingIterables_thenEquals() {
        Iterable<String> al = new ArrayList<>(Arrays.asList("Java", "Junit", "Test"));
        Iterable<String> ll = new LinkedList<>(Arrays.asList("Java", "Junit", "Test"));

        assertIterableEquals(al, ll);
    }
    
    /**
    1. Check if the expected line is equal to the actual one. If yes it continues with the next pair
    2. Treat the expected line as a regular expression and performs a check with the String.matches() method. If yes it continues with the next pair
    3. Check if the expected line is a fast-forward marker. If yes apply fast-forward and repeat the algorithm from the step 1
    **/
    @Test
    public void whenAssertingEqualityListOfStrings_thenEqual() {
        List<String> expected = Arrays.asList("Java", "\\d+", "JUnit");
        List<String> actual = Arrays.asList("Java", "11", "JUnit");

        assertLinesMatch(expected, actual);
    }
}