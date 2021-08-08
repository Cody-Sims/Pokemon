package MoveCatalog.StatusEffects;

public class Burnt {
    int _hp = 100;
    public void burnDamage(){
        _hp = Math.round(_hp%16);
    }
}
