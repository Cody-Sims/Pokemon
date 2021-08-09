package MoveCatalog.Effects;

import Pokemon.Pokemon;

public class SharplyRaisesAccuracy implements PlayerEffect{
    public void updateStat(Pokemon pokemon) {
        pokemon.setAccuracyStage(pokemon.getAccuracyStage() + 2);
        if (pokemon.getAccuracyStage() > 6) {
            pokemon.setAccuracyStage(6);
        }
    }
}
