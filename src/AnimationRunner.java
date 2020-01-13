import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * The type Animation runner.
 */
public class AnimationRunner {
    private GUI gui;



    private int framesPerSecond;
    private Sleeper sleeper = new Sleeper();

    /**
     * Instantiates a new Animation runner.
     *
     * @param g   the g
     * @param fpS the fp s
     */
    public AnimationRunner(GUI g, int fpS) {
        this.gui = g;
        this.framesPerSecond = fpS;
    }

    /**
     * Gets frames per second.
     *
     * @return the frames per second
     */
    public int getFramesPerSecond() {
        return framesPerSecond;
    }
    /**
     * Run.
     *
     * @param animation the animation
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            double dt = (double) 1 / framesPerSecond;
            animation.doOneFrame(d, dt);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}