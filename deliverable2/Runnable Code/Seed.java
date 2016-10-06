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