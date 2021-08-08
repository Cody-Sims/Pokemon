package MoveCatalog.StatusEffects;

public class Confusion {
    int damage = 40;
    int chance = 33;
    int _hp = 100;
    public boolean snapOutOfConfusion(){ return Math.random() * 100 < chance;}
    public String getText(){return "The pokemon snapped out of confusion!";}
    //damage is calculated as a typeless move with 40 power
    public void confusionDamage(){
        if(!snapOutOfConfusion()){
            _hp = _hp - damage;
        }
    }

}
