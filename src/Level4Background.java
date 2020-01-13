import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Level 4 background.
 */
public class Level4Background implements Sprite {

    /**
     * draw the sprite to the screen.
     *
     * @param d the drawSurface to draw on
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.decode("#00B5DC"));
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.decode("#B8BDBC"));
        d.fillCircle(150 - 10, 390 - 10, 25);
        d.setColor(Color.decode("#B3B8B7"));
        d.fillCircle(170 - 10, 420 - 10, 30);
        d.setColor(Color.decode("#ACB1B0"));
        d.fillCircle(200 - 10, 390 - 10, 30);
        d.setColor(Color.decode("#A4A9A8"));
        d.fillCircle(210 - 10, 420 - 10, 25);
        d.setColor(Color.decode("#9BA09F"));
        d.fillCircle(240 - 10, 405 - 10, 30);
        d.setColor(Color.decode("#B8BDBC"));
        d.fillCircle(550 - 5, 440 - 5, 25);
        d.setColor(Color.decode("#B3B8B7"));
        d.fillCircle(570 - 5, 470 - 5, 30);
        d.setColor(Color.decode("#ACB1B0"));
        d.fillCircle(600 - 5, 440 - 5, 30);
        d.setColor(Color.decode("#A4A9A8"));
        d.fillCircle(610 - 5, 470 - 5, 25);
        d.setColor(Color.decode("#9BA09F"));
        d.fillCircle(640 - 5, 455 - 5, 30);
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
