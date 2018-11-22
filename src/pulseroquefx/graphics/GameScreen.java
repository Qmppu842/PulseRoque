package pulseroquefx.graphics;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Qmppu842
 */
public class GameScreen {

    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 800;
    private static final int TILES_IN_SCREEN_WIDTH = 70;
    private static final int TILES_IN_SCREEN_HEIGHT = 60;

    private double gridWidth = SCENE_WIDTH / TILES_IN_SCREEN_WIDTH;
    private double gridHeight = SCENE_HEIGHT / TILES_IN_SCREEN_HEIGHT;

    private Stage stage;
    private Scene scene;
    private Group root;

    public GameScreen(Stage stage) {
        this.stage = stage;
    }

    public void start() {
        root = new Group();
        
        
        scene = new Scene(root,SCENE_WIDTH, SCENE_HEIGHT);
        stage.setScene(scene);
        stage.show();
        
        stage.setTitle("PulseRoque");
                
    }
    
    public void draw(char[][] map, int centerX, int centerY){
        
    }

}
