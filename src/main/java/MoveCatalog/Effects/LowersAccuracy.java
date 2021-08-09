package MoveCatalog.Effects;

import Pokemon.Pokemon;

public class LowersAccuracy implements EnemyEffect {
    public void updateStat(Pokemon pokemon) {
        pokemon.setAccuracyStage(pokemon.getAccuracyStage() - 1);
        if (pokemon.getAccuracyStage() < -6) {
            pokemon.setAccuracyStage(-6);
        }
    }
}
