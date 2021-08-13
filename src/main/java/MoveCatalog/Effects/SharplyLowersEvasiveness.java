package MoveCatalog.Effects;

import MoveCatalog.Move;
import Pokemon.Pokemon;

public class SharplyLowersEvasiveness implements EnemyEffect {
    public void updateStat(Pokemon pokemon){
        pokemon.setEvasivenessStage(pokemon.getEvasivenessStage() - 2);
        if (pokemon.getEvasivenessStage() < -6) {
            pokemon.setEvasivenessStage(-6);
        }
    }
    public String getText(Pokemon player, Pokemon enemy, Move move){
        return player.getName() + " used " + move.getName() + "and sharply lowered " + enemy.getName() + "'s evasiveness!";
    }
}
