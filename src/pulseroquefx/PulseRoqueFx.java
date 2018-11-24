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
        char[][][] map = new char[41][41][1];
        for (int y = 0; y < 41; y++) {
            for (int x = 0; x < 41; x++) {
                char sym = 'v';
                if (x > 30) {
                    sym = 'x';
                } else if (x > 15) {
                    sym = 'a';
                }
                map[y][x][0] = sym;
            }
        }
        gs.draw(map, 40, 40, 0);
        char[][][] test = {
            {
                {'k', 'p', 's'},
                {'1', '2', '3'}
            },
            {
                {'g', 'd', 'r'},
                {'5', '6', '7'}
            }
        };
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
