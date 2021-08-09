package MoveCatalog.Effects;

import Pokemon.Pokemon;

public class SharplyLowersAccuracy implements EnemyEffect{
    public void updateStat(Pokemon pokemon) {
        pokemon.setAccuracyStage(pokemon.getAccuracyStage() - 2);
        if (pokemon.getAccuracyStage() < -6) {
            pokemon.setAccuracyStage(-6);
        }
    }
}

