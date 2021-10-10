package math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The Class MyMathTest.
 */
public class MyMathTest {
    
    /**
     * Test multi.
     */
    @Test
    public void testMulti() {
        MyMath math = new MyMath();
        assertEquals(50, math.multi(5, 10));
    }
}