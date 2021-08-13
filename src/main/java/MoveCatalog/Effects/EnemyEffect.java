package MoveCatalog.Effects;

import MoveCatalog.Move;
import Pokemon.Pokemon;

public interface EnemyEffect {
    void updateStat(Pokemon player);
    String getText(Pokemon player, Pokemon enemy, Move move);
    //todo getText()
}
