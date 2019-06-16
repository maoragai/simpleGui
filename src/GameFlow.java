import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

public class GameFlow {
private KeyboardSensor keyboardSensor;
private AnimationRunner animationRunner;
private Counter lives;
private Counter score;

    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI g, Counter l,Counter s) {
        this.animationRunner=ar;
        this.keyboardSensor=ks;
        this.lives=l;
        this.score=s;
    }

    public void runLevels(List<LevelInformation> levels) {

        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo,
                    this.keyboardSensor,
                    this.animationRunner,this.lives,this.score);
            level.initialize();
            while ((level.getBlockCount().getValue()!=0)&&(lives.getValue()!=0)) {
                level.playOneTurn();
            }
            //user lost the game
            if (lives.getValue()==0) {
                this.animationRunner.run(new EndGame( this.score, this.keyboardSensor,false));
                return;
            }

        }
        this.animationRunner.run(new EndGame( this.score, this.keyboardSensor,true));
    }
}