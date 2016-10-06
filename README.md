# **IS2545 - DELIVERABLE 2: Unit Testing**
>## Program Design
>>###There are four classes in this program: CitySim9002, Visitor, RandomGenerator, Seed.
    
         Seed:       check whether the parameter passed when the program run can be a seed for Random class.
    
    RandomGenerator: generate 5 occupation index for five visitor.
                     generate one location index for visitor first visiting.
                     generate one location index for visitor to visit after first visiting.
                     
       Visitor:      construct a visitor using visitor's number and occupation index.
                     map the occupation index to real String.
                     print out visitor's number and occupation.
                     interative print out the location visitor has visited and his preference.
             
     CitySim9002:    get an array of occupation indexs passed from RandomGenerator object.
                     construct five Visitor objects.
                     get the result
>## Test Case Design (only core test is showned)
>>###Verify Seed

          The String array that user input should exactly have one element. Unfortunately, this part of code 
      contains in the main function, thus can only test when actually run the program.
```Java
                                        args.length==0||args.length>1
```
            
          The seed should be integer: I use integer, float, and char to construct 3 test case.
                                      float test case is shown below.
          
```Java
        /*
         * Test of isSeed method, of class Seed.
         * This is Test Doubles. Assuming "1.5" is the parameter passed into Seed
         * 1.5 is not integer, expect value is false
         */
        @Test
        public void testIsSeedFloat() {
            seed = new Seed("1.5");
            Boolean expResult = false;
            Boolean result = seed.isSeed();
            assertEquals(expResult, result);
        }
```
>>###Verify location Index

          Visitor has equal probability to go four locations and leave city. Thus program should generate
       location index between 0 to 4. 
          0->Cathedral of Learning  1->Squrill Hill  2->The Point  3->Downtown  4->leave city
          
```Java
        /**
         * Test of generateLocation method, of class RandomGenerator.
         * This is Test Doubles.  Assuming the seed for random is 10
         * The location index returned randomly should one of 0,1,2,3,4
         * Test the generateFirstLocation method 10 times for assurance
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
```
>>###Verify Occupationm Index

          Visitor has equal probability to be one of four occupations. Thus program should generate
       occupation index between 1 to 4. 
          1->Student  2->Professor  3->Business Person  4->Blogger
```Java
        /**
        * Test of generateVisitor method, of class RandomGenerator.
        * This is Test Doubles.  Assuming the seed for random is 10
        * The array that orgin function return should have 5 elements.
        * Each element should one of 1,2,3,4
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
```        
>>###Verify Occupationm Map

           The occupation index should correctly map to the actually occupation String. 
```Java
        /**
         * Test of construction method, of class Visitor
         * This is a Test Doubles. Assuming the occupation index passed into method is from a given array
         * Construct five Visitor objects.
         * Whether each object's occupation mapped to the right String
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
```
>>###Verify Iteration

          When the location index randomly generatored by RandomGenerator is 4, the visit should stop visiting and
        leave the city. This case is to test the stop condition of iteration.
```Java
                         /**
                          * Test of IterateVisit method, of class Visitor.
                          * This is a stub method.  Simulcate RandomGenerator object
                          * Assuming the random generator will always 4 for location index
                          * The test should print out the first location visitor1 visit and his preference.
                          * Then immediately leave city.
                          */
                          @Test
                          public void testIterateVisitleft() {
                                int expResult = 0;
                                RandomGenerator r = mock(RandomGenerator.class);      //mock
                                Visitor visitor = new Visitor(1,1);
                                when(r.generateLocation()).thenReturn(4);
                                int result=visitor.IterateVisit(1, r);
                                assertEquals(expResult,result);
   
                          }
```                          
>>###Verify Five Visitors 

           This is a boundary test.
           The program should create exactly five visitors and each visitor map to a specific occupation. The                        CitySim9002.class use an array of occupation index passed by RandomGenerator to consrtuct Visitor object
       Thus I simulate the object of RandomGenerator.  I use two test case, one has 4 elements in occupation index 
       array the other has 5.  The four elements one should throw a Exception to remind ArrayIndexOutOfBounds
```Java
            /**4 Elements
             * Test of programStart method, of class CitySim9002.
             * This is a stub method.   Simulate RandomGenerator object
             * Pass four occupations for five visitors
             * This test should throw out an exception, the array is out of bound
             */
             @Test(expected=ArrayIndexOutOfBoundsException.class)
             public void testProgramStartFourPerson() {
                  System.out.println("programStart");
                  int[] i={1,2,3,4};                                    //occupation index array
                  RandomGenerator random = mock(RandomGenerator.class);  //mock
                  when(random.generateVisitor()).thenReturn(i);
                  CitySim9002.programStart(random,2);
             }
             
             /**5 Elements
              * Test of programStart method, of class CitySim9002.
              * This is a stub method. Simulate RandomGenerator object
              * Pass five occupations for five visitors
              */
              @Test
              public void testProgramStartFivePerson() {
                  System.out.println("programStart");
                  int[] i={1,2,3,4,1};                                  //occupation index array
                  RandomGenerator random = mock(RandomGenerator.class);  //mock
                  when(random.generateVisitor()).thenReturn(i);
                  int result=CitySim9002.programStart(random,2);
                  int expResult=0;
                  assertEquals(0,result);
              }
```
>>###Resonable Fail

              As mentioned in Verify Iteration, the program also should test the condition that continue the iteraion.
           However it is not make sense to excute the loop infinitly.  Thus, I set a time bound as 200mm.  The test is 
           failed when exceed the time bound.  If the origin methods is logical, the test will 100% be failed.
```Java
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
                             int expResult = 0;
                             RandomGenerator r = mock(RandomGenerator.class);
                             Visitor visitor = new Visitor(1,1);
                             when(r.generateLocation()).thenReturn(1);
                             int result=visitor.IterateVisit(1, r);
                             assertEquals(expResult,result);
   
                         }
```        
 
    
