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
        int size = 5;
        char[][] map = new char[size][size];
        for (int y = 0; y < size - 1; y++) {
            for (int x = 0; x < size - 1; x++) {
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
        for (int i = 0; i < size; i++) {
            map[size - 1][i] = '#';
            map[i][size - 1] = '#';
        }
        gs.draw(map, xx, yy);

        Scene scene = gs.getScene();
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.A) {
                xx--;
                xx = Math.max(xx, 0);
//                gs.draw(map, xx, yy);
            }
            if (event.getCode() == KeyCode.D) {
                xx++;
                xx = Math.min(xx, map.length - 1);
//                gs.draw(map, xx, yy);
            }
            if (event.getCode() == KeyCode.W) {
                yy--;
                yy = Math.max(yy, 0);
//                gs.draw(map, xx, yy);
            }
            if (event.getCode() == KeyCode.S) {
                yy++;
                yy = Math.min(yy, map.length - 1);
            }
            System.out.println("xx: " + xx + ", yy: " + yy);
            gs.draw(map, xx, yy);
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
