package MoveCatalog.Effects;

import MoveCatalog.Move;
import Pokemon.Pokemon;

public class LowersAttack implements EnemyEffect {
    public void updateStat(Pokemon pokemon) {
        pokemon.setAttackStage(pokemon.getAttackStage() - 1);
        if (pokemon.getAttackStage() < -6) {
            pokemon.setAttackStage(-6);
        }
    }
    public String getText(Pokemon player, Pokemon enemy, Move move){
        return player.getName() + " used " + move.getName() + "and lowered " + enemy.getName() + "'s attack!";
    }

}