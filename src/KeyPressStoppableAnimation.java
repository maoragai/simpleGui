import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Key press stoppable animation.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private String         key;
    private Animation      animation;
    private boolean        shouldStop;
    private boolean        isAlreadyPressed;
    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param sensor the sensor
     * @param k      the k
     * @param a      the a
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String k, Animation a) {
        this.keyboardSensor = sensor;
        this.key = k;
        this.animation = a;
        this.shouldStop = false;
        this.isAlreadyPressed = true;
    }

    /**
     * Do one frame.
     *
     * @param d  the d
     * @param dt the amount of time passed from the last call
     */
    @Override
    public void doOneFrame(DrawSurface d, double dt) {
        if (keyboardSensor.isPressed(key)) {
            if (isAlreadyPressed) {
                return;
            }
            shouldStop = true;
        }
        isAlreadyPressed = false;
        //deco
    }

    /**
     * Should stop boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean shouldStop() {
        return shouldStop;
    }
}