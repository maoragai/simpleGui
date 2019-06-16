import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.*;

public class EndGame implements Animation {
    private KeyboardSensor keyboardSensor;
    private int countFrom;
    private double numOfSeconds;
    private Counter score;
    private boolean isWin;
    private boolean shouldstop;

    public EndGame(Counter s, KeyboardSensor ks,Boolean w) {
        this.score=s;
        this.keyboardSensor=ks;
        this.isWin=w;
        this.shouldstop = false;
    }

    public void doOneFrame(DrawSurface d) {
        //background
        d.setColor(Color.white);
        d.drawRectangle(0,0,d.getWidth(),d.getHeight());
        if (this.isWin==true){
            d.setColor(Color.BLACK);
            d.drawText(40,d.getHeight()/2,"You Win! Your score is "+this.score.getValue(),50);
        }
        if (this.isWin==false){
            d.setColor(Color.BLACK);
            d.drawText(40,d.getHeight()/2,"Game Over. Your score is  "+this.score.getValue(),50);
        }
        if (this.keyboardSensor.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.shouldstop = true;
        }
    }
    public boolean shouldStop() {
        return this.shouldstop;
    }
}