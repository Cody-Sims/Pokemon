package MoveCatalog.Effects;

import MoveCatalog.Move;
import Pokemon.Pokemon;

public class RaisesSpeed implements PlayerEffect{
    public void updateStat(Pokemon pokemon) {
        pokemon.setSpeedStage(pokemon.getSpeedStage() + 1);
        if (pokemon.getSpeedStage() > 6) {
            pokemon.setSpeedStage(6);
        }
    }
    public String getText(Pokemon player, Move move){
        return player.getName() + " used " + move.getName() + " and raised its speed!";
    }
}
