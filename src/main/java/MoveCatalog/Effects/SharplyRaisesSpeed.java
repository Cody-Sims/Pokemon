package MoveCatalog.Effects;

import Pokemon.Pokemon;

public class SharplyRaisesSpeed implements Effect {
    public void updateStat(Pokemon pokemon){
        pokemon.setSpeedStage(pokemon.getSpeedStage() + 2);
        if (pokemon.getSpeedStage() > 6) {
            pokemon.setSpeedStage(6);
        }
    }
}
