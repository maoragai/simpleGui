/**
 * The type Ball remover.
 */
public class BallRemover implements HitListener  {
private GameLevel gameLevel;
private Counter remainingBalls;


    /**
     * Instantiates a new Ball remover.
     *
     * @param g the g
     * @param c the c
     */
    public BallRemover(GameLevel g, Counter c) {
        this.gameLevel = g;
        this.remainingBalls = c;
    }

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit the block that being hit
     * @param hitter   the ball that hits
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
            hitter.removeFromGame(this.gameLevel);
            remainingBalls.decrease(1);
    }
}
