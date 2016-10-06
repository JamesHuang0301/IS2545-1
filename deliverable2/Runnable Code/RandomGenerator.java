import java.util.Random;

/**
 *
 * @author duxiao
 */
public class RandomGenerator {
    Random randomNumber;
    int[] randomVisitor = new int[5];
    RandomGenerator(long seed){
        this.randomNumber = new Random(seed);
    }
    
    /* randomly generate 5 index of occupation 1<=index<=4
    *  1->Student  2->Professor  3->Business Person  4->Blogger
    */
    public int[] generateVisitor(){            
        for(int i=0;i<5;i++){
            this.randomVisitor[i]=randomNumber.nextInt(4)+1;
        }
        return randomVisitor;
    }
    
    /* randomly generate a index of location that the visitor first visit
    *  0->Cathedral of Learning  1->Squrill Hill  2->The Point  3->Downtown
    * At the first iteration, visitor should not leave city
    */
    public int generateFirstLocation(){
        return randomNumber.nextInt(4);
    }
    
    /* randomly generate a index of location that the visitor first visit
    *  0->Cathedral of Learning  1->Squrill Hill  2->The Point  3->Downtown  4->leave city
    */
    public int generateLocation(){                            //random generate one index of location to go 
            return randomNumber.nextInt(5);
    } 
    
}

