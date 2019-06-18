import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * GameLevel class declaration.
 */
public class GameLevel implements Animation {
    private AnimationRunner runner;
    private boolean         running;
    private KeyboardSensor  key;
    private Counter         live;
    private SpriteCollection sprites;
    private GameEnvironment environment = new GameEnvironment();
    private Counter         blockCount = new Counter();
    private Counter         ballCount = new Counter();
    private BlockRemover    blockRemover = new BlockRemover(this, blockCount);
    private Counter         score;
    private ScoreTrackingListener scoreListener;
    private LevelInformation level;

    /**
     * Instantiates a new Game level.
     *
     * @param li the li
     * @param k  the k
     * @param ar the ar
     * @param l  the l
     * @param s  the s
     */
    public GameLevel(LevelInformation li, KeyboardSensor k, AnimationRunner ar, Counter l, Counter s) {
        this.level = li;
        this.key   = k;
        this.runner = ar;
        this.live   = l;
        sprites     = new SpriteCollection();
        this.score  = s;
        scoreListener = new ScoreTrackingListener(score);
    }

    /**
     * adds collidable to the game.
     *
     * @param c the collidable to add
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * add a sprite to this game.
     *
     * @param s the sprite to add tho the game
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     */
    public void initialize() {
        level.getBackground().addToGame(this);

        //defining borders
        Block rightBorder  = new Block(new Rectangle(new Point(780, 0),  20, 600));
        Block upperBorder  = new Block(new Rectangle(new Point(1, 1), 800,  40));
        Block leftBorder   = new Block(new Rectangle(new Point(1, 1),  20, 600));
        Block bottomBorder = new Block(new Rectangle(new Point(0, 600), 800,  20));

        //defining border colors
        Color borderColor = Color.GRAY;
        rightBorder.setColor(borderColor);
        upperBorder.setColor(borderColor);
        leftBorder.setColor(borderColor);
        bottomBorder.setColor(borderColor);

        //disabling hit points representation for the borders (comment if needed)
        rightBorder.setHitPoints(-1);
        bottomBorder.setHitPoints(-1);
        leftBorder.setHitPoints(-1);
        upperBorder.setHitPoints(-1);

        //defining paddle
        Paddle pad = new Paddle(key, new Block(new Rectangle(new Point(400, 550), level.paddleWidth(), 20)));
        pad.setMoveStep(level.paddleSpeed());
        pad.addToGame(this);

        //defining scoreboard
        ScoreIndicator si = new ScoreIndicator(score);
        //defining lives board
        LivesIndicator li = new LivesIndicator(live);
        //level name indicator
        LevelNameIndicator ln = new LevelNameIndicator(level.levelName());

        //adding borders and paddle to the game
        rightBorder.addToGame(this);
        upperBorder.addToGame(this);
        leftBorder.addToGame(this);
        bottomBorder.addToGame(this);
        //adding scoreBoard and live indicator to the game
        si.addToGame(this);
        li.addToGame(this);
        ln.addToGame(this);
       // this.createBallsOnTopOfPaddle();
        //listener for the bottom border
        BallRemover br = new BallRemover(this, ballCount);
        bottomBorder.addHitListener(br);

        //here we should take care of the blocks that appear
        blockCount.increase(level.numberOfBlocksToRemove());

        for (Block b:level.blocks()) {
            b.addHitListener(blockRemover);
            b.addHitListener(scoreListener);
            b.setHitPoints(1);
            b.addToGame(this);
        }

    }

    /**
     * Create balls on top of paddle.this method was commented out because of the assignment instructions.
     */
    public void createBallsOnTopOfPaddle() {

        int posOffset = 5;
        int i = 0;
        for (Velocity v:level.initialBallVelocities()) {
            i++;
            //create a ball
            Ball ball1 = new Ball(385 +  posOffset, 400, 5, Color.WHITE);
            ball1.setVelocity(v);
            ball1.setBorders(602, 0, 0, 800);
            ball1.addToGame(this);
            ball1.setGameEnvironment(environment);
            ballCount.increase(1);
            posOffset += 20;
        }
     }

    /**
     * Play one turn.
     */
    public void playOneTurn() {
    CountdownAnimation ca = new CountdownAnimation(6, 3, sprites);
        this.createBallsOnTopOfPaddle();
    while (!ca.shouldStop()) {
            this.runner.run(ca);
        }
             // or a similar method
            this.running = true;
            // use our runner to run the current animation -- which is one turn of
            // the game.
            this.runner.run(this);
    }

    /**
     * Remove collidable.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollifable(c);
    }

    /**
     * Remove sprite.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
       sprites.removeSprite(s);
    }

    /**
     * Run.
     */
    public void run() {
        live.increase(4);
        this.initialize();
        this.playOneTurn();
    }

    /**
     * Gets block count.
     *
     * @return the block count
     */
    public Counter getBlockCount() {
        return blockCount;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.key.isPressed("p")) {
            this.runner.run(new PauseScreen(this.key));
        }
        //checking if all the blocks are destroyed
        if (blockCount.getValue() == 0) {
            score.increase(100);
            this.running = false;
            //sprites.removeSprite();
            return;
        }
        //check if all balls are destroyed
        if (ballCount.getValue() == 0) {
            live.decrease(1);
            this.running = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}