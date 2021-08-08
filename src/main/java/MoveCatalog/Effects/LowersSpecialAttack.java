package MoveCatalog.Effects;

import Pokemon.Pokemon;

public class LowersSpecialAttack implements Effect{
    public void updateStat(Pokemon pokemon) {
        pokemon.setSpecialAttackStage(pokemon.getSpecialAttackStage() - 1);
        if (pokemon.getSpecialAttackStage() > 6) {
            pokemon.setSpecialAttackStage(6);
        }
    }
}
