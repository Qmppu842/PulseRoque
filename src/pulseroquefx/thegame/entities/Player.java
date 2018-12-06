package pulseroquefx.thegame.entities;

import java.awt.Point;

/**
 *
 * @author Qmppu842
 */
public class Player {

    private final char SYMBOL = '@';
    private Point position;
    private boolean isThisPassable;

    public Player() {
        position = new Point(1, 1);
        isThisPassable = false;
    }    

}
