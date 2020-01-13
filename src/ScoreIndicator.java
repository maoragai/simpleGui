import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Score indicator.
 */
public class ScoreIndicator implements Sprite {
    private Counter scr;
    private Rectangle shape = new Rectangle(new Point(0, 0), 800, 20);

    /**
     * Instantiates a new Score indicator.
     *
     * @param scoreRef the score ref
     */
    public ScoreIndicator(Counter scoreRef) {
        this.scr = scoreRef;
    }


    /**
     * draw the sprite to the screen.
     *
     * @param d  the drawSurface to draw on
     *
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
       /** d.drawRectangle((int) r.getUpperLeft().getX(),
                (int) r.getUpperLeft().getY(), (int) r.getWidth(), (int) r.getHeight());
            */
        //setting the text for the scoreboard
        if (scr.getValue() >= 0) {
            d.setColor(Color.BLACK);
            d.drawText((int) (r.getUpperLeft().getX() + (r.getWidth() / 2)),
                    (int) (r.getUpperLeft().getY() + (r.getHeight() / 2)) + 5,
                    "score: " + this.scr.getValue(), 15);
        }

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
