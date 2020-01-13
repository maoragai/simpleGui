import java.io.File;
import java.io.IOException;

public class ReadWriteTest {

    public static void main(String[] args) throws IOException {
        HighScoresTable table = new HighScoresTable(10);
        table.add(new ScoreInfo("maor", 1));
        table.add(new ScoreInfo("mair", 2));
        table.add(new ScoreInfo("mair", 3));
        table.add(new ScoreInfo("mair", 4));
        table.add(new ScoreInfo("mair", 5));
        table.add(new ScoreInfo("mair", 6));
        table.add(new ScoreInfo("mair", 7));
        table.add(new ScoreInfo("mair", 8));
        table.add(new ScoreInfo("mair", 9));
        table.add(new ScoreInfo("mair", 10));
        table.add(new ScoreInfo("mair", 11));
        int rank = table.getRank(1);
        File file = new File(System.getProperty("user.dir") + "/highscores.txt");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("new file created");
        }
        table.save(file);
        }

    }