package MoveCatalog.StatusEffects;

public class Sleep {
    int sleepcounter = (int)(Math.random()*3);
    public boolean isAsleep(){
            if(sleepcounter == 3){
                System.out.println("The pokemon woke up!");
                return false;
            }
            sleepcounter ++;
            return true;
        }
    }

