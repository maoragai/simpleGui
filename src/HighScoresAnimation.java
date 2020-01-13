import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.*;

/**
 * The type High scores animation.
 */
public class HighScoresAnimation implements Animation {
    private HighScoresTable scoresTable;
    private String          end;
    private KeyboardSensor  keyboardSensor;
    private Boolean         shouldStop;

    /**
     * Instantiates a new High scores animation.
     *
     * @param scores the scores
     * @param endKey the end key
     * @param key    the key
     */
    public HighScoresAnimation(HighScoresTable scores, String endKey, KeyboardSensor key) {
        this.keyboardSensor = key;
        this.end = endKey;
        this.scoresTable = scores;
        this.shouldStop = false;
    }

    /**
     * Do one frame.
     *
     * @param d  the d
     * @param dt the amount of time passed from the last call
     */
    @Override
    public void doOneFrame(DrawSurface d, double dt) {
        int width = d.getWidth();
        int height = d.getHeight();

        d.setColor(Color.gray);
        d.fillRectangle(0, 0, width, height);
        d.setColor(Color.BLACK);
        d.drawText(50, 50, "High Scores:", 40);

        d.setColor(Color.BLUE);
        d.drawText(100, 150, "Player Name", 32);
        d.setColor(Color.BLUE);
        d.drawText(500, 150, "Score", 32);
        d.drawText(100, 150, "____________________________________", 32);
        int i = 0;
        for (ScoreInfo si:scoresTable.getHighScores()) {
            d.setColor(Color.BLUE);
            d.drawText(100, 200 + i * 50, si.getName(), 32);
            d.setColor(Color.BLUE);
            d.drawText(500, 200 + i * 50, "" + si.getScore(), 32);
            i++;
        }
        d.setColor(Color.BLACK);
        d.drawText(200, 500, "Please press space to continue", 32);

    }

    /**
     * Should stop boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean shouldStop() {
        return this.shouldStop;
    }
}