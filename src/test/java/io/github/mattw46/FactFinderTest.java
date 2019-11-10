/*
 * Junit tests to confirm all outputs are correct
 * Tests FactFinder Class
 */
package io.github.mattw46;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author neo
 */
public class FactFinderTest {
    
    public FactFinderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Question1 method, of class FactFinder.
     */
    @org.junit.Test
    public void testQuestion1() {
        System.out.println("Question1");
        FactFinder instance = new FactFinder();
        String expResult = "Output #1: 9";
        String result = instance.Question1();
        assertEquals(expResult, result);
    }

    /**
     * Test of Question2 method, of class FactFinder.
     */
    @org.junit.Test
    public void testQuestion2() {
        System.out.println("Question2");
        FactFinder instance = new FactFinder();
        String expResult = "Output #2: 5";
        String result = instance.Question2();
        assertEquals(expResult, result);
    }

    /**
     * Test of Question3 method, of class FactFinder.
     */
    @org.junit.Test
    public void testQuestion3() {
        System.out.println("Question3");
        FactFinder instance = new FactFinder();
        String expResult = "Output #3: 13";
        String result = instance.Question3();
        assertEquals(expResult, result);
    }

    /**
     * Test of Question4 method, of class FactFinder.
     */
    @org.junit.Test
    public void testQuestion4() {
        System.out.println("Question4");
        FactFinder instance = new FactFinder();
        String expResult = "Output #4: 22";
        String result = instance.Question4();
        assertEquals(expResult, result);
    }

    /**
     * Test of Question5 method, of class FactFinder.
     */
    @org.junit.Test
    public void testQuestion5() {
        System.out.println("Question5");
        FactFinder instance = new FactFinder();
        String expResult = "Output #5: NO SUCH ROUTE";
        String result = instance.Question5();
        assertEquals(expResult, result);
    }

    /**
     * Test of Question6 method, of class FactFinder.
     */
    @org.junit.Test
    public void testQuestion6() {
        System.out.println("Question6");
        FactFinder instance = new FactFinder();
        String expResult = "Output #6: 2";
        String result = instance.Question6();
        assertEquals(expResult, result);
    }

    /**
     * Test of Question7 method, of class FactFinder.
     */
    @org.junit.Test
    public void testQuestion7() {
        System.out.println("Question7");
        FactFinder instance = new FactFinder();
        String expResult = "Output #7: 3";
        String result = instance.Question7();
        assertEquals(expResult, result);
    }

    /**
     * Test of Question8 method, of class FactFinder.
     */
    @org.junit.Test
    public void testQuestion8() {
        System.out.println("Question8");
        FactFinder instance = new FactFinder();
        String expResult = "Output #8: 9";
        String result = instance.Question8();
        assertEquals(expResult, result);
    }

    /**
     * Test of Question9 method, of class FactFinder.
     */
    @org.junit.Test
    public void testQuestion9() {
        System.out.println("Question9");
        FactFinder instance = new FactFinder();
        String expResult = "Output #9: 9";
        String result = instance.Question9();
        assertEquals(expResult, result);
    }

    /**
     * Test of Question10 method, of class FactFinder.
     */
    @org.junit.Test
    public void testQuestion10() {
        System.out.println("Question10");
        FactFinder instance = new FactFinder();
        String expResult = "Output #10: 7";
        String result = instance.Question10();
        assertEquals(expResult, result);
    }
    
}
