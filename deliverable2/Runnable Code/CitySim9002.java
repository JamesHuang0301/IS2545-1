public class CitySim9002 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length==0||args.length>1){                         //whether the number of parameters is 0 or more than 1 
            System.out.println("Please enter one integer argument seed");
        }
        else{
            Seed se = new Seed(args[0]);
            if(!se.isSeed()){                                      // whether the parameter is Integer
                System.out.println("Please enter one integer argument seed");
              }
            else{
                int seed=Integer.parseInt(args[0]);                 // pass the parameter to random generator as seed
                RandomGenerator random = new RandomGenerator(seed);
                programStart(random,seed);
            }          
            
        }
    }
    
    public static int programStart(RandomGenerator random,int seed){
        
        System.out.println("Welcome to CitySim! Your seed is "+seed );
           
        int[] occupation=random.generateVisitor();          // randomly generate occupations for 5 visitor 
      
            
        for(int i=1;i<=5;i++){                              //iteration for five visitors
            Visitor visitor = new Visitor(occupation[i-1],i);
            visitor.IterateVisit(i, new RandomGenerator(seed+i));    //consider of the varity, use different seed in each iteration
        }
        return 0;                                               // verify the function
    }
    
}