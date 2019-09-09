/*The area the game takes place in
 * has button EXIT (to game over screen)*/

class Field extends Screen {

    //static variables
    final private static int ROWS = 20, COLS = 20;
    final private static String MESSAGE = "SCORE: %d    LEVEL: %d";
    final private static String REMOVE_REGEX = "SCORE:.*";

    //instance variables
    private int rows, cols;
    private int sideLength, xOffset, yOffset;
    private int level;

    Field(int level) {
        this(ROWS, COLS, level);
    }

    Field(int newRows, int newCols, int level) {
        //set game as the next logical screen
        super(Action.GAME);
        //add the exit button, goes to game over
        addButton(getHalfWidth(), getFractionOfHeight(0.95), ButtonText.EXIT, Action.GAME_OVER);
        //take input
        this.level = level;
        rows = newRows;
        cols = newCols;
        //compute the grid of the field
        int height = getScreenHeight();
        int width = getScreenWidth();
        //80% of the smaller dimension for field
        if (width > height) {
            sideLength = (int) (height * 0.8 / rows);
        } else {
            sideLength = (int) (width * 0.8 / cols);
        }
        xOffset = (width - rows * sideLength) / 2;
        yOffset = (height - cols * sideLength) / 2;
        //update the score text
        updateScoreText(0);
    }

    void updateScoreText(int score) {
        //remove the previous score text
        removeText(REMOVE_REGEX);
        //add the updated score text
        addText(getHalfWidth(), getFractionOfHeight(0.05), String.format(MESSAGE, score, level), TextType.MEDIUM);
    }

    Integer[] getCenterOfField() {
        //return the center coordinates of the field
        return new Integer[]{rows / 2, cols / 2};
    }

    //getters
    int getSideLength() {
        return sideLength;
    }

    int getRows() {
        return rows;
    }

    int getCols() {
        return cols;
    }

    int getYOffset() {
        return yOffset;
    }

    int getXOffset() {
        return xOffset;
    }

    int getMaxScore() {
        return rows * cols;
    }
}
