package MoveCatalog.Effects;

import MoveCatalog.Move;
import Pokemon.Pokemon;

public class RaisesDefense implements PlayerEffect{
    public void updateStat(Pokemon pokemon) {
        pokemon.setDefenseStage(pokemon.getDefenseStage() + 1);
        if (pokemon.getDefenseStage() > 6) {
            pokemon.setDefenseStage(6);
        }
    }
    public String getText(Pokemon player, Move move){
        return player.getName() + " used " + move.getName() + " and raised its defense!";
    }
}
