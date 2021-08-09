package MoveCatalog.Effects;

import Pokemon.Pokemon;

public class SharplyLowersEvasiveness implements EnemyEffect {
    public void updateStat(Pokemon pokemon){
        pokemon.setEvasivenessStage(pokemon.getEvasivenessStage() - 2);
        if (pokemon.getEvasivenessStage() < -6) {
            pokemon.setEvasivenessStage(-6);
        }
    }
}
