import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 4.
 */
public class Level4 implements LevelInformation {

    private int         numberofballs;
    private int         paddlespeed, paddlewidth, numberOfBlocksToRemove;
    private List<Velocity> initialballvelocity = new ArrayList<>();
    private Sprite      background;
    private List<Block> blocksarray = new ArrayList<>();
    private String      levelname = "Final Four";
    /**
     * The Default width.
     */
    private double defaultWidth = 50.6, /**
     * The Default height.
     */
    defaultHeight = 25;

    /**
     * Instantiates a new Level 4.
     */
    public Level4() {
        background = new Level4Background();
        //build balls velocity array here
        initialballvelocity.add(new Velocity(2, 2));
        initialballvelocity.add(new Velocity(3, 3));

        numberofballs = initialballvelocity.size();
        //paddle
        this.paddlespeed = 20;
        this.paddlewidth = 50;

        //create an array of colors for the block rows
        ArrayList<Color> blockColors = new ArrayList<Color>();
        blockColors.add(Color.GRAY);
        blockColors.add(Color.red);
        blockColors.add(Color.yellow);
        blockColors.add(Color.BLUE);
        blockColors.add(Color.PINK);
        blockColors.add(Color.GREEN);
        //create the game blocks rows
        //set a reference point for the game blocks
        Point reference = new Point(800 - 20, 150 - 10);
        //create the game blocks rows
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 15; j++) {
                Block b = new Block(new Rectangle(new Point(reference.getX()
                        - (j * defaultWidth), reference.getY()), defaultWidth, defaultHeight));
                b.setColor(blockColors.get(i - 1));
                blocksarray.add(b);
            }
            reference.setY(reference.getY() + defaultHeight);
        }

        this.numberOfBlocksToRemove = blocksarray.size();
    }

    /**
     * Number of balls int.
     *
     * @return the number of balls in the level
     */
    public int numberOfBalls() {
        return numberofballs;
    }
    /**
     * Initial ball velocities list.
     *The initial velocity of each ball
     * Note that initialBallVelocities().size() == numberOfBalls()
     *
     * @return list of balls velocities
     */
    public List<Velocity> initialBallVelocities() {
        return initialballvelocity;
    }
    /**
     * Paddle speed int.
     *
     * @return the paddle speed
     */
    public int paddleSpeed() {
        return paddlespeed;
    }
    /**
     * Paddle width int.
     *
     * @return the paddle width
     */
    public int paddleWidth() {
        return paddlewidth;
    }
    /**
     * Level name string.
     *the level name will be displayed at the top of the screen.
     *
     * @return the name of the level
     */
    public String levelName() {
        return levelname;
    }
    /**
     * Gets background.
     *
     * @return the background for the level
     */
    public Sprite getBackground() {
        return background;
    }
    /**
     * Blocks list. The Blocks that make up this level, each block contains
     *  its size, color and location.
     *
     * @return the list of blocks in the level
     */
    public List<Block> blocks() {
        return blocksarray;
    }
    /**
     * Number of blocks to remove int.Number of levels that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     *
     * @return the number of blaocks to remove in the level
     */
    public int numberOfBlocksToRemove() {
        return numberOfBlocksToRemove;
    }
}
