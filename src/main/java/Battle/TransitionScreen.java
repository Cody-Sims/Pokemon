package Battle;

import MoveCatalog.Move;
import Pokemon.Pokemon;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static Battle.BattleConstants.SCREEN_HEIGHT;
import static Battle.BattleConstants.SCREEN_WIDTH;

public class TransitionScreen {
    Pane _transitionScreenPane;
    Pane _root;
    Pokemon _playerPokemon;
    Pokemon _enemyPokemon;
    Battle _curBattle;
    Move _move;

    public TransitionScreen(Pane root, Pokemon playerPokemon, Pokemon enemyPokemon, Battle curBattle, Move move){
        _root = root;
        _playerPokemon = playerPokemon;
        _enemyPokemon = enemyPokemon;
        _curBattle = curBattle;
        _move = move;
        _transitionScreenPane = new Pane();
        _root.getChildren().add(_transitionScreenPane);
        createTransitionScreen();
    }

    public void createTransitionScreen(){
        Rectangle transition = new Rectangle(SCREEN_WIDTH, SCREEN_HEIGHT/5);
        transition.setY(SCREEN_HEIGHT - (SCREEN_HEIGHT / 5) - 30);
        transition.setStroke(Color.GRAY);
        transition.setStrokeWidth(8);
        transition.setFill(Color.rgb(255, 175, 175));
        _transitionScreenPane.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                removeScreen();
            }
        });
        Text text;
        if(_enemyPokemon.getTypeOne().getWeaknesses().contains((_move.getType())) ||
                _enemyPokemon.getTypeTwo().getWeaknesses().contains((_move.getType()))){
            text = new Text(0, (SCREEN_HEIGHT-(SCREEN_HEIGHT/5) - 30),
                    _playerPokemon.getName() + " used " + _move.getName() + ". It was super effective!");
        }
        else if(_enemyPokemon.getTypeOne().getImmunities().contains(_move.getType())
                || _enemyPokemon.getTypeTwo().getImmunities().contains(_move.getType())){
            text = new Text(0, (SCREEN_HEIGHT-(SCREEN_HEIGHT/5) - 30),
                    _playerPokemon.getName() + " used " + _move.getName() + ". It had no effect!");
        }
        else if(_enemyPokemon.getTypeOne().getStrengths().contains(_move.getType())
                || _enemyPokemon.getTypeTwo().getStrengths().contains(_move.getType())){
            text = new Text(0, (SCREEN_HEIGHT-(SCREEN_HEIGHT/5) - 30),
                    _playerPokemon.getName() + " used " + _move.getName() + ". It was not very effective!");
        }

        else {
            text = new Text(0, (SCREEN_HEIGHT-(SCREEN_HEIGHT/5) - 30),
                    _playerPokemon.getName() + " used " + _move.getName());
            }

        if(_move.getEffect() != null){
            text = new Text(0, (SCREEN_HEIGHT - (SCREEN_HEIGHT / 5) - 30), _move.getEffect().getText(_playerPokemon, _move));
        }
        else if(_move.getOpponentEffect() != null){
            text = new Text(0, (SCREEN_HEIGHT - (SCREEN_HEIGHT / 5)), _move.getOpponentEffect()
                    .getText(_playerPokemon, _enemyPokemon,_move));
        }

        text.setX(100);
        text.setY(SCREEN_HEIGHT - (SCREEN_HEIGHT/5));
        text.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 30));
        text.setWrappingWidth(600);

        _transitionScreenPane.getChildren().addAll( transition, text);
    }



    public void removeScreen(){ _root.getChildren().remove(_transitionScreenPane);}
}
