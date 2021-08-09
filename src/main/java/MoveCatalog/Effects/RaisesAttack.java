package MoveCatalog.Effects;

import Pokemon.Pokemon;

public class RaisesAttack implements PlayerEffect {
    public void updateStat(Pokemon pokemon) {
        pokemon.setAttackStage(pokemon.getAttackStage() + 1);
        if (pokemon.getAttackStage() > 6) {
            pokemon.setAttackStage(6);
        }
    }
}
