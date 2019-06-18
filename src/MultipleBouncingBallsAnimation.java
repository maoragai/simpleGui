import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.util.ArrayList;
import java.util.Random;

import static java.awt.Color.BLACK;

/**
 * creates an animation of bouncing balls.
 */
public class MultipleBouncingBallsAnimation {
    /**
     * creates an animation of bouncing balls.
     *
     * @param args array of balls radius
     */
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<Ball> balls = new ArrayList<>();
        int radius;
        for (int i = 0; i < args.length; i++) {
            Ball b = new Ball(new Point(rand.nextInt(200), rand.nextInt(200)), Integer.parseInt(args[i]), BLACK);
            radius = Integer.parseInt(args[i]);
            b.setVelocity((double) 10 / radius, (double) 10 / radius);
            balls.add(b);
        }
        GUI gui = new GUI("title", 200, 200);
        Sleeper sleeper = new Sleeper();

        while (true) {
            DrawSurface d = gui.getDrawSurface();
            for (int j = 0; j < balls.size(); j++) {
                balls.get(j).moveOneStep();
                balls.get(j).drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}
