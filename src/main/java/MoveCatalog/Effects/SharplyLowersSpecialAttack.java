package MoveCatalog.Effects;

import Pokemon.Pokemon;

public class SharplyLowersSpecialAttack implements EnemyEffect{
    public void updateStat(Pokemon pokemon){
        pokemon.setSpecialAttackStage(pokemon.getSpecialAttackStage() - 2);
        if (pokemon.getSpecialAttackStage() > 6) {
            pokemon.setSpecialAttackStage(6);
        }
    }
}
