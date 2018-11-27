/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulseroquefx.thegame;

import java.awt.Point;

/**
 *
 * @author Qmppu842
 */
public class mapAndCenter {

    private Point pPos;
    private char[][] map;

    public mapAndCenter(Point pPos, char[][] map) {
        this.pPos = pPos;
        this.map = map;
    }

    public Point getpPos() {
        return pPos;
    }

    public char[][] getMap() {
        return map;
    }

    public int getCenterX() {
        return pPos.x;
    }

    public int getCenterY() {
        return pPos.y;
    }

}
