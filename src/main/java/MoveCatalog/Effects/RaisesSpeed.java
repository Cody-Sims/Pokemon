package MoveCatalog.Effects;

import Pokemon.Pokemon;

public class RaisesSpeed implements Effect{
    public void updateStat(Pokemon pokemon) {
        pokemon.setSpeedStage(pokemon.getSpeedStage() + 1);
        if (pokemon.getSpeedStage() > 6) {
            pokemon.setSpeedStage(6);
        }
    }
}
