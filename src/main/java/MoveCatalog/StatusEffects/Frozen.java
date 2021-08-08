package MoveCatalog.StatusEffects;

public class Frozen {
    int chance = 20;
    public boolean isFrozen(){ return Math.random() * 100 < chance; }
    public String getText(){return "The pokemon was unable to move!";}
}
