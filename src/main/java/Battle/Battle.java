package Battle;

import Pokemon.Pokemon;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import javafx.scene.image.ImageView;

import static Battle.BattleConstants.SCREEN_HEIGHT;
import static Battle.BattleConstants.SCREEN_WIDTH;

public class Battle {
    Pane _root;
    Pokemon _playerPokemon;
    Pokemon _enemyPokemon;

    int _playerHP;
    int _enemyHP;

    Pane _battlePane;
    Pane _bottomPane;
    Pane _playerPane;
    Pane _enemyPane;


    //todo create the screens for these buttons
    //Todo: Create an bagScreen
    FightScreen _fightScreen;
    BagScreen _bagScreen;
    PokemonScreen _pokemonScreen = new PokemonScreen();

    public Battle(Pane root, Pokemon playerPokemon, Pokemon enemyPokemon){
        //Set instance variables
        _playerPokemon = playerPokemon;
        _enemyPokemon = enemyPokemon;
        _root = root;

        //Instantiate Battle Screens
        _fightScreen = new FightScreen(_root, playerPokemon, enemyPokemon, this);

        // Instantiate Panes
        _battlePane = new Pane();
        _bottomPane = new Pane();
        _playerPane = new Pane();
        _enemyPane = new Pane();

        //Instantiate Health
        _playerPokemon.setCurrentHP(_playerPokemon.getHP()); //Resets current HP to max HP at start of battle
        _playerHP =_playerPokemon.getHP();

        _enemyPokemon.setCurrentHP(_enemyPokemon.getHP()); //Resets current HP to max HP at start of battle
        _enemyHP = _enemyPokemon.getCurrentHP();

        _root.getChildren().add(_battlePane);
        _battlePane.getChildren().addAll(_bottomPane,_playerPane, _enemyPane);

        updateScene();
    }

    // Updates the scene with new information after a turn.
    public void updateScene(){
        _battlePane = new Pane();
        addBottomPane();
        addPlayerPane(_playerPokemon.getCurrentHP());
        addPlayerPokemon();
        addEnemyPane(_enemyPokemon.getCurrentHP());
        addEnemyPokemon();
    }

    // Adds a pane to the bottom that controls the battle
    private void addBottomPane(){
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

        Button fightButton = new Button("Fight");
        fightButton.setLayoutX(SCREEN_WIDTH / 2 + 5);
        fightButton.setLayoutY(SCREEN_HEIGHT - (SCREEN_HEIGHT / 5) - 25);
        fightButton.setMinSize(SCREEN_WIDTH / 4 - 5,SCREEN_HEIGHT / 10 - 5);
        fightButton.setOnAction(e -> _fightScreen.showScreen());

        Button bagButton = new Button("Bag");
        bagButton.setLayoutX(SCREEN_WIDTH / 2 + SCREEN_WIDTH / 4);
        bagButton.setLayoutY(SCREEN_HEIGHT - (SCREEN_HEIGHT / 5) - 25);
        bagButton.setMinSize(SCREEN_WIDTH / 4 - 5,SCREEN_HEIGHT / 10 - 5);
        bagButton.setOnAction(e -> _bagScreen.showBagScreen());

        Button pokemonButton = new Button("Pokemon");
        pokemonButton.setLayoutX(SCREEN_WIDTH / 2 + 5);
        pokemonButton.setLayoutY(SCREEN_HEIGHT - (SCREEN_HEIGHT / 10) - 30);
        pokemonButton.setMinSize(SCREEN_WIDTH / 4 - 5,SCREEN_HEIGHT / 10 - 5);


        Button runButton = new Button("Run");
        runButton.setLayoutX(SCREEN_WIDTH / 2 + SCREEN_WIDTH / 4);
        runButton.setLayoutY(SCREEN_HEIGHT - (SCREEN_HEIGHT / 10) - 30);
        runButton.setMinSize(SCREEN_WIDTH / 4 - 5,SCREEN_HEIGHT / 10 - 5);
        runButton.setOnAction(e -> System.exit(0)); //Todo exit to overworld


        _bottomPane.getChildren().addAll(window, buttonWindow, fightButton, bagButton, pokemonButton, runButton);

    }

    // Adds a pane containing opponent's information at the bottom left
    private void addPlayerPane(int remainingHP){
        Rectangle window = new Rectangle(100, 100);
        window.setX(SCREEN_WIDTH - 130);
        window.setY(SCREEN_HEIGHT - 210 - 100);
        window.setStroke(Color.GRAY);
        window.setStrokeWidth(8);
        window.setFill(Color.BEIGE);

        Text name = new Text(SCREEN_WIDTH - 100, SCREEN_HEIGHT - 275, _playerPokemon.getName());
        Text hp = new Text(SCREEN_WIDTH - 100, SCREEN_HEIGHT - 250, remainingHP + " / " +
                _playerPokemon.getHP());
        Text level = new Text(SCREEN_WIDTH - 100, SCREEN_HEIGHT - 225, String.valueOf(_playerPokemon.getLevel()));
        _playerPane.getChildren().addAll(window, name, hp, level);
    }

    // Adds the player's pokemon to the bottom left of the screen. The player's pokemon faces forward
    private void addPlayerPokemon(){
       ImageView playerView = new ImageView(_playerPokemon.getImageBack());
       playerView.setX(10);

       int yOffset = _playerPokemon.getImageBackHeight() - 8;
       playerView.setY(SCREEN_HEIGHT - SCREEN_HEIGHT / 4 - yOffset);
       _root.getChildren().add(playerView);
    }

    // Adds a pane containing opponent's information at the top right
    private void addEnemyPane(int remainingHP){
        Rectangle window = new Rectangle(125, 100);
        window.setX(25);
        window.setY(25);
        window.setStroke(Color.GRAY);
        window.setStrokeWidth(8);
        window.setFill(Color.BEIGE);

        Text name = new Text(50, 50, _enemyPokemon.getName());
        Text hp = new Text( 50, 75, remainingHP + " / " + _enemyPokemon.getHP());
        Text level = new Text(50, 100, String.valueOf(_enemyPokemon.getLevel()));
        _enemyPane.getChildren().addAll(window, name, hp, level);
    }

    // Adds the enemy pokemon to the top right of the screen. The enemy's pokemon faces forward
    private void addEnemyPokemon(){
        ImageView enemyView = new ImageView(_enemyPokemon.getImageFront());
        enemyView.setX(SCREEN_WIDTH - 450 + _enemyPokemon.getImageFront().getWidth());
        int yOffset = _playerPokemon.getImageBackHeight() - 8;
        enemyView.setY(200 - yOffset);
        _root.getChildren().add(enemyView);
    }
}
