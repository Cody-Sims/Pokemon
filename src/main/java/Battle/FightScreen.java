package Battle;

import MoveCatalog.Move;
import Pokemon.Pokemon;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


import static Battle.BattleConstants.SCREEN_HEIGHT;
import static Battle.BattleConstants.SCREEN_WIDTH;
import static Battle.Mechanics.CalculateDamage.calculateDamage;
import static Battle.Mechanics.CalculateDamage.enemyAttack;


public class FightScreen {
    Pane _root;
    Pane _fightScreenPane;

    //Keeps track of the ongoing battle
    Battle _curBattle;

    Pokemon _playerPokemon;
    Pokemon _enemyPokemon;

    int _playerCurrentHP;
    int _enemyCurrentHP;

    Move _move1;
    Move _move2;
    Move _move3;
    Move _move4;

    // The root pane is the pane that the FightScreen is placed on
    // playerPokemon is used to keep track of the moves that the pokemon can use
    public FightScreen(Pane root, Pokemon playerPokemon, Pokemon enemyPokemon, Battle curBattle){
        _root = root;
        _playerPokemon = playerPokemon;
        _enemyPokemon = enemyPokemon;
        _curBattle = curBattle;
        _playerCurrentHP = _playerPokemon.getCurrentHP();
        _enemyCurrentHP = _enemyPokemon.getCurrentHP();
        _fightScreenPane = new Pane();
        _fightScreenPane.setPrefSize(SCREEN_WIDTH, SCREEN_HEIGHT / 5);

        _move1 = _playerPokemon.getMoveOne();
        _move2 = _playerPokemon.getMoveTwo();
        _move3 = _playerPokemon.getMoveThree();
        _move4 = _playerPokemon.getMoveFour();
        createScreen();
    }

    //Todo (Priority Lowish)
    // Visual changes. Move attack menu to left part of screen
    public void createScreen(){
        Rectangle window = new Rectangle(SCREEN_WIDTH, SCREEN_HEIGHT / 5);
        window.setY(SCREEN_HEIGHT - (SCREEN_HEIGHT / 5) - 30);
        window.setStroke(Color.GRAY);
        window.setStrokeWidth(8);
        window.setFill(Color.LIGHTCYAN);

        Rectangle buttonWindow = new Rectangle(SCREEN_WIDTH / 2, SCREEN_HEIGHT /5);
        buttonWindow.setX(SCREEN_WIDTH / 2);
        buttonWindow.setY(SCREEN_HEIGHT - (SCREEN_HEIGHT / 5) - 30);
        buttonWindow.setStroke(Color.GRAY);
        buttonWindow.setStrokeWidth(8);
        buttonWindow.setFill(Color.rgb(212, 255, 223));

        Button move1Button = new Button(_move1.getName());
        move1Button.setLayoutX(SCREEN_WIDTH / 2 + 5);
        move1Button.setLayoutY(SCREEN_HEIGHT - (SCREEN_HEIGHT / 5) - 25);
        move1Button.setMinSize(SCREEN_WIDTH / 4 - 5,SCREEN_HEIGHT / 10 - 5);
        move1Button.setOnAction(e -> attack(_move1));

        _fightScreenPane.getChildren().addAll(window, buttonWindow, move1Button);
        if(_move2 != null){
            Button move2Button = new Button(_move2.getName());
            move2Button.setLayoutX(SCREEN_WIDTH / 2 + SCREEN_WIDTH / 4);
            move2Button.setLayoutY(SCREEN_HEIGHT - (SCREEN_HEIGHT / 5) - 25);
            move2Button.setMinSize(SCREEN_WIDTH / 4 - 5,SCREEN_HEIGHT / 10 - 5);
            move2Button.setOnAction(e -> attack(_move2));
            _fightScreenPane.getChildren().add(move2Button);
        }

        if(_move3 != null){
            Button move3Button = new Button(_move3.getName());
            move3Button.setLayoutX(SCREEN_WIDTH / 2 + 5);
            move3Button.setLayoutY(SCREEN_HEIGHT - (SCREEN_HEIGHT / 10) - 30);
            move3Button.setMinSize(SCREEN_WIDTH / 4 - 5,SCREEN_HEIGHT / 10 - 5);
            move3Button.setOnAction(e -> attack(_move3));
            _fightScreenPane.getChildren().add(move3Button);
        }

        if(_move4 != null){
            Button move4Button = new Button(_move4.getName());
            move4Button.setLayoutX(SCREEN_WIDTH / 2 + SCREEN_WIDTH / 4);
            move4Button.setLayoutY(SCREEN_HEIGHT - (SCREEN_HEIGHT / 10) - 30);
            move4Button.setMinSize(SCREEN_WIDTH / 4 - 5,SCREEN_HEIGHT / 10 - 5);
            move4Button.setOnAction(e -> attack(_move4));
            _fightScreenPane.getChildren().add(move4Button);
        }
    }

    // Occurs when a button is clicked. The input is a move that will be used to calculate the damage given
    // to the receiving pokemon
    // Todo Faint detection
    public void attack(Move move){
        // Faster Pokemon Moves First
        if(_playerPokemon.getBattleSpeed() >= _enemyPokemon.getBattleSpeed()){
            _enemyCurrentHP -= calculateDamage(move, _playerPokemon, _enemyPokemon);
            _playerCurrentHP -= calculateDamage(enemyAttack(_enemyPokemon), _enemyPokemon, _playerPokemon);
        }
        else{
            _playerCurrentHP -= calculateDamage(enemyAttack(_enemyPokemon), _enemyPokemon, _playerPokemon);
            _enemyCurrentHP -= calculateDamage(move, _playerPokemon, _enemyPokemon);
        }

        // Update HP
        _enemyPokemon.set_currentHP(_enemyCurrentHP);
        _playerPokemon.set_currentHP(_playerCurrentHP);

        hideScreen(); // Hides fight screen but doesn't remove it for faster performance
        _curBattle.updateScene(); //Updates Pokemons' current health and returns back to defaultbattle screen

        //TODO Create a transition screen. Something like playerPokemon attacked using moveName!
        // showTransitionScreen()
    }

    // adds screen to pane
    public void showScreen(){
        // Error catching in case the fight button is double clicked before it loads
        try {
            _root.getChildren().add(_fightScreenPane);
        }
        catch (Exception IllegalArgumentException) {
            System.out.println("You can't add the fight pane when it has already been added");
        }
    }

    // This will be used to remove the fightScreen from mainPane after the move is selected
    // Todo implement a transition screen. Ie, pikachu used thunderbolt, the enemy's charmander use flamethrower, etc
    public void hideScreen(){ _root.getChildren().remove(_fightScreenPane); }
}
