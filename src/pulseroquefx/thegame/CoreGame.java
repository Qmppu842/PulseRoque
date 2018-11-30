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
    }

    public mapAndCenter idle() {
        return new mapAndCenter(pPos, map);
    }
    private boolean didMovementHappen;

    public mapAndCenter moveManyTiles(int x, int y) {
        //TODO: implement some pathfinding algo here maybe?
        //For now, it will have just reducing y distance and x distance separetly.
        System.out.println("localPPos.x: " + x);
        System.out.println("localPPos.y: " + y);
        Point target = new Point(x + pPos.x, y + pPos.y);
        int distX = x;//x;//- pPos.x;
        int distY = y;// y;//- pPos.y;
        didMovementHappen = distX != 0 || distY != 0;
//        do {
//            distX = x;//pPos.x - x;
//            distY = y;//pPos.y - y;
//            System.out.println("distX: " + distX);
//            System.out.println("distY: " + distY);
//            if (distX == 0 && distY == 0) {
//                didMovementHappen = false;
//                break;
//            }
//            int dirX = 0;
//            int dirY = 0;
//
//            if (distX < 0) {
//                dirX = 1;
//            } else if (distX > 0) {
//                dirX = -1;
//            }
//            if (distY < 0) {
//                dirY = 1;
//            } else if (distY > 0) {
//                dirY = -1;
//            }
//
////            if (distX != 0) {
////                dirX = distX / Math.abs(distX);
////            }
////            if (distY != 0) {
////                dirY = distY / Math.abs(distY);
////            }
//            System.out.println("truePPos: " + pPos);
//            System.out.println("futureX: " + pPos.x + dirX);
//            System.out.println("futureY: " + pPos.y + dirY);
//            move(pPos.x + dirX, pPos.y + dirY);
//        } while (didMovementHappen);

        while (didMovementHappen) {
//            distX = target.x - pPos.x;//pPos.x - x;
//            distY = target.y - pPos.y;//pPos.y - y;
            distX = pPos.x - target.x;//pPos.x - x;
            distY = pPos.y - target.y;//pPos.y - y;

            System.out.println("distX: " + distX);
            System.out.println("distY: " + distY);
            if (distX == 0 && distY == 0) {
                break;
            }
            int dirX = 0;
            int dirY = 0;

            if (distX < 0) {
                dirX = 1;
            } else if (distX > 0) {
                dirX = -1;
            }
            if (distY < 0) {
                dirY = 1;
            } else if (distY > 0) {
                dirY = -1;
            }

            System.out.println("truePPos: " + pPos);
            System.out.println("futureX: " + pPos.x + dirX);
            System.out.println("futureY: " + pPos.y + dirY);
            move(pPos.x + dirX, pPos.y + dirY);
        }
        return idle();
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

        didMovementHappen = true;

        return new mapAndCenter(pPos, map);
    }

    private class Tile {

        private boolean isPassable;
        private char symbol;

        public Tile(boolean isPassable, char symbol) {
            this.isPassable = isPassable;
            this.symbol = symbol;
        }

        public boolean isIsPassable() {
            return isPassable;
        }

        public void setIsPassable(boolean isPassable) {
            this.isPassable = isPassable;
        }

        public char getSymbol() {
            return symbol;
        }

        public void setSymbol(char symbol) {
            this.symbol = symbol;
        }

    }

    private class ThingOnTiles {

    }

}
