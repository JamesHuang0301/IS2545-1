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
public class RandomGeneratorTest {
    
    public RandomGeneratorTest() {
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
     * Test of generateVisitor method, of class RandomGenerator.
     * This is Test Doubles.  Assuming the seed for random is 10
     * The array that orgin function return should have 5 elements.
     * Each element should one of 1,2,3,4
     * This test should pass
     */
    @Test
    public void testGenerateVisitor() {
        Boolean result=true;
        Boolean expResult=true;
        RandomGenerator random = new RandomGenerator(10);
        int[] occupationIndex=random.generateVisitor();
        result=result&&(occupationIndex.length==5);
        for(int i=0;i<occupationIndex.length;i++){
            result=result&&(occupationIndex[i]>=1&&occupationIndex[i]<=4);
        }
        assertEquals(expResult,result);
    }
    
    /**
     * Test of generateFirstLocation method, of class RandomGenerator.
     * This is Test Doubles.  Assuming the seed for random is 10
     * The location index returned randomly should one of 0,1,2,3
     * Test the generateFirstLocation method 10 times for assurance
     * The test should pass
     */
    @Test
    public void testGenerateFirstLocation() {
        Boolean result=true;
        Boolean expResult=true;
        RandomGenerator random = new RandomGenerator(10);
        int locationIndex=random.generateFirstLocation();
        for(int i=1;i<=10;i++){
            result=result&&(locationIndex>=0&&locationIndex<=3);
        }
        assertEquals(expResult,result);
    }
    
    /**
     * Test of generateLocation method, of class RandomGenerator.
     * This is Test Doubles.  Assuming the seed for random is 10
     * The location index returned randomly should one of 0,1,2,3,4
     * Test the generateFirstLocation method 10 times for assurance
     * The test should pass
     */
    @Test
    public void testGenerateLocation() {
        Boolean result=true;
        Boolean expResult=true;
        RandomGenerator random = new RandomGenerator(10);
        int locationIndex=random.generateFirstLocation();
        for(int i=1;i<=10;i++){
            result=result&&(locationIndex>=0&&locationIndex<=4);
        }
        assertEquals(expResult,result);
    }
    
    
 
}
