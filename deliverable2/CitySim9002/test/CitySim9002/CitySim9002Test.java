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
import static org.mockito.Mockito.*;

/**
 *
 * @author duxiao
 */
public class CitySim9002Test {
    
    public CitySim9002Test() {
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
     * Test of programStart method, of class CitySim9002.
     * This is a stub method. Simulate RandomGenerator object
     * Pass five occupations for five visitors
     * This test should pass
     */
    @Test
    public void testProgramStartFivePerson() {
        System.out.println("programStart");
        int[] i={1,2,3,4,1};
        RandomGenerator random = mock(RandomGenerator.class);
        when(random.generateVisitor()).thenReturn(i);
        int result=CitySim9002.programStart(random,2);
        int expResult=0;
        assertEquals(0,result);
    }
    
    /**
     * Test of programStart method, of class CitySim9002.
     * This is a stub method.   Simulate RandomGenerator object
     * Pass four occupations for five visitors
     * This test should throw out an exception, the array is out of bound
     * This test should pass
     */
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testProgramStartFourPerson() {
        System.out.println("programStart");
        int[] i={1,2,3,4};
        RandomGenerator random = mock(RandomGenerator.class);
        when(random.generateVisitor()).thenReturn(i);
        CitySim9002.programStart(random,2);
    }
    
}
