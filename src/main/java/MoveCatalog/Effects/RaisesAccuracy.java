package MoveCatalog.Effects;

import Pokemon.Pokemon;

public class RaisesAccuracy implements PlayerEffect {
    public void updateStat(Pokemon pokemon) {
        pokemon.setAccuracyStage(pokemon.getAccuracyStage() + 1);
        if (pokemon.getAccuracyStage() > 6) {
            pokemon.setAccuracyStage(6);
        }
    }
}
