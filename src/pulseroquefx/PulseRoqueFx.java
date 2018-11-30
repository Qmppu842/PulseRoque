package pulseroquefx;

import java.awt.Point;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pulseroquefx.graphics.GameScreen;
import pulseroquefx.thegame.CoreGame;

/**
 *
 * @author Qmppu842
 */
public class PulseRoqueFx extends Application {

    @Override
    public void start(Stage primaryStage) {
        CoreGame game = new CoreGame();
        GameScreen gs = new GameScreen(primaryStage);
        gs.start();
        gs.draw(game.idle());

        Scene scene = gs.getScene();
        scene.setOnKeyPressed(event -> {
            int x = 0;
            int y = 0;
            if (event.getCode() == KeyCode.A) {
                x = -1;

            }
            if (event.getCode() == KeyCode.D) {
                x = 1;
            }
            if (event.getCode() == KeyCode.W) {
                y = -1;
            }
            if (event.getCode() == KeyCode.S) {
                y = 1;
            }
            if (x == 0 && y == 0) {
                gs.draw(game.idle());
            } else {
                gs.draw(game.move(x, y));
            }
        });

        scene.setOnMouseClicked(event -> {
            event.getX();
            int trueX = (int) Math.floor(gs.figureMapX(event.getX()));
            int trueY = (int) Math.floor(gs.figureMapY(event.getY()));

            Point localPPos = gs.getLocalPPos();
            gs.draw(game.move(trueX - localPPos.x, trueY - localPPos.y));
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
