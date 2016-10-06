/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CitySim9002;

import junit.framework.Assert;
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
public class VisitorTest {
    
    public VisitorTest() {
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
     * Test of IterateVisit method, of class Visitor.
     * This is a stub method.  Simulcate RandomGenerator object
     * Assuming the random generator will always 4 for location index
     * The test should print out the first location visitor1 visit and his preference.
     * Then immediately leave city.
     */
    @Test
    public void testIterateVisitleft() {
        System.out.println("IterateVisit");
        int expResult = 0;
        RandomGenerator r = mock(RandomGenerator.class);
        Visitor visitor = new Visitor(1,1);
        when(r.generateLocation()).thenReturn(4);
        int result=visitor.IterateVisit(1, r);
        assertEquals(expResult,result);
   
    }
    
    /**
     * Test of IterateVisit method, of class Visitor.
     * The test should fail
     * Use a time bound, if exceed 200mm, the test fail.
     * This is a stub method.  Simulcate RandomGenerator object
     * Assuming the random generator will always 1 for location index
     * The test should print out the first location visitor1 visit and his preference.
     * Then continuously print the same information.
     * This test is testing the stop condition of iteration
     * The test fail reasonablly. 
     */
    @Test(timeout=200)
    public void testIterateVisit() {
        System.out.println("IterateVisit");
        int expResult = 0;
        RandomGenerator r = mock(RandomGenerator.class);
        Visitor visitor = new Visitor(1,1);
        when(r.generateLocation()).thenReturn(1);
        int result=visitor.IterateVisit(1, r);
        assertEquals(expResult,result);
   
    }
    
    
    /**
     * Test of construction method, of class Visitor
     * This is a Test Doubles. Assuming the occupation index passed into method is from a given array
     * Construct five Visitor objects.
     * Whether each object's occupation mapped to the right String
     * The test should pass
     */
    @Test
    public void testOccupation(){
        Boolean result=true;
        String[] occupation={"Student","Professor","Business Person","Blogger","Student"};
        int[] occupationIndex={1,2,3,4,1};
        for(int i=1;i<=5;i++){
            Visitor visitor = new Visitor(occupationIndex[i-1],i);
            result=result&&(visitor.occupation==occupation[i-1]);
        }
        assertEquals(true,result);
    }
 
    
}
