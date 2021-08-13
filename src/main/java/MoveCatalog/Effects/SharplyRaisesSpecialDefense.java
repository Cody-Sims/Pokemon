package MoveCatalog.Effects;

import MoveCatalog.Move;
import Pokemon.Pokemon;

public class SharplyRaisesSpecialDefense implements PlayerEffect {
    public void updateStat(Pokemon pokemon){
        pokemon.setSpecialDefenseStage(pokemon.getSpecialDefenseStage() + 2);
        if (pokemon.getSpecialDefenseStage() > 6) {
            pokemon.setSpecialDefenseStage(6);
        }
    }
    public String getText(Pokemon player, Move move){
        return player.getName() + " used " + move.getName() + " and sharply raised its special defense!";
    }
}
