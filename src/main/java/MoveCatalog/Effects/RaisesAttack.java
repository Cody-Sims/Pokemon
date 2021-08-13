package MoveCatalog.Effects;

import MoveCatalog.Move;
import Pokemon.Pokemon;

public class RaisesAttack implements PlayerEffect {
    public void updateStat(Pokemon pokemon) {
        pokemon.setAttackStage(pokemon.getAttackStage() + 1);
        if (pokemon.getAttackStage() > 6) {
            pokemon.setAttackStage(6);
        }
    }
    public String getText(Pokemon player, Move move){
        return player.getName() + " used " + move.getName() + " and raised its attack!";
    }
}
