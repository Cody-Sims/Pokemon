package Battle.Mechanics;

import MoveCatalog.Move;
import Pokemon.Pokemon;

// Todo
// Determines whether a move is super effective, not very effective, or normal effectiveness
public class TypeEffectiveness {
    public static double getEffectiveness(Move move, Pokemon enemy){
        double curEffectiveness = 1; // Default Effectiveness

        // Return 0 if enemy is immune to move type
        if(enemy.getTypeOne().getImmunities().contains(move.getType())
                || enemy.getTypeTwo().getImmunities().contains(move.getType())){
            return 0;
        }

        // Strength Calculation
        if(enemy.getTypeOne().getStrengths().contains((move.getType()))){
            curEffectiveness *= 0.5;
        }
        if(enemy.getTypeTwo().getStrengths().contains((move.getType()))){
            curEffectiveness *= 0.5;
        }

        // Immunities Calculation
        if(enemy.getTypeOne().getWeaknesses().contains((move.getType()))){
            curEffectiveness *= 2;
        }
        if(enemy.getTypeTwo().getWeaknesses().contains((move.getType()))){
            curEffectiveness *= 2;
        }
        return curEffectiveness;
    }
}
