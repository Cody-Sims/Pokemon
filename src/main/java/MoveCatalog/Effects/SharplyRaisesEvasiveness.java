package MoveCatalog.Effects;

import Pokemon.Pokemon;

public class SharplyRaisesEvasiveness implements PlayerEffect {
    public void updateStat(Pokemon pokemon){
        pokemon.setEvasivenessStage(pokemon.getEvasivenessStage() + 2);
        if (pokemon.getEvasivenessStage() > 6) {
            pokemon.setEvasivenessStage(6);
        }
    }
}
