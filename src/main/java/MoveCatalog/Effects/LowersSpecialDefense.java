package MoveCatalog.Effects;

import Pokemon.Pokemon;

public class LowersSpecialDefense implements Effect{
    public void updateStat(Pokemon pokemon) {
        pokemon.setSpecialDefenseStage(pokemon.getSpecialDefenseStage() - 1);
        if (pokemon.getSpecialDefenseStage() > 6) {
            pokemon.setSpecialDefenseStage(6);
        }
    }
}