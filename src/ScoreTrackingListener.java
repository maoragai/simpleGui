/**
 * The type Score tracking listener.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * Instantiates a new Score tracking listener.
     *
     * @param scoreCounter the score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * note if an hit happend.
     * @param beingHit the block that being hit
     * @param hitter   the ball that hits
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        //ball being hit and destroyed
        if (beingHit.getHitPoints() == 1) {
            this.currentScore.increase(10);
        } else {
            this.currentScore.increase(5);
        }
    }
}
