import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class SimpleGuiExample {
    /**
     * creates a draw of 10 lines and their intersections and middle points.
     *
     * @param args irrelevant
     */
    public static void main(String[] args) {
        SimpleGuiExample example = new SimpleGuiExample();
        example.drawRandomLines();
    }

    /**
     * Draws random lines, their intersection and middle points.
     */
    public void drawRandomLines() {
        //create an array of lines need to be drawn and their intersection points
        ArrayList<Line> lines = new ArrayList<Line>();
        ArrayList<Point> intersections = new ArrayList<Point>();
        //create 10 random lines
        for (int i = 0; i < 10; i++) {
            lines.add(randomLine());
            for (int j = 0; j < lines.size() - 1; j++) {
                if (lines.get(i).isIntersecting(lines.get(j))) {
                    intersections.add(lines.get(i).intersectionWith(lines.get(j)));
                }
            }
        }
        GUI gui = new GUI("Random lines example", 400, 300);
        DrawSurface d = gui.getDrawSurface();
        //draw the lines and their middle point
        for (int i = 0; i <= lines.size() - 1; i++) {
            d.setColor(Color.BLACK);
            d.drawLine((int) lines.get(i).getStartPoint().getX(), (int) lines.get(i).getStartPoint().getY(),
                    (int) lines.get(i).getEndPoint().getX(), (int) lines.get(i).getEndPoint().getY());
            d.setColor(Color.BLUE);
            d.fillCircle((int) lines.get(i).middle().getX(), (int) lines.get(i).middle().getY(), 5);
        }
        //draw the lines intersection points
        for (int i = 0; i <= intersections.size() - 1; i++) {
            d.setColor(Color.RED);
            d.fillCircle((int) intersections.get(i).getX(), (int) intersections.get(i).getY(), 5);
        }
        gui.show(d);
    }

    /**
     * creates a random line.
     *
     * @return line object
     */
    public Line randomLine() {
        Random rand = new Random();
        int xBound = 400, yBound = 300;
        Line line = new Line(rand.nextInt(400) + 1, rand.nextInt(yBound) + 1,
                rand.nextInt(xBound) + 1, rand.nextInt(yBound) + 1);
        return line;
    }
}