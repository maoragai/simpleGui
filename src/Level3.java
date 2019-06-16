import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Level3 implements LevelInformation {

    private int numberofballs;
    private int paddlespeed,paddlewidth,numberOfBlocksToRemove;
    private List<Velocity> initialballvelocity=new ArrayList<>();
    private Sprite background;
    private List<Block> blocksarray=new ArrayList<>();
    private String levelname="Green 3";
    double defaultWidth = 45, defaultHeight = 25;

    public Level3() {
        background =new Level3Background();
        //build balls velocity array here
        initialballvelocity.add(new Velocity(2,2));
        initialballvelocity.add(new Velocity(3,3));

        numberofballs = initialballvelocity.size();
        //paddle
        this.paddlespeed=20;
        this.paddlewidth=50;

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
        Point reference = new Point(800-20, 150-10);
        //create the game blocks rows
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 12 - i; j++) {
                Block b = new Block(new Rectangle(new Point(reference.getX()
                        - (j * defaultWidth), reference.getY()), defaultWidth, defaultHeight));
                b.setColor(blockColors.get(i - 1));
                blocksarray.add(b);
            }
            reference.setY(reference.getY() + defaultHeight);// = reference.getY() + defaultHeight;
        }

        this.numberOfBlocksToRemove = blocksarray.size();
    }


    public int numberOfBalls(){
        return numberofballs;
    }
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    public List<Velocity> initialBallVelocities(){
        return initialballvelocity;
    }
    public int paddleSpeed() {
        return paddlespeed;
    }
    public int paddleWidth(){
        return paddlewidth;
    }
    // the level name will be displayed at the top of the screen.
    public String levelName(){
        return levelname;
    }
    // Returns a sprite with the background of the level
    public Sprite getBackground(){
        return background;
    }
    // The Blocks that make up this level, each block contains
    // its size, color and location.
    public List<Block> blocks(){
        return blocksarray;
    }
    // Number of levels that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();
    public int numberOfBlocksToRemove(){
        return numberOfBlocksToRemove;
    }
}
