/**
 * The type Printing hit listener.
 */
public class PrintingHitListener implements HitListener {


    /**
     * Instantiates a new Printing hit listener.
     */
    public PrintingHitListener() {
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
        System.out.println("A Block with " + beingHit.getHitPoints() + " points was hit.");
    }
}