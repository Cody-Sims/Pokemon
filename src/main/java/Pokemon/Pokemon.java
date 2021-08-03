package Pokemon;

import MoveCatalog.Move;
import javafx.scene.image.Image;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static Pokemon.Constants.POKEMON_HEIGHT;
import static Pokemon.Constants.POKEMON_WIDTH;
import static Pokemon.PokemonStatConstants.*;

public class Pokemon {
    // Classification
    private String _name;
    private int _pokedexNumber;

    // Moves
    String[][] _learnableMoves;
    Move _moveOne;
    Move _moveTwo;
    Move _moveThree;
    Move _moveFour;

    //Type
    private String _typeOne;
    private String _typeTwo;

    // Base Statistics
    private int _baseTotal;
    private int _baseHp;
    private int _baseAttack;
    private int _baseDefense;
    private int _baseSpecialAttack;
    private int _baseSpecialDefense;
    private int _baseSpeed;

    // cur Statistics
    private int _total;
    private int _hp;
    private int _attack;
    private int _defense;
    private int _specialAttack;
    private int _specialDefense;
    private int _speed;

    // Ivs
    private int _hpIv = 0;
    private int _attackIv = 0;
    private int _defenseIv = 0;
    private int _specialAttackIv = 0;
    private int _specialDefenseIv = 0;
    private int _speedIv = 0;

    // Evs
    private int _hpEv = 0;
    private int _attackEv = 0;
    private int _defenseEv = 0;
    private int _specialAttackEv = 0;
    private int _specialDefenseEv = 0;
    private int _speedEv = 0;


    //Battle Handling;
    private int _currentHP;
    private int _level;

    // Image Handling
    private Image _imgFront;
    private Image _imgBack;
    private int _imgFrontHeight;
    private int _imgBackHeight;


    // Constructs the pokemon based on it's pokedex number
    //Todo create a random Pokemon initializer class with parameters
    //Todo instantiate pokemon stats
    public Pokemon(int pokedexNumber) {
        _pokedexNumber = pokedexNumber;
        _level = 50;
        createPokemon();
        _currentHP = _hp;
        printStats();
    }

    // Instantiates the pokemon
    public void createPokemon(){
        setImageFront();
        setImageBack();
        setBaseStats();
        calculateStats();
        findLearnableMoves();
        setRandomMoves();
    }

    //Todo calculate stats and check for new moves

    public void calculateStats(){
        _hp = (int)(Math.floor(0.01 * (2 * _baseHp + _baseHp + _hpIv + Math.floor(0.25 * _hpEv)) * _level) + _level + 10);

        _attack = (int)(Math.floor(0.01 * (2 * _baseAttack + _attackIv + Math.floor(0.25 * _attackEv)) * _level) + 5);
        _defense = (int)(Math.floor(0.01 * (2 * _baseDefense + _defenseIv + Math.floor(0.25 * _defenseEv)) * _level) + 5);
        _specialAttack = (int)(Math.floor(0.01 * (2 * _baseSpecialAttack + _specialAttackIv + Math.floor(0.25 * _specialAttackEv)) * _level) + 5);
        _specialDefense = (int)(Math.floor(0.01 * (2 * _baseSpecialAttack + _specialDefenseIv + Math.floor(0.25 * _specialDefenseEv)) * _level) + 5);
        _speed= (int)(Math.floor(0.01 * (2 * _baseSpeed + _speedIv + Math.floor(0.25 * _speedEv)) * _level) + 5);
    }

