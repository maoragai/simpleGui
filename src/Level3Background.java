import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Level 3 background.
 */
public class Level3Background implements Sprite {

    /**
     * draw the sprite to the screen.
     *
     * @param d the drawSurface to draw on
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.green);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());

        d.setColor(Color.decode("#393939").brighter().brighter());
        d.fillRectangle(115, 160, 10, 230);
        d.setColor(Color.decode("#393939").brighter());
        d.fillRectangle(100, 380, 40, 100);
        d.setColor(Color.decode("#393939"));
        d.fillRectangle(70, 440, 100, 200);
        d.setColor(Color.WHITE);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.fillRectangle((j * 20) + 75, (i * 30) + 450, 11, 20);
            }
        }
    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

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
