import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Level 1 background.
 */
public class Level1Background implements Sprite {

    /**
     * draw the sprite to the screen.
     *
     * @param d the drawSurface to draw on
     */
    @Override
    public void drawOn(DrawSurface d) {
        //back
        d.setColor(Color.black);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        //objects
        d.setColor(Color.blue);
        //middle of the target
        Point p = new Point(d.getWidth() / 2, d.getHeight() / 3);
        d.drawCircle((int) p.getX(), (int) p.getY(), 25);
        d.drawCircle((int) p.getX(), (int) p.getY(), 50);
        d.drawCircle((int) p.getX(), (int) p.getY(), 75);
        d.drawLine((int) p.getX(), 100, (int) p.getX(), 300);
    }

    /**
     * notify the sprite that time has passed.
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
