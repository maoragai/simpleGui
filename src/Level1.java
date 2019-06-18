import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 1.
 */
public class Level1 implements LevelInformation {

    private int numberofballs;
    private int paddlespeed, paddlewidth, numberOfBlocksToRemove;
    private List<Velocity> initialballvelocity = new ArrayList<>();
    private Sprite background;
    private List<Block> blocksarray = new ArrayList<>();
    private String levelname = "Direct Hit";
    /**
     * The Default width.
     */
    private double defaultWidth = 25, /**
     * The Default height.
     */
    defaultHeight = 25;

    /**
     * Instantiates a new Level 1.
     */
    public Level1() {
        background = new Level1Background();
        //build balls velocity array here
        initialballvelocity.add(new Velocity(2, 2));
        initialballvelocity.add(new Velocity(3, 3));
        numberofballs = initialballvelocity.size();
        //paddle
        this.paddlespeed = 20;
        this.paddlewidth = 50;
        //set a reference point for the game blocks.
        Point reference = new Point(400 - 10, 200 - 10);
        Block b = new Block(new Rectangle(new Point(reference.getX(), reference.getY()), defaultWidth, defaultHeight));
        b.setColor(Color.red);
        blocksarray.add(b);
        this.numberOfBlocksToRemove = blocksarray.size();
    }

    /**
     * returns the number of balls in the level.
     * @return number of balls.
     */
    public int numberOfBalls() {
        return numberofballs;
    }
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()

    /**
     * returns the list of balls velocities.
     * @return list of velocities.
     */
    public List<Velocity> initialBallVelocities() {
        return initialballvelocity;
    }

    /**
     * return paddle speed.
     * @return paddle speed
     */
    public int paddleSpeed() {
        return paddlespeed;
    }

    /**
     * returns the paddle width.
     * @return paddle width
     */
    public int paddleWidth() {
        return paddlewidth;
    }

    /**
     * the level name will be displayed at the top of the screen.
     * @return the level name
     */
    public String levelName() {
        return levelname;
    }

    /**Returns a sprite with the background of the level.
     *
     * @return the bachground for the level
     */
    public Sprite getBackground() {
        return background;
    }

    /**
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return list of blocks
     */
    public List<Block> blocks() {
        return blocksarray;
    }

    /**
     * Number of levels that should be removed
     *     // before the level is considered to be "cleared".
     *     // This number should be <= blocks.size();
     *
     * @return nuber of blocks to remove
     */
    public int numberOfBlocksToRemove() {
        return numberOfBlocksToRemove;
    }
}
