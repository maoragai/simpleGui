import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Pause screen.
 */
public class PauseScreen implements Animation {

    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * Instantiates a new Pause screen.
     *
     * @param k the k
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * do one frame of the animation.
     * @param d the drawsurface
     * @param dt the amount of time since last call
     */
    public void doOneFrame(DrawSurface d, double dt) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     * if the animation should stop.
     * @return boolean
     */
    public boolean shouldStop() {
        return this.stop;
    }
}