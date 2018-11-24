package pulseroquefx;

import javafx.application.Application;
import javafx.scene.Scene;
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
        char[][] map = new char[41][41];
        for (int y = 0; y < 41; y++) {
            for (int x = 0; x < 41; x++) {
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
        gs.draw(map, 23, 30);
        
        Scene scene = gs.getScene();
    
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
