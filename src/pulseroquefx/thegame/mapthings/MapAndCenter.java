package pulseroquefx.thegame.mapthings;

import java.awt.Point;

/**
 *
 * @author Qmppu842
 */
public class MapAndCenter {

    private Point pPos;
    private Tile[][] map;

    public MapAndCenter(Point pPos, Tile[][] map) {
        this.pPos = pPos;
        this.map = map;
    }

    public Point getPPos() {
        return pPos;
    }

    public char[][] getFlattedMap() {
        char[][] flatMap = new char[map.length][map[0].length];
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                flatMap[y][x] = map[y][x].peekSymbol();
            }
        }
        return flatMap;
    }

    public int getCenterX() {
        return pPos.x;
    }

    public int getCenterY() {
        return pPos.y;
    }

}
