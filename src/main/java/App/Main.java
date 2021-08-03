package App;

import Battle.PaneOrganizer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        PaneOrganizer organizer = new PaneOrganizer();

        Scene scene = new Scene(organizer.getRoot());
        stage.setScene(scene);

        stage.setTitle("src/main/pokemon/Pokemon");
        stage.show();

    }

    /*
     * Here is the mainline! No need to change this.
     */
    public static void main(String[] argv) {
        // launch is a method inherited from Application
        launch(argv);
    }
}
