package MoveCatalog.Effects;

import Pokemon.Pokemon;

public class RaisesEvasiveness implements PlayerEffect{
    public void updateStat(Pokemon pokemon) {
        pokemon.setEvasivenessStage(pokemon.getEvasivenessStage() + 1);
        if (pokemon.getEvasivenessStage() > 6) {
            pokemon.setEvasivenessStage(6);
        }
    }
}
