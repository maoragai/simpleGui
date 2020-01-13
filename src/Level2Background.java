import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Level 2 background.
 */
public class Level2Background implements Sprite {

    /**
     * draw the sprite to the screen.
     *
     * @param d the drawSurface to draw on
     */
    @Override
    public void drawOn(DrawSurface d) {
        //back
        d.setColor(Color.white);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        Point p = new Point(d.getWidth() / 4, d.getHeight() / 4);
        d.setColor(Color.orange);
        d.fillCircle((int) p.getX(), (int) p.getY(), 75);
        d.setColor(Color.yellow);
        d.fillCircle((int) p.getX(), (int) p.getY(), 60);
    }

    /**
     * notify the sprite that time has passed.
     * @param dt the amount of time since last call
     */
    @Override
    public void timePassed(double dt) {

    }

    /**
     * add this object to a specified game.
     *
     * @param g the game to be added to
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
