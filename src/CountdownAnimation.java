import biuoop.DrawSurface;
import biuoop.Sleeper;
import java.awt.Color;


/**
 * The type Countdown animation.
 */
public class CountdownAnimation implements Animation {
    private SpriteCollection gameScreen;
    private int              countFrom;
    private double           numOfSeconds;
    private int              counterCurrent;
    private boolean          shouldStop;
    private Sleeper          sleeper;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param num   the num
     * @param count the count
     * @param game  the game
     */
    public CountdownAnimation(double num, int count, SpriteCollection game) {
        this.numOfSeconds = num;
        this.countFrom = count;
        this.gameScreen = game;
        this.shouldStop = false;
        this.counterCurrent = count;
        this.sleeper = new Sleeper();
    }

    /**
     * draw a one frame of objects.
     * @param d the drawsurface
     * @param dt the amount of time since the last call
     */
    public void doOneFrame(DrawSurface d, double dt) {
        this.gameScreen.drawAllOn(d);
        if (this.counterCurrent > 0) {
            d.setColor(Color.RED);
            d.drawText(d.getWidth() / 2, d.getHeight() / 2, Integer.toString(this.counterCurrent), 50);

        }
        if (this.counterCurrent != this.countFrom) {
            sleeper.sleepFor((long) ((this.numOfSeconds / this.countFrom) * 1000));
        }
        this.counterCurrent--;

    }

    /**
     * note if the animation should stop running.
     * @return boolean
     */
    public boolean shouldStop() {
        if (this.counterCurrent < 0) {
            return true;
        }
        return this.shouldStop;
    }
}