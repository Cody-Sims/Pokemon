package MoveCatalog.Effects;

import Pokemon.Pokemon;

public class SharplyLowersAttack implements EnemyEffect{
    public void updateStat(Pokemon pokemon) {
        pokemon.setAttackStage(pokemon.getAttackStage() - 2);
        if (pokemon.getAttackStage() > 6) {
            pokemon.setAttackStage(6);
        }
    }
}