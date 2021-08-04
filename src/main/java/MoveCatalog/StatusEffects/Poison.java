package MoveCatalog.StatusEffects;

public class Poison {
    int _hp = 100;
    int badDamage = 2;
    int damage = 10;

    // need something to start these after a pokemon is poisoned.
    // need something to break these after a pokemon is healed.
    public void badPoisonDamage(){
        _hp =_hp -badDamage;
        if(badDamage >15*(_hp%16)) {
            badDamage = badDamage;
        }
    }
    public void poisonDamage{
            damage = (Math.round(_hp%8));
            _hp = _hp - damage;
    }
}
