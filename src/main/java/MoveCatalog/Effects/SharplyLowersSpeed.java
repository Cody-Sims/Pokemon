package MoveCatalog.Effects;

import MoveCatalog.Move;
import Pokemon.Pokemon;

public class SharplyLowersSpeed implements EnemyEffect {
    public void updateStat(Pokemon pokemon){
        pokemon.setSpeedStage(pokemon.getSpeedStage() - 2);
        if (pokemon.getSpeedStage() > 6) {
            pokemon.setSpeedStage(6);
        }
    }
    public String getText(Pokemon player, Pokemon enemy, Move move){
        return player.getName() + " used " + move.getName() + "and sharply lowered " + enemy.getName() + "'s speed!";
    }
}