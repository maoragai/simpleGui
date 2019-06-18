import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Lives indicator.
 */
public class LivesIndicator implements Sprite {
    private Counter lives;
    private Rectangle shape = new Rectangle(new Point(0, 0), 100, 20);

    /**
     * Instantiates a new Lives indicator.
     *
     * @param l the l
     */
    public LivesIndicator(Counter l) {
        this.lives = l;
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
        //create the frame for the block
        //d.drawRectangle((int) r.getUpperLeft().getX(),
          //      (int) r.getUpperLeft().getY(), (int) r.getWidth(), (int) r.getHeight());

        //setting the text for the scoreboard
        if (lives.getValue() >= 0) {
            d.setColor(Color.BLACK);
            d.drawText((int) (r.getUpperLeft().getX() + (r.getWidth() / 2)),
                    (int) (r.getUpperLeft().getY() + (r.getHeight() / 2)) + 5, "lives: " + this.lives.getValue(),
                    15);
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
