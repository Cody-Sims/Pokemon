package Battle.Mechanics;

import MoveCatalog.Move;
import Pokemon.Pokemon;

import java.util.concurrent.ThreadLocalRandom;

// https://www.serebii.net/games/damage.shtml
// Used to calculate damage
//Todo
public class CalculateDamage {
    public static double calculateDamage(Move move, Pokemon attackingPokemon, Pokemon defendingPokemon) {
        int level = attackingPokemon.getLevel();
        int attackStat = getAttackStat(move,attackingPokemon); // Todo implement in Pokemon Class
        int movePower = move.getPower();    //Todo implement in move Class
        int enemyDefense = getDefenseStat(move, defendingPokemon); //Todo implement in Pokemon Class
        double effectiveness = 1;
        int randomNumber = ThreadLocalRandom.current().nextInt(85, 101);
        double STAB = 1; // Same-Type attack bonus

        //Todo implement stab
        if(attackingPokemon.get_typeTwo().equals(move.getType()) || attackingPokemon.get_typeOne().equals(move.getType())){
            STAB = 1.5;
        }

        System.out.println();


        int damage = (int) (((((2 * level / 5 + 2) * attackStat * movePower / enemyDefense) / 50) + 2)
                * STAB * effectiveness * randomNumber / 100);

        System.out.println("damage: " +damage);
        return damage;
    }

    //Todo
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
            return pokemon.getSpecialAttack();
        } else {
            return pokemon.getAttack();
        }
    }

    // Calculates the defense stat based on the type of move
    public static int getDefenseStat(Move move, Pokemon pokemon) {
        if (move.getCategory().equals("Special")) {
            return pokemon.getSpecialDefense();
        } else {
            return pokemon.getDefense();
        }
    }
}

