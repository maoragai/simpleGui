import biuoop.DrawSurface;

/**
 * sprite interface decleration.
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     *
     * @param d the drawSurface to draw on
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     *
     * @param dt the time passed since last call
     */
    void timePassed(double dt);

    /**
     * add this object to a specified game.
     *
     * @param g the game to be added to
     */
    void addToGame(GameLevel g);
}