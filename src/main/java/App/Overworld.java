package App;

import Battle.PaneOrganizer;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.CollisionHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


import Overworld.battleScreen;

import java.util.Map;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameScene;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getPhysicsWorld;

public class Overworld extends GameApplication {
    @Override
    protected void initSettings(GameSettings settings){
        settings.setWidth(800);
        settings.setHeight(800);
        settings.setTitle("Pokemon");
        settings.setVersion("Beta 0.1");
    }

    @Override
    protected void initUI() {
        //getGameScene().addUINode(new PaneOrganizer().getRoot()); // add battle to the game
    }

    public enum EntityType {
        PLAYER, TRAINER
    }

    private Entity player;
    @Override
    protected void initGame() {
        player = FXGL.entityBuilder()
                .type(EntityType.PLAYER)
                .at(300, 300)
                .viewWithBBox(new Rectangle(25, 25, Color.BLUE))
                .with(new CollidableComponent(true))
                .buildAndAttach();

        FXGL.entityBuilder()
                .type(EntityType.TRAINER)
                .at(500, 200)
                .viewWithBBox(new Circle(15, 15, 15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach();

    }

    @Override
    protected void initPhysics(){
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(EntityType.PLAYER, EntityType.TRAINER) {
            @Override
            protected void onCollisionBegin(Entity player, Entity trainer) {
                FXGL.getSceneService().pushSubScene(new battleScreen());
                player.removeFromWorld();
                trainer.removeFromWorld();
            }
        });
    }


    // Global Variables that get updated during gameplay
    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("pixelsMoved", 0);
        //Current Pokemon
        //inBattle
    }


    @Override
    protected void initInput() {
        FXGL.onKey(KeyCode.D, () -> {
            player.translateX(5); // move right 5 pixels
        });
        FXGL.onKey(KeyCode.A, () -> {
            player.translateX(-5); // move left 5 pixels
        });
        FXGL.onKey(KeyCode.W, () -> {
            player.translateY(-5); // move up 5 pixels
        });
        FXGL.onKey(KeyCode.S, () -> {
            player.translateY(5); // move down 5 pixels
        });
    }

    public static void main(String[] args) {
        // launch is a method inherited from Application
        launch(args);
    }
}
