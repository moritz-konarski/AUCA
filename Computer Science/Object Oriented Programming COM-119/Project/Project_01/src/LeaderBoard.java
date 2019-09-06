import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/*The screen showing the high scores of the user*/

class LeaderBoard extends Screen {

    //instance variables
    private File highScoreFile = new File(getClass().getResource("highScores.dat").getPath());
    private int[] highScores;
    private int numberOfHighScores, heightStep, yOffset;

    //final strings for templates and regex
    final private static String TITLE = "LEADER BOARD";
    final private static String LEVEL_HEADER = "LEVEL";
    final private static String SCORE_HEADER = "SCORE";
    final private static String FIND_LEVEL = "\\s*Level_%02d\\s+-?\\d+\\D*.*";
    final private static String REPLACE_SCORE = "$1$2$3%d$5";
    final private static String GET_LEVEL = "$2";
    final private static String GET_SCORE = "$4";
    final private static String REGEX = "(\\s*Level_)(\\d+)(\\s+)(-?\\d+)(\\D*.*)";
    final private static String COLUMN_TEMPLATE = "%d";
    final private static String COLUMN_REMOVE_TEMPLATE = "\\d+";

    LeaderBoard() {
        //set main menu as next screen
        super(Action.MAIN_MENU);
        //add main menu button
        addButton(getHalfWidth(), getFractionOfHeight(0.95), ButtonText.MAIN_MENU, Action.MAIN_MENU);
        //add reset high scores button
        addButton((int) (getHalfWidth() + getButtonList().get(0).getWidth() * 1.1),
                getFractionOfHeight(0.95), ButtonText.RESET_HIGH_SCORES, Action.RESET_HIGH_SCORES);
        //add the title
        addText(getHalfWidth(), getFractionOfHeight(0.05), TITLE, TextType.LARGE);
        //get the number of high scores
        numberOfHighScores = Main.getLevels();
        //set up the table for the high scores
        yOffset = (int) (getScreenHeight() / 10f);
        heightStep = (int) ((getScreenHeight() - 2 * yOffset) / 12f);
        //add table headers
        addText(2 * getHalfWidth() / 3, yOffset + heightStep, LEVEL_HEADER, TextType.SMALL);
        addText(4 * getHalfWidth() / 3, yOffset + heightStep, SCORE_HEADER, TextType.SMALL);
        //read all high scores from the file
        readAllHighScores();
        //update the text in the table
        updateText();
    }

    int getyOffset() {
        return yOffset;
    }

    int getHeightStep() {
        return heightStep;
    }

    //TODO: make "addLevel" and "delete level, so that one might change the number of levels

    void updateText() {
        //remove all the previous text objects from the list
        removeText(COLUMN_REMOVE_TEMPLATE);

        //add all the text objects with updated values
        for (int i = 0; i < numberOfHighScores; i++) {
            addText(2 * getHalfWidth() / 3, yOffset + (i + 2) * heightStep, String.format(COLUMN_TEMPLATE, i + 1), TextType.SMALL);
            addText(4 * getHalfWidth() / 3, yOffset + (i + 2) * heightStep, String.format(COLUMN_TEMPLATE, highScores[i]), TextType.SMALL);
        }
    }

    private void writeHighScore(int level, int score) {
        //regex for finding a specific level in the file
        String findRegex = String.format(FIND_LEVEL, level);
        //regex replace template for a new score
        String replacement = String.format(REPLACE_SCORE, score);
        try {
            //list for all the lines in the file
            List<String> lines = new ArrayList<>();
            //iterate through all lines
            for (String line : Files.readAllLines(highScoreFile.toPath(), StandardCharsets.UTF_8)) {
                //if the line matches the findRegex, i.e. it is the level we want to update
                if (line.matches(findRegex)) {
                    //add the new, modified line by replacing the old score with the new one
                    //using the REGEX template that is defined above
                    lines.add(line.replaceAll(REGEX, replacement));
                } else {
                    //add the old line without changing it
                    lines.add(line);
                }
            }
            //write the list of lines back to the file
            Files.write(highScoreFile.toPath(), lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    void readAllHighScores() {
        highScores = new int[numberOfHighScores];
        int index;
        try {
            List<String> lines = Files.readAllLines(highScoreFile.toPath(), StandardCharsets.UTF_8);
            for (String line : lines) {
                if (line.matches(REGEX)) {
                    index = Integer.parseInt(line.replaceAll(REGEX, GET_LEVEL)) - 1;
                    highScores[index] = Integer.parseInt(line.replaceAll(REGEX, GET_SCORE));
                }
            }
        } catch (IOException e) {
            System.err.println(e.getCause());
        }
    }

    private int getHighScore(int level) {
        String findLevelRegex = String.format(FIND_LEVEL, level);
        int score = -1;
        try {
            List<String> lines = Files.readAllLines(highScoreFile.toPath(), StandardCharsets.UTF_8);
            for (String line : lines) {
                if (line.matches(findLevelRegex)) {
                    score = Integer.parseInt(line.replaceAll(REGEX, GET_SCORE));
                }
            }
        } catch (IOException e) {
            System.err.println(e.getCause());
        }
        return score;
    }

    void resetHighScores() {
        for (int i = 1; i <= numberOfHighScores; i++) {
            writeHighScore(i, 0);
        }
    }

    boolean isNewHighScore(int score, int level) {
        int currScore = getHighScore(level);
        return currScore < score;
    }

    void writeNewHighScore(int score, int level) {
        if (level > 0 && level <= 10) {
            writeHighScore(level, score);
        }
    }
}
