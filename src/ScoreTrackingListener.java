public class ScoreTrackingListener implements HitListener{
    private Counter currentScore;

    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    public void hitEvent(Block beingHit, Ball hitter) {
        //ball being hit and destroyed
        if (beingHit.getHitPoints()==1){
            this.currentScore.increase(10);
            //printing score for check
            //System.out.println("score:"+ currentScore.getValue());
        }
        //block is just hit
        else{
            this.currentScore.increase(5);
            //printing score for check
           // System.out.println("score:"+ currentScore.getValue());
        }
    }
}