    public void findLearnableMoves(){
        _learnableMoves = new String[20][2];
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/LearnableMoves/"+ _name +".csv"))) {
            br.readLine();
            for(int i = 0; i < _learnableMoves.length; i++) {
                String row = br.readLine();
                for(int j = 0; j < _learnableMoves[i].length; j++){
                    if(row != null){
                        String[] stats = row.split(",");
                        _learnableMoves[i][j] = stats[j];
                    }
                    else{
                        _learnableMoves[i][j] = null;
                    }
                }
            }
        }
        catch(IOException e){
            System.out.println("Error parsing Moves");
        }
    }

    // Sets Current Moves to most recently learned moves up to four moves.
    private void setRandomMoves(){
        ArrayList<String> moves = new ArrayList<>();
        for (String[] learnableMove : _learnableMoves) {
            if (learnableMove[0] != null && Double.parseDouble(learnableMove[0]) < _level) {
                moves.add(learnableMove[1]);
            }
        }

        if(moves.size() >= 1){
            _moveOne = new Move(moves.get(moves.size() - 1));
        }
        if(moves.size() >= 2){
            _moveTwo = new Move(moves.get(moves.size() - 2));
        }
        if(moves.size() >= 3){
            _moveThree = new Move(moves.get(moves.size() - 3));
        }
        if(moves.size() >= 4){
            _moveFour = new Move(moves.get(moves.size() - 4));
        }
    }

    private void setImageFront(){
        _imgFront = new Image("PokemonSprites/front/" + _pokedexNumber +".png", POKEMON_WIDTH, POKEMON_HEIGHT,
                true, false);
        _imgFrontHeight = (int)_imgFront.getHeight();
    }
    private void setImageBack(){
        _imgBack = new Image("PokemonSprites/Back/" + _pokedexNumber +".png", POKEMON_WIDTH, POKEMON_HEIGHT,
                true, false);
        _imgBackHeight = (int)_imgBack.getHeight();
    }

    // Used for setting the pokemon's name based on the pokedex number
    private void setBaseStats() {
        _name = POKEMON_NAMES.get(_pokedexNumber);
        _typeOne = POKEMON_TYPE_ONE.get(_pokedexNumber);
        _typeTwo = POKEMON_TYPE_TWO.get(_pokedexNumber);

        // Base Stats
        _baseTotal = Integer.parseInt(POKEMON_TOTAL.get(_pokedexNumber));
        _baseHp = Integer.parseInt(POKEMON_HP.get(_pokedexNumber));
        _baseAttack = Integer.parseInt(POKEMON_ATTACK.get(_pokedexNumber));
        _baseDefense = Integer.parseInt(POKEMON_DEFENSE.get(_pokedexNumber));
        _baseSpecialAttack = Integer.parseInt(POKEMON_SPECIAL_ATTACK.get(_pokedexNumber));
        _baseSpecialDefense = Integer.parseInt(POKEMON_SPECIAL_DEFENSE.get(_pokedexNumber));
        _baseSpeed = Integer.parseInt(POKEMON_SPEED.get(_pokedexNumber));

    }

    public void set_currentHP(int _currentHP) {
        this._currentHP = _currentHP;
    }

    public int getCurrentHP() {
        return _currentHP;
    }

    public String getName(){ return _name; }

    public int getHP() {
        return _hp;
    }

    public String get_typeOne() {
        return _typeOne;
    }

    public String get_typeTwo() {
        return _typeTwo;
    }

    public int getAttack(){ return _attack;}

    public int getDefense(){ return _defense;}

    public int getSpecialAttack(){ return _attack;}

    public int getSpecialDefense(){ return _specialDefense;}

    public int getSpeed(){return _speed;}

    public int getLevel() {
        return _level;
    }

    public Move getMoveOne(){
        return _moveOne;
    }

    public Move getMoveTwo(){
        return _moveTwo;
    }

    public Move getMoveThree(){
        return _moveThree;
    }

    public Move getMoveFour(){
        return _moveFour;
    }

    // Returns a front view of the pokemon
    public Image getImageFront() {
        return _imgFront;
    }

    public int getImageFrontHeight() {
        return _imgFrontHeight;
    }

    // Returns a back view of the pokemon
    public Image getImageBack() {
        return _imgBack;
    }

    // Used for snapping image to border
    public int getImageBackHeight() {
        return _imgBackHeight;
    }

    // Used for debugging
    public void printStats(){
        System.out.println("HP: " + _hp);
        System.out.println("Attack: " + _attack);
        System.out.println("Defense: " + _defense);
        System.out.println("Special Attack: " + _specialAttack);
        System.out.println("Special Defense: " + _specialDefense);
        System.out.println("Speed: " + _speed);
    }
}
