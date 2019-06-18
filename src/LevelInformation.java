import java.util.List;

/**
 * The interface Level information.
 */
public interface LevelInformation {
    /**
     * Number of balls int.
     *
     * @return the number of balls in the level
     */
    int numberOfBalls();

    /**
     * Initial ball velocities list.
     *The initial velocity of each ball
     * Note that initialBallVelocities().size() == numberOfBalls()
     *
     * @return list of balls velocities
     */
    List<Velocity> initialBallVelocities();

    /**
     * Paddle speed int.
     *
     * @return the paddle speed
     */
    int paddleSpeed();

    /**
     * Paddle width int.
     *
     * @return the paddle width
     */
    int paddleWidth();

    /**
     * Level name string.
     *the level name will be displayed at the top of the screen.
     *
     * @return the name of the level
     */
     String levelName();

    /**
     * Gets background.
     *
     * @return the background for the level
     */
    Sprite getBackground();

    /**
     * Blocks list. The Blocks that make up this level, each block contains
     *  its size, color and location.
     *
     * @return the list of blocks in the level
     */
    List<Block> blocks();

    /**
     * Number of blocks to remove int.Number of levels that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     *
     * @return the number of blaocks to remove in the level
     */
    int numberOfBlocksToRemove();
}