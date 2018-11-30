package pulseroquefx.thegame;

import pulseroquefx.thegame.mapthings.mapAndCenter;
import java.awt.Point;
import pulseroquefx.thegame.mapthings.Tile;

/**
 *
 * @author Qmppu842
 */
public class CoreGame {

    private int size;
    private Point pPos;
    private Tile[][] map2;

    public CoreGame() {
        pPos = new Point(1, 1);
        size = 50;
        initBasicMap();
    }

    public void initBasicMap() {
        map2 = new Tile[size][size];
        char floor = '.';
        for (int y = 0; y < size - 1; y++) {
            for (int x = 0; x < size - 1; x++) {
                map2[y][x] = new Tile(true, floor);
            }
        }
        char wall = '#';
        for (int i = 0; i < size; i++) {
            map2[size - 1][i] = new Tile(false, wall);
            map2[i][size - 1] = new Tile(false, wall);
            map2[0][i] = new Tile(false, wall);
            map2[i][0] = new Tile(false, wall);
        }
        map2[pPos.y][pPos.x].setCurrentSymbol('@');
    }

    //TODO: Istead of coregame commanding player directly, there should be Player class that has distinct actions.
    //And then coreGame should have method turn that goes through list of things that have turns.
    public mapAndCenter idle() {
        return new mapAndCenter(pPos, map2);
    }

    public mapAndCenter move(int x, int y) {
        return move(new Point(x, y));
    }

    /**
     * Moves player to location of dir.
     *
     * @param dir
     * @return
     */
    public mapAndCenter move(Point dir) {
        Point oldLoc = (Point) pPos.clone();
        pPos.translate(dir.x, dir.y);

        Tile target = map2[pPos.y][pPos.x];
        Tile oldLocation = map2[oldLoc.y][oldLoc.x];
        if (target.isIsPassable()) {
            char thignToMove = oldLocation.popSymbol();
            target.setCurrentSymbol(thignToMove);
            oldLocation.setCurrentSymbol('x');
        }

        return new mapAndCenter(pPos, map2);
    }
}
