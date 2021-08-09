package MoveCatalog.Effects;

import MoveCatalog.Move;
import Pokemon.Pokemon;

public class LowersAttack implements EnemyEffect {
    public void updateStat(Pokemon pokemon) {
        pokemon.setAttackStage(pokemon.getAttackStage() - 1);
        if (pokemon.getAttackStage() < -6) {
            pokemon.setAttackStage(-6);
        }
    }
}