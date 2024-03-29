package pulseroquefx.graphics;

import java.awt.Font;
import java.awt.Point;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import pulseroquefx.thegame.mapthings.MapAndCenter;

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
    private static final int TILES_IN_SCREEN_WIDTH = 71 - 50;
    private static final int TILES_IN_SCREEN_HEIGHT = 71 - 50;

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
        initScreen();
//        defZoom();
//        root.maxWidth(800);
//        root.maxHeight(800);
//        int thing1;
//        int thing2;
//        Test that MyNode works
//        eka:
//        for (int y = 0; y < TILES_IN_SCREEN_HEIGHT - 50; y++) {
//            for (int x = 0; x < TILES_IN_SCREEN_WIDTH - 50; x++) {
//                MyNode node = new MyNode(x * gridWidth + boardOffset + 50, y * gridHeight + boardOffset + 50);
//                root.getChildren().add(node);
////                if (x * gridWidth > 800/root.getScaleX()) {
////                    break eka;
////                }
////                if (y * gridHeight > 800/root.getScaleY()) {
////                    break eka;
////                }
//
//            }
//        }

        scene = new Scene(root, SCENE_WIDTH + boardOffset + 10, SCENE_HEIGHT + boardOffset + 10);
        stage.setScene(scene);
        stage.show();

        stage.setTitle("PulseRoque");
//        //onMouseClick movement
//        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//            }
//        };
//        scene.setOnMousePressedProperty(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });

//                 this.setOnMouseEntered(new EventHandler<MouseEvent>() {
//
//                @Override
//                public void handle(MouseEvent t) {
//                    rect.setStroke(activeBorderColor);
//                }
//            });
    }
    private MyNode[][] screen;
    private int tilesInWidth = 21;//71;
    private int tilesInHeight = 21;//71;
    private int tileWidth;
    private int tileHeight;
    private int fontSize;
    private int zoomLevel = 3;
    private int boardOffset = 15;
    private Point localPPos;

    public void draw(MapAndCenter a) {
        draw(a.getFlattedMap(), a.getCenterX(), a.getCenterY());
    }

    public void draw(char[][] map, int centerX, int centerY) {
//        int yOffset = map.length - 1 - centerY + 10;
//        if (centerY + 10 > map.length) {
//
//        }
        int yMin = Math.max(centerY - 10, 0);
        int xMin = Math.max(centerX - 10, 0);
        int yMax = Math.min(map.length - 1, centerY + 10);
        int xMax = Math.min(map[yMin].length - 1, centerX + 10);

        if (yMin == 0) {
            yMax = Math.min(map.length - 1, yMin + 20);
        } else if (yMax == map.length - 1) {
            yMin = Math.max(yMax - 20, 0);
        }
        if (xMin == 0) {
            xMax = Math.min(map[yMin].length - 1, xMin + 20);
        } else if (xMax == map.length - 1) {
            xMin = Math.max(xMax - 20, 0);
        }

        for (int y = 0; y < tilesInHeight; y++) {
            for (int x = 0; x < tilesInWidth; x++) {
                if (y > yMax || x > xMax) {
                    screen[y][x].setVisible(false);
                } else //                if (x < xMax || y < yMax) 
                {
                    screen[y][x].getLabel().setText("" + map[yMin + y][xMin + x]);
                    screen[y][x].setVisible(true);

                if (map[yMin + y][xMin + x] == '@') {
                    localPPos = new Point(x, y);
                }
                }
//                else {
//                    screen[y][x].getLabel().setText("M");
//////                    screen[y][x].
//                }
            }
        }
    }
//will new gitIgnore work?

    private void initScreen() {
        screen = new MyNode[tilesInWidth][tilesInHeight];
        for (int y = 0; y < tilesInHeight; y++) {
            for (int x = 0; x < tilesInWidth; x++) {
                MyNode node = new MyNode(gridWidth * x, gridHeight * y);
                screen[y][x] = node;
                root.getChildren().add(node);
            }
        }

    }

    public double figureMapX(double x) {
        return (x - boardOffset) / gridWidth;
    }

    public double figureMapY(double y) {
        return (y - boardOffset) / gridHeight;
    }

    private void defZoom() {
        zoom(3);
    }

    private void zoom(int scale) {
        zoomLevel = scale;
        root.setScaleX(scale);
        root.setScaleY(scale);
        //Okkei... Scale confirmed offically as horrible...
        //At the time you can't get the real coordinates from anywhere.
        //So no matter what you do you are not able to cut after certain amount of pixels.
        //Oh nou. It is even wors than that. It scales from center not from upper left corner.
//        for (int y = 0; y < screen.length; y++) {
//            for (int x = 0; x < screen[y].length; x++) {
//
//            }
//        }
    }

    public Scene getScene() {
        return scene;
    }

    public Point getLocalPPos() {
        return localPPos;
    }

    private class MyNode extends StackPane {

        private Label label;
        private Color textColor;
        private Color backgroundColor;
        private Color borderColor;
        private Color activeBorderColor;
        private int fontSize;
        private Rectangle rect;
        private double x;
        private double y;
        private char symbol;

        public MyNode(double x, double y) {
            this.x = x;
            this.y = y;
            Color edit = Color.RED;//.deriveColor(1, 1, 1, 0.5);
            textColor = edit;
            borderColor = Color.BLACK;//Color.ALICEBLUE;
            activeBorderColor = Color.CHARTREUSE;
            fontSize = 40;

            rect = new Rectangle(gridWidth - 1, gridHeight - 1);
//            rect.setFill(Color.AQUA);
            rect.setStroke(borderColor);
            label = new Label("O");
            label.setFont(javafx.scene.text.Font.font(Font.MONOSPACED, fontSize));//15
//            label.setBackground(new Background(new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY)));
//            label.setBorder(Border.EMPTY);
//            edit.
            label.setTextFill(edit);
//            label
//            label.set
//            if (x > SCENE_WIDTH / zoomLevel) {
//                this.setVisible(false);
////                System.out.println("moiii");
//            }
//            if (y > SCENE_HEIGHT  / zoomLevel) {
//                this.setVisible(false);
//            }
            setTranslateX(x + boardOffset);
            setTranslateY(y + boardOffset);

//            getChildren().addAll(label);
            getChildren().addAll(rect, label);
            this.managedProperty().bind(this.visibleProperty());

            //onMouseHover Test
            this.setOnMouseEntered(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    rect.setStroke(activeBorderColor);
                }
            });

            this.setOnMouseExited(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    rect.setStroke(borderColor);
                }
            });

        }

        /*
         * TODO add method so screen can always draw all tiles and so it does
         * not need to init all the nodes again but just update them.
         */
        public Label getLabel() {
            return label;
        }

        public void setLabel(Label label) {
            this.label = label;
        }

        public Color getTextColor() {
            return textColor;
        }

        public void setTextColor(Color textColor) {
            this.textColor = textColor;
        }

        public Color getBackgroundColor() {
            return backgroundColor;
        }

        public void setBackgroundColor(Color backgroundColor) {
            this.backgroundColor = backgroundColor;
        }

        public Color getBorderColor() {
            return borderColor;
        }

        public void setBorderColor(Color borderColor) {
            this.borderColor = borderColor;
        }

        public int getFontSize() {
            return fontSize;
        }

        public void setFontSize(int fontSize) {
            this.fontSize = fontSize;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public void setSymbol(char symbol) {
            this.symbol = symbol;
        }

    }

}
