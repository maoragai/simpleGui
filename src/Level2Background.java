import biuoop.DrawSurface;

import java.awt.*;

public class Level2Background implements Sprite {

    /**
     * draw the sprite to the screen.
     *
     * @param d the drawSurface to draw on
     */
    @Override
    public void drawOn(DrawSurface d) {
        //back
        d.setColor(Color.white);
        d.fillRectangle(0,0,d.getWidth(),d.getHeight());
        //objects

        //middle of the target
        Point p = new Point(d.getWidth()/4,d.getHeight()/4);

        d.setColor(Color.orange);
        d.fillCircle((int)p.getX(),(int)p.getY(),75);
        d.setColor(Color.yellow);
        d.fillCircle((int)p.getX(),(int)p.getY(),60);
        //d.drawCircle((int)p.getX(),(int)p.getY(),75);
        //d.drawLine((int)p.getX(),100,(int)p.getX(),300);
    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }

    /**
     * add this object to a specified game.
     *
     * @param g the game to be added to
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
