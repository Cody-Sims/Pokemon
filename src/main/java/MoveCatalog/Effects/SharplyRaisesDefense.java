package MoveCatalog.Effects;

import Pokemon.Pokemon;

public class SharplyRaisesDefense implements Effect{
    public void updateStat(Pokemon pokemon){
        pokemon.setDefenseStage(pokemon.getDefenseStage() + 2);
        if (pokemon.getDefenseStage() > 6) {
            pokemon.setDefenseStage(6);
        }
    }
}
