package pulseroquefx.graphics;

import java.awt.Font;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Qmppu842
 */
public class GameScreen {

    /**
     * TODO: Make basic zooming possible;
     */
    
    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 800;
    private static final int TILES_IN_SCREEN_WIDTH = 70;
    private static final int TILES_IN_SCREEN_HEIGHT = 60;

    private double gridWidth = SCENE_WIDTH / TILES_IN_SCREEN_WIDTH;
    private double gridHeight = SCENE_HEIGHT / TILES_IN_SCREEN_HEIGHT;

    private Stage stage;
    private Scene scene;
    private Group root;

    private MyNode[][] map;

    public GameScreen(Stage stage) {
        this.stage = stage;
        map = new MyNode[TILES_IN_SCREEN_WIDTH][TILES_IN_SCREEN_HEIGHT];
    }

    public void start() {
        root = new Group();

//        Test that MyNode works
        for (int y = 0; y < TILES_IN_SCREEN_HEIGHT; y++) {
            for (int x = 0; x < TILES_IN_SCREEN_WIDTH; x++) {
                MyNode node = new MyNode('m', x * gridWidth, y * gridHeight);
                root.getChildren().add(node);

            }
        }

        scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        stage.setScene(scene);
        stage.show();

        stage.setTitle("PulseRoque");

    }

    public void draw(char[][][] map, int centerX, int centerY, int centerZ) {

    }

    private class MyNode extends StackPane {

        public MyNode(char name, double x, double y) {
            Rectangle rect = new Rectangle(gridWidth, gridHeight);
//            rect.setFill(Color.AQUA);
            Label label = new Label(""+ name);
            label.setFont(javafx.scene.text.Font.font(Font.MONOSPACED));
//            label.setBackground(new Background(new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY)));
//            label.setBorder(Border.EMPTY);
            Color edit = Color.RED;//.deriveColor(1, 1, 1, 0.5);
//            edit.
            label.setTextFill(edit);
//            label.set
            setTranslateX(x);
            setTranslateY(y);

//            getChildren().addAll(label);
            getChildren().addAll(rect, label);

        }
        /**
         * TODO add method so screen can always draw all tiles and so it does
         * not need to init all the nodes again but just update them.
         */
    }

}
