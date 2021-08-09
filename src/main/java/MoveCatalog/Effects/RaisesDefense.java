package MoveCatalog.Effects;

import Pokemon.Pokemon;

public class RaisesDefense implements PlayerEffect{
    public void updateStat(Pokemon pokemon) {
        pokemon.setDefenseStage(pokemon.getDefenseStage() + 1);
        if (pokemon.getDefenseStage() > 6) {
            pokemon.setDefenseStage(6);
        }
    }
}
