package MoveCatalog.StatusEffects;

public class Paralysis {
    int chance = 25; // Chance of being paralyzed and losing a turn

    public boolean isParalyzed(){
        return Math.random() * 100 < chance;
    }

    public String getText(){
        return "was paralyzed and lost it's turn! :(";
    }
}
