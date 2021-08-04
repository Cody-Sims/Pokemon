package App;

import Battle.PaneOrganizer;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameScene;

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
        getGameScene().addUINode(new PaneOrganizer().getRoot()); // add battle to the game
    }

    public static void main(String[] args) {
        // launch is a method inherited from Application
        launch(args);
    }
}
