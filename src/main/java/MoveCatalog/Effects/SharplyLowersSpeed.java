package MoveCatalog.Effects;

import Pokemon.Pokemon;

public class SharplyLowersSpeed implements EnemyEffect {
    public void updateStat(Pokemon pokemon){
        pokemon.setSpeedStage(pokemon.getSpeedStage() - 2);
        if (pokemon.getSpeedStage() < -6) {
            pokemon.setSpeedStage(-6);
        }
    }
}