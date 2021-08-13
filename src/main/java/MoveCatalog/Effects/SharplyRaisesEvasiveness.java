package MoveCatalog.Effects;

import MoveCatalog.Move;
import Pokemon.Pokemon;

public class SharplyRaisesEvasiveness implements PlayerEffect {
    public void updateStat(Pokemon pokemon){
        pokemon.setEvasivenessStage(pokemon.getEvasivenessStage() + 2);
        if (pokemon.getEvasivenessStage() > 6) {
            pokemon.setEvasivenessStage(6);
        }
    }
    public String getText(Pokemon player, Move move){
        return player.getName() + " used " + move.getName() + " and sharply raised its evasiveness!";
    }
}
