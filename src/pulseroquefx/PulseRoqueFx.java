package pulseroquefx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import pulseroquefx.graphics.GameScreen;
import pulseroquefx.thegame.CoreGame;

/**
 *
 * @author Qmppu842
 */
public class PulseRoqueFx extends Application {

    int xx = 0;
    int yy = 0;

    @Override
    public void start(Stage primaryStage) {
        CoreGame game = new CoreGame();
        GameScreen gs = new GameScreen(primaryStage);
        gs.start();

//        int size = 10;
//        char[][] map = new char[size][size];
//        for (int y = 0; y < size - 1; y++) {
//            for (int x = 0; x < size - 1; x++) {
//                char sym = '.';
////                if (x > 30) {
////                    sym = 'x';
////                } else if (x > 15) {
////                    sym = '✍';
////                }
////                if (y > 35) {
////                    sym = 'O';
////                }
//                map[y][x] = sym;
//            }
//        }
//        for (int i = 0; i < size; i++) {
////            map[size - 1][i] = '#';
////            map[i][size - 1] = '#';
//            map[size - 1][i] = '#';
//            map[i][size - 1] = '#';
//            map[0][i] = '#';
//            map[i][0] = '#';
//        }
//        gs.draw(map, xx, yy);
        gs.draw(game.idle());

        Scene scene = gs.getScene();
        scene.setOnKeyPressed(event -> {
//            System.out.println(event.getCode().toString());
            int x = 0;
            int y = 0;
            if (event.getCode() == KeyCode.A) {
                xx--;
//                xx = Math.max(xx, 0);
//                gs.draw(map, xx, yy);
                x = -1;

            }
            if (event.getCode() == KeyCode.D) {
                xx++;
//                xx = Math.min(xx, map.length - 1);
//                gs.draw(map, xx, yy);
                x = 1;
            }
            if (event.getCode() == KeyCode.W) {
                yy--;
//                yy = Math.max(yy, 0);
//                gs.draw(map, xx, yy);
                y = -1;
            }
            if (event.getCode() == KeyCode.S) {
                yy++;
//                yy = Math.min(yy, map.length - 1);
                y = 1;
            }
//            System.out.println("xx: " + xx + ", yy: " + yy);
//            gs.draw(map, xx, yy);
            if (x == 0 && y == 0) {
                gs.draw(game.idle());
            } else {
                gs.draw(game.move(x, y));
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
