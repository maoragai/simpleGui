import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.util.ArrayList;
import java.util.Random;

import static java.awt.Color.*;

/**
 * creates an animation of two frames of bouncing balls
 */
public class MultipleFramesBouncingBallsAnimation {
    /**
     * creates an animation of two frames of bouncing balls
     *
     * @param args array of balls radius
     */
    public static void main(String[] args) {
        int greyTop = 50, greyBottom = 500, greyLeft = 50, greyRight = 500;
        int yellowTop = 450, yellowBottom = 600, yellowLeft = 450, yellowRight = 600;
        GUI gui = new GUI("title", 600, 600);
        ArrayList<Ball> balls = new ArrayList<>();
        Random rand = new Random();
        int radius;
        for (int i = 0; i < args.length; i++) {
            //building grey area balls
            if (i < args.length / 2) {
                Ball b = new Ball(new Point(rand.nextInt(449) + 50, rand.nextInt(449) + 50), Integer.parseInt(args[i]), BLACK);
                radius = Integer.parseInt(args[i]);
                b.setVelocity((double) 10 / radius, (double) 10 / radius);
                b.setBorders(greyBottom, greyTop, greyLeft, greyRight);
                balls.add(b);
            }
            //building array of yellow frame balls
            else {
                Ball b = new Ball(new Point(rand.nextInt(149) + 450, rand.nextInt(149) + 450), Integer.parseInt(args[i]), BLACK);
                radius = Integer.parseInt(args[i]);
                b.setVelocity((double) 10 / radius, (double) 10 / radius);
                b.setBorders(yellowBottom, yellowTop, yellowLeft, yellowRight);
                balls.add(b);
            }
        }
        Sleeper sleeper = new Sleeper();
        //creates animation
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            d.setColor(GRAY);
            d.fillRectangle(50, 50, 450, 450);
            d.setColor(YELLOW);
            d.fillRectangle(450, 450, 150, 150);
            for (int j = 0; j < balls.size(); j++) {
                balls.get(j).moveOneStep();
                balls.get(j).drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.

        }


    }

}




