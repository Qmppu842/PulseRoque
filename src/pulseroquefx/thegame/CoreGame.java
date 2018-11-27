package pulseroquefx.thegame;

import java.awt.Point;

/**
 *
 * @author Qmppu842
 */
public class CoreGame {

    private char[][] map;
    private int size;
    private Point pPos;

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

    public mapAndCenter idle() {
        return new mapAndCenter(pPos, map);
    }

    public mapAndCenter move(int x, int y) {
        return move(new Point(x, y));
    }

    public mapAndCenter move(Point dir) {
        Point oldLoc = (Point) pPos.clone();
        pPos.translate(dir.x, dir.y);
        map[pPos.y][pPos.x] = '@';
        map[oldLoc.y][oldLoc.x] = 'x';

        return new mapAndCenter(pPos, map);
    }

//    private class mapAndCenter {
//
//        private Point pPos;
//        private char[][] map;
//
//        public mapAndCenter(Point pPos, char[][] map) {
//            this.pPos = pPos;
//            this.map = map;
//        }
//
//        public Point getpPos() {
//            return pPos;
//        }
//
//        public char[][] getMap() {
//            return map;
//        }
//
//    }
}
