package MoveCatalog.Effects;

import Pokemon.Pokemon;

public class SharplyRaisesAttack implements Effect{
    public void updateStat(Pokemon pokemon) {
        pokemon.setAttackStage(pokemon.getAttackStage() + 2);
        if (pokemon.getAttackStage() > 6) {
            pokemon.setAttackStage(6);
        }
    }
}