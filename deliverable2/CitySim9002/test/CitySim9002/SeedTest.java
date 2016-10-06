/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CitySim9002;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author duxiao
 */
public class SeedTest {
    
    public static Seed seed = new Seed("0");
    
    public SeedTest() {
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
     * Test of isSeed method, of class Seed.
     * This is Test Doubles. Assuming "9" is the parameter passed into Seed
     * 9 is integer, expect value is true
     * The test should pass
     */
    @Test
    public void testIsSeedInt() {
        System.out.print("Whether 9 is Seed : ");
        seed = new Seed("9");
        Boolean expResult = true;
        Boolean result = seed.isSeed();
        System.out.println(result);
        assertEquals(expResult, result);
      
    }
    
    /**
     * Test of isSeed method, of class Seed.
     * This is Test Doubles. Assuming "1.5" is the parameter passed into Seed
     * 1.5 is not integer, expect value is false
     * The test should pass
     */
    @Test
    public void testIsSeedFloat() {
        System.out.print("Whether 1.5 is Seed : ");
        seed = new Seed("1.5");
        Boolean expResult = false;
        Boolean result = seed.isSeed();
        System.out.println(result);
        assertEquals(expResult, result);
      
    }
    
    /**
     * Test of isSeed method, of class Seed.
     * This is Test Doubles. Assuming "12x" is the parameter passed into Seed
     * 12x is not integer, expect value is false
     * The test should pass
     */
    @Test
    public void testIsSeedLetter() {
        System.out.print("Whether 12x is Seed : ");
        seed = new Seed("12x");
        Boolean expResult = false;
        Boolean result = seed.isSeed();
        System.out.println(result);
        assertEquals(expResult, result);
      
    }
    
}
