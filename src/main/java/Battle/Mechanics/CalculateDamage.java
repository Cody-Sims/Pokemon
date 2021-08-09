package Battle.Mechanics;

import MoveCatalog.Effects.PlayerEffect;
import MoveCatalog.Move;
import MoveCatalog.StatusEffects.Paralysis;
import Pokemon.Pokemon;

import java.util.concurrent.ThreadLocalRandom;

// https://www.serebii.net/games/damage.shtml
// Used to calculate damage
//Todo
public class CalculateDamage {
    public static double calculateDamage(Move move, Pokemon attackingPokemon, Pokemon defendingPokemon) {

        // If the move is an effect that raises the players stat, return 0 and update stats
        if(move.getEffect() != null){
            move.getEffect().updateStat(attackingPokemon);
            attackingPokemon.calculateBattleStats();
            return 0;
        }

        // If the move is an effect that decreases the opponents stat, return 0 and lower the stat of the opponent
        if(move.getOpponentEffect() != null){
            System.out.println(defendingPokemon.getSpeedStage());
            move.getOpponentEffect().updateStat(defendingPokemon);
            defendingPokemon.calculateBattleStats();
            System.out.println(defendingPokemon.getSpeedStage());
            return 0;
        }

        //Calculate battle stats
        attackingPokemon.calculateBattleStats();
        defendingPokemon.calculateBattleStats();


        // Calculate initial variables needed for damage calculation
        int level = attackingPokemon.getLevel();
        int attackStat = getAttackStat(move,attackingPokemon);
        int movePower = move.getPower();
        int enemyDefense = getDefenseStat(move, defendingPokemon);
        double effectiveness = 1;
        int randomNumber = ThreadLocalRandom.current().nextInt(85, 101);
        double STAB = 1; // Same-Type attack bonus

        if(attackingPokemon.get_typeTwo().equals(move.getType()) || attackingPokemon.get_typeOne().equals(move.getType())){
            STAB = 1.5;
        }

        // Damage Calculation
        int damage = (int) (((((2 * level / 5 + 2) * attackStat * movePower / enemyDefense) / 50) + 2)
                * STAB * effectiveness * randomNumber / 100);

        return damage;
    }

    //Chooses a random move from the enemies moves and calculates damage to player
    public static Move enemyAttack(Pokemon enemy) {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 5);
        {
            if(randomNumber == 1){
                return enemy.getMoveOne();
            }
            else if(randomNumber == 2){
                return enemy.getMoveTwo();
            }
            else if(randomNumber == 3){
                return enemy.getMoveThree();
            }
            else{
                return enemy.getMoveFour();
            }
        }
    }

    // Calculates the attack stat based on the type of move
    public static int getAttackStat(Move move, Pokemon pokemon) {
        if (move.getCategory().equals("Special")) {
            return pokemon.getBattleSpecialAttack();
        } else {
            return pokemon.getBattleAttack();
        }
    }

    // Calculates the defense stat based on the type of move
    public static int getDefenseStat(Move move, Pokemon pokemon) {
        if (move.getCategory().equals("Special")) {
            return pokemon.getBattleSpecialDefense();
        } else {
            return pokemon.getBattleDefense();
        }
    }
}

