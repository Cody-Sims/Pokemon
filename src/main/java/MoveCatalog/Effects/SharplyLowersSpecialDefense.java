package MoveCatalog.Effects;

import Pokemon.Pokemon;

public class SharplyLowersSpecialDefense implements Effect {
    public void updateStat(Pokemon pokemon){
        pokemon.setSpecialDefenseStage(pokemon.getSpecialDefenseStage() - 2);
        if (pokemon.getSpecialDefenseStage() > 6) {
            pokemon.setSpecialDefenseStage(6);
        }
    }
}
