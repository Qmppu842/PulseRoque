package pulseroquefx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import pulseroquefx.graphics.GameScreen;

/**
 *
 * @author Qmppu842
 */
public class PulseRoqueFx extends Application {

    int xx = 0;
    int yy = 0;

    @Override
    public void start(Stage primaryStage) {
        GameScreen gs = new GameScreen(primaryStage);
        gs.start();
        int size = 50;
        char[][] map = new char[size][size];
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                char sym = 'v';
                if (x > 30) {
                    sym = 'x';
                } else if (x > 15) {
                    sym = 'a';
                }
                if (y > 35) {
                    sym = 'O';
                }
                map[y][x] = sym;
            }
        }
        gs.draw(map, xx, yy);

        Scene scene = gs.getScene();
        scene.setOnKeyPressed(event -> {
            //KeyTypeds works with this:
//            if (event.getCharacter().equals("c")) {
//                System.out.println("moii");
//            }
            if (event.getCode() == KeyCode.A) {
                xx--;
                gs.draw(map, xx, yy);
            }
            if (event.getCode() == KeyCode.D) {
                xx++;
                gs.draw(map, xx, yy);
            }
            if (event.getCode() == KeyCode.W) {
                yy--;
                gs.draw(map, xx, yy);
            }
            if (event.getCode() == KeyCode.S) {
                yy++;
                gs.draw(map, xx, yy);
            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
