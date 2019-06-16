import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.ArrayList;

public class Ass5Game {

    private Counter ballCount = new Counter();

    public static void main(String[] args){
        GUI             gui = new GUI("Arkanoid", 800, 600);
        AnimationRunner runner=new AnimationRunner(gui,60);
        KeyboardSensor  key = gui.getKeyboardSensor();
        Counter         live = new Counter();
        Counter         score=new Counter();
        GameFlow        gameFlow=new GameFlow(runner,key,gui,live,score);

        live.increase(7);
        ArrayList<LevelInformation> levels=new ArrayList<>();
        levels.add(new Level1());
        levels.add(new Level2());
        levels.add(new Level3());
        levels.add(new Level4());
        gameFlow.runLevels(levels);
        //game is over close the ui
        gui.close();
    }

}
