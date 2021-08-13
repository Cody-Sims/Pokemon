package Battle.Mechanics;

import MoveCatalog.Move;
import Pokemon.Pokemon;

// Todo
// Determines whether a move is super effective, not very effective, or normal effectiveness
public class TypeEffectiveness {

    public double effectiveness(Move move, Pokemon enemy){
        int curEffectiveness = 1; // Default Effectiveness

        // Return 0 if enemy is immune to move type
        if(enemy.getTypeOne().getImmunities().contains(move.getType())
                || enemy.getTypeTwo().getImmunities().contains(move.getType())){
            return 0;
        }
        return curEffectiveness;
    }
}
