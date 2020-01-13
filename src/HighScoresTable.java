import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


/**
 * The type High scores table.
 */
class HighScoresTable {
private List<ScoreInfo> scoreInfo;
private int size;

    /**
     * Instantiates a new High scores table.
     *
     * @param s the s
     */
    public HighScoresTable(int s) {
        this.scoreInfo = new ArrayList<ScoreInfo>(s);
        this.size = s;
    }

    /**
     * Add.
     *
     * @param score the score
     */
    public void add(ScoreInfo score) {
        scoreInfo.add(score);
        if (scoreInfo.size() >= this.size) {
            this.getHighScores();
        }
    }

    /**
     * Size int.
     *
     * @return the size
     */
// Return table size.
    public int size() {
        return scoreInfo.size();
    }

    /**
     * Gets high scores.
     * Return the current high scores .
     * The list is sorted such that the highest
     * scores come first.
     *also, this method is sorting the table.
     * @return the high scores
     */
    public List<ScoreInfo> getHighScores() {
        Comparator<ScoreInfo> scoreInfoComparator = (o1, o2) -> {
            if (o1.getScore() < o2.getScore()) {
                return 1;
            } else if (o1.getScore() > o2.getScore()) {
                return -1;
            } else {
                return 0;
            }
        };
        Collections.sort(scoreInfo, scoreInfoComparator);
        if (scoreInfo.size() >= this.size) {
            scoreInfo = scoreInfo.subList(0, this.size);
        }
        return scoreInfo;
    }

    /**
     * Gets rank.
     *
     * @param score the score
     * @return the rank
     */
// return the rank of the current score: where will it
    // be on the list if added?
    // Rank 1 means the score will be highest on the list.
    // Rank `size` means the score will be lowest.
    // Rank > `size` means the score is too low and will not
    //      be added to the list.
    public int getRank(int score) {
        this.getHighScores();
      List<ScoreInfo> tempList = new ArrayList<>(this.size);
        for (ScoreInfo si:scoreInfo) {
            tempList.add(new ScoreInfo(si.getName(), si.getScore()));
        }
      ScoreInfo tempName = new ScoreInfo("tempName", score);
      tempList.add(tempName);
      Comparator<ScoreInfo> scoreInfoComparator = (o1, o2) -> {
            if (o1.getScore() < o2.getScore()) {
                return 1;
            } else if (o1.getScore() > o2.getScore()) {
                return -1;
            } else {
                return 0;
            }
        };
        Collections.sort(tempList, scoreInfoComparator);
        tempList = tempList.subList(0, this.size);
        if (tempList.contains(tempName)) {
            return tempList.indexOf(tempName) + 1;
        } else {
            return this.size + 2;
        }

    }

    /**
     * Clear.
     */
// Clears the table
    public void clear() {
        this.scoreInfo.clear();
    }

    /**
     * Load.
     *
     * @param filename the filename
     * @throws IOException the io exception
     */
    public void load(File filename) throws IOException {
        try {
            if (filename.canRead()) {
                Scanner fileScan = new Scanner(filename);
                while (fileScan.hasNextLine()) {
                    String[] line = fileScan.nextLine().split(",");
                    this.scoreInfo.add(new ScoreInfo(line[0], Integer.parseInt(line[1])));
                }
            } else {
                throw new IOException("file not readable.");
            }
        } catch (IOException e) {
            System.out.println("couldn't load file");
        }
    }

    /**
     * Save.
     *
     * @param filename the filename
     * @throws IOException the io exception
     */
// Save table data to the specified file.
    public void save(File filename) throws IOException {
        try {
            if (filename.canWrite()) {

                FileWriter fileWriter = new FileWriter(filename);
                for (ScoreInfo si:scoreInfo) {
                    fileWriter.write(si.getName() + "," + si.getScore() + System.lineSeparator());
                }
                fileWriter.close();
            } else {
                throw new IOException("file not readable.");
            }
        } catch (Exception e) {
            throw new IOException("couldn't load file");
        }
    }

    /**
     * Load from file high scores table.
     *
     * @param filename the filename
     * @return the high scores table
     */
// Read a table from file and return it.
    // If the file does not exist, or there is a problem with
    // reading it, an empty table is returned.
    public static HighScoresTable loadFromFile(File filename) {return new HighScoresTable(10); }
}
