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
public class Seed{
    String seed;
    
    Seed(String seed){        
       this.seed=seed;   
    }
    
    public Boolean isSeed(){       // the seed should not contain charater that is not digit
 
        for(int i=0;i<seed.length();i++){
           if(!Character.isDigit(seed.charAt(i))){
               return  false;              
           }
        }
        return true;
    }
}
