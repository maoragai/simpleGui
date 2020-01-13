import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * The type End game.
 */
public class EndGame implements Animation {
    private KeyboardSensor keyboardSensor;
    private int countFrom;
    private double numOfSeconds;
    private Counter score;
    private boolean isWin;
    private boolean shouldstop;

    /**
     * Instantiates a new End game.
     *
     * @param s  the s
     * @param ks the ks
     * @param w  the w
     */
    public EndGame(Counter s, KeyboardSensor ks, Boolean w) {
        this.score = s;
        this.keyboardSensor = ks;
        this.isWin = w;
        this.shouldstop = false;
    }

    /**
     * do one frame of the animation.
     * @param d the ddrawsurface
     * @param dt the amount of time since last call
     */
    public void doOneFrame(DrawSurface d, double dt) {
        //background
        d.setColor(Color.white);
        d.drawRectangle(0, 0, d.getWidth(), d.getHeight());
        if (this.isWin) {
            d.setColor(Color.BLACK);
            d.drawText(40, d.getHeight() / 2, "You Win! Your score is " + this.score.getValue(), 50);
        }
        if (!this.isWin) {
            d.setColor(Color.BLACK);
            d.drawText(40, d.getHeight() / 2, "Game Over. Your score is  " + this.score.getValue(), 50);
        }
        if (this.keyboardSensor.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.shouldstop = true;
        }
    }

    /**
     * if the animation should stop run.
     * @return boolean
     */
    public boolean shouldStop() {
        return this.shouldstop;
    }
}