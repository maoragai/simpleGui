import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.*;

public class CountdownAnimation implements Animation {
    private SpriteCollection gameScreen;
    private int countFrom;
    private double numOfSeconds;
    private int counterCurrent;
    private boolean shouldStop;
    private Sleeper sleeper;

    public CountdownAnimation(double num, int count, SpriteCollection game) {
        this.numOfSeconds=num;
        this.countFrom=count;
        this.gameScreen=game;
        this.shouldStop=false;
        this.counterCurrent=count;
        this.sleeper=new Sleeper();
    }

    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        if (this.counterCurrent>0){
            d.setColor(Color.RED);
            d.drawText(d.getWidth()/2,d.getHeight()/2,Integer.toString(this.counterCurrent),50);

        }
        if (this.counterCurrent != this.countFrom) {
            sleeper.sleepFor((long) ((this.numOfSeconds / this.countFrom) * 1000));
        }
        this.counterCurrent--;

    }

    public boolean shouldStop() {
        if (this.counterCurrent<0){
            return true;
        }
        return this.shouldStop;
    }
}