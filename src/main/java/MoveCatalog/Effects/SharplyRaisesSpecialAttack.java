package MoveCatalog.Effects;

import MoveCatalog.Move;
import Pokemon.Pokemon;

public class SharplyRaisesSpecialAttack implements PlayerEffect{
    public void updateStat(Pokemon pokemon){
        pokemon.setSpecialAttackStage(pokemon.getSpecialAttackStage() + 2);
        if (pokemon.getSpecialAttackStage() > 6) {
            pokemon.setSpecialAttackStage(6);
        }
    }
    public String getText(Pokemon player, Move move){
        return player.getName() + " used " + move.getName() + " and sharply raised its special attack!";
    }
}
