import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.awt.Color.green;

/**
 * The type Level 2.
 */
public class Level2 implements LevelInformation {

    private int            numberofballs;
    private int            paddlespeed, paddlewidth, numberOfBlocksToRemove;
    private List<Velocity> initialballvelocity = new ArrayList<>();
    private Sprite         background;
    private List<Block>    blocksarray = new ArrayList<>();
    private String         levelname = "Wide Easy";
    private double         defaultWidth = (double) 760 / 15, defaultHeight = 25;

    /**
     * Instantiates a new Level 2.
     */
    public Level2() {
        background = new Level2Background();
        //build balls velocity array here
        initialballvelocity.add(new Velocity(2, 2));
        initialballvelocity.add(new Velocity(3, 3));
        numberofballs = initialballvelocity.size();
        //paddle
        this.paddlespeed = 20;
        this.paddlewidth = 500;

        //create an array of colors for the block rows
        ArrayList<Color> blockColors = new ArrayList<Color>();
        blockColors.add(Color.CYAN);
        blockColors.add(Color.PINK);
        blockColors.add(Color.blue);
        blockColors.add(green);
        blockColors.add(Color.yellow);
        blockColors.add(Color.ORANGE);
        blockColors.add(Color.red);
        Collections.reverse(blockColors);

        //create the game blocks rows
        //set a reference point for the game blocks
        Point reference = new Point(20, 250);
        double tempwidth = 0;
        //create the game blocks rows
        for (int i = 0; i < blockColors.size() * 2; i = i + 2) {
            //tempwidth=i*( defaultWidth);
            Color col = blockColors.get(i / 2);
                Block b1 = new Block(new Rectangle(new Point(reference.getX()
                        + tempwidth, reference.getY()), defaultWidth, defaultHeight));
                b1.setColor(col);
                blocksarray.add(b1);
                tempwidth += defaultWidth;
            Block b2 = new Block(new Rectangle(new Point(reference.getX()
                    + tempwidth, reference.getY()), defaultWidth, defaultHeight));
            b2.setColor(col);
            blocksarray.add(b2);
            if (col == green) {
                tempwidth += defaultWidth;
                Block b = new Block(new Rectangle(new Point(reference.getX()
                        + tempwidth, reference.getY()), defaultWidth, defaultHeight));
                b.setColor(blockColors.get(i / 2));
                blocksarray.add(b);
            }
            tempwidth += defaultWidth;
        }
        this.numberOfBlocksToRemove = blocksarray.size();
    }

    /**
     * returns the number of balls in the level.
     * @return number of balls
     */
    public int numberOfBalls() {
        return numberofballs;
    }

    /**
     *The initial velocity of each ball.
     Note that initialBallVelocities().size() == numberOfBalls()
     * @return list of balls velocities
     */
    public List<Velocity> initialBallVelocities() {
        return initialballvelocity;
    }

    /**
     * paddle speed.
     * @return the paddle speed for the level
     */
    public int paddleSpeed() {
        return paddlespeed;
    }

    /**
     * paddle width.
     * @return the paddles width.
     */
    public int paddleWidth() {
        return paddlewidth;
    }

    /**
     *the level name will be displayed at the top of the screen.
     * @return the level name
     */
    public String levelName() {
        return levelname;
    }

    /**
     * the background for the level.
     * @return background
     */
    public Sprite getBackground() {
        return background;
    }

    /**
     * get the list of blocks for the level.
     * @return list of blocks for the level
     */
    public List<Block> blocks() {
        return blocksarray;
    }

    /**
     * Number of levels that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     * @return number of blocks to remove
     */
    public int numberOfBlocksToRemove() {
        return numberOfBlocksToRemove;
    }
}

