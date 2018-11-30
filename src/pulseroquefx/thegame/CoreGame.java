package pulseroquefx.thegame;

import pulseroquefx.thegame.mapthings.mapAndCenter;
import java.awt.Point;

/**
 *
 * @author Qmppu842
 */
public class CoreGame {

    private char[][] map;
    private int size;
    private Point pPos;
    private Tile[][] map2;

    public CoreGame() {
        pPos = new Point(1, 1);
        size = 50;
        map = new char[size][size];
        for (int y = 0; y < size - 1; y++) {
            for (int x = 0; x < size - 1; x++) {
                char sym = '.';
//                if (x > 30) {
//                    sym = 'x';
//                } else if (x > 15) {
//                    sym = '✍';
//                }
//                if (y > 35) {
//                    sym = 'O';
//                }
                map[y][x] = sym;
            }
        }
        for (int i = 0; i < size; i++) {
            map[size - 1][i] = '#';
            map[i][size - 1] = '#';
            map[0][i] = '#';
            map[i][0] = '#';
        }
        map[pPos.y][pPos.x] = '@';
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
        map2[pPos.y][pPos.x].setCurrentSymbol('#');
    }

    public mapAndCenter idle() {
        return new mapAndCenter(pPos, map);
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
        map[pPos.y][pPos.x] = '@';
        map[oldLoc.y][oldLoc.x] = 'x';

        return new mapAndCenter(pPos, map);
    }

    private class Tile {

        private boolean isPassable;
        private char oldSymbol;
        private char currentSymbol;
        private boolean isHereSomething;

        public Tile(boolean isPassable, char symbol) {
            this.isPassable = isPassable;
            this.oldSymbol = symbol;
            isHereSomething = false;
        }

        public boolean isIsPassable() {
            return isPassable;
        }
        /**
         * Can Entities enter to this tile.
         * @param isPassable 
         */
        public void setIsPassable(boolean isPassable) {
            this.isPassable = isPassable;
        }

        /**
         * Enter to this tile. This also sets currentSymbol as the thing that
         * entered.
         *
         * @param currentSymbol
         */
        public void setCurrentSymbol(char currentSymbol) {
            this.currentSymbol = currentSymbol;
            isHereSomething = true;
        }

        /**
         * Returns the symbol to display and removes it from this tile if this
         * tile had something to remove.
         *
         * @return
         */
        public char popSymbol() {
            char symbolToReturn = oldSymbol;
            if (isHereSomething) {
                symbolToReturn = currentSymbol;
            }
            isHereSomething = false;
            return symbolToReturn;
        }

        /**
         * Returns the symbol to display without removing it from tile
         *
         * @return
         */
        public char peekSymbol() {
            char symbolToReturn = oldSymbol;
            if (isHereSomething) {
                symbolToReturn = currentSymbol;
            }
            return symbolToReturn;
        }

    }

}
