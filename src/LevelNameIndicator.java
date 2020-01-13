import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Level name indicator.
 */
public class LevelNameIndicator implements Sprite {
    private String name;
    private Rectangle shape = new Rectangle(new Point(550, 0), 100, 20);

    /**
     * Instantiates a new Level name indicator.
     *
     * @param l the l
     */
    public LevelNameIndicator(String l) {
        this.name = l;
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d the drawSurface to draw on
     */
    @Override
    public void drawOn(DrawSurface d) {
        Rectangle r = this.shape;
        d.setColor(Color.white);
        //filling the block with color
        d.fillRectangle((int) r.getUpperLeft().getX(), (int) r.getUpperLeft().getY(),
                (int) r.getWidth(), (int) r.getHeight());
        d.setColor(Color.BLACK);
        d.drawText((int) (r.getUpperLeft().getX() + (r.getWidth() / 2)),
                (int) (r.getUpperLeft().getY() + (r.getHeight() / 2)) + 5, "Level Name: " + name, 15);
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
