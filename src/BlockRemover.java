// a BlockRemover is in charge of removing blocks from the gameLevel, as well as keeping count
// of the number of blocks that remain.
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    public BlockRemover(GameLevel g, Counter r) {
        this.gameLevel =g;
        this.remainingBlocks=r;
    }

    // Blocks that are hit and reach 0 hit-points should be removed
    // from the gameLevel. Remember to remove this listener from the block
    // that is being removed from the gameLevel.
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getHitPoints()==0){
            beingHit.removeFromGame(this.gameLevel);
            remainingBlocks.decrease(1);
        }
    }
}