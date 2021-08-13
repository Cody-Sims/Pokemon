package MoveCatalog.Effects;

import MoveCatalog.Move;
import Pokemon.Pokemon;

// Interface of the different stat changing effects
public interface PlayerEffect {
    void updateStat(Pokemon player);
    String getText(Pokemon player, Move move);
    //todo getText()
}
