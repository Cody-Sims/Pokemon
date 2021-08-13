package MoveCatalog.Effects;

import MoveCatalog.Move;
import Pokemon.Pokemon;

public class LowersSpecialDefense implements EnemyEffect{
    public void updateStat(Pokemon pokemon) {
        pokemon.setSpecialDefenseStage(pokemon.getSpecialDefenseStage() - 1);
        if (pokemon.getSpecialDefenseStage() < -6) {
            pokemon.setSpecialDefenseStage(-6);
        }
    }
    public String getText(Pokemon player, Pokemon enemy, Move move){
        return player.getName() + " used " + move.getName() + "and lowered " + enemy.getName() + "'s special defense!";
    }
}