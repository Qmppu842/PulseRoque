package pulseroquefx;

import javafx.application.Application;
import javafx.stage.Stage;
import pulseroquefx.graphics.GameScreen;

/**
 *
 * @author Qmppu842
 */
public class PulseRoqueFx extends Application {

    @Override
    public void start(Stage primaryStage) {
        GameScreen gs = new GameScreen(primaryStage);
        gs.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
