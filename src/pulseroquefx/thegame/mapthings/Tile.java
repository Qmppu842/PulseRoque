package pulseroquefx.thegame.mapthings;

/**
 *
 * @author Qmppu842
 */
public class Tile {

    private boolean isPassable;
    private final char OLD_SYMBOL;
    private char currentSymbol;
    private boolean isHereSomething;

    public Tile(boolean isPassable, char symbol) {
        this.isPassable = isPassable;
        this.OLD_SYMBOL = symbol;
        isHereSomething = false;
    }

    public boolean isIsPassable() {
        return isPassable;
    }

    /**
     * Can Entities enter to this tile.
     *
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
     * Returns the symbol to display and removes it from this tile if this tile
     * had something to remove.
     *
     * @return
     */
    public char popSymbol() {
        char symbolToReturn = OLD_SYMBOL;
        if (isHereSomething) {
            symbolToReturn = currentSymbol;
            isHereSomething = false;
            currentSymbol = OLD_SYMBOL;
        }
        return symbolToReturn;
    }

    /**
     * Returns the symbol to display without removing it from tile
     *
     * @return
     */
    public char peekSymbol() {
        char symbolToReturn = OLD_SYMBOL;
        if (isHereSomething) {
            symbolToReturn = currentSymbol;
        }
        return symbolToReturn;
    }

}
