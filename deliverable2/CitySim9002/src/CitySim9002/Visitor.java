/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CitySim9002;

/**
 *
 * @author duxiao
 */
public class Visitor {
    int visitorNum;                  //visitor's number
    String occupation;               //visitor's occupation
    String[][] locationPreference;   //visitor's preference of location
    
    Visitor(int indexOfOccupation,int visitorNum){     //use occupation index and visitor number to construct instance
        
        this.visitorNum=visitorNum;
        
        switch(indexOfOccupation){
            
            case 1:
                occupation = "Student";               
                String[][] location1={{"Cathedral of Learning","did not"},{"Squirrel Hill","did"},{"The Point","did"},{"Downtown","did"}};
                this.locationPreference=location1;
                break;
   
            case 2:
                occupation="Professor";
                String[][] location2={{"Cathedral of Learning","did"},{"Squirrel Hill","did"},{"The Point","did"},{"Downtown","did"}};
                this.locationPreference=location2;
                break;
                
            case 3: 
                occupation="Business Person";
                String[][] location3={{"Cathedral of Learning","did not"},{"Squirrel Hill","did"},{"The Point","did not"},{"Downtown","did"}};
                this.locationPreference=location3;
                break;
                
            case 4:
                occupation="Blogger";
                String[][] location4={{"Cathedral of Learning","did not"},{"Squirrel Hill","did not"},{"The Point","did not"},{"Downtown","did not"}};
                this.locationPreference=location4;
                break;
            
        }
            
    }
    
    public int IterateVisit(int visitorNum,RandomGenerator r){
        int i=r.generateFirstLocation();                             //visitor at the first iteration should not leave city
        System.out.println("Visitor "+visitorNum+" is a "+occupation+"."); // print out visitor's number and occupation
        
        /* randomly generate location index at each iteration.
         * when location index is 4, leave city.
         * print out where the visitor going and his preference
        */
        while(i!=4){                                                
                                                                        
            System.out.println("Visitor "+visitorNum+" is going to "+locationPreference[i][0]+" !");
            System.out.println("Visitor "+visitorNum+" "+locationPreference[i][1]+" like "+locationPreference[i][0]);
            i=r.generateLocation();
        }
        
        System.out.println("Visitor "+visitorNum+" has left the city.");
        System.out.println("*******************************************");
        return 0;                                                           //used to verify whether the function is excutable
    }
    
    
}

