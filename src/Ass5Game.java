import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The type Ass 5 game.
 */
public class Ass5Game {

    private Counter ballCount = new Counter();

    /**
     * Main.
     *
     * @param args the args
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        GUI             gui = new GUI("Arkanoid", 800, 600);
        AnimationRunner runner = new AnimationRunner(gui, 60);
        KeyboardSensor  key = gui.getKeyboardSensor();
        Counter         live = new Counter();
        Counter         score = new Counter();
        GameFlow        gameFlow = new GameFlow(runner, key, gui, live, score);
        HighScoresTable table = new HighScoresTable(10);
        File file = new File(System.getProperty("user.dir") + "/highscores.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        live.increase(7);
        ArrayList<LevelInformation> levels = new ArrayList<>();

        if (args.length == 0) {
            levels.add(new Level1());
            levels.add(new Level2());
            levels.add(new Level3());
            levels.add(new Level4());
        } else { //there are arguments
            for (String levelNumberString : args) {
                int levelNumber;
                try {
                    levelNumber = Integer.parseInt(levelNumberString);
                } catch (NumberFormatException e) {
                    continue;
                }
                switch (levelNumber) {
                    case 1:
                        levels.add(new Level1());
                        break;
                    case 2:
                        levels.add(new Level2());
                        break;
                    case 3:
                        levels.add(new Level3());
                        break;
                    case 4:
                        levels.add(new Level4());
                        break;
                    default:
                        break;
                }
            }
        }
        //run the levels array
        gameFlow.runLevels(levels);
        //game is over close the ui
        gui.close();
    }

}
