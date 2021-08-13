package Overworld;
import Battle.PaneOrganizer;
import com.almasb.fxgl.particle.ParticleSystem;
import com.almasb.fxgl.scene.SubScene;

import static com.almasb.fxgl.dsl.FXGL.*;


public class battleScreen extends SubScene {

    public battleScreen() {
        var scene = new PaneOrganizer().getRoot();
        getContentRoot().getChildren().addAll(scene);
    }
}